/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package read.dicom.view;

import ij.ImagePlus;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Adriano
 */
public class MainForm extends JFrame {

    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JButton btnAbrir;
    private JButton btnExtraer;
    private PanelImagen panelImagen;
    private PanelResultado panelResultado;
    private JFileChooser fileChooser;
    private JScrollPane scrollPanel;
    

    public MainForm() {
        initComponents();
    }

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imagenes DICOM", "dcm"));
            fileChooser.setAcceptAllFileFilterUsed(false);
        }

        int returnEval = fileChooser.showDialog(this, "Agregar");

        if (returnEval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Agrendo Archivo:" + file.getName());
            
            System.out.println("path:"+file.getPath());
            
            ImagePlus imagePlus = new ImagePlus(file.getPath());

            System.out.println(imagePlus);

            Image imagen = imagePlus.getImage();

            Image imagenEscalada = imagen.getScaledInstance(panelImagen.getHeight(), panelImagen.getWidth(), Image.SCALE_SMOOTH);

            panelImagen.setBackgroundImage(imagenEscalada);
            
            panelImagen.repaint();
        } else {
            System.out.println("El usuario cancelo la subida de la imagen");
        }

        fileChooser.setSelectedFile(null);
    }

    private void btnExtraerActionPerformed(java.awt.event.ActionEvent evt) {
        //Codigo extraer caracteristicas
        System.out.println("Se selecciono extraccion de caracteristicas");
        panelResultado.setNumImagenes(20);
        panelResultado.mostrarResultado();
        //panelResultado.repaint();
        //jScrollPane1.repaint();
        panelResultado.revalidate();
    }

    private void initComponents() {
        setTitle("Imagenes DICOM");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setMaximumSize(new Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        panelImagen = new PanelImagen();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnExtraer = new javax.swing.JButton();

        panelImagen.setBackground(new java.awt.Color(255, 102, 204));
        panelImagen.setMaximumSize(new java.awt.Dimension(400, 400));
        panelImagen.setMinimumSize(new java.awt.Dimension(400, 400));
        panelImagen.setPreferredSize(new java.awt.Dimension(400, 400));
        panelImagen.setSize(400, 400);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE));

        btnAbrir.setText("Abrir");

        btnExtraer.setText("Extraer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAbrir)
                .addGap(53, 53, 53)
                .addComponent(btnExtraer)
                .addContainerGap(58, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAbrir)
                .addComponent(btnExtraer))
                .addContainerGap(44, Short.MAX_VALUE)));

        
        
        panelResultado = new PanelResultado();
        
        jScrollPane1.setViewportView(panelResultado);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)))));

        /*ImagePlus imagePlus = new ImagePlus("C:\\IM-0001-0001.dcm");

         System.out.println(imagePlus);

         Image imagen = imagePlus.getImage();

         Image imagenEscalada = imagen.getScaledInstance(panelImagen.getHeight(), panelImagen.getWidth(), Image.SCALE_SMOOTH);

         panelImagen.setBackgroundImage(imagenEscalada); */

        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnExtraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraerActionPerformed(evt);
            }
        });

        pack();
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
}
