/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Grzegorz
 */
@XmlRootElement
public class Root {

    public int wys;
    public int szer;
    public int it;
    public int im;
    public Date data;
    public FiguraMap figures;

    public LinieMap lines;

}
