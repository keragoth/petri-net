/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grzegorz
 */
@XmlRootElement(name = "figury")
@XmlAccessorType(XmlAccessType.FIELD)
public class FiguraMap {

    private HashMap<Integer, Figura> figuraMap = new HashMap<Integer, Figura>();

    public HashMap<Integer, Figura> getFiguraMap() {
        return figuraMap;
    }

    public void setFiguraMap(HashMap<Integer, Figura> figuraMap) {
        this.figuraMap = figuraMap;
    }

}
