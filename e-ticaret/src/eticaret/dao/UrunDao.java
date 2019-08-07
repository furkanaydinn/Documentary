package eticaret.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


import eticaret.model.*;

public class UrunDao {
	static String connectionURL;
	static  Connection con = null;
	

	
	protected static void Connect () throws SQLException{
	if (con == null || con.isClosed()) {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connectionURL = "jdbc:mysql://localhost:3306/aydýnticaret";
			con = DriverManager.getConnection(connectionURL, "root", "");
		}
		catch (Exception e) {
			System.out.println("mysql driver bulunamadý...");
		}
	}
	}
	
	protected static void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
	
	public static boolean UrunEkle(Urun urun){
		int state = 0;
		try{
			Connect();
			String sql = "INSERT INTO urun (urunId,urunAd,  urunFiyat, urunAdet, urunGaranti,urunRenk ,kategoriId) VALUE (?, ?, ?, ? ,?,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, urun.getUrunId());
			ps.setString(2, urun.getUrunAd());
			ps.setInt(3, urun.getUrunFiyat());
			ps.setInt(4, urun.getUrunAdet());
			ps.setInt(5, urun.getUrunGaranti());
			ps.setString(6, urun.getUrunRenk());
			ps.setInt(7, urun.getKategoriId());
		
			state = ps.executeUpdate();
			System.out.println("ÜRÜN EKLENDÝ...");
			ps.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("ÜRÜN EKLENEMEDÝ..." + e);
		}
		return state > 0 ? true:false;
	}
	public List<Urun> UrKatGoreGetir(int kategoriId){ //jsplerde urun listelerken
		List<Urun> Urunler = new ArrayList<Urun>();
		try{
			Connect();
			String sql = "SELECT * FROM urun WHERE kategoriId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, kategoriId);
			ResultSet row = ps.executeQuery();
			while (row.next()){
				int urId=row.getInt("urunId");
				String urAd=row.getString("urunAd");
				int  urFiyat=row.getInt("urunFiyat");
				int  urAdet=row.getInt("urunAdet");
				int  urGaranti=row.getInt("urunGaranti");
                String urRenk=row.getString("urunRenk");
                Urun urun=new Urun(urId,urAd,urFiyat,urAdet,urGaranti,urRenk);  
				Urunler.add(urun);
			}
			ps.close();
			row.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("ÜRÜNLER LÝSTELENÝRKEN HATA OLUÞTU1..." + e);
		}
		return Urunler;
	}
	public static ArrayList<Urun> UrunGetir(int urunId){
		ArrayList<Urun> urunList = new ArrayList<Urun>();
		try{
			Connect();
			String sql = "SELECT * FROM urun WHERE urunId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, urunId);
			ResultSet row = ps.executeQuery();
			while (row.next()){
				Urun urun = new Urun();
				urun.setUrunId(row.getInt(1));
				urun.setUrunAd(row.getString(2));
				urun.setUrunFiyat(row.getInt(3));
				urun.setUrunAdet(row.getInt(4));
				urun.setUrunGaranti(row.getInt(5));
				urun.setKategoriId(row.getInt(6));
				urun.setUrunRenk(row.getString(7));
				urunList.add(urun);
			}
			ps.close();
			row.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("ÜRÜN LÝSTELENÝRKEN HATA OLUÞTU2..." + e);
		}
		return urunList;
	} 
	public List<Urun> TumUrunleriGetir(){
		List<Urun> TumUrunler = new ArrayList<>();
		try{
			Connect();
			String sql = "SELECT urunId,urunAd,urunFiyat,urunAdet,urunGaranti,urunRenk FROM urun";
			Statement ps =  con.createStatement();
			ResultSet row = ps.executeQuery(sql);
			while (row.next()){
				int urId=row.getInt("urunId");
				String urAd=row.getString("urunAd");
				int  urFiyat=row.getInt("urunFiyat");
				int  urAdet=row.getInt("urunAdet");
				int  urGaranti=row.getInt("urunGaranti");
                String urRenk=row.getString("urunRenk");
                Urun urun=new Urun(urId,urAd,urFiyat,urAdet,urGaranti,urRenk);
                TumUrunler.add(urun);
			}
			ps.close();
			row.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("ÜRÜNLER LÝSTELENÝRKEN HATA OLUÞTU3..." + e);
		}
		return TumUrunler;
	} 
	public static boolean urunSil(int urunId){
		int status = 0;
		try{
			Connect();
			String sql = "DELETE FROM urun where urunId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, urunId);
			status = ps.executeUpdate();
			ps.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("urun silme" + e);
		}
		return status > 0 ? true : false;
	}
	public static boolean urunGuncelle(Urun urun){
		int sonuc=0;
		try{
			Connect();
			String sql = "UPDATE urun set urunId=?, urunAd=?, urunFiyat=?, urunAdet=?,urunGaranti=?, urunRenk=?, kategoriId=? WHERE urunId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, urun.getUrunId());
			ps.setString(2, urun.getUrunAd());
			ps.setInt(3, urun.getUrunFiyat());
			ps.setInt(4, urun.getUrunAdet());
			ps.setInt(5, urun.getUrunGaranti());
			ps.setString(6, urun.getUrunRenk());
			ps.setInt(7, urun.getKategoriId());
			ps.setInt(8, urun.getUrunId());
			System.out.println(ps);
			sonuc=ps.executeUpdate();
			ps.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("ürün güncelleþtirilemedi..." + e);
		}
		return sonuc > 0 ? true :false;
	}
	public Urun ugetirId(int id) throws SQLException {
		 Urun r = null;
		 Connect();
		 try {
		     String query = "Select * from urun where urunId=?";
	    	 PreparedStatement psmt = con.prepareStatement(query);
		     psmt.setInt(1, id);
		     ResultSet rs = psmt.executeQuery();
		    while (rs.next()) {
		      r = new Urun(rs.getInt("urunId"), rs.getString("urunAd"),rs.getInt("urunFiyat"),rs.getInt("urunAdet"),rs.getInt("urunGaranti"),rs.getString("urunRenk"),rs.getInt("kategoriId"));
		    }
		    psmt.close();
		    rs.close();
		    disconnect();
		 
		} catch (Exception e) {
		 e.printStackTrace();
		 }
		 return r;
		 }
	public Urun urungetirbilgi(int id) { //sepet icin
		 Urun r = null;
		 try {
			 Connect();
		     String query = "Select urunId,urunAd,urunFiyat,urunGaranti from urun where urunId=?";
	    	 PreparedStatement psmt = con.prepareStatement(query);
		     psmt.setInt(1, id);
		     ResultSet rs = psmt.executeQuery();
		     System.out.println("basarili");
		     while (rs.next()) {
		      r = new Urun(rs.getInt("urunId"),rs.getString("urunAd"), rs.getInt("urunFiyat"),rs.getInt("urunGaranti"));
		    }
		    psmt.close();
		    rs.close();
		    disconnect();
		 
		} catch (Exception e) {
		    e.printStackTrace();
	    }
		return r;
	}
}
