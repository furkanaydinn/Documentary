package eticaret.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

//import eticaret.model.Uye;
import eticaret.model.Siparis;

public class SiparisDao {
	
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
			System.out.println(" driver bulunamadý...");
		
		}}
	}
	
	protected static void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
	public static int siparisTamamla(Siparis siparis){
		int state=0;
		try{
			Connect();
			String sql = "INSERT INTO siparis(  siparisTutar, siparisUrunAdet,siparisSonuc,uyeId,siparisOdeme) VALUES(?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, siparis.getSiparisTutar());
			ps.setInt(2, siparis.getSiparisUrunAdet());
			ps.setBoolean(3, siparis.getSiparisSonuc());
			ps.setInt(4, siparis.getUyeId());
			ps.setString(5,siparis.getSiparisOdeme());
			state = ps.executeUpdate();
			System.out.println("Sipariþ Tamamlandý...ps"+ps);
			ps.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("Sipariþ Tamamlanmadý..." + e);
		}
		return state;
	}
	public  List<Siparis> tumSiparisleriGetir(){
		List<Siparis> tumSiparisler = new ArrayList<>();
		try{
			Connect();
			String sql = "SELECT * From siparis"; //hatalý olabilir
			Statement ps =  con.createStatement();
			ResultSet row = ps.executeQuery(sql);
			while(row.next()){
				
						int sId=row.getInt("siparisId");
						int sTutar=row.getInt("siparisTutar");
						int sUrunAdet=row.getInt("siparisUrunAdet");
						boolean sSonuc=row.getBoolean("siparisSonuc");
						int uyeid=row.getInt("uyeId");
						String odeme=row.getString("siparisOdeme");
				Siparis siparis = new Siparis(sId,sTutar,sUrunAdet,sSonuc,uyeid,odeme);		
				
				tumSiparisler.add(siparis);
			}
			row.close();
			ps.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("Sipariþler getirelemedi... " + e);
		}
		return tumSiparisler;
	}
	public static boolean siparisSil(int urunId){
		int status = 0;
		try{
			Connect();
			String sql = "DELETE FROM siparis where siparisId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, urunId);
			status = ps.executeUpdate();
			ps.close();
			disconnect();
		}
		catch (Exception e){
			System.out.println("siparis silme" + e);
		}
		return status > 0 ? true : false;
	}
	public  String uyeAdGetir(int uyeId){
		String AdSoyad = null;
		try{
			Connect();
			String sql = "SELECT uyeAd, uyeSoyad FROM uye WHERE uyeId=?;";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, uyeId);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				AdSoyad = row.getString(1) + " " + row.getString(2).toUpperCase();
			}
			ps.close();
			row.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("Sipariþ veren kullanici adý getirilemedi..." + e);
		}
		return AdSoyad;
	}
	public static int siparisSayisi(){
		int adet = 0;
		try{
			Connect();
			String sql = "SELECT COUNT(siparisId) FROM siparis;";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				int sayi = (row.getInt(1));
				adet = sayi;
			}
			ps.close();
			row.close();
			disconnect();
		}
		catch(Exception e){
			System.out.println("Sipariþ sayýsý getirilemedi..." + e);
		}
		return adet;
	}

}
