/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.waw.frej.michajłowicz.egzamin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author adam
 */
public class SiatkaPanel extends JPanel {

    private int gridWidth;
    private int gridSize;
    private ArrayList<Point> line = new ArrayList<>();
    private ArrayList<Point> points = new ArrayList<>();

    public SiatkaPanel() {
        this.gridWidth = 20;
        this.gridSize = 20;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public ArrayList<Point>getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        drawGrid(g);
        drawLine(g);
        drawPoints(g);
        drawRedLines(g);
    }

    public void addPointToLine(Point point) {
        line.add(point);
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    private void clearLine() {
        boolean pointCrosedXLine;
        boolean pointCrosedYLine;
        int prevLineNumberX=0;
        int lineNumberX;
        int prevLineNumberY=0;
        int lineNumberY;
            
        for (Point p : line) {
            lineNumberX=p.x; 
            pointCrosedXLine = Math.abs(lineNumberX-prevLineNumberX)>=gridWidth;            
            lineNumberY=p.y;            
            pointCrosedYLine = Math.abs(lineNumberY-prevLineNumberY)>=gridWidth;
            boolean pointCrossedLine = pointCrosedYLine || pointCrosedXLine;
            boolean pointOnTheGrid = p.x<=gridSize*gridWidth && p.y<=gridSize*gridWidth;
            if(pointCrossedLine && pointOnTheGrid){
                Point punkt = snapToGrid(p);
                prevLineNumberY=punkt.y;
                prevLineNumberX=punkt.x;
                points.add(punkt);
            } 
        }
        line.clear();
    }

    
    private void drawGrid(Graphics g) {
        for (int i = 0; i <= gridSize*gridWidth; i += gridWidth) {
            g.drawLine(i, 0, i, gridSize*gridWidth);
        }
        for (int i = 0; i <= gridSize*gridWidth; i += gridWidth) {
            g.drawLine(0, i, gridSize*gridWidth, i);
        }
    }

    private void drawLine(Graphics g) {
        for (int i = 0; i < line.size() - 2; i++) {
            Point p1 = line.get(i);
            Point p2 = line.get(i + 1);

            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private void drawPoints(Graphics g) {
        g.setColor(Color.red);
        for (Point p : points) {
            g.fillOval(p.x - 5, p.y - 5, 10, 10);
        }
    }
    private void drawRedLines(Graphics g){
        g.setColor(Color.red);
        for (int i=0;i<points.size()-1;i++) {
            g.drawLine(points.get(i).x,points.get(i).y, points.get(i+1).x,points.get(i+1).y);
        }
        
    }

    private Point snapToGrid(Point p) {
        double halfPoint = gridWidth / 2.0;

        int xDetail = p.x % gridWidth;
        int pointX;

        if (xDetail <= halfPoint) {
            pointX = p.x - xDetail;
        } else {
            pointX = p.x + (gridWidth - xDetail);
        }

        int yDetail = p.y % gridWidth;
        int pointY;

        if (yDetail <= halfPoint) {
            pointY = p.y - yDetail;
        } else {
            pointY = p.y + (gridWidth - yDetail);
        }

        return new Point(pointX, pointY);

    }

    void clearPoints() {
        points.clear();
    }

    KrzywaDyskretna getKrzywa() {
        clearLine();
        return new KrzywaDyskretna(points, gridWidth, gridSize);
    }
}
