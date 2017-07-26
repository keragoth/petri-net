/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.awt.Point;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Grzegorz
 */
class PointAdapter extends XmlAdapter<String, Point> {

    @Override
    public String marshal(Point v) throws Exception {
        return String.format("%d;%d", v.x, v.y);
    }

    @Override
    public Point unmarshal(String v) throws Exception {
        String[] coords = v.split(";");
        return new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

}
