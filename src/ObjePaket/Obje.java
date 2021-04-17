package ObjePaket;

import java.util.ArrayList;

import KoordinatPaket.Koordinat;

public class Obje {

	@SuppressWarnings("unused")
	private int objeSayisi = 0;
	private ArrayList<Koordinat> Liste = new ArrayList<Koordinat>();

	public int getObjeSayisi() {
		return this.Liste.size();
	}

	public void setObjeSayisi(int objeSayisi) {
		this.objeSayisi = objeSayisi;
	}

	public ArrayList<Koordinat> List() {
		return Liste;
	}

	public void setListe(ArrayList<Koordinat> liste) {
		Liste = liste;
	}

}
