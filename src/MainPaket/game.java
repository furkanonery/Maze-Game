package MainPaket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DusmanPaket.Azman;
import DusmanPaket.Gargamel;
import DusmanPaket.dusmanKarakter;
import KarakterPaket.Karakter;
import KoordinatPaket.Koordinat;
import ObjePaket.Altin;
import ObjePaket.Mantar;
import ObjePaket.Obje;
import OyuncuPaket.Gozluklu;
import OyuncuPaket.Puan;
import OyuncuPaket.Tembel;

public class game {

	public static Thread game1;
	public static Thread game2;
	public static Thread game3;
	public static Thread game4;
	public static Thread altinEkle;
	public static Thread mantarEkle;
	public static Thread altinSil;
	public static Thread mantarSil;

	public static char player;

	public static List<Karakter.Field> shortestPath2;
	public static List<Karakter.Field> shortestPath;

	public static Obje mantarList = new Obje();
	public static Obje altinList = new Obje();
	public static ArrayList<Koordinat> yol3 = new ArrayList<Koordinat>();

	public static ArrayList<dusmanKarakter> dusmanKarakterList2 = new ArrayList<dusmanKarakter>();

	public static Gargamel gargamel = new Gargamel(1, "gargamel", "dusman");
	public static Azman azman = new Azman(2, "azman", "dusman");
	public static Puan puan = new Puan();

	public static Tembel tembel = new Tembel(3, "tembel", "oyuncu");
	public static Gozluklu gozluklu = new Gozluklu(4, "gozluklu", "oyuncu");

	public static Altin altinObje = new Altin();
	public static Mantar mantarObje = new Mantar();

