/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.waw.frej.michajłowicz.egzamin;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adam
 */
public class KrzywaDyskretna {

    private ArrayList<Point> points = new ArrayList<>();
    private int gridWidth;
    Map<Integer, Integer> directions;
    Map<Integer, String> differentialDirections;
    Map<Integer, String> decimalDirections;
    private int gridSize;

    private void map() {
        directions = new HashMap<>();
        directions.put(1, 0);
        directions.put(0, 7);
        directions.put(3, 6);
        directions.put(6, 5);
        directions.put(7, 4);
        directions.put(8, 3);
        directions.put(5, 2);
        directions.put(2, 1);

        differentialDirections = new HashMap<>();
        differentialDirections.put(0, "0");
        differentialDirections.put(7, "01");
        differentialDirections.put(1, "011");
        differentialDirections.put(6, "0111");
        differentialDirections.put(2, "01111");
        differentialDirections.put(5, "011111");
        differentialDirections.put(3, "0111111");
        differentialDirections.put(4, "01111111");
        
        decimalDirections = new HashMap<>();
        decimalDirections.put(0, "0");
        decimalDirections.put(7, "+1");
        decimalDirections.put(1, "-1");
        decimalDirections.put(6, "+2");
        decimalDirections.put(2, "-2");
        decimalDirections.put(5, "+3");
        decimalDirections.put(3, "-3");
        decimalDirections.put(4, "4");
        
    }

    public KrzywaDyskretna(int gridWidth, int gridSize) {
        map();
        this.gridWidth = gridWidth;
        this.gridSize = gridSize;
    }

    public KrzywaDyskretna(ArrayList<Point> points, int gridWidth, int gridSize) {
        map();
        this.points = points;
        this.gridWidth = gridWidth;
        this.gridSize = gridSize;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points, int gridWidth) {
        this.points = points;
        this.gridWidth = gridWidth;
    }

