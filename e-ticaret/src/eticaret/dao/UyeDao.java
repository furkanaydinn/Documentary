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

public class UyeDao {
	static String connectionURL;
	static Connection con = null;
	
	protected static void Connect () throws SQLException {
		if (con == null || con.isClosed()) {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connectionURL = "jdbc:mysql://localhost:3306/aydýnticaret";
			con = DriverManager.getConnection(connectionURL, "root", "");
		}
		catch (Exception e) {
			System.out.println("mysql driver bulunamadý..."+ e);
		}
	}
	}	
	
	protected static void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
	public static boolean UyeEkle(Uye uye){
		int state = 0;
		try{
			Connect();
			String sql = "INSERT INTO uye (uyeId,uyeAd,  uyeSoyad, uyeTel, uyeAdres,uyeEposta ,uyeSifre,uyeYetki) VALUE (?, ?, ?, ? ,? ,? ,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, uye.getUyeId());
			ps.setString(2, uye.getUyeAd());
			ps.setString(3, uye.getUyeSoyad());
			ps.setLong(4, uye.getUyeTel());
			ps.setString(5, uye.getUyeAdres());
			ps.setString(6, uye.getUyeEposta());
			ps.setString(7, uye.getUyeSifre());
			ps.setBoolean(8, uye.getUyeYetki());
			
		
			state = ps.executeUpdate();
			System.out.println("uye EKLENDÝ...");
			ps.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("uye EKLENEMEDÝ..." + e);
		}
		return state > 0 ? true:false;
	}
	public  List<Uye> butunUyeler() throws SQLException{
		List<Uye> listUye = new ArrayList <>();
		try{
			Connect();
			String sql = "SELECT uyeId, uyeAd, uyeSoyad, uyeTel, uyeEposta, uyeAdres, uyeYetki from uye";
			Statement ps =  con.createStatement();
			ResultSet row = ps.executeQuery(sql);
			while(row.next()){
				int uyeId=row.getInt("uyeId");
				String uyeAd=row.getString("uyeAd");
				String uyeSoyad=row.getString("uyeSoyad");
				long uyeTel=row.getLong("uyeTel");
				String uyeEposta=row.getString("uyeEposta");	
				String uyeAdres=row.getString("uyeAdres");
				Boolean uyeYetki=row.getBoolean("uyeYetki");
			
				Uye Uye  = new Uye(uyeId,uyeAd,uyeSoyad,uyeTel,uyeEposta,uyeAdres,uyeYetki);
				listUye.add(Uye);
				
			}
			row.close();
			ps.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("hata"+e);
		}
		return listUye;	
	} 
	
	public static boolean  kisiSil(int uyeId) {
		int don=0;
		try{
		 Connect();
		 String query = "DELETE FROM uye where uyeId=?";
		 PreparedStatement psmt = con.prepareStatement(query);
		 psmt.setInt(1,uyeId);
		 don= psmt.executeUpdate();
		 System.out.println("basarili");
		 psmt.close();
		 disconnect();
		 }catch (Exception e) {
		 e.printStackTrace();
		 }
		
		 return don > 0 ? true: false;
	}
	
	public static boolean Kayitlimi(int id){
		try{
			Connect();
			String sql = "SELECT * FROM Uye WHERE uyeId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				System.out.println("ÜYE KAYITLI: " + id);
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			System.out.println("ÜYE KAYITLI DEÐÝL"+ e);
		}
		return false;
	}
	public static boolean Girisadmin(int uyeId, String uyeSifre){
		try {
			Connect();
			String querry = "SELECT uyeId, uyeSifre,uyeYetki FROM Uye WHERE uyeId=? AND uyeSifre=? AND uyeYetki=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setInt(1, uyeId);
			ps.setString(2, uyeSifre);
			ps.setBoolean(3, true);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				System.out.println("uye var: "+uyeId);
				return true;
			}
			else {
				return false;
		    }}
		catch(Exception e){
			System.out.println("Uye giriþi baþarýlý deðil..." + e);
		}
		return false;
	}
	public static boolean Girisuye(int uyeId, String uyeSifre){
		try {
			Connect();
			String querry = "SELECT uyeId, uyeSifre,uyeYetki FROM Uye WHERE uyeId=? AND uyeSifre=? AND uyeYetki=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setInt(1, uyeId);
			ps.setString(2, uyeSifre);
			ps.setBoolean(3, false);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				System.out.println("uye var: "+uyeId);
				return true;
			}
			else {
				return false;
		    }}
		catch(Exception e){
			System.out.println("Uye giriþi baþarýlý deðil..." + e);
		}
		return false;
	}
	public static void  UyeGetir(int uyeId){
		try{
			Connect();
			String sql = "SELECT uyeAd,uyeSoyad FROM uye WHERE UyeId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, uyeId);
			ResultSet row = ps.executeQuery();
			while (row.next()){
				
			}
			System.out.println(ps);	
		}
		catch (Exception e){
			System.out.println("ÜRÜNLER LÝSTELENÝRKEN HATA OLUÞTU1..." + e);
		}
	
	}
	public Uye ugetirAd(int id) {
		 Uye r = null;
		 try {
			 Connect();
		     String query = "Select uyeId,uyeAd,uyeSoyad from uye where uyeId=?";
	    	 PreparedStatement psmt = con.prepareStatement(query);
		     psmt.setInt(1, id);
		     ResultSet rs = psmt.executeQuery();
		     System.out.println("basarili");
		     while (rs.next()) {
		      r = new Uye(rs.getInt("uyeId"), rs.getString("uyeAd"), rs.getString("uyeSoyad"));
		  }
		  psmt.close();
		  rs.close();
		  disconnect();
		 
		  } catch (Exception e) {
		     e.printStackTrace();
		  }
		return r;
	}
	public static boolean uyeGuncelle(Uye uye){
		int sonuc=0;
		try{
			Connect();
			String sql = "UPDATE uye set   uyeYetki=? WHERE uyeId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setBoolean(1, uye.getUyeYetki());
			ps.setInt(2, uye.getUyeId());
			
			sonuc=ps.executeUpdate();
			System.out.println("uyeguncelle geldi"+ps);
			ps.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("üye yetki  güncelleþtirilemedi..." + e);
		}
		return sonuc > 0 ? true :false;
	}
	public Uye uyegetiryetki(int id) throws SQLException {
		 Uye r = null;
		 Connect();
		 try {
		     String query = "Select uyeId,uyeYetki from uye where uyeId=?";
	    	 PreparedStatement psmt = con.prepareStatement(query);
		     psmt.setInt(1, id);
		     ResultSet rs = psmt.executeQuery();
		    while (rs.next()) {
		      r = new Uye(rs.getInt("uyeId"), rs.getBoolean("uyeYetki"));
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
