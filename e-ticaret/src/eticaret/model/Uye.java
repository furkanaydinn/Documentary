package eticaret.model;

public class Uye {
	private int uyeId;
	private String uyeAd;
	private String uyeSoyad;
	private long uyeTel;
	private String uyeEposta;
	private String uyeAdres;
	private String uyeSifre;
	private boolean uyeYetki;
	
	public Uye(int uyeId){
		super();
		this.uyeId = uyeId;
	}
	public Uye (){
		super();
	}
	public Uye(int uyeId,String uyeSifre) {//girisde
		super();
		this.uyeId=uyeId;
		this.uyeSifre=uyeSifre;
	}
	public Uye(int uyeId,Boolean uyeYetki) {//admin uye yetki guncellede
		super();
		this.uyeId=uyeId;
		this.uyeYetki=uyeYetki;
	}
	public Uye(int uyeId,String uyeAd, String uyeSoyad){//girisde bilgilericekerken
		super();
		this.uyeId=uyeId;
		this.uyeAd = uyeAd;
		this.uyeSoyad = uyeSoyad;
	}
	public Uye(int uyeId, String uyeAd, String uyeSoyad,long uyeTel, String uyeEposta, String uyeAdres, boolean uyeYetki){//listelerken
		super();
		this.uyeId = uyeId;
		this.uyeAd = uyeAd;
		this.uyeSoyad = uyeSoyad;
		this.uyeTel =uyeTel;
		this.uyeEposta = uyeEposta;
		this.uyeAdres = uyeAdres;
		this.uyeYetki = uyeYetki;
	}
	public Uye(int uyeId, String uyeAd, String uyeSoyad,long uyeTel, String uyeEposta, String uyeAdres, String uyeSifre, boolean uyeYetki){
		super();
		this.uyeId = uyeId;
		this.uyeAd = uyeAd;
		this.uyeSoyad = uyeSoyad;
		this.uyeTel =uyeTel;
		this.uyeEposta = uyeEposta;
		this.uyeAdres = uyeAdres;
		this.uyeSifre = uyeSifre;
		this.uyeYetki = uyeYetki;
	}
	public int getUyeId() {
		return uyeId;
	}
	public void setUyeId(int uyeId) {
		this.uyeId = uyeId;
	}
	public String getUyeAd() {
		return uyeAd;
	}
	public void setUyeAd(String uyeAd) {
		this.uyeAd = uyeAd;
	}
	public String getUyeSoyad() {
		return uyeSoyad;
	}
	public long getUyeTel() {
		return uyeTel;
	}
	public void setUyeTel(int uyeTel) {
		this.uyeTel = uyeTel;
	}
	public void setUyeSoyad(String uyeSoyad) {
		this.uyeSoyad = uyeSoyad;
	}
	public String getUyeEposta() {
		return uyeEposta;
	}
	public void setUyeEposta(String uyeEposta) {
		this.uyeEposta = uyeEposta;
	}
	public String getUyeAdres() {
		return uyeAdres;
	}
	public void setUyeAdres(String uyeAdres) {
		this.uyeAdres = uyeAdres;
	}
	public String getUyeSifre() {
		return uyeSifre;
	}
	public void setUyeSifre(String uyeSifre) {
		this.uyeSifre = uyeSifre;
	}
	public boolean getUyeYetki() {
		return uyeYetki;
	}
	public void setUyeYetki(boolean uyeYetki) {
		this.uyeYetki = uyeYetki;
	}


}
