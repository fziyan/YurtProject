package com.tr.yurt.dao;

import com.tr.yurt.entity.Oda;
import com.tr.yurt.entity.Ogrenci;
import com.tr.yurt.jdbc.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdaDao {

    DBConnection dbConnection = new DBConnection();

    public Oda insert(Oda oda){

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("INSERT INTO oda (oda_no,kapasite,dolu,bos) " + "VALUES (?, ?, ?, ?)");
            prst.setInt(1, oda.getOda_no());
            prst.setInt(2, oda.getKapasite());
            prst.setInt(3,oda.getDolu());
            prst.setInt(4,oda.getBos());
            prst.executeUpdate();
            System.out.println("Oda Insert işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(prst, conn);

        }
        return oda;
    }
    public Oda update(Oda oda){
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("UPDATE oda SET kapasite=?, dolu=?, bos=?, oda_no=? WHERE id=?");
            prst.setInt(1, oda.getKapasite());
            prst.setInt(2, oda.getDolu());
            prst.setInt(3, oda.getBos());
            prst.setInt(4, oda.getOda_no());
            prst.setInt(5, oda.getId());
            prst.executeUpdate();
            System.out.println("Oda Update işlemi başarılıdır..");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

            dbConnection.closeConnection(prst, conn);
        }

        return oda;
    }

    public boolean delete(int id) {

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("DELETE * from oda WHERE (id=?)");
            prst.setInt(1, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }

        return true;
    }
    public List<Oda> getAllOda(){

        Connection conn = dbConnection.openConnection();
        ResultSet rs = null;
        PreparedStatement prst = null;

        List<Oda> odaList = new ArrayList<>();

       try {
           prst = conn.prepareStatement("SELECT * FROM oda");
           rs = prst.executeQuery();
           while (rs.next()){
               Oda oda = new Oda();
               oda.setId(rs.getInt("id"));
               oda.setOda_no(rs.getInt("oda_no"));
               oda.setKapasite(rs.getInt("kapasite"));
               oda.setDolu(rs.getInt("dolu"));
               oda.setBos(rs.getInt("bos"));
               odaList.add(oda);
           }

       }catch (Exception e){
           e.printStackTrace();
       }

       return odaList;
    }
    public Oda getOdaById(final int id){
        Oda oda = null;
        Connection connection =  dbConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = connection.prepareStatement("SELECT * FROM oda WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()){
                oda = new Oda();
                oda.setId(rs.getInt("id"));
                oda.setDolu(rs.getInt("dolu"));
                oda.setBos(rs.getInt("bos"));
                oda.setOda_no(rs.getInt("oda_no"));
                oda.setKapasite(rs.getInt("kapasite"));
                oda.setKat_id(rs.getInt("kat_id"));
            }
            if (oda == null){
                System.out.println(id + " id'li oda bulunamadı.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection(ps, connection);
        }

        return oda;
    }


    public static void main(String[] args) throws SQLException {

        OdaDao odaDao = new OdaDao();
        List<Oda> allOda = odaDao.getAllOda();
        System.out.println("Ogrenciler : " +allOda);
    }
}