    public void saveDiffChainCodeFile(String path, boolean binary) {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "utf-8"));

            writer.write(gridSize + "\n");
            if (binary) {
                int leadingDigit = (int) Math.pow(2, Integer.toBinaryString(gridSize - 1).length());
                writer.write(addLeadingZeros(points.get(0).x / gridWidth, leadingDigit) + addLeadingZeros(points.get(0).y / gridWidth, leadingDigit));
            } else {
                int leadingDigit = (int) Math.pow(10, Integer.toString(gridSize - 1).length());
                writer.write(addLeadingZerosDecimal(points.get(0).x/gridWidth, leadingDigit) + addLeadingZerosDecimal(points.get(0).y/gridWidth, leadingDigit));
            }


            int deltaX = (points.get(0).x - points.get(1).x) / gridWidth + 1;
            int deltaY = (points.get(0).y - points.get(1).y) / gridWidth + 1;
            if (binary) {
                    writer.write(directionCode(deltaX, deltaY));
                } else {
                    writer.write(directionValue(deltaX, deltaY).toString());
                }

            for (int i = 2; i < points.size(); i++) {
                deltaX = (points.get(i - 1).x - points.get(i).x) / gridWidth + 1;
                deltaY = (points.get(i - 1).y - points.get(i).y) / gridWidth + 1;
                int dir = directionValue(deltaX, deltaY);

                int deltaXPrev = (points.get(i - 2).x - points.get(i - 1).x) / gridWidth + 1;
                int deltaYPrev = (points.get(i - 2).y - points.get(i - 1).y) / gridWidth + 1;
                int dirPrev = directionValue(deltaXPrev, deltaYPrev);

                int dirDiff = (dirPrev - dir) % 8;
                if (dirDiff < 0) {
                    dirDiff += 8;
                }
                if(binary){
                writer.write(differentialDirections.get(dirDiff));
                }
                else{
                    writer.write(decimalDirections.get(dirDiff));
                }

            }


        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }

    }

    public void saveChainCodeFile(String path, boolean binary) {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "utf-8"));



            writer.write(gridSize + "\n");
            if (binary) {
                int leadingDigit = (int) Math.pow(2, Integer.toBinaryString(gridSize - 1).length());
                writer.write(addLeadingZeros(points.get(0).x / gridWidth, leadingDigit) + addLeadingZeros(points.get(0).y / gridWidth, leadingDigit));
            } else {
                int leadingDigit = (int) Math.pow(10, Integer.toString(gridSize - 1).length());
                writer.write(addLeadingZerosDecimal(points.get(0).x/gridWidth, leadingDigit) + addLeadingZerosDecimal(points.get(0).y/gridWidth, leadingDigit));
            }
            for (int i = 1; i < points.size(); i++) {
                int deltaX = (points.get(i - 1).x - points.get(i).x) / gridWidth + 1;
                int deltaY = (points.get(i - 1).y - points.get(i).y) / gridWidth + 1;
                if (binary) {
                    writer.write(directionCode(deltaX, deltaY));
                } else {
                    writer.write(directionValue(deltaX, deltaY).toString());
                }
            }


        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }

    }

    public String getChainCodeStats() {
        String text;
        Integer pointSize;
        double kp, kw, sk;

        pointSize = 2 * Integer.toBinaryString(gridSize - 1).length();
        kp = points.size() * pointSize;
        kw = pointSize + (points.size() - 1) * 3;
        sk = kp / kw;

        text = "KP = " + kp + "\n";
        text += "KW = " + kw + "\n";
        text += "SK = " + sk;

        return text;
    }

    public String getDiffChainCodeStats() {
        String text;
        Integer pointSize;
        double kp, kw, sk;

        pointSize = 2 * Integer.toBinaryString(gridSize - 1).length();
        kp = points.size() * pointSize;
        kw = pointSize + 3;
        for (int i = 2; i < points.size(); i++) {
            int deltaX = (points.get(i - 1).x - points.get(i).x) / gridWidth + 1;
            int deltaY = (points.get(i - 1).y - points.get(i).y) / gridWidth + 1;
            int dir = directionValue(deltaX, deltaY);

            int deltaXPrev = (points.get(i - 2).x - points.get(i - 1).x) / gridWidth + 1;
            int deltaYPrev = (points.get(i - 2).y - points.get(i - 1).y) / gridWidth + 1;
            int dirPrev = directionValue(deltaXPrev, deltaYPrev);

            int dirDiff = (dirPrev - dir) % 8;
            if (dirDiff < 0) {
                dirDiff += 8;
            }
            kw += differentialDirections.get(dirDiff).length();
        }
        sk = kp / kw;

        text = "KP = " + kp + "\n";
        text += "KW = " + kw + "\n";
        text += "SK = " + sk;

        return text;
    }

    public void saveFile(String path) {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path), "utf-8"));
            for (Point p : points) {
                writer.write(p.x + "," + p.y + ",");
            }


        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }

    }

    public void openFile(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = reader.readLine();
            }
            String everything = sb.toString();
            String[] tablica = everything.split(",");
            points.clear();
            for (int i = 0; i < tablica.length - 2; i += 2) {
                points.add(new Point(Integer.parseInt(tablica[i]), Integer.parseInt(tablica[i + 1])));
            }
        } catch (IOException ex) {
            // report
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
            }
        }

    }

    private String directionCode(int deltaX, int deltaY) {
        return addLeadingZeros(directionValue(deltaX, deltaY), 8);
    }

    private Integer directionValue(int deltaX, int deltaY) {        
        return directions.get(3 * deltaX + deltaY);
    }

    private String addLeadingZeros(int number, int leadingDigit) {
        return Integer.toBinaryString((number + leadingDigit)).substring(1);
    }

    private String addLeadingZerosDecimal(int number, int leadingDigit) {
        return Integer.toString(number + leadingDigit).substring(1);
    }

    Object getIntr1Stats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    KrzywaDyskretna getInterpolująca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
