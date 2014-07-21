/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package read.dicom.view;

import ij.ImagePlus;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Adriano
 */
public class PanelResultado extends JPanel {

    private int numImagenes;

    public PanelResultado() {
        super();
        setLayout(new GridLayout(0, 2, 20, 20));
    }

    public void setNumImagenes(int numImagenes) {
        this.numImagenes = numImagenes;
    }
   
    public void mostrarResultado() {
        this.removeAll();
        ImagePlus imagePlus = new ImagePlus("C:\\IM-0001-0001.dcm");
        System.out.println(imagePlus);
        Image imagen = imagePlus.getImage();
        Image imagenEscalada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        for (int i = 1;i <= numImagenes;i++) {
            add(new JLabel(new ImageIcon(imagenEscalada)));
        }
    }
}
