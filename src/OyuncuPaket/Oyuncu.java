package OyuncuPaket;

import KarakterPaket.Karakter;

public abstract class Oyuncu extends Karakter {

	private int skor = 20;
	private int oyuncuID = 0;
	private String oyuncuAdi;
	private String oyuncuTur;

	public Oyuncu(int id, String ad, String tip) {
		// TODO Auto-generated constructor stub
		this.oyuncuID = id;
		this.oyuncuAdi = ad;
		this.oyuncuTur = tip;
	}

	public Oyuncu() {
		// TODO Auto-generated constructor stub
	}

	public int getSkor() {
		return skor;
	}

	public void setSkor(int skor) {
		this.skor = skor;
	}

	public int getOyuncuID() {
		return oyuncuID;
	}

	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}

	public String getOyuncuAdi() {
		return oyuncuAdi;
	}

	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}

	public String getOyuncuTur() {
		return oyuncuTur;
	}

	public void setOyuncuTur(String oyuncuTur) {
		this.oyuncuTur = oyuncuTur;
	}

	public int PuaniGoster() {
		// TODO Auto-generated method stub
		return this.skor;
	}

}
