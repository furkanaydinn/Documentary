package eticaret.model;

public class UrunSiparis {
 
	private int urunId;
	private String urunAd;
	private int urunFiyat;
	private int uyeId;
	
	public UrunSiparis() {
		super();
	}
	public UrunSiparis(int urunId) { 
		super();
		this.urunId=urunId;
	}
	public UrunSiparis(int urunId,int uyeId,String urunAd,int urunFiyat) {
		super();
		this.urunId=urunId;
		this.uyeId=uyeId;
		this.urunAd=urunAd;
		this.urunFiyat=urunFiyat;
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
	public int getUyeId() {
		return uyeId;
	}
	public void setUyeId(int uyeId) {
		this.uyeId = uyeId;
	}
}
