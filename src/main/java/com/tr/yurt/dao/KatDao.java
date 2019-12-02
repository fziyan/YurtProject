package com.tr.yurt.dao;

import com.tr.yurt.entity.Kat;
import com.tr.yurt.entity.Oda;
import com.tr.yurt.jdbc.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KatDao {

    DBConnection dbConnection = new DBConnection();

    public Kat insert(Kat kat){
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("INSERT INTO kat (ad,kapasite,dolu,bos) " + "VALUES (?, ?, ?, ?)");
            prst.setString(1, kat.getAd());
            prst.setInt(2, kat.getKapasite());
            prst.setInt(3,kat.getDolu());
            prst.setInt(4,kat.getBos());
            prst.executeUpdate();
            System.out.println("Kat Insert işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            dbConnection.closeConnection(prst, conn);

        }
        return kat;
    }
    public Kat update(Kat kat){

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("UPDATE kat SET  ad=?, dolu=?, bos=?, kapasite=?, blokId=? WHERE id=?");
            prst.setString(1,kat.getAd());
            prst.setInt(2, kat.getDolu());
            prst.setInt(3, kat.getBos());
            prst.setInt(4,kat.getKapasite());
            prst.setInt(5,kat.getBlokId());
            prst.setInt(6,kat.getId());
            prst.executeUpdate();
            System.out.println("Kat Update işlemi başarılıdır..");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

            dbConnection.closeConnection(prst, conn);
        }

        return kat;
    }

    public  boolean delete(int id){
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("DELETE from kat WHERE (id=?)");
            prst.setInt(1, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }

        return true;
    }
    public List<Kat> getAllKat(){
        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        ResultSet rs = null;
        List<Kat> katList = new ArrayList<>();
        try{
            prst = conn.prepareStatement("SELECT * FROM kat");
            rs = prst.executeQuery();

            while (rs.next()){
                Kat kat = new Kat();
                kat.setAd(rs.getString("ad"));
                kat.setKapasite(rs.getInt("kapasite"));
                kat.setDolu(rs.getInt("dolu"));
                kat.setBos(rs.getInt("bos"));
                katList.add(kat);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

       return katList;
    }
    public Kat getKatById(final int id){

        Kat kat = null;
        Connection connection =  dbConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM kat WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()){
                kat = new Kat();
                kat.setId(rs.getInt("id"));
                kat.setAd(rs.getString("ad"));
                kat.setDolu(rs.getInt("dolu"));
                kat.setBos(rs.getInt("bos"));
                kat.setBlokId(rs.getInt("blokId"));
                kat.setKapasite(rs.getInt("kapasite"));

            }
            if (kat == null){
                System.out.println(id + " id'li kat bulunamamıştır.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection(ps, connection);
        }

        return kat;
    }

}
