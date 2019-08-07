package eticaret.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.model.Kategori;

import eticaret.model.*;
public class KategoriDao {
	
	static String connectionURL;
	static  Connection con = null;
	PreparedStatement ps = null;

	
	protected static void Connect () throws SQLException{
	if (con == null || con.isClosed()) {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connectionURL = "jdbc:mysql://localhost:3306/aydýnticaret";
			con = DriverManager.getConnection(connectionURL, "root", "");
			System.out.println("mysql driver var");
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
	public static  boolean kategoriEkle(Kategori kategori){
		int sonuc=0;
		try{
			Connect();
			String sql = "INSERT INTO kategori (kategoriId,kategoriAd) VALUE (?,?) ";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, kategori.getKategoriId());
			ps.setString(2, kategori.getKategoriAd());
			sonuc=ps.executeUpdate();
			ps.close();
			disconnect();
			System.out.println("Kategori Eklendi...");
			
		}
		catch (Exception e){
			System.out.println("KATEGORÝ EKLENEMEDÝ BÝR HATA OLUÞTU..." + e);
		}
		return sonuc > 0 ? true: false;
		
	}
	public static  boolean kategoriGuncelle(Kategori kategori) throws SQLException {
		int sonuc=0;
        String sql = "UPDATE kategori SET kategoriId = ?, kategoriAd = ?  WHERE kategoriId = ?";
        
        Connect();
         try {
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, kategori.getKategoriId());
        statement.setString(2, kategori.getKategoriAd());
        statement.setInt(3, kategori.getKategoriId());
        System.out.println("statement:"+statement);
        sonuc= statement.executeUpdate() ;
        statement.close();
        }catch(Exception e) {
        	System.out.println("daoda hata"+e); 
        }
        disconnect();
        return sonuc > 0 ? true:false;     
    }
	public  List<Kategori> Kategoriler(){
		List<Kategori> Kategoriler = new ArrayList<>();
		try{
			Connect();
			String sql = "SELECT * From kategori"; //hatalý olabilir
			Statement ps =  con.createStatement();
			ResultSet row = ps.executeQuery(sql);
			while(row.next()){
				
						int kId=row.getInt("kategoriId");
						String kAd=row.getString("kategoriAd");
						
				Kategori kategori = new Kategori(kId,kAd);		
				
				Kategoriler.add(kategori);
			}
			row.close();
			ps.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("KATEGORÝLER GETÝRLEMEDÝ..." + e);
		}
		
		return Kategoriler;
	}
		public static boolean  kategoriSil(int kategoriId) {
		int don=0;
		try{
		 Connect();
		 String query = "DELETE FROM kategori where kategoriId=?";
		 PreparedStatement psmt = con.prepareStatement(query);
		 psmt.setInt(1,kategoriId);
		 System.out.println(psmt);
		  don= psmt.executeUpdate();
		 System.out.println("basarili");
		 psmt.close();
		 disconnect();
		 
		 }catch (Exception e) {
		 e.printStackTrace();
		 }
		 return don > 0 ? true: false;
		 }
	 public Kategori kgetirId(int id) throws SQLException {
		 Kategori r = null;
		 Connect();
		 try {
		     String query = "Select * from kategori where kategoriId=?";
	    	 PreparedStatement psmt = con.prepareStatement(query);
		     psmt.setInt(1, id);
		     System.out.println("Ýd"+id);
		     ResultSet rs = psmt.executeQuery();
		    while (rs.next()) {
		      r = new Kategori(rs.getInt("kategoriId"), rs.getString("kategoriAd"));
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
