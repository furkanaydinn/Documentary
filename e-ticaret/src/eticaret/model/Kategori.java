package eticaret.model;

public class Kategori {
	private int kategoriId;
	private String kategoriAd;
	
	public Kategori(){
		super();
	} 
	public Kategori(int kategoriId, String kategoriAd){
		super();
		this.kategoriId = kategoriId;
		this.kategoriAd = kategoriAd;
	}
	public int getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}
	public String getKategoriAd() {
		return kategoriAd;
	}
	public void setKategoriAd(String kategoriAd) {
		this.kategoriAd = kategoriAd;
	}

}
