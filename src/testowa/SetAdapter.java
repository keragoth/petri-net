/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.awt.Point;
import java.util.Set;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Grzegorz
 */
class SetAdapter extends XmlAdapter<String, Set<Integer>> {

    @Override
    public Set<Integer> unmarshal(String vt) throws Exception {
        System.out.println(vt);
        return null;
    }

    @Override
    public String marshal(Set<Integer> bt) throws Exception {
        
        return bt.toString();
    }


}
