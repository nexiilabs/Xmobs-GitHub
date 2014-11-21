package scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelpIcon {
    public static Connection connection =null;
    public static Statement statement;
    public static ResultSet resultSet;
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        try {
               String driver = "com.mysql.jdbc.Driver";
               String url = "jdbc:mysql://212.117.213.18:3306/lapsinotes";
               String user = "root";
               String pwd = "nexiilabs@123";
             Class.forName(driver).newInstance();
             connection = DriverManager.getConnection(url,user,pwd);
             statement = connection.createStatement();
//             System.out.println("hurray connected");
             //resultSet = statement.executeQuery("select * from crm_user");
             resultSet = statement.executeQuery("select * from lapn_game");
             while(resultSet.next()){
            	 String str = resultSet.getString("game_name");
            	 System.out.println(str);
             }
              
             //String str = resultSet.getString("password");
             
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }

}