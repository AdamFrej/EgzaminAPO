/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.waw.frej;

import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author adam
 */
public class Okienko extends javax.swing.JFrame {

    public static final int GRID_WIDTH = 20;
    Integer gridSize = 20;
    private KrzywaDyskretna krzywa = new KrzywaDyskretna(GRID_WIDTH, gridSize);
    private KrzywaDyskretna interpolująca = new KrzywaDyskretna(GRID_WIDTH, gridSize);

    /**
     * Creates new form Okienko
     */
    public Okienko() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gridSizeTextField = new javax.swing.JTextField();
        raiseGridSizeButton = new javax.swing.JButton();
        lowerGridSizeButton = new javax.swing.JButton();
        gridSizeLabel = new javax.swing.JLabel();
        binaryCheckBox = new javax.swing.JCheckBox();
        siatka = new pl.waw.frej.SiatkaPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        SaveCompressedMenu = new javax.swing.JMenu();
        saveToChainCodeMenuItem = new javax.swing.JMenuItem();
        saveToDiffCodeMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        compressionMenu = new javax.swing.JMenu();
        chainCodeMenuItem = new javax.swing.JMenuItem();
        differentialChainCodeMenuItem = new javax.swing.JMenuItem();
        intr1MenuItem = new javax.swing.JMenuItem();
        intr3MenuItem = new javax.swing.JMenuItem();
        intr5MenuItem = new javax.swing.JMenuItem();
        intn3MenuItem = new javax.swing.JMenuItem();
        intn3ManualMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gridSizeTextField.setEditable(false);
        gridSizeTextField.setText("20");
        gridSizeTextField.setEnabled(false);

