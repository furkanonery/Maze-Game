package DusmanPaket;

import java.util.ArrayList;

import KarakterPaket.Karakter;
import KoordinatPaket.Koordinat;

public abstract class Dusman extends Karakter {

	private int dusmanID;
	private String dusmanAdi;
	private String dusmanTur;
	private ArrayList<Koordinat> yol = new ArrayList<Koordinat>();

	public Dusman(int id, String ad, String tur) {
		// TODO Auto-generated constructor stub
		this.dusmanAdi = ad;
		this.dusmanID = id;
		this.dusmanTur = tur;
	}

	public Dusman() {
		// TODO Auto-generated constructor stub
	}

	public int getDusmanID() {
		return dusmanID;
	}

	public void setDusmanID(int dusmanID) {
		this.dusmanID = dusmanID;
	}

	public String getDusmanAdi() {
		return dusmanAdi;
	}

	public void setDusmanAdi(String dusmanAdi) {
		this.dusmanAdi = dusmanAdi;
	}

	public String getDusmanTur() {
		return dusmanTur;
	}

	public void setDusmanTur(String dusmanTur) {
		this.dusmanTur = dusmanTur;
	}

	public ArrayList<Koordinat> getYol() {
		return yol;
	}

}