	public static void start(char[][] dizi, int en, int boy) {
		// TODO Auto-generated method stub

		ArrayList<Koordinat> yol = new ArrayList<Koordinat>();

		for (int i = 0; i < en; i++) {
			for (int j = 0; j < boy; j++) {
				if (dizi[i][j] == '1') {
					Koordinat x = new Koordinat(i, j);
					yol.add(x);
					yol3.add(x);
				}
			}
		}

		/*
		 * System.out.println(ekran.dusmanlar.size());
		 * System.out.println(ekran.dusmanlar.get(0));
		 * System.out.println(ekran.dusmanlar.get(1));
		 */

		ArrayList<dusmanKarakter> dusmanKarakterList = new ArrayList<dusmanKarakter>();

		String dusman = "";
		char kapi = ' ';
		if (ekran.dusmanlar.size() > 0) {
			for (int i = 9; ekran.dusmanlar.get(0).charAt(i) != ','; i++) {
				dusman = dusman + ekran.dusmanlar.get(0).charAt(i);
			}
			kapi = ekran.dusmanlar.get(0).charAt(ekran.dusmanlar.get(0).length() - 1);
			dusmanKarakter dusmanKarakter = new dusmanKarakter(dusman, kapi);
			dusmanKarakterList.add(dusmanKarakter);
			dusmanKarakterList2.add(dusmanKarakter);
			// System.out.println(dusman+" "+kapi);
			ekran.dusmanlar.remove(0);
			dusman = "";
		}

		if (ekran.dusmanlar.size() > 0) {
			for (int i = 9; ekran.dusmanlar.get(0).charAt(i) != ','; i++) {
				dusman = dusman + ekran.dusmanlar.get(0).charAt(i);
			}
			kapi = ekran.dusmanlar.get(0).charAt(ekran.dusmanlar.get(0).length() - 1);
			dusmanKarakter dusmanKarakter = new dusmanKarakter(dusman, kapi);
			dusmanKarakterList.add(dusmanKarakter);
			dusmanKarakterList2.add(dusmanKarakter);
			// System.out.println(dusman+" "+kapi);
			ekran.dusmanlar.remove(0);
			dusman = "";
		}

		if (ekran.dusmanlar.size() > 0) {
			for (int i = 9; ekran.dusmanlar.get(0).charAt(i) != ','; i++) {
				dusman = dusman + ekran.dusmanlar.get(0).charAt(i);
			}
			kapi = ekran.dusmanlar.get(0).charAt(ekran.dusmanlar.get(0).length() - 1);
			dusmanKarakter dusmanKarakter = new dusmanKarakter(dusman, kapi);
			dusmanKarakterList.add(dusmanKarakter);
			dusmanKarakterList2.add(dusmanKarakter);
			// System.out.println(dusman+" "+kapi);
			ekran.dusmanlar.remove(0);
			dusman = "";
		}

		if (ekran.dusmanlar.size() > 0) {
			for (int i = 9; ekran.dusmanlar.get(0).charAt(i) != ','; i++) {
				dusman = dusman + ekran.dusmanlar.get(0).charAt(i);
			}
			kapi = ekran.dusmanlar.get(0).charAt(ekran.dusmanlar.get(0).length() - 1);
			dusmanKarakter dusmanKarakter = new dusmanKarakter(dusman, kapi);
			dusmanKarakterList.add(dusmanKarakter);
			dusmanKarakterList2.add(dusmanKarakter);
			// System.out.println(dusman+" "+kapi);
			ekran.dusmanlar.remove(0);
			dusman = "";
		}
		Koordinat kapi1 = new Koordinat(0, 0);
		Koordinat kapi2 = new Koordinat(0, 0);

		// System.out.println(dusmanKarakterList.get(0).dusman+"
		// "+dusmanKarakterList.get(0).kapi);
		// System.out.println(dusmanKarakterList.get(1).dusman+"
		// "+dusmanKarakterList.get(1).kapi);

		while (dusmanKarakterList.size() > 0) {
			if (dusmanKarakterList.get(0).kapi == 'A') {
				if (dusmanKarakterList.get(0).dusman.equals("Gargamel")) {
					dizi[ekran.kapi.get(0).x][ekran.kapi.get(0).y] = 'L';
					Koordinat x = new Koordinat(ekran.kapi.get(0).x, ekran.kapi.get(0).y);
					gargamel.setKonum(x);
					kapi1.setKoordinat(x);
				}
			}
			if (dusmanKarakterList.get(0).kapi == 'B') {
				if (dusmanKarakterList.get(0).dusman.equals("Gargamel")) {
					dizi[ekran.kapi.get(1).x][ekran.kapi.get(1).y] = 'L';
					Koordinat x = new Koordinat(ekran.kapi.get(1).x, ekran.kapi.get(1).y);
					gargamel.setKonum(x);
					kapi1.setKoordinat(x);
				}
			}
			if (dusmanKarakterList.get(0).kapi == 'C') {
				if (dusmanKarakterList.get(0).dusman.equals("Gargamel")) {
					dizi[ekran.kapi.get(2).x][ekran.kapi.get(2).y] = 'L';
					Koordinat x = new Koordinat(ekran.kapi.get(2).x, ekran.kapi.get(2).y);
					gargamel.setKonum(x);
					kapi1.setKoordinat(x);
				}
			}
			if (dusmanKarakterList.get(0).kapi == 'D') {
				if (dusmanKarakterList.get(0).dusman.equals("Gargamel")) {
					dizi[ekran.kapi.get(3).x][ekran.kapi.get(3).y] = 'L';
					Koordinat x = new Koordinat(ekran.kapi.get(3).x, ekran.kapi.get(3).y);
					gargamel.setKonum(x);
					kapi1.setKoordinat(x);
				}
			}
			if (dusmanKarakterList.get(0).kapi == 'A') {
				if (dusmanKarakterList.get(0).dusman.equals("Azman")) {
					dizi[ekran.kapi.get(0).x][ekran.kapi.get(0).y] = 'N';
					Koordinat x = new Koordinat(ekran.kapi.get(0).x, ekran.kapi.get(0).y);
					azman.setKonum(x);
					kapi2.setKoordinat(x);
				}
			}
			if (dusmanKarakterList.get(0).kapi == 'B') {
				if (dusmanKarakterList.get(0).dusman.equals("Azman")) {
					dizi[ekran.kapi.get(1).x][ekran.kapi.get(1).y] = 'N';
					Koordinat x = new Koordinat(ekran.kapi.get(1).x, ekran.kapi.get(1).y);
					azman.setKonum(x);
					kapi2.setKoordinat(x);
				}
			}
			if (dusmanKarakterList.get(0).kapi == 'C') {
				if (dusmanKarakterList.get(0).dusman.equals("Azman")) {
					dizi[ekran.kapi.get(2).x][ekran.kapi.get(2).y] = 'N';
					Koordinat x = new Koordinat(ekran.kapi.get(2).x, ekran.kapi.get(2).y);
					azman.setKonum(x);
					kapi2.setKoordinat(x);
				}
			}
			if (dusmanKarakterList.get(0).kapi == 'D') {
				if (dusmanKarakterList.get(0).dusman.equals("Azman")) {
					dizi[ekran.kapi.get(3).x][ekran.kapi.get(3).y] = 'N';
					Koordinat x = new Koordinat(ekran.kapi.get(3).x, ekran.kapi.get(3).y);
					azman.setKonum(x);
					kapi2.setKoordinat(x);
				}
			}
			dusmanKarakterList.remove(0);
		}

		/*
		 * for(int i=0;i<dusmanKarakterList2.size();i++){
		 * System.out.println(dusmanKarakterList2.get(i).dusman+" "
		 * +dusmanKarakterList2.get(i).kapi); }
		 */

		game1 = new Thread() {// gozluklu

			public void run() {

				while (true) {

					if (dusmanKarakterList2.size() == 2) {
						if (dusmanKarakterList2.get(0).dusman.equals("Azman")
								|| dusmanKarakterList2.get(1).dusman.equals("Azman")) {
							shortestPath2 = azman.findShortestPath(dizi, azman.getKonum(), player);
							for (int i = 1; i < shortestPath2.size() - 1; i++) {
								if (dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] == '1')
									dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] = 'Y';
							}
						}
						if (dusmanKarakterList2.get(0).dusman.equals("Gargamel")
								|| dusmanKarakterList2.get(1).dusman.equals("Gargamel")) {
							shortestPath = gargamel.findShortestPath(dizi, gargamel.getKonum(), player);
							for (int i = 1; i < shortestPath.size() - 1; i++) {
								if (dizi[shortestPath.get(i).x][shortestPath.get(i).y] == '1')
									dizi[shortestPath.get(i).x][shortestPath.get(i).y] = 'F';
							}
						}
					} else if (dusmanKarakterList2.size() == 1) {
						if (dusmanKarakterList2.get(0).dusman.equals("Azman")) {
							shortestPath2 = azman.findShortestPath(dizi, azman.getKonum(), player);
							for (int i = 1; i < shortestPath2.size() - 1; i++) {
								if (dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] == '1')
									dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] = 'Y';
							}
						}

						if (dusmanKarakterList2.get(0).dusman.equals("Gargamel")) {
							shortestPath = gargamel.findShortestPath(dizi, gargamel.getKonum(), player);
							for (int i = 1; i < shortestPath.size() - 1; i++) {
								if (dizi[shortestPath.get(i).x][shortestPath.get(i).y] == '1')
									dizi[shortestPath.get(i).x][shortestPath.get(i).y] = 'F';
							}
						}
					}

