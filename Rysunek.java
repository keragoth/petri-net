/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.BevelBorder;
import static testowa.Symulacja.h_sym;
import static testowa.Symulacja.his;

/**
 *
 * @author Grzegorz
 */
public class Rysunek extends JPanel implements MouseListener,
        MouseMotionListener, KeyListener {

    private static JPanel jp;

    private static void checkActivate(int index, Object[] arrObj) {

        Integer[] tmp;
        for (int i = 0; i < arrObj.length; i++) {
            tmp = c_linie.get(arrObj[i]).Wypisz();
            if (tmp[1] == index) {
                if (c_punkty.get(tmp[0]).ile() > 0) {
                    c_punkty.get(index).activate(1);

                } else if (c_punkty.get(tmp[0]).ile() == 0) {
                    c_punkty.get(index).activate(0);
                    break;

                }
            }
        }
    }
    private Point punkt;
    public static HashMap<Integer, Figura> punkty = new HashMap<Integer, Figura>();
    private int line = 0;
    private int ind = 0;
    private int x2 = 0, y2 = 0, x3 = 0, y3 = 0;
    private int t = 0;
    public static HashMap<Integer, Linie> linie = new HashMap<Integer, Linie>();
    public static HashMap<Integer, Figura> c_punkty;
    public static HashMap<Integer, Linie> c_linie;
    private JPopupMenu jpm;
    int krok = 0;
    int ind_h = 0;

    public Rysunek() {
        addMouseListener(this);
        addMouseMotionListener(this);
        jp = this;

    }

    public static HashMap<Integer, Figura> getDeepCopy(HashMap<Integer, Figura> source) {
        HashMap<Integer, Figura> copy = new HashMap<Integer, Figura>();
        for (Map.Entry<Integer, Figura> entry : source.entrySet()) {
            try {
                copy.put(entry.getKey(), entry.getValue().clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Rysunek.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return copy;
    }

    public HashMap<Integer, Linie> getDeepCopyLinie(HashMap<Integer, Linie> source) {
        HashMap<Integer, Linie> copy = new HashMap<Integer, Linie>();
        for (Map.Entry<Integer, Linie> entry : source.entrySet()) {
            try {
                copy.put(entry.getKey(), entry.getValue().clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Rysunek.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return copy;
    }

    public Rysunek(HashMap<Integer, Figura> p, HashMap<Integer, Linie> l) {

        addMouseListener(this);
        addMouseMotionListener(this);
        jp = this;

        c_punkty = getDeepCopy(p);
        c_linie = new HashMap<Integer, Linie>(l);
        if (Ustawienia.symulacja == 1) {
            Ustawienia.blokada = 0;
            checkStatus(1);
            Ustawienia.krok = 0;
            Ustawienia.max_krok = 0;
            Ustawienia.czas = 0;
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mousePressed(MouseEvent me) {

        int wh = 0;

        int x1 = me.getX();
        int y1 = me.getY();

        Point punkt1 = null;
        if (Ustawienia.symulacja == 0) { //podczas edycji
            //
       
            
        } //koniec edycji
        //podczas symulacji
      
            //koniec symulacji
      //  }
/*
        if (Ustawienia.symulacja == 0) {
            repaint();
        }*/
    }

    public static void checkStatus(int ind) {
        if (Ustawienia.symulacja == 1) {
            int index = 0;
            int size = c_punkty.size();
            if (ind == -1) {
/**/
               
            } //</editor-fold>
            else if (ind == 1) {
                while (index < size) {
                    boolean stan = false;
                    Integer tmp[];
                    if (c_punkty.get(index).TypFig() == 2) {
                        Set<Integer> liness = c_punkty.get(index).tab();
                        Object[] arrObj = liness.toArray();
                        for (int i = 0; i < liness.size(); i++) {
/**/
                        }
                       /**/
                    }
                    index++;
                }
            }
        }
        refresh();
    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        punkt = null;
        Ustawienia.SELECTID = 0;

    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me
    ) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (Ustawienia.symulacja == 0) {
            if (punkt != null) {
                punkt.x = me.getX();
                punkt.y = me.getY();
                repaint();
            }
            // <editor-fold defaultstate="collapsed" desc="zmiana pozycji id">
            if (Ustawienia.SELECTID == 1) {

                if (Ustawienia.x > me.getX()) {
                    if (Ustawienia.y > me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 0) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(3);
                        }
                        if (punkty.get(Ustawienia.SELECT).pozID() == 1) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(2);
                        }
                    }
                    //nastaw.getY()
                    if (Ustawienia.y < me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 1) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(0);
                        }
                        if (punkty.get(Ustawienia.SELECT).pozID() == 2) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(3);
                        }
                    }
                    if (Ustawienia.y == me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 1) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(3);
                        }
                    }
                }
                //nastaw.getX()
                if (Ustawienia.x < me.getX()) {
                    if (Ustawienia.y > me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 0) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(1);
                        }
                        if (punkty.get(Ustawienia.SELECT).pozID() == 3) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(2);
                        }
                    }

                    if (Ustawienia.y < me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 3) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(0);
                        }
                        if (punkty.get(Ustawienia.SELECT).pozID() == 2) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(1);
                        }
                    }
                    if (Ustawienia.y == me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 3) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(1);
                        }
                    }
                }

                if (Ustawienia.x == me.getX()) {
                    if (Ustawienia.y > me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 0) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(2);
                        }
                    }

                    if (Ustawienia.y < me.getY()) {
                        if (punkty.get(Ustawienia.SELECT).pozID() == 2) {
                            punkty.get(Ustawienia.SELECT).ustaw_pozID(0);
                        }
                    }
                }

                repaint();
            }
            //</editor-fold>
        }
    }

    @Override
    public void mouseMoved(MouseEvent me
    ) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void refresh() {
        jp.repaint();

    }

    @Override
    protected void paintComponent(Graphics g
    ) {
        if (Ustawienia.symulacja == 1) {
            // checkStatus(); 
        }
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE); 

        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        g2d.setColor(Color.BLACK); 

        rysuj(g2d);

    }

    public void rysuj(Graphics2D g2d) {
        int x, y;
        int x1, y1;
        Iterator it = punkty.entrySet().iterator();
        //System.out.println("-------------------------- Rysuj");
        while (it.hasNext()) {
            Entry thisEntry = (Entry) it.next();
            Object key = thisEntry.getKey();
            x = (int) punkty.get(key).PunktFig().getX();
            y = (int) punkty.get(key).PunktFig().getY();
            if (punkty.get(key).TypFig() == 1) {
                /**/
            } else if (punkty.get(key).TypFig() == 2) {
   /**/
            }

        }

        Iterator ite = linie.entrySet().iterator();
        Integer tmp[];
        double kat = 0;
        while (ite.hasNext()) {
            Entry thisEntry = (Entry) ite.next();
            Object key = thisEntry.getKey();
            if (linie.get(key).Typ() == 1) {
                tmp = linie.get(key).Wypisz();

                if (punkty.get(tmp[0]).TypFig() == 1) {
                    x = (int) punkty.get(tmp[0]).PunktFig().getX();
                    y = (int) punkty.get(tmp[0]).PunktFig().getY();

                    x1 = (int) punkty.get(tmp[1]).PunktFig().getX();
                    y1 = (int) punkty.get(tmp[1]).PunktFig().getY();

                    x += 15;
                    y += 15;
                    x1 += 15;
                    y1 += 15;

                    double arc = Math.atan2(-y1 + y, x1 - x);
                    kat = -arc;

                    double arc2 = Math.atan2(-y1 + y, -x1 + x);
                    double kat2 = arc2;

                    g2d.setColor(Color.GREEN);

                    double xw = 15 * Math.cos(kat2) + x1;
                    double yw = 15 * Math.sin(kat2) + y1;

                    double xx = 15 * Math.cos(kat) + x;
                    double yy = 15 * Math.sin(kat) + y;

                    double dx = (xw - xx), dy = (yw - yy);
                    double D = Math.sqrt(dx * dx + dy * dy);
                    double xm = D - 11, xn = xm, ym = 5, yn = -5, ne;
                    double sin = dy / D, cos = dx / D;

                    ne = xm * cos - ym * sin + xx;
                    ym = xm * sin + ym * cos + yy;
                    xm = ne;

                    ne = xn * cos - yn * sin + xx;
                    yn = xn * sin + yn * cos + yy;
                    xn = ne;

                    int[] xpoints = {(int) xw, (int) xm, (int) xn};
                    int[] ypoints = {(int) yw, (int) ym, (int) yn};

                    g2d.drawLine((int) xx, (int) yy, (int) xw, (int) yw);
                    g2d.fillPolygon(xpoints, ypoints, 3);
                }
                //===========================================================
                if (punkty.get(tmp[0]).TypFig() == 2) {
                    x = (int) punkty.get(tmp[0]).PunktFig().getX();
                    y = (int) punkty.get(tmp[0]).PunktFig().getY();

                    x1 = (int) punkty.get(tmp[1]).PunktFig().getX();
                    y1 = (int) punkty.get(tmp[1]).PunktFig().getY();

                    x += 15;
                    y += 15;
                    x1 += 15;
                    y1 += 15;
                    double arc = Math.atan2(-y1 + y, x1 - x);
                    kat = -arc;

                    double arc2 = Math.atan2(-y1 + y, -x1 + x);
                    double kat2 = arc2;

                    g2d.setColor(Color.GREEN);

                    double xw = 15 * Math.cos(kat2) + x1;
                    double yw = 15 * Math.sin(kat2) + y1;

                    double xx = 15 * Math.cos(kat) + x;
                    double yy = 15 * Math.sin(kat) + y;

                    double dx = (xw - xx), dy = (yw - yy);
                    double D = Math.sqrt(dx * dx + dy * dy);
                    double xm = D - 11, xn = xm, ym = 5, yn = -5, ne;
                    double sin = dy / D, cos = dx / D;

                    ne = xm * cos - ym * sin + xx;
                    ym = xm * sin + ym * cos + yy;
                    xm = ne;

                    ne = xn * cos - yn * sin + xx;
                    yn = xn * sin + yn * cos + yy;
                    xn = ne;

                    int[] xpoints = {(int) xw, (int) xm, (int) xn};
                    int[] ypoints = {(int) yw, (int) ym, (int) yn};

                    g2d.drawLine((int) xx, (int) yy, (int) xw, (int) yw);
                    g2d.fillPolygon(xpoints, ypoints, 3);

                }
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent ke
    ) {
        //  System.out.println("Typed");
    }

    @Override
    public void keyPressed(KeyEvent ke
    ) {
        //  System.out.println("Presed");
    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {
        // System.out.println("Released");
    }

    ActionListener menuListener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {

            if (event.getActionCommand() == "Właściwości") {
                Wlasciwosci tmp = new Wlasciwosci(Ustawienia.SELECT);
                tmp.show();
                tmp.setLocationRelativeTo(null);

            }
            if (event.getActionCommand() == "Usuń") {
                delete();
           
                repaint();

            }
            if (event.getActionCommand() == "+1") {
                punkty.get(Ustawienia.SELECT).dodaj();
        
                repaint();

            }
            if (event.getActionCommand() == "-1") {
                punkty.get(Ustawienia.SELECT).odejmij();
               
                repaint();

            }
        }
    };

    class MousePopupListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            checkPopup(e);
        }

        public void mouseClicked(MouseEvent e) {
            checkPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            checkPopup(e);
        }

        private void checkPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                if (jpm != null) {
//                    jpm.show(Rysunek.this, e.getX(), e.getY());
                }
            }
        }
    }

    public void delete() {
        Object toRemove = null;
        int x1, y1;
        Iterator it = punkty.entrySet().iterator();
        // <editor-fold defaultstate="collapsed" desc="pobranie wybranego obiektu">
        while (it.hasNext()) {
            Entry thisEntry = (Entry) it.next();
            Object key = thisEntry.getKey();
            x1 = Ustawienia.x;
            y1 = Ustawienia.y;
            x2 = (int) punkty.get(key).PunktFig().getX();
            y2 = (int) punkty.get(key).PunktFig().getY();
            if (punkty.get(key).TypFig() == 1) {
                if (x1 >= x2 && y1 >= y2 && x1 <= x2 + 30 && y1 <= y2 + 30) {
                    toRemove = key;
                }
            } else if (punkty.get(key).TypFig() == 2) {
                if (x1 >= x2 && y1 >= y2 && x1 <= x2 + 30 && y1 <= y2 + 30) {
                    toRemove = key;
                }
            }

        }
//</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="usuniecie obiektu">
        if (toRemove != null) {
            Iterator iterator = punkty.get(toRemove).ZLinia().iterator();

            while (iterator.hasNext()) {

                Integer element = (Integer) iterator.next();
                linie.get(element).ZTyp(0);
            }

            punkty.get(toRemove).LiniaUsun();
            punkty.get(toRemove).zTypFig(0);
            updateFigury();
        }

        //</editor-fold>
    }

    public void updateFigury() {
        Iterator it = punkty.entrySet().iterator();
        HashMap<Integer, Figura> copy = new HashMap<Integer, Figura>();
        int l = 0;
        int lm = 0, lt = 0;
        boolean stan = false;
        while (it.hasNext()) {
            Entry thisEntry = (Entry) it.next();
            Object key = thisEntry.getKey();
            int typ = punkty.get(key).TypFig();
 /**/
        }
        this.punkty = getDeepCopy(copy);
        Ustawienia.it = lt;
        Ustawienia.im = lm;
    }

    public void updateLinie() {
        Iterator it = linie.entrySet().iterator();
        HashMap<Integer, Linie> copy = new HashMap<Integer, Linie>();
        int l = 0;
        boolean stan = false;
        while (it.hasNext()) {
            Entry thisEntry = (Entry) it.next();
            Object key = thisEntry.getKey();
            int typ = linie.get(key).Typ();
/**/
        }
        this.linie = getDeepCopyLinie(copy);

    }

    public static void process(int index) {
        Integer tmp[];
        boolean st = false;
        if (c_punkty.get(index).getStatus() == 1) {
            Set<Integer> liness = c_punkty.get(index).tab();
            Object[] arrObj = liness.toArray();
            for (int i = 0; i < liness.size(); i++) {
                tmp = c_linie.get(arrObj[i]).Wypisz();
                if (tmp[0] != index) {
                    if (c_punkty.get(tmp[0]).ile() > 0) {
                        c_punkty.get(tmp[0]).odejmij();
                        c_punkty.get(index).setTime(0);
                        c_punkty.get(index).blokuj(0);

                        st = true;

                    } else {
                    }
                } else if (tmp[0] == index) {
                    if (c_punkty.get(index).getStatus() == 1) {
                        c_punkty.get(tmp[1]).dodaj();
                        st = true;
                    }
                }
            }
        }
        if (st == true) {
            c_punkty.get(index).setTime(0);

        }

        checkStatus(1);

    }
}
