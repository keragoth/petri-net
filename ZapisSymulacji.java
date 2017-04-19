/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Grzegorz
 */
public class ZapisSymulacji {

    public HashMap<Integer, Figura> figury;
    public HashMap<Integer, HashMap> s_punkty;

    public ZapisSymulacji(int c, HashMap a) {
        this.figury = new HashMap<Integer, Figura>();
        this.figury = Rysunek.getDeepCopy(a);
        this.s_punkty = new HashMap<Integer, HashMap>();
        this.s_punkty.put(c, figury);
    }

    public HashMap<Integer, Figura> fig() {

        return this.figury;
    }

    public Integer czas() {
        Integer key = 0;
        for (Map.Entry< Integer, HashMap> entry : s_punkty.entrySet()) {
            key = entry.getKey();
        }
        return key;
    }
}
