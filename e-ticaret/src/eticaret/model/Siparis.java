package eticaret.model;


public class Siparis {
	private int siparisId;
	private int siparisTutar;
	private int siparisUrunAdet;
	private Boolean siparisSonuc;
	private String siparisOdeme;
	
	private int uyeId;
	
	
	public Siparis(){
		super();
	}
	public Siparis(int siparisId,int siparisTutar,int siparisUrunAdet,boolean siparisSonuc,int uyeId,String siparisOdeme) {
		this.siparisId=siparisId;
		this.siparisTutar=siparisTutar;
		this.siparisUrunAdet=siparisUrunAdet;
		this.siparisSonuc=siparisSonuc;
		this.uyeId=uyeId;
		this.siparisOdeme=siparisOdeme;
	}
	public Siparis(int siparisTutar,int siparisUrunAdet,boolean siparisSonuc,int uyeId,String siparisOdeme) {
		super();
		this.siparisTutar=siparisTutar;
		this.siparisUrunAdet=siparisUrunAdet;
		this.siparisSonuc=siparisSonuc;
		this.uyeId=uyeId;
		this.siparisOdeme=siparisOdeme;
	}
	public int getSiparisId() {
		return siparisId;
	}
	public void setSiparisId(int siparisId) {
		this.siparisId = siparisId;
	}
	public Boolean getSiparisSonuc() {
		return siparisSonuc;
	}
	public void setSiparisSonuc(Boolean siparisSonuc) {
		this.siparisSonuc = siparisSonuc;
	}
	 
	public int getSiparisUrunAdet() {
		return siparisUrunAdet;
	}
	public void setSiparisUrunAdet(int siparisUrunAdet) {
		this.siparisUrunAdet = siparisUrunAdet;
	}
	public int getSiparisTutar() {
		return siparisTutar;
	}
	public void setSiparisTutar(int siparisTutar) {
		this.siparisTutar = siparisTutar;
	}
	public int getUyeId() {
		return uyeId;
	}
	public void setUyeId(int uyeId) {
		this.uyeId = uyeId;
	}
	public String getSiparisOdeme() {
		return siparisOdeme;
	}
	public void setSiparisOdeme(String siparisOdeme) {
		this.siparisOdeme = siparisOdeme;
	}
	
}
