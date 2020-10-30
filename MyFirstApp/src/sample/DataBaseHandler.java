package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sample.assets.User;

public class DataBaseHandler extends Configs
{
Connection dbConnection ;
public Connection getDbConnection() throws ClassNotFoundException, SQLException
{
  //String ConnectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
  String ConnectionString = "jdbc:mysql://" + dbHost + ":"
      + dbPort +"/" +dbName + "?" +
      //String ConnectionString = "jdbc:mysql://127.0.0.1:3306/mydbtest";

  Class.forName("com.mysql.cj.jdbc.Driver");
  dbConnection = DriverManager.getConnection(ConnectionString, dbUser, dbPass);
  //dbConnection = DriverManager.getConnection(ConnectionString, "root", "root");
  return dbConnection;
}

public void signUpUser(User user)
{
  String insert = "INSERT INTO" + Const.USER_TABLE + "(" + Const.USERS_NAME + "," + Const.USERS_SURNAME + ","
      + Const.USERS_USERNAME +"," + Const.USERS_PASSWORD + "," + Const.USERS_GENDER + ")" +"VALUES(?,?,?,?,?)";

  try {
    PreparedStatement prSt = getDbConnection().prepareStatement(insert);
    prSt.setString(1, user.getFirstname());
    prSt.setString(2, user.getLastname());
    prSt.setString(3, user.getUsername());
    prSt.setString(4, user.getPassword());
    prSt.setString(5, user.getGender());

    prSt.executeUpdate();
  } catch (SQLException e) {
    e.printStackTrace();
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  }
}
}
