/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Grzegorz
 */
public class Otworz {

    int status;

    public Otworz() throws FileNotFoundException, JAXBException {
        showOpenFileDialog();
    }

    private void showOpenFileDialog() throws FileNotFoundException, JAXBException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setPreferredSize(new Dimension(500, 500));
        fileChooser.setDialogTitle("Specify a file to open");
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Model sieci (*.tpngp)", "tpngp");
        fileChooser.setFileFilter(fileFilter);

        String path = GUI.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath = null;
        try {
            decodedPath = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Otworz.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (decodedPath != null) {
            path = decodedPath;
        }
        fileChooser.setCurrentDirectory(new File(path));

        Action lista = fileChooser.getActionMap().get("viewTypeDetails");
        lista.actionPerformed(null);

        int status = fileChooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
          
            Otworz(fileToOpen.getAbsolutePath());

        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("Canceled");
        }
    }

    private void Otworz(String f) throws FileNotFoundException, JAXBException {

        // create JAXB context and instantiate marshaller
        File file = new File(f);
        JAXBContext context = JAXBContext.newInstance(Root.class);

        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

        Root dane = (Root) jaxbUnmarshaller.unmarshal(file);

        Ustawienia.it = dane.it;
        Ustawienia.im = dane.im;

        Rysunek.punkty = dane.figures.getFiguraMap();
        Rysunek.linie = dane.lines.getLinieMap();

        Rysunek.refresh();

    }

}
