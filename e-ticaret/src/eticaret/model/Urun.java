package eticaret.model;



public class Urun {

	private int urunId;
	private String urunAd;
	private int urunFiyat;
	private int urunAdet;
	private int urunGaranti;
	private int kategoriId;
	private String urunRenk;
	
	public Urun(){
		super();
	}
	public Urun(int urunId, String urunAd,int urunFiyat,int urunGaranti){
		super();
		this.urunId = urunId;
		this.urunAd = urunAd;
		this.urunFiyat=urunFiyat;
		this.urunGaranti=urunGaranti;
	}
	public Urun(int urunId, String urunAd,int urunFiyat,int urunAdet,int urunGaranti,String urunRenk){
		super();
		this.urunId = urunId;
		this.urunAd = urunAd;
		this.urunFiyat=urunFiyat;
		this.urunAdet=urunAdet;
		this.urunGaranti=urunGaranti;
		this.urunRenk=urunRenk;
	}
	public Urun(int urunId, String urunAd,int urunFiyat,int urunAdet,int urunGaranti,String urunRenk,int kategoriId){
		super();
		this.urunId = urunId;
		this.urunAd = urunAd;
		this.urunFiyat=urunFiyat;
		this.urunAdet=urunAdet;
		this.urunGaranti=urunGaranti;
		this.urunRenk=urunRenk;
		this.kategoriId=kategoriId;
	}
	public int getUrunId() {
		return urunId;
	}
	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}
	public String getUrunAd() {
		return urunAd;
	}
	public void setUrunAd(String urunAd) {
		this.urunAd = urunAd;
	}
	public int getUrunFiyat() {
		return urunFiyat;
	}
	public void setUrunFiyat(int urunFiyat) {
		this.urunFiyat = urunFiyat;
	}
	public int getUrunGaranti() {
		return urunGaranti;
	}
	public void setUrunGaranti(int urunGaranti) {
		this.urunGaranti = urunGaranti;
	}
	
	public String getUrunRenk() {
		return urunRenk;
	}
	public void setUrunRenk(String urunRenk) {
		this.urunRenk = urunRenk;
	}
	public int getUrunAdet() {
		return urunAdet;
	}
	public void setUrunAdet(int urunAdet) {
		this.urunAdet = urunAdet;
	}
	public int getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}
	
}
