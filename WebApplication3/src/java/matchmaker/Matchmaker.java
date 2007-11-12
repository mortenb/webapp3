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
    public void setBruker(Bruker b) {
        //b.lagre();
        bruker = b;
    }
    
    public Bruker getBruker() {
        return bruker;
    }
    
    public String getMatchNavn() {
        /*Bruker b = new Bruker();
        b.setBrukernavn("frode");
         
        return b.getBrukernavn();*/
        return getBesteMatchNavn();
    }
    
    public List<Bruker> getSortertMatchListe() {
        List<Bruker> alleBrukere = Bruker.getBrukere();
        System.out.println("for for" + alleBrukere.size());
        Bruker fjern = new Bruker();
        for(Bruker b : alleBrukere) {
            if(b.getBrukernavn().equalsIgnoreCase(bruker.getBrukernavn())) {
                fjern = b;
            }
        }
        alleBrukere.remove(fjern);
        List<Bruker> alleSorterteBrukere = new ArrayList<Bruker>();
        
        System.out.println("for while" + alleBrukere.size());
        while(!alleBrukere.isEmpty()) {
            double minAvstand = Double.MAX_VALUE;
            Bruker best = null;         
            for(Bruker b : alleBrukere) {
                double tempAvstand = getTotalAvstand(b, bruker);
                if(tempAvstand < minAvstand) {
                    minAvstand = tempAvstand;
                    best = b;
                }
            }
            alleSorterteBrukere.add(best);
            alleBrukere.remove(best);
        }
        return alleSorterteBrukere;
    }
    
    private String getBesteMatchNavn() {
        //super simpel algoritme for å hente ut beste match.
        double minAvstand = Double.MAX_VALUE;
        String minAvstandNavn = "Det har oppstått en feil. Vennligst fall kontrollert til venstre og rop, hey doodle doodle dei.";
        
        for(Bruker b : Bruker.getBrukere()) {
            double tempAvstand = getTotalAvstand(b, bruker);
            //System.out.println(b.getBrukernavn().equalsIgnoreCase(bruker.getBrukernavn()));
            if(tempAvstand < minAvstand) {
                if(b.getBrukernavn().equalsIgnoreCase(bruker.getBrukernavn()) == false) {
                    minAvstand = tempAvstand;
                    minAvstandNavn = b.getBrukernavn();
                }
            }
        }
        
        
        return minAvstandNavn;
    }
    
    private double getTotalAvstand(Bruker b1, Bruker b2) {
        
        Double total = 0.0;
        if(b2.getKriterie1() == 1)
            total += avstand(b1.getPreferanse1(), b2.getPreferanse1());
        if(b2.getKriterie2() == 1)
            total += avstand(b1.getPreferanse2(), b2.getPreferanse2());
        if(b2.getKriterie3() == 1)
            total += avstand(b1.getPreferanse3(), b2.getPreferanse3());
        if(b2.getKriterie4() == 1)
            total += avstand(b1.getPreferanse4(), b2.getPreferanse4());
        if(b2.getKriterie5() == 1)
            total += avstand(b1.getPreferanse5(), b2.getPreferanse5());
        if(b2.getKriterie6() == 1)
            total += avstand(b1.getPreferanse6(), b2.getPreferanse6());
        if(b2.getKriterie7() == 1)
            total += avstand(b1.getPreferanse7(), b2.getPreferanse7());
        if(b2.getKriterie8() == 1)
            total += avstand(b1.getPreferanse8(), b2.getPreferanse8());
        if(b2.getKriterie9() == 1)
            total += avstand(b1.getPreferanse9(), b2.getPreferanse9());
        if(b2.getKriterie10() == 1)
            total += avstand(b1.getPreferanse10(), b2.getPreferanse10());
        
        return total;
    }
    private double avstand(int a1, int a2) {
        return Math.pow(a1 - a2, 2.0);
    }
    
    
}