					for (int i = 0; i < altinList.List().size(); i++) {
						if (ekran.player.x == altinList.List().get(i).x
								&& ekran.player.y == altinList.List().get(i).y) {
							gozluklu.setSkor(gozluklu.getSkor() + 5);
							altinList.List().remove(i);
						}
					}

					for (int i = 0; i < mantarList.List().size(); i++) {
						if (ekran.player.x == mantarList.List().get(i).x
								&& ekran.player.y == mantarList.List().get(i).y) {
							gozluklu.setSkor(gozluklu.getSkor() + 50);
							mantarList.List().remove(i);
						}
					}

					if (ekran.player.x == gargamel.getKonum().x && ekran.player.y == gargamel.getKonum().y) {
						gozluklu.setSkor(gozluklu.getSkor() - 15);
						gargamel.setKonum(kapi1);
					}

					if (ekran.player.x == azman.getKonum().x && ekran.player.y == azman.getKonum().y) {
						gozluklu.setSkor(gozluklu.getSkor() - 5);
						azman.setKonum(kapi2);
					}

					ekran.gozlukluLabel.setText("G\u00F6zl\u00FCkl\u00FC: " + gozluklu.getSkor());

					if (ekran.player.x == 7 && ekran.player.y == 12) {
						ekran.kazanLabel.setVisible(true);
						bitir();

					}
					if (gozluklu.getSkor() <= 0) {
						ekran.kaybetLabel.setVisible(true);
						bitir();

					}

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		};
		game2 = new Thread() {// tembel

			public void run() {

				while (true) {

					if (dusmanKarakterList2.size() == 2) {
						if (dusmanKarakterList2.get(0).dusman.equals("Azman")
								|| dusmanKarakterList2.get(1).dusman.equals("Azman")) {
							shortestPath2 = azman.findShortestPath(dizi, azman.getKonum(), player);
							for (int i = 1; i < shortestPath2.size() - 1; i++) {
								if (dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] == '1')
									dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] = 'Y';
							}
						}
						if (dusmanKarakterList2.get(0).dusman.equals("Gargamel")
								|| dusmanKarakterList2.get(1).dusman.equals("Gargamel")) {
							shortestPath = gargamel.findShortestPath(dizi, gargamel.getKonum(), player);
							for (int i = 1; i < shortestPath.size() - 1; i++) {
								if (dizi[shortestPath.get(i).x][shortestPath.get(i).y] == '1')
									dizi[shortestPath.get(i).x][shortestPath.get(i).y] = 'F';
							}
						}
					} else if (dusmanKarakterList2.size() == 1) {
						if (dusmanKarakterList2.get(0).dusman.equals("Azman")) {
							shortestPath2 = azman.findShortestPath(dizi, azman.getKonum(), player);
							for (int i = 1; i < shortestPath2.size() - 1; i++) {
								if (dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] == '1')
									dizi[shortestPath2.get(i).x][shortestPath2.get(i).y] = 'Y';
							}
						}

						else if (dusmanKarakterList2.get(0).dusman.equals("Gargamel")) {
							shortestPath = gargamel.findShortestPath(dizi, gargamel.getKonum(), player);
							for (int i = 1; i < shortestPath.size() - 1; i++) {
								if (dizi[shortestPath.get(i).x][shortestPath.get(i).y] == '1')
									dizi[shortestPath.get(i).x][shortestPath.get(i).y] = 'F';
							}
						}
					}

					for (int i = 0; i < altinList.List().size(); i++) {
						if (ekran.player.x == altinList.List().get(i).x
								&& ekran.player.y == altinList.List().get(i).y) {
							tembel.setSkor(tembel.getSkor() + 5);
							altinList.List().remove(i);
						}
					}

					for (int i = 0; i < mantarList.List().size(); i++) {
						if (ekran.player.x == mantarList.List().get(i).x
								&& ekran.player.y == mantarList.List().get(i).y) {
							tembel.setSkor(tembel.getSkor() + 50);
							mantarList.List().remove(i);
						}
					}

					if (ekran.player.x == gargamel.getKonum().x && ekran.player.y == gargamel.getKonum().y) {
						tembel.setSkor(tembel.getSkor() - 15);
						gargamel.setKonum(kapi1);
					}

					if (ekran.player.x == azman.getKonum().x && ekran.player.y == azman.getKonum().y) {
						tembel.setSkor(tembel.getSkor() - 5);
						azman.setKonum(kapi2);
					}

					ekran.tembelLabel.setText("Tembel: " + tembel.getSkor());

					if (ekran.player.x == 7 && ekran.player.y == 12) {
						ekran.kazanLabel.setVisible(true);
						bitir();

					}

					if (tembel.getSkor() <= 0) {
						ekran.kaybetLabel.setVisible(true);
						bitir();

					}

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		};

		game3 = new Thread() {// azman

			public void run() {

				while (true) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (shortestPath2.size() > 1) {
						Koordinat x = new Koordinat(shortestPath2.get(1).x, shortestPath2.get(1).y);
						int a = azman.getKonum().x;
						int b = azman.getKonum().y;
						azman.setKonum(x);
						if (dizi[azman.getKonum().x][azman.getKonum().y] != 'G'
								&& dizi[azman.getKonum().x][azman.getKonum().y] != 'R') {
							dizi[azman.getKonum().x][azman.getKonum().y] = 'N';
						}
						if (dizi[a][b] == 'N') {
							dizi[a][b] = '1';
						}
					}

				}

			}

		};

		game4 = new Thread() {// gargamel

			public void run() {

				while (true) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (shortestPath.size() > 2) {

						Koordinat x = new Koordinat(shortestPath.get(2).x, shortestPath.get(2).y);
						int a = gargamel.getKonum().x;
						int b = gargamel.getKonum().y;
						gargamel.setKonum(x);
						if (dizi[gargamel.getKonum().x][gargamel.getKonum().y] != 'G'
								&& dizi[gargamel.getKonum().x][gargamel.getKonum().y] != 'R') {
							dizi[gargamel.getKonum().x][gargamel.getKonum().y] = 'L';
						}

						if (dizi[a][b] == 'L') {
							dizi[a][b] = '1';
						}

					} else if (shortestPath.size() > 1) {
						Koordinat x = new Koordinat(shortestPath.get(1).x, shortestPath.get(1).y);
						int a = gargamel.getKonum().x;
						int b = gargamel.getKonum().y;
						gargamel.setKonum(x);
						if (dizi[gargamel.getKonum().x][gargamel.getKonum().y] != 'G'
								&& dizi[gargamel.getKonum().x][gargamel.getKonum().y] != 'R') {
							dizi[gargamel.getKonum().x][gargamel.getKonum().y] = 'L';
						}

						if (dizi[a][b] == 'L') {
							dizi[a][b] = '1';
						}
					}

				}

			}

		};

		altinEkle = new Thread() {

			public void run() {
				while (true) {

					Random r = new Random();

					int u = r.nextInt(10) + 1;

					u = u * 1000;

					for (int i = 0; i < 5; i++) {

						int rast = r.nextInt(yol3.size());

						Koordinat z = new Koordinat(yol3.get(rast).x, yol3.get(rast).y);
						altinList.List().add(z);
					}

					for (int i = 0; i < altinList.List().size(); i++) {

						dizi[altinList.List().get(i).x][altinList.List().get(i).y] = 'G';
					}

					try {
						Thread.sleep(u);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		};

		altinSil = new Thread() {

			public void run() {
				while (true) {

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (int i = 0; i < 5 && altinList.List().size() > 5; i++) {
						if (dizi[altinList.List().get(i).x][altinList.List().get(i).y] == 'G') {
							dizi[altinList.List().get(i).x][altinList.List().get(i).y] = '1';
							altinList.List().remove(i);
						}

					}

				}

			}

		};

		mantarEkle = new Thread() {

			public void run() {

				while (true) {

					Random r = new Random();

					int u = r.nextInt(20) + 1;

					u = u * 1000;

					int rast = r.nextInt(yol3.size());
					Koordinat z = new Koordinat(yol3.get(rast).x, yol3.get(rast).y);

					mantarList.List().add(z);

					dizi[mantarList.List().get(mantarList.List().size() - 1).x][mantarList.List()
							.get(mantarList.List().size() - 1).y] = 'R';

					try {
						Thread.sleep(u);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		};
		mantarSil = new Thread() {

			public void run() {

				while (true) {

					try {
						Thread.sleep(7000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (mantarList.List().size() > 0
							&& dizi[mantarList.List().get(0).x][mantarList.List().get(0).y] == 'R') {
						dizi[mantarList.List().get(0).x][mantarList.List().get(0).y] = '1';
						mantarList.List().remove(0);
					}
				}

			}

		};

	}

	@SuppressWarnings("deprecation")
	public static void bitir() {
		altinSil.stop();
		altinEkle.stop();
		mantarEkle.stop();
		mantarSil.stop();
		game1.stop();
		game2.stop();
		game3.stop();
		game4.stop();
		ekran.live.stop();
	}

}
