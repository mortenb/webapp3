/*
 * Bruker.java
 *
 * Created on 10. oktober 2007, 11:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package matchmaker;

import matchmaker.hjelpeklasser.DataAccess;
import java.util.*;

/**
 *
 * @author Andreas
 */
public class Bruker {
    
    private String brukernavn, bildeURL;
    private int preferanser[];
    private int brukerID;
    
    public Bruker() {
        brukernavn = "";
        preferanser= new int[10];
        brukerID = -1;
    }
    
    
    public void lagre()
    {
        //hvis brukerID = -1, lagre ny, hvis != -1 oppdater eksisterende.
        String sql;
        if( brukerID == -1)
        {
            sql = "INSERT INTO brukerprofil ";
            sql += "(`brukerID`,`brukernavn`, `bildeurl` ," +
                  "`pref1` ,`pref2` ,`pref3` ,`pref4` ,`pref5` ,`pref6` ,`pref7` ,`pref8` ," +
                  "`pref9` ,`pref10`) VALUES ( 'null', '" + brukernavn +"','testbilde.jpg'" ;
            for(int i = 0; i < preferanser.length; i++)
            {  
                sql += ", '" + preferanser[i] + "'";
            }
            sql += ");";
            System.out.println(sql);
        }
        else //Oppdaterer en eksisterende profil
        {
            sql = "UPDATE brukerprofil SET ";
            for(int i = 0; i < preferanser.length; i++)
            {
                sql += "pref" + (i+1) + "='" + preferanser[i] + "'";
                if(i < preferanser.length -1) sql += ", ";
            }
            sql += " WHERE brukernavn = '" + brukernavn + "';";
        }
        System.out.println(sql);
        //brukerprofil SET WHERE brukernavn = " + brukerID;
        try
        {
            DataAccess.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void getProfil()
    {
        //< hente profildata fra database hvis det finnes  >
        
        String sql = "SELECT * FROM brukerprofil WHERE brukernavn = '" + brukernavn + "'";
        
        List<List<String>> brukerinfo = DataAccess.getResultQuery(sql);
        
        if(brukerinfo.isEmpty()) return;
        
        for(List<String> l : brukerinfo)
        {
            
            brukerID = Integer.parseInt(l.get(0));
            bildeURL = l.get(2);
            for(int i = 0; i < preferanser.length; i++)
            {
                preferanser[i] = Integer.parseInt(l.get(i+3));
            }
            
        }
            
        
    }
    
    
    public void setBrukernavn(String navn)
    {
        this.brukernavn = navn;
        getProfil();
    }
    
    public String getBrukernavn()
    {
        return brukernavn;
    }
    
    public String getBildeurl()
    {
        return bildeURL;
    }
    
    public void setBildeUrl(String bildeurl)
    {
        this.bildeURL = bildeurl;
    }
    
    
    public void setPreferanse1(int pref)
    {
        preferanser[0] = pref;
    }

    public void setPreferanse2(int pref)
    {
        preferanser[1] = pref;
    }
        
    public void setPreferanse3(int pref)
    {
        preferanser[2] = pref;
    }
            
    public void setPreferanse4(int pref)
    {
        preferanser[3] = pref;
    }
                
    public void setPreferanse5(int pref)
    {
        preferanser[4] = pref;
    }
                    
    public void setPreferanse6(int pref)
    {
        preferanser[5] = pref;
    }
                        
    public void setPreferanse7(int pref)
    {
        preferanser[6] = pref;
    }
                            
    public void setPreferanse8(int pref)
    {
        preferanser[7] = pref;
    }
                                
    public void setPreferanse9(int pref)
    {
        preferanser[8] = pref;
    }
    
    public void setPreferanse10(int pref)
    {
        preferanser[9] = pref;
    }
    
    public int getPreferanse1()
    {
        return preferanser[0];
    }

    public int getPreferanse2()
    {
        return preferanser[1];
    }
        
    public int getPreferanse3()
    {
        return preferanser[2];
    }
            
    public int getPreferanse4()
    {
        return preferanser[3];
    }
                
    public int getPreferanse5()
    {
        return preferanser[4];
    }
                    
    public int getPreferanse6()
    {
        return preferanser[5];
    }
                        
    public int getPreferanse7()
    {
        return preferanser[6];
    }
                            
    public int getPreferanse8()
    {
        return preferanser[7];
    }
                                
    public int getPreferanse9()
    {
        return preferanser[8];
    }
    
    public int getPreferanse10()
    {
        return preferanser[9];
    }
    
    public static List<Bruker> getBrukere()
    {
        String sql = "SELECT brukernavn FROM brukerprofil ORDER BY brukernavn";
        List<List<String>> resultat = DataAccess.getResultQuery(sql);
        List<Bruker> brukerliste = new LinkedList<Bruker>();
        
        for(List<String> l : resultat)
        {           
            String brukernavn = l.get(0);
            brukerliste.add(Bruker.getBruker(brukernavn));
         }
        
        return brukerliste;
    }
    
    
    public static Bruker getBruker(String brukernavn)
    {
        Bruker b = new Bruker();
        b.setBrukernavn(brukernavn);
        return b;
        
    }
    

}
