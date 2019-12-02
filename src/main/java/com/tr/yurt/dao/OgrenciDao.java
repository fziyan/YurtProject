package com.tr.yurt.dao;

import com.tr.yurt.entity.Ogrenci;
import com.tr.yurt.entity.Yurt;
import com.tr.yurt.jdbc.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OgrenciDao {

    DBConnection dbConnection = new DBConnection();

    public Ogrenci insert(Ogrenci ogrenci) {

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("INSERT INTO ogrenci(ad,soyad,ogr_no,tc_no)" + "VALUES (? , ?, ? , ?)");
            prst.setString(1, ogrenci.getAd());
            prst.setString(2, ogrenci.getSoyad());
            prst.setInt(3, ogrenci.getOgr_no());
            prst.setInt(4, ogrenci.getTc_no());
            prst.executeUpdate();
            System.out.println("Insert işlemi başarılıdır..");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);

        }

        return ogrenci;
    }

    public Yurt update(Ogrenci ogrenci) throws SQLException {

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("UPDATE ogrenci SET ad=?, soyad=?, bolum=?, ogr_no=?, tc_no=? WHERE id=?");
            prst.setString(1, ogrenci.getAd());
            prst.setString(2, ogrenci.getSoyad());
            prst.setString(3, ogrenci.getBolum());
            prst.setInt(4,ogrenci.getOgr_no());
            prst.setInt(5,ogrenci.getTc_no());
            prst.setInt(6, ogrenci.getId());
            int i = prst.executeUpdate();
            if (i == 1)
                System.out.println("Ogrenci update işlemi başarılıdır.");
            else
                System.out.println("Ogrenci update işlemi başarısız.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }
        return null;
    }

    public boolean delete(int id) {

        Connection conn = dbConnection.openConnection();
        PreparedStatement prst = null;
        try {
            prst = conn.prepareStatement("DELETE from ogrenci WHERE (id=?)");
            prst.setInt(1, id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }

        return true;
    }

    public List<Ogrenci> getAllOgrenci() {

        Connection connection = dbConnection.openConnection();

        List<Ogrenci> ogrenciList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            prst = connection.prepareStatement("SELECT * FROM ogrenci");
            rs = prst.executeQuery();
            while (rs.next()) {
                Ogrenci ogrenci = new Ogrenci();
                ogrenci.setAd(rs.getString("ad"));
                ogrenci.setSoyad(rs.getString("soyad"));
                ogrenci.setTc_no(rs.getInt("tc_no"));
                ogrenci.setId(rs.getInt("id"));
                ogrenciList.add(ogrenci);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(prst, conn);
        }

        return ogrenciList;
    }

    public Ogrenci getOgrenciById(final int id) {
        Ogrenci ogrenci = null;
        Connection connection = dbConnection.openConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM ogrenci WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ogrenci = new Ogrenci();
                ogrenci.setId(rs.getInt("id"));
                ogrenci.setAd(rs.getString("ad"));
                ogrenci.setSoyad(rs.getString("soyad"));
                ogrenci.setBolum(rs.getString("bolum"));
                ogrenci.setTc_no(rs.getInt("tc_no"));
                ogrenci.setOgr_no(rs.getInt("ogr_no"));
            }
            if (ogrenci == null) {
                System.out.println(id + "id'li öğrecin bulunamamıştır.");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            dbConnection.closeConnection(ps, connection);
        }

        return ogrenci;
    }

    public static void main(String[] args) {

        OgrenciDao ogrenciDao = new OgrenciDao();
        List<Ogrenci> allOgrenci = ogrenciDao.getAllOgrenci();
        System.out.println("Ogrenciler : " + allOgrenci);
    }

}
