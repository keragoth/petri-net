/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

/**
 *
 * @author Grzegorz
 */
class Historia implements Cloneable {

    private String id;
    private int czas_p;
    private int czas_k;

    public Historia(String id, int p, int k) {
        this.id = id;
        this.czas_p = p;
        this.czas_k = k;
    }

    public Historia clone() throws CloneNotSupportedException {
        return (Historia) super.clone();
    }

    public int getP() {
        return this.czas_p;

    }

    public int getK() {
        return this.czas_k;

    }

    public String getID() {
        return this.id;
    }
}
