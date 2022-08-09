/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.booking;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import thuanlm.utils.DBHelper;

/**
 *
 * @author lthua
 */
public class BookingDAO implements Serializable {

    private List<BookingDTO> accounts;

    public boolean checkLogin(String username, String password)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select username "
                        + "FROM user_booking "
                        + "WHERE username = ? "
                        + "AND password = ?";
                //3. Create SQL statment
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process Result
                if (rs.next()) {
                    return true;
                }
            }//process when connection is existed
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public List<BookingDTO> getAccounts() {
        return accounts;
    }

    public String getFullName(String username) throws SQLException, ClassNotFoundException, NamingException {
        String fullName = null;
        Connection con = null;
        PreparedStatement ptsm = null;
        ResultSet rs = null;

        try {
            //1. Call connection 
            con = DBHelper.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT lastname "
                        + "FROM user_booking "
                        + "WHERE username = ?";
                //3. Create statement
                ptsm = con.prepareStatement(sql);
                ptsm.setString(1, username);
                //4. Execute query 
                rs = ptsm.executeQuery();
                //5. processs 
                if (rs.next()) {
                    fullName = rs.getString("lastname");
                }

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptsm != null) {
                ptsm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return fullName;
    }

    public boolean checkAdmin(String username)
            throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. create DB
            con = DBHelper.makeConnection();

            if (con != null) {
                //2. create SQL String
                String sql = "SELECT isAdmin "
                        + "FROM user_booking "
                        + "WHERE username = ? ";
                //3. Create SQL Statetments
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4.Excute query
                rs = stm.executeQuery();
                //5.Process result
                if (rs.next()) {
                    check = rs.getBoolean("isAdmin");
                } // end username is exits
            } // process when connection is existed

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public void searchLastname(String searchValue) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select username, password, lastname, isAdmin "
                        + "From user_booking "
                        + "where lastname Like ?";

                //3. Create SQL statment
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
//stm.setString(1,searchValue );
//                //4. Execute Query
                rs = stm.executeQuery();
                //5. Process Result
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String fullName = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    BookingDTO dto = new BookingDTO(username, password, fullName, role);

                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    } // end account are not existed
                    this.accounts.add(dto);
                }//end traverse Result set
            }//process when connection is existed
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean deleteAccount(String searchValue) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Creat SQL String
                String sql = "Delete from user_booking "
                        + "Where username = ?";

                //3.Creat SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, searchValue);
                //4.Excute Query
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
                //5.Process Result
                return true;
            }//process when connection is existed
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean update(String username, String password, boolean role)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Creat SQL String
                String sql = "Update user_booking Set password = ?, isAdmin = ? Where username = ?";

                //3.Creat SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);

                //4.Excute Query
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
                //5.Process Result
                return true;
            }//process when connection is existed
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean createAccount(BookingDTO dto)
            throws SQLException, NamingException, ClassNotFoundException {
        if (dto == null) {
            return false;
        }

        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Creat SQL String
                String sql = "Insert Into user_booking("
                        + "username, password, lastname,isAdmin"
                        + ") Values (?, ?, ?, ?)";

                //3.Creat SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getLastname());
                stm.setBoolean(4, dto.isRole());

                //4.Excute Query
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
                //5.Process Result
                return true;
            }//process when connection is existed
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
