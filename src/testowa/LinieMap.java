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
@XmlRootElement(name = "linie")
@XmlAccessorType(XmlAccessType.FIELD)
public class LinieMap {

    private HashMap<Integer, Linie> linieMap = new HashMap<Integer, Linie>();

    public HashMap<Integer, Linie> getLinieMap() {
        return linieMap;
    }

    public void setLinieMap(HashMap<Integer, Linie> linieMap) {
        this.linieMap = linieMap;
    }
}
