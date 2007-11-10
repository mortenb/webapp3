package matchmaker.hjelpeklasser;
import java.sql.*;
import java.util.Collections;
import java.util.Collection;
import java.util.*;


public class DataAccess {
    private static final String connectionString = "jdbc:mysql://cube.iu.hio.no/";
    private static final String dbName = "s134846";
    private static final String userName = "s134846";
    private static final String passWord = "";
    private static final String driverName = "com.mysql.jdbc.Driver";
    
    /** Does not Create a new instance of DataAccess */
    private DataAccess() {
    }
    
    private static Connection getConnection() throws Exception
    {
        Connection c = null;
        try{
            Class.forName(driverName).newInstance();
            
            c = DriverManager.getConnection(connectionString + dbName, userName, passWord);
            
        }
        catch (Exception e){
            //TODO: do something
            System.out.println(e.getMessage());
            throw e;
        }
        return c;
    }
    
    public static List<List<String>> getResultQuery(String sql)
    {
        List<List<String>> resultat = new ArrayList<List<String>>();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        
        try{
            c = getConnection();
            
            s = c.createStatement();
            
            rs = s.executeQuery(sql);
               
            
            System.out.println(rs.getMetaData().getColumnCount());
            while(rs.next())
            {
                List<String> kolonner = new ArrayList<String>();
                for(int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++)
                {
                    
                    kolonner.add(rs.getString(i));
                    
                }
                resultat.add(kolonner);
            }
            
            rs.close();
            s.close();
            
            c.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
       
        return resultat;
    }
    
    public static int executeUpdate(String sql) throws Exception//returnerer affected rows
    {
        Connection c = null;
        Statement s = null;
        
        
            c = getConnection();
            s = c.createStatement();
            
            
            s.execute(sql);
            
        
        
        return 0;
    }
    
    public static int executeInsert(String sql) //returnerer id til insatt verdi
    {
        return 0;
    }
    
    
}
