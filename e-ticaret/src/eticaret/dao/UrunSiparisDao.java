package eticaret.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eticaret.model.UrunSiparis;


public class UrunSiparisDao {
	static String connectionURL;
	static  Connection con = null;
	PreparedStatement ps = null;
   
	
	protected static void Connect () throws SQLException{
	if (con == null || con.isClosed()) {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connectionURL = "jdbc:mysql://localhost:3306/aydýnticaret";
			con = DriverManager.getConnection(connectionURL, "root", "");
			System.out.println("urunsiparis driver var");
		}
		catch(Exception e) {
			System.out.println("mysql driver bulunamadý");
		}
		
	}
	}
	
	protected static void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
	public static  boolean SepeturunEkle(UrunSiparis urunsiparis){
		int state = 0;
		try{
			Connect();
		
			String sql = "INSERT INTO urunSiparis (urunId, uyeId, urunAd, urunFiyat) VALUE (?, ?, ?, ? )";
			System.out.println(sql);
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);			
			System.out.println("geldi");
			ps.setInt(1, urunsiparis.getUrunId());
			ps.setInt(2, urunsiparis.getUyeId());
			ps.setString(3, urunsiparis.getUrunAd());
			ps.setInt(4, urunsiparis.getUrunFiyat());
			System.out.println("ps"+ps);
			state = ps.executeUpdate();
			System.out.println("ÜRÜN EKLENDÝ...");
			ps.close();
			disconnect();
		}
		catch (SQLException e){
			System.out.println("ÜRÜN EKLENEMEDÝ..." + e);
		}
		return state > 0 ? true:false;
	}
	public List<UrunSiparis> SepuyeyeGoreGetir(int uyeId){ //jsplerde urun listelerken
		List<UrunSiparis> UrunSiparis = new ArrayList<>();
		try{
			Connect();
			String sql = "SELECT * FROM urunSiparis WHERE uyeId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, uyeId);
			ResultSet row = ps.executeQuery();
			while (row.next()){
				int urId=row.getInt("urunId");
				int siId=row.getInt("uyeId");
				String urAd=row.getString("urunAd");
				int  urFiyat=row.getInt("urunFiyat");
				
                UrunSiparis urunsiparis=new UrunSiparis(urId,siId,urAd,urFiyat);  
				UrunSiparis.add(urunsiparis);
			}
			ps.close();
			row.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("ÜRÜNLER LÝSTELENÝRKEN HATA OLUÞTU1..." + e);
		}
		return UrunSiparis;
	}
	public List<UrunSiparis> SepuyeyeAdetGetir(int uyeId){ //sepet jsp urun listelerken
		List<UrunSiparis> UrunSiparis = new ArrayList<>();
		try{
			Connect();
			String sql = "SELECT count (urunId) As sepeturunadet FROM urunSiparis WHERE uyeId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, uyeId);
			ResultSet row = ps.executeQuery();
			while (row.next()){
				int urId=row.getInt("urunId");
                UrunSiparis urunsiparis=new UrunSiparis(urId);  
				UrunSiparis.add(urunsiparis);
			}
			ps.close();
			row.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("ÜRÜNLER LÝSTELENÝRKEN HATA OLUÞTU1..." + e);
		}
		return UrunSiparis;
	}
	public int ugetirAdet(int id) {
		
		 int adet=0;
		 try {
			 Connect();
		     String query = "SELECT urunId FROM urunSiparis WHERE uyeId=?";
	    	 PreparedStatement psmt = con.prepareStatement(query);
		     psmt.setInt(1, id);
		     ResultSet rs = psmt.executeQuery();
		     while (rs.next()) {
		    	int urId=rs.getInt("urunId");
		        adet +=1;
		     }
		  
		     System.out.println("adet"+adet);
		     psmt.close();
		     rs.close();
		     disconnect();
		 
		  } catch (Exception e) {
		     e.printStackTrace();
		  }
		return adet;
	}public int ugetirFiyat(int id) {
		
		 int fiyat=0;
		 try {
			 Connect();
		     String query = "SELECT urunFiyat FROM urunSiparis WHERE uyeId=?";
	    	 PreparedStatement psmt = con.prepareStatement(query);
		     psmt.setInt(1, id);
		     ResultSet rs = psmt.executeQuery();
		     while (rs.next()) {
		    	int urfiyat=rs.getInt("urunFiyat");
		        fiyat +=urfiyat;
		     }
		  
		     System.out.println("fiyat"+fiyat);
		  psmt.close();
		  rs.close();
		  disconnect();
		 
		  } catch (Exception e) {
		     e.printStackTrace();
		  }
		return fiyat;
	}

	
	public static boolean sepeturunSil(int urunId){
		int status = 0;
		try{
			Connect();
			String sql = "DELETE FROM urunSiparis where urunId=? limit 1" ;
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
	public static boolean sepeturunlerisil(int uyeId){
		int status = 0;
		try{
			Connect();
			String sql = "DELETE FROM urunSiparis where uyeId=?" ;
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, uyeId);
			status = ps.executeUpdate();
			ps.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("urun silme" + e);
		}
		return status > 0 ? true : false;
	}
}
