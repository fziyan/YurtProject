package com.tr.yurt.dao;

import com.tr.yurt.entity.Yatak;
import com.tr.yurt.jdbc.DBConnection;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class YatakDao {

    DBConnection dbConnection = new DBConnection();

    public Yatak insert(Yatak yatak) {

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("INSERT INTO yatak (doluMu) " + "VALUES ( ? )");
            prst.setBoolean(1, yatak.isDoluMu());
            prst.executeUpdate();
            System.out.println("Yatak Insert işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(prst, conn);

        }
        return yatak;
    }

    public Yatak update(Yatak yatak) {
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("UPDATE yatak SET ogrenciId=?, yatakNo=?, odaId=?, doluMu=? WHERE id=?");
            prst.setInt(1, yatak.getOgrenciId());
            prst.setInt(2, yatak.getYatakNo());
            prst.setInt(3,yatak.getOdaId());
            prst.setBoolean(4, yatak.isDoluMu());
            prst.setInt(5,yatak.getId());
            prst.executeUpdate();
            System.out.println("Yatak Update işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(prst, conn);
        }

        return yatak;
    }

    public boolean delete(int id) {
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("DELETE from yatak WHERE (id=?)");
            prst.setInt(1, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }

        return true;
    }

    public List<Yatak> gettAllYatak() {
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        ResultSet rs = null;
        List<Yatak> yatakList = new ArrayList<>();
        try {
            prst = conn.prepareStatement("SELECT * FROM yatak");
            rs = prst.executeQuery();
            while (rs.next()) {
                Yatak yatak = new Yatak();
                yatak.setDoluMu(rs.getBoolean("doluMu"));
                yatakList.add(yatak);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //yatak id sine göre getirilecektir.
    public Yatak findById(int id) {

        Yatak yatak = null;
        Connection connection = dbConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * from yatak WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                yatak = new Yatak();
                yatak.setDoluMu(rs.getBoolean("doluMu"));
                yatak.setId(rs.getInt("id"));
                yatak.setOgrenciId(rs.getInt("ogrenciId"));
                yatak.setOdaId(rs.getInt("odaId"));
                yatak.setYatakNo(rs.getInt("yatakNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(ps, connection);
        }
        return yatak;
    }

    public Yatak findByOgrenciIdWithYatak(int ogrenciId){

        Yatak yatak = null;
        Connection connection = dbConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM yatak WHERE ogrenciId=?");
            ps.setInt(1, ogrenciId);
            rs = ps.executeQuery();
            while (rs.next()){
                yatak = new Yatak();
                yatak.setDoluMu(rs.getBoolean("doluMu"));
                yatak.setOgrenciId(rs.getInt("ogrenciId"));
                yatak.setId(rs.getInt("id"));
                yatak.setOdaId(rs.getInt("odaId"));
                yatak.setYatakNo(rs.getInt("yatakNo"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection(ps, connection);
        }
        return yatak;
    }

   /* public static void main(String[] args) throws SQLException {

       Yatak yatak = new Yatak();
       yatak.setDoluMu(false);

       YatakDao yatakDao = new YatakDao();
       yatakDao.insert(yatak);
    }*/
}
