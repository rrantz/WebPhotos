/**
 * Copyright 2008 WebPhotos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.webphotos.gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.webphotos.BancoImagem;
import net.sf.webphotos.util.Util;
import net.sf.webphotos.util.legacy.CacheFTP;

/**
 * Gera um frame que aloca PainelWebFotos.
 * Seu construtor chama o m�todo initComponents() para gerar o frame, m�todo gerado automaticamente pela IDE.
 * @author guilherme
 */
public class FrameWebFotos extends javax.swing.JFrame {
    
    private static final Logger log = Logger.getLogger(FrameWebFotos.class.getName());
    private static FrameWebFotos janela;
    
    /**
     * Creates new form FrameWebFotos 
     */
    private FrameWebFotos() {
        initComponents();
        // TODO: corrigir o painel para se transformar num bean totalmente funcional
        add(PainelWebFotos.getInstance());
        pack();
        setLocationRelativeTo(null);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        fileMenu.setText("Arquivo");

        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save As ...");
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Editar");

        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setText("Ajuda");

        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebPhotos");
        setName("Frame WebPhotos"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        FrameWebFotos.exit();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // Blocks resizing if size bellow minimumSize
        FrameWebFotos comp = (FrameWebFotos)evt.getComponent();
        int width = comp.getSize().width;
        int height = comp.getSize().height;
        int minWidth = comp.getPreferredSize().width;
        int minHeight = comp.getPreferredSize().height;
        
        if(width < minWidth && height < minHeight ) {
            comp.setSize(minWidth, minHeight);
        } else if (width < minWidth) {
            comp.setSize(minWidth, height);
        } else if (height < minHeight) {
            comp.setSize(width, minHeight);
        }
    }//GEN-LAST:event_formComponentResized

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        FrameWebFotos.exit();
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * Retorna a inst�ncia de FrameWebFotos.
     * Caso n�o exista nenhuma, inicia uma.
     * @return Retorna um frame.
     */
    public static FrameWebFotos getInstance() {
        if(janela == null) {
            janela = new FrameWebFotos();
        }
        return janela;
    }

    private static void exit() {
        log.log(Level.FINE, "Shutting down WebPhotos");
        CacheFTP.getCache().saveFile();
        Util.setLoggingTextArea(null);
        try { BancoImagem.closeConnection(); } catch (SQLException ex) { }
        getInstance().dispose();
    }
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JMenuItem aboutMenuItem;
    private static javax.swing.JMenuItem contentsMenuItem;
    private static javax.swing.JMenuItem copyMenuItem;
    private static javax.swing.JMenuItem cutMenuItem;
    private static javax.swing.JMenuItem deleteMenuItem;
    private static javax.swing.JMenu editMenu;
    private static javax.swing.JMenuItem exitMenuItem;
    private static javax.swing.JMenu fileMenu;
    private static javax.swing.JMenu helpMenu;
    private static javax.swing.JMenuBar menuBar;
    private static javax.swing.JMenuItem openMenuItem;
    private static javax.swing.JMenuItem pasteMenuItem;
    private static javax.swing.JMenuItem saveAsMenuItem;
    private static javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

	
}