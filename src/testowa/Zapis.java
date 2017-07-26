/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.awt.Dimension;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import static testowa.Rysunek.punkty;
import static testowa.Rysunek.linie;

/**
 *
 * @author Grzegorz
 */
public class Zapis {

    int status;
    Dimension rozmiar;

    public Zapis(Dimension size) throws FileNotFoundException, JAXBException {
        this.rozmiar = size;
        showSaveFileDialog();
    }

    private void showSaveFileDialog() throws FileNotFoundException, JAXBException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setPreferredSize(new Dimension(500, 500));
        fileChooser.setDialogTitle("Specify a file to save");
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Model sieci (*.tpngp)", "tpngp");
        fileChooser.setFileFilter(fileFilter);
        String path = GUI.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        fileChooser.setCurrentDirectory(new File(path));

        Action lista = fileChooser.getActionMap().get("viewTypeDetails");
        lista.actionPerformed(null);

        int status = fileChooser.showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            String tmp = fileToSave.getAbsolutePath();
            int dl = tmp.length();
            if (!tmp.substring(dl - 5, dl).toLowerCase().matches("tpngp")) {
                tmp += ".tpngp";
            }
            Zapisz(tmp);

        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("Canceled");
        }
    }

    private void Zapisz(String f) throws FileNotFoundException, JAXBException {

        // create JAXB context and instantiate marshaller
        File file = new File(f);
        JAXBContext context = JAXBContext.newInstance(Root.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Root root = new Root();

        root.data = currentDateStr();
        root.it = Ustawienia.it;
        root.im = Ustawienia.im;
        root.szer = this.rozmiar.width;
        root.wys = this.rozmiar.height;

        root.figures = new FiguraMap();
        root.lines = new LinieMap();
        root.figures.setFiguraMap(punkty);
        root.lines.setLinieMap(linie);
        m.marshal(root, file);

    }

    public Date currentDateStr() {

        java.util.Date date = new java.util.Date();

        return date;
    }
}
