package com.tr.yurt.dao;

import com.tr.yurt.entity.Blok;
import com.tr.yurt.entity.Kat;
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
public class BlokDao {

    DBConnection dbConnection = new DBConnection();

    public Blok insert (Blok blok){
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("INSERT INTO blok(ad,kapasite,dolu,bos)" + "VALUES ( ?, ?, ?, ?)");
            prst.setString(1, blok.getAd());
            prst.setInt(2, blok.getKapasite());
            prst.setInt(3, blok.getDolu());
            prst.setInt(4, blok.getBos());
            prst.executeUpdate();
            System.out.println("Blok Insert işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(prst, conn);

        }

        return blok;
    }

    public Blok update (Blok blok){
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("UPDATE blok SET ad=?, kapasite=?, dolu=?, bos=? WHERE id=?");
            prst.setString(1, blok.getAd());
            prst.setInt(2,blok.getKapasite());
            prst.setInt(3,blok.getDolu());
            prst.setInt(4, blok.getBos());
            prst.setInt(5,blok.getId());
            prst.executeUpdate();
            System.out.println("Blok Update işlemi başarılıdır..");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

            dbConnection.closeConnection(prst, conn);
        }

        return blok;
    }

    public boolean delete(int id){

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("DELETE from blok WHERE (id=?)");
            prst.setInt(1, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }

        return true;
    }

    public List<Blok> getAllBlok(){

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        ResultSet rs = null;
        List<Blok> blokList = new ArrayList<>();
        try {
            prst = conn.prepareStatement("SELECT * FROM blok");
            rs = prst.executeQuery();

            while (rs.next()){
                Blok blok = new Blok();
                blok.setAd(rs.getString("ad"));
                blok.setKapasite(rs.getInt("kapasite"));
                blok.setDolu(rs.getInt("dolu"));
                blokList.add(blok);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return blokList;
    }
    public Blok getBlokById(final int id){

        Blok blok = null;
        Connection connection =  dbConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM blok WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){

                blok = new Blok();
                blok.setId(rs.getInt("id"));
                blok.setAd(rs.getString("ad"));
                blok.setDolu(rs.getInt("dolu"));
                blok.setBos(rs.getInt("bos"));
                blok.setKapasite(rs.getInt("kapasite"));
                blok.setYurtId(rs.getInt("yurt_id"));

            }
            if (blok == null){
                System.out.println(id + " id'li blok bulunamamıştır.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection(ps, connection);
        }

        return blok;
    }

   /* public static void main(String[] args) throws SQLException {

        Blok blok = new Blok();
        blok.setAd("C BLOK");
        blok.setKapasite(1500);
        blok.setDolu(0);
        blok.setBos(1500);

        BlokDao blokDao = new BlokDao();
        blokDao.insert(blok);
    }*/

}
