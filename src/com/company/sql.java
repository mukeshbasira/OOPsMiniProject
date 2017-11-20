package com.company;
import java.sql.*

public class sql {
    static  Connection con ;
    static  Statement st ;
    public static void init() throws ClassNotFoundException , SQLException{
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:question.db");
        st = con.createStatement();
        st.execute("khud se padho ");
        st.execute("khud se pdho");
    }
    public  static  void discon() throws  SQLException{
        con.commit();
        con.close();
    }
}
