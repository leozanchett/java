package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    public static Connection getConn(){
        if(conn == null){
            Properties props = loadProperties();
            String url = props.getProperty("dburl");
            try {
               conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DBExceptions(e.getMessage());
            }
        }
        return conn;
    }

    public static void CloseConnection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DBExceptions(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try ( FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DBExceptions(e.getMessage());
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DBExceptions(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DBExceptions(e.getMessage());
            }
        }
    }

    public static void closePrepareStatement(PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DBExceptions(e.getMessage());
            }
        }
    }
}
