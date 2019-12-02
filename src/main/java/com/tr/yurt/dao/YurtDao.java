package com.tr.yurt.dao;

import com.tr.yurt.entity.Yurt;
import com.tr.yurt.jdbc.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class YurtDao {

    DBConnection dbConnection = new DBConnection();

    public List<Yurt> getAllYurt() {

        Connection conn = dbConnection.openConnection();

        List<Yurt> yurtList = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("SELECT * FROM yurt");
            rs = prst.executeQuery();
            while (rs.next()) {
                Yurt y = new Yurt();
                y.setIsim(rs.getString("isim"));
                y.setKapasite(rs.getInt("kapasite"));
                yurtList.add(y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst,conn);
        }
        return yurtList;
    }

    public Yurt insert(Yurt yurt) throws SQLException {
        // Gönderilen yurt kaydedilecek

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;

        try {
            prst = conn.prepareStatement("INSERT INTO yurt(isim,kapasite)" + "VALUES (?, ?)");
            prst.setString(1, yurt.getIsim());
            prst.setString(2, String.valueOf(yurt.getKapasite()));
            prst.executeUpdate();
            System.out.println("Insert işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(prst, conn);
        }
        return yurt;
    }

    public Yurt update(Yurt yurt) {

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("UPDATE yurt SET isim=?, kapasite=?, dolu=?, bos=?, kodu=? WHERE id=?");
            prst.setString(1, yurt.getIsim());
            prst.setString(2, String.valueOf(yurt.getKapasite()));
            prst.setInt(3, yurt.getDolu());
            prst.setInt(4, yurt.getBos());
            prst.setString(5, yurt.getKodu());
            prst.setInt(6, yurt.getId());
            prst.executeUpdate();
            System.out.println("Yurt Update işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(prst, conn);
        }
        return yurt;
    }

    public boolean delete(int id) {

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("DELETE from yurt WHERE (id=?)");
            prst.setInt(1, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }

        return true;
    }

     public Yurt getYurtById(final int id) {

        Yurt yurt = null;
        Connection connection = dbConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM yurt WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                yurt = new Yurt();
                yurt.setId(rs.getInt("id"));
                yurt.setIsim(rs.getString("isim"));
                yurt.setKodu(rs.getString("kodu"));
                yurt.setKapasite(rs.getInt("kapasite"));
                yurt.setBos(rs.getInt("bos"));
                yurt.setDolu(rs.getInt("dolu"));
            }
            if (yurt == null) {
                System.out.println(id + " id'li yurt bulunamadı.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(ps, connection);
        }
        return yurt;
    }

    private List<Yurt> getYurtListById(List<Integer> idList){

            List<Yurt> yurtList = new ArrayList<>();
            for ( Integer yurtId : idList){
                Yurt yurt = getYurtById(yurtId);
                yurtList.add(yurt);
            }
            return  yurtList;
    }


   /* public static void main(String[] args) throws SQLException {

        List<Integer> idList = Arrays.asList(1, 2, 4);
        List<Yurt> yurtList = getYurtListById(idList);
        System.out.print("Gelen Yurtlar: " +yurtList);

        //int id = 7;
        //Yurt yurt = getYurtById(id);

    }*/

}
