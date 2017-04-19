/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grzegorz
 */
@XmlRootElement(name = "linia")
@XmlAccessorType(XmlAccessType.FIELD)
public class Linie implements Cloneable {

    private int obj1;
    private int obj2;
    private int typ;

    public Linie() {

    }
    public Linie clone() throws CloneNotSupportedException {
        return (Linie) super.clone();
    }

    public Linie(int o1, int o2, int t) {
        this.obj1 = o1;
        this.obj2 = o2;
        this.typ = t;
    }

    public void Zmien1(int o) {
        this.obj1 = o;
    }

    public void Zmien2(int o) {
        this.obj2 = o;
    }

    public Integer[] Wypisz() {
        Integer[] tmp = {this.obj1, this.obj2};
        return tmp;
    }

    public int Typ() {
        return this.typ;
    }

    public void ZTyp(int t) {
        this.typ = t;
    }
}
