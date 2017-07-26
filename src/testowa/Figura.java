/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Grzegorz
 */
@XmlRootElement(name = "figura")
@XmlAccessorType(XmlAccessType.FIELD)
public class Figura implements Cloneable {

    private int typ;
    private String id; 
    //@XmlTransient
    @XmlElement
    @XmlJavaTypeAdapter(PointAdapter.class)
    private Point punkt1;
    private String etykieta = null;
    private int poz_ety = -1;
    private int poz_id = 0;
    private int start_time = 0;
    private int end_time = 0;
    private int time = 0;
    private int status = 0;
    private int blokada = 0;
    private int active = 0;

    private Set<Integer> Linia = new HashSet<Integer>();
    private int ile;

    public Figura() {

    }

    public void activate(int s) {
        this.active = s;
    }

    public int active() {
        return this.active;
    }

    public void blokuj(int s) {
        this.blokada = s;
    }

    public int blok() {
        return this.blokada;
    }

    public Figura(Point p, int t, String id) {
        this.typ = t;
        this.punkt1 = p;
        this.id = id;

    }

    public Figura clone() throws CloneNotSupportedException {
        return (Figura) super.clone();
    }

    public Point PunktFig() {
        return this.punkt1;
    }

    public String getID() {
        return this.id;
    }

    public int getST() {
        return this.start_time;
    }

    public void setST(int czas) {
        this.start_time = czas;
    }

    public int getET() {
        return this.end_time;
    }

    public void setET(int czas) {
        this.end_time = czas;
    }

    public void setTime(int s) {
        this.time = s;
    }

    public int getTime() {
        return this.time;
    }

    public Integer TypFig() {
        return this.typ;
    }

    public void zPunktFig(Point p) {
        this.punkt1 = p;
    }

    public void LiniaDodajEl(int i) {
        this.Linia.add(i);
    }

    public void LiniaUsunEl(int i) {
        this.Linia.remove(i);
    }

    public void LiniaUsun() {
        this.Linia.removeAll(Linia);
    }

    public void zTypFig(int t) {
        this.typ = t;
    }

    public void dodaj() {
        this.ile++;
    }

    public void odejmij() {
        if (this.ile > 0) {
            this.ile--;
        }
    }

    public void ustaw_ile(int i) {
        this.ile = i;
    }

    public void ustaw_etykiete(String ety) {
        this.etykieta = ety;
    }

    public String pobierz_etykiete() {
        return this.etykieta;
    }

    public int pozID() {
        return this.poz_id;
    }

    public void ustaw_pozID(int poz) {
        this.poz_id = poz;
    }

    public Set<Integer> tab() {
        return Linia;
    }

    public void setStatus(int s) {
        this.status = s;
    }

    public int getStatus() {
        return this.status;
    }

    public int ile() {
        return this.ile;
    }

    public Set ZLinia() {
        return this.Linia;
    }

    public void setID(String id) {
        this.id = id;
    }

}
