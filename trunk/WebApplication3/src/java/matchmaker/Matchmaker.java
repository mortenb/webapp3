/*
 * Matchmaker.java
 *
 * Created on 10. oktober 2007, 11:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package matchmaker;

import java.util.*;

/**
 *
 * @author Andreas
 */
public class Matchmaker {
    
    private Bruker bruker;
    
    /** Creates a new instance of Matchmaker */
    public Matchmaker() {
    }
    
    
    //public void 
    public void setBruker(Bruker b)
    {
        //b.lagre();
        bruker = b;
    }
    
    public Bruker getBruker()
    {
        return bruker;
    }
    
    public String getMatchNavn()
    {
        /*Bruker b = new Bruker();
        b.setBrukernavn("frode");
        
        return b.getBrukernavn();*/
        return getBesteMatchNavn();
    }
    
    private List<Bruker> getSortertMatchListe()
    {
        /*List<List<String>> resultat;
        String sql;
        sql = "select brukernavn, ";
        sql += "power(pref1-3, 2)+power(pref2-3, 2)+power(pref3-3, 2) as avstand from brukerprofil order by avstand;
        */
        return null;
    }
    
    private String getBesteMatchNavn()
    {
        //super simpel algoritme for å hente ut beste match.
        double minAvstand = Double.MAX_VALUE;
        String minAvstandNavn = "Det har oppstått en feil. Vennligst fall kontrollert til venstre og rop, hey doodle doodle dei.";
        
        for(Bruker b : Bruker.getBrukere())
        {
            double tempAvstand = getTotalAvstand(b, bruker);
            //System.out.println(b.getBrukernavn().equalsIgnoreCase(bruker.getBrukernavn()));
            if(tempAvstand < minAvstand)
            {
                if(b.getBrukernavn().equalsIgnoreCase(bruker.getBrukernavn()) == false)
                {   
                    minAvstand = tempAvstand;
                    minAvstandNavn = b.getBrukernavn();
                }
            }
        }
        
        
        return minAvstandNavn;
    }
    
    private double getTotalAvstand(Bruker b1, Bruker b2)
    {
        
        Double total = 0.0;
        
        total += avstand(b1.getPreferanse1(), b2.getPreferanse1());
        total += avstand(b1.getPreferanse2(), b2.getPreferanse2());
        total += avstand(b1.getPreferanse3(), b2.getPreferanse3());
        total += avstand(b1.getPreferanse4(), b2.getPreferanse4());
        total += avstand(b1.getPreferanse5(), b2.getPreferanse5());
        total += avstand(b1.getPreferanse6(), b2.getPreferanse6());
        total += avstand(b1.getPreferanse7(), b2.getPreferanse7());
        total += avstand(b1.getPreferanse8(), b2.getPreferanse8());
        total += avstand(b1.getPreferanse9(), b2.getPreferanse9());
        total += avstand(b1.getPreferanse10(), b2.getPreferanse10());
        
        return total;              
    }
    private double avstand(int a1, int a2)
    {
            return Math.pow(a1 - a2, 2.0);
    }   
    
    
}