        raiseGridSizeButton.setText("+");
        raiseGridSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiseGridSizeButtonActionPerformed(evt);
            }
        });

        lowerGridSizeButton.setText("-");
        lowerGridSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowerGridSizeButtonActionPerformed(evt);
            }
        });

        gridSizeLabel.setText("Grid size:");

        binaryCheckBox.setText("Binary");

        siatka.setBackground(new java.awt.Color(255, 255, 255));
        siatka.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                siatkaMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siatkaMouseClicked(evt);
            }
        });
        siatka.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                siatkaMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout siatkaLayout = new javax.swing.GroupLayout(siatka);
        siatka.setLayout(siatkaLayout);
        siatkaLayout.setHorizontalGroup(
            siatkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        siatkaLayout.setVerticalGroup(
            siatkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        newMenuItem.setText("New");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        SaveCompressedMenu.setText("Save Compressed");

        saveToChainCodeMenuItem.setText("Chain code");
        saveToChainCodeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToChainCodeMenuItemActionPerformed(evt);
            }
        });
        SaveCompressedMenu.add(saveToChainCodeMenuItem);

        saveToDiffCodeMenuItem.setText("Differential Chain Code");
        saveToDiffCodeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToDiffCodeMenuItemActionPerformed(evt);
            }
        });
        SaveCompressedMenu.add(saveToDiffCodeMenuItem);

        fileMenu.add(SaveCompressedMenu);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        compressionMenu.setText("Compression");

        chainCodeMenuItem.setText("Chain Code");
        chainCodeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chainCodeMenuItemActionPerformed(evt);
            }
        });
        compressionMenu.add(chainCodeMenuItem);

        differentialChainCodeMenuItem.setText("Differential Chain Code");
        differentialChainCodeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                differentialChainCodeMenuItemActionPerformed(evt);
            }
        });
        compressionMenu.add(differentialChainCodeMenuItem);

        intr1MenuItem.setText("Intr1");
        intr1MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intr1MenuItemActionPerformed(evt);
            }
        });
        compressionMenu.add(intr1MenuItem);

        intr3MenuItem.setText("Intr3");
        compressionMenu.add(intr3MenuItem);

        intr5MenuItem.setText("Intr5");
        compressionMenu.add(intr5MenuItem);

        intn3MenuItem.setText("Intn3");
        compressionMenu.add(intn3MenuItem);

        intn3ManualMenuItem.setText("Intn3 Manual");
        compressionMenu.add(intn3ManualMenuItem);

        jMenuBar1.add(compressionMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siatka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gridSizeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lowerGridSizeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gridSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(raiseGridSizeButton)
                        .addGap(18, 18, 18)
                        .addComponent(binaryCheckBox)
                        .addGap(0, 365, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raiseGridSizeButton)
                    .addComponent(lowerGridSizeButton)
                    .addComponent(gridSizeLabel)
                    .addComponent(binaryCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siatka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void siatkaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siatkaMouseDragged
        siatka.addPointToLine(evt.getPoint());
        repaint();
    }//GEN-LAST:event_siatkaMouseDragged

    private void siatkaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siatkaMouseReleased
        krzywa = siatka.getKrzywa();
        repaint();
    }//GEN-LAST:event_siatkaMouseReleased

    private void siatkaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siatkaMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            siatka.clearPoints();
            krzywa = siatka.getKrzywa();
            repaint();
        }
    }//GEN-LAST:event_siatkaMouseClicked

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        krzywa = new KrzywaDyskretna(GRID_WIDTH, gridSize);
        siatka.setPoints(krzywa.getPoints());
        repaint();
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "Autorzy:\nAdam Frej \nMarek Michajłowicz\n2013", "Curvs 2013", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void saveToChainCodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToChainCodeMenuItemActionPerformed
        String path = getFilePath();
        if (!"".equals(path)) {
            krzywa.saveChainCodeFile(path,binaryCheckBox.isSelected());
        }
    }//GEN-LAST:event_saveToChainCodeMenuItemActionPerformed

    private void saveToDiffCodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToDiffCodeMenuItemActionPerformed
        String path = getFilePath();
        if (!"".equals(path)) {
            krzywa.saveDiffChainCodeFile(path,binaryCheckBox.isSelected());
        }
    }//GEN-LAST:event_saveToDiffCodeMenuItemActionPerformed

    private void raiseGridSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiseGridSizeButtonActionPerformed


        gridSize = Integer.decode(gridSizeTextField.getText()) + 1;
        gridSizeTextField.setText(gridSize.toString());
        siatka.setGridSize(gridSize);
        krzywa=siatka.getKrzywa();
        repaint();
    }//GEN-LAST:event_raiseGridSizeButtonActionPerformed

    private void lowerGridSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowerGridSizeButtonActionPerformed
        gridSize = Integer.decode(gridSizeTextField.getText()) - 1;
        gridSizeTextField.setText(gridSize.toString());
        siatka.setGridSize(gridSize);
        krzywa=siatka.getKrzywa();
        repaint();
    }//GEN-LAST:event_lowerGridSizeButtonActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        String path = getFilePath();
        if (!"".equals(path)) {
            krzywa.saveFile(path);
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        String path = getOpenFilePath();
        if (!"".equals(path)) {
            krzywa = new KrzywaDyskretna(GRID_WIDTH, gridSize);
            krzywa.openFile(path);
            siatka.setPoints(krzywa.getPoints());
            repaint();
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void chainCodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chainCodeMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, krzywa.getChainCodeStats(), "Chain code stats", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_chainCodeMenuItemActionPerformed

    private void differentialChainCodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_differentialChainCodeMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, krzywa.getDiffChainCodeStats(), "Differential Chain code stats", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_differentialChainCodeMenuItemActionPerformed

    private void intr1MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intr1MenuItemActionPerformed
        JOptionPane.showMessageDialog(this, krzywa.getIntr1Stats(), "Intr1 stats", JOptionPane.PLAIN_MESSAGE);
        interpolująca=krzywa.getInterpolująca();
        
    }//GEN-LAST:event_intr1MenuItemActionPerformed
/*
    private void siatkaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siatkaPanel1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_siatkaPanel1MouseDragged

    private void siatkaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siatkaPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_siatkaPanel1MouseClicked

    private void siatkaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siatkaPanel1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_siatkaPanel1MouseReleased
*/
    private String getFilePath() throws HeadlessException {
        JFileChooser c = new JFileChooser();
        // Demonstrate "Save" dialog:
        int rVal = c.showSaveDialog(Okienko.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(c.getCurrentDirectory().toString() + File.separator + c.getSelectedFile().getName());
            return (c.getCurrentDirectory().toString() + File.separator + c.getSelectedFile().getName());


        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("You pressed cancel");
            System.out.println("");
            return "";
        }
        return "";

    }
    private String getOpenFilePath() throws HeadlessException {
        JFileChooser c = new JFileChooser();
        // Demonstrate "Save" dialog:
        int rVal = c.showOpenDialog(Okienko.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(c.getCurrentDirectory().toString() + File.separator + c.getSelectedFile().getName());
            return (c.getCurrentDirectory().toString() + File.separator + c.getSelectedFile().getName());


        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("You pressed cancel");
            System.out.println("");
            return "";
        }
        return "";

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Okienko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Okienko().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu SaveCompressedMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JCheckBox binaryCheckBox;
    private javax.swing.JMenuItem chainCodeMenuItem;
    private javax.swing.JMenu compressionMenu;
    private javax.swing.JMenuItem differentialChainCodeMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel gridSizeLabel;
    private javax.swing.JTextField gridSizeTextField;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem intn3ManualMenuItem;
    private javax.swing.JMenuItem intn3MenuItem;
    private javax.swing.JMenuItem intr1MenuItem;
    private javax.swing.JMenuItem intr3MenuItem;
    private javax.swing.JMenuItem intr5MenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton lowerGridSizeButton;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton raiseGridSizeButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem saveToChainCodeMenuItem;
    private javax.swing.JMenuItem saveToDiffCodeMenuItem;
    private pl.waw.frej.SiatkaPanel siatka;
    // End of variables declaration//GEN-END:variables
}
