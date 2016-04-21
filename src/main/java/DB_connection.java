
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DB_connection {
    private String db_url = "jdbc:mysql://localhost/euro_2016";
    private String db_password ="root";
    private String db_username="root";
    private String db_name="euro_2016";
    private String user_table="users";
    private Connection connection;
    private PreparedStatement statement= null;
    private ResultSet result = null;
    
    
    
    // constructori
    
    protected DB_connection(String db_name, String db_username, String db_password){
        this.db_name= db_name;
        this.db_username=db_username;
        this.db_password=db_password;
    }
    
    protected DB_connection(){
    }
    
    protected void makeConnection() throws InstantiationException, IllegalAccessException{
       
            try {
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                try {
                    connection =DriverManager.getConnection(db_url, db_username,db_password);
                    System.out.println("S-a conectat la DB");
                } catch (SQLException ex) {
                    Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
    
    protected boolean checkUser(String username, String password) throws SQLException{
        boolean isInDb = false;
       
        String dbValues = "select * from users where user_id = '" + username + "' and password ='"+password + "' ";
         statement = connection.prepareStatement(dbValues);
        result = statement.executeQuery();
        while (result.next()){
            String user = result.getString("user_id");
            String pass = result.getString("password");
            if (user.equals(username)&&pass.equals(password)){
                System.out.print("User and password ok");
                isInDb= true;
                
            }
        }
        
        return isInDb;
    }
      protected boolean checkUser_id(String username) throws SQLException{
        boolean isInDb = false;
       
        String dbUsers = "select * from users where user_id = '" + username + "' ";
        statement = connection.prepareStatement(dbUsers);
        result = statement.executeQuery();
        while (result.next()){
            String user = result.getString("user_id");
           
            if (user.equals(username)){
                System.out.print("User exist in DB");
                isInDb= true;
                
            }
        }
        
        return isInDb;
    }
    
      protected void addUserToDB (Users user){
        String query = "INSERT INTO " + user_table + " (user_id, password, name, surname, email, department)"
                + " values (?, ?, ?, ?, ?, ?);";
        
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getUser_id());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getDepartment());
           
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Cannot add user to Db", e);
        } 
    }
}
