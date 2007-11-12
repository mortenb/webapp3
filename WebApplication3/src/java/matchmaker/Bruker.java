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
import javax.faces.model.SelectItem;

/**
 *
 * @author Andreas
 */
public class Bruker {
    
    private String brukernavn, bildeURL;
    private int preferanser[];
    private int brukerID;
    private List alternativer = new ArrayList();
    private int kriterier[]; //Hvilke kriterier som skal regnes med
    private List kriterieAlternativer = new ArrayList();
    
    
    
    public Bruker() 
    {
        brukernavn = "";
        preferanser= new int[10];
        kriterier = new int[preferanser.length];
        brukerID = -1;
        for(int i = 1; i<6; i++)
        {  
            SelectItem u = new SelectItem(i);
            alternativer.add(u);
        }
        for(int i = 0; i<kriterier.length; i++)
            kriterier[i] = 1;
        
        
            SelectItem u = new SelectItem(0,"nei");
            kriterieAlternativer.add(u);
            SelectItem v = new SelectItem(1, "ja");
            kriterieAlternativer.add(v);
            
            
    
    }
    public List getAlternativer()
    {
        
        return alternativer;
        
    }
    
    public List getKriterieAlternativer()
    {
        return kriterieAlternativer;
    }
    
    public void setKriterie1( int i )
    {
        kriterier[0] = i;
    }
    
    public int getKriterie1()
    {
        return kriterier[0];
    }
    
   
    
     public void setKriterie2( int i )
    {
        kriterier[1] = i;
    }
    
    public int getKriterie2()
    {
        return kriterier[1];
    }
    
     public void setKriterie3( int i )
    {
        kriterier[2] = i;
    }
    
    public int getKriterie3()
    {
        return kriterier[2];
    }
    
     public void setKriterie4( int i )
    {
        kriterier[3] = i;
    }
    
    public int getKriterie4()
    {
        return kriterier[3];
    }
    
     public void setKriterie5( int i )
    {
        kriterier[4] = i;
    }
    
    public int getKriterie5()
    {
        return kriterier[4];
    }
    
     public void setKriterie6( int i )
    {
        kriterier[5] = i;
    }
    
    public int getKriterie6()
    {
        return kriterier[5];
    }
    
   public void setKriterie7( int i )
    {
        kriterier[6] = i;
    }
    
    public int getKriterie7()
    {
        return kriterier[6];
    }
    
     public void setKriterie8( int i )
    {
        kriterier[7] = i;
    }
    
    public int getKriterie8()
    {
        return kriterier[7];
    }
     public void setKriterie9( int i )
    {
        kriterier[8] = i;
    }
    
    public int getKriterie9()
    {
        return kriterier[8];
    }
    
     public void setKriterie10( int i )
    {
        kriterier[9] = i;
    }
    
    public int getKriterie10()
    {
        return kriterier[9];
    }
    
    public String lagre()
    {
        String retur = "visStat";
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
        return retur;
    }
    
    private void getProfil()
    {
        //< hente profildata fra database hvis det finnes  >
        
        String sql = "SELECT * FROM brukerprofil WHERE brukernavn = '" + brukernavn + "'";
        System.out.println("getprofil kalles nå: " + sql);
        List<List<String>> brukerinfo = DataAccess.getResultQuery(sql);
        System.out.println("antall:" + brukerinfo.size() );
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
    
    public String getMatch()
    {
        String ut = "";
        Matchmaker m = new Matchmaker();
        m.setBruker(this);
        List<Bruker> brukere = m.getSortertMatchListe();
        for(Bruker b : brukere)
        {
            ut += "" + b.getBrukernavn();
        }
        System.out.println(ut);
        return ut;
    }
    

}
