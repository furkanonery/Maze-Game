package MainPaket;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import KoordinatPaket.Koordinat;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ekran extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3660238811763421358L;
	private JPanel contentPane;
	static JLabel[][] harita = new JLabel[11][13];
	static char[][] dizi = new char[11][13];
	public static Thread live;
	static int en = 0;
	static int boy = 0;
	static int deger = 1;
	static int dongu = 1;
	private BufferedReader br;
	public static Koordinat player = new Koordinat(5, 6);
	public static ArrayList<String> dusmanlar = new ArrayList<String>();
	public static ArrayList<Koordinat> kapi = new ArrayList<Koordinat>();
	public static ArrayList<Koordinat> yol2 = new ArrayList<Koordinat>();
	public static JLabel gozlukluLabel = new JLabel("G\u00F6zl\u00FCkl\u00FC:");
	public static JLabel tembelLabel = new JLabel("Tembel:");
	public static char p = 'M';
	public static JLabel kazanLabel = new JLabel("KAZANDINIZ");
	public static JLabel kaybetLabel = new JLabel("KAYBETTÝNÝZ");
	private JButton gozlukluButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ekran frame = new ekran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ekran() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		File dosya = new File("harita.txt");

		int sayac = 0;

		try {
			if (!dosya.exists()) {
				dosya.createNewFile();
			}

			FileReader fr = new FileReader(dosya);

			br = new BufferedReader(fr);

			String asd;

			while ((asd = br.readLine()) != null) {

				char x;
				if (asd.charAt(0) == '1' || asd.charAt(0) == '0') {
					sayac++;
					for (int i = 0; i < asd.length(); i++) {

						boy = asd.length();
						if (i % 2 == 0) {
							x = asd.charAt(i);
							dizi[sayac - 1][i / 2] = x;
							// System.out.print(Integer.parseInt(x)+" ");
						}
					}
					// System.out.println();
				} else {
					dusmanlar.add(asd);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("hata");
		}

		/*
		 * for(int i=0;i<11;i++){ for(int j=0;j<13;j++){
		 * System.out.print(dizi[i][j]+" "); } System.out.println(); }
		 */

		en = sayac;
		if (boy % 2 == 0) {
			boy = boy / 2;
		} else {
			boy = boy / 2 + 1;
		}

		Image a = new ImageIcon(this.getClass().getResource("/a.png")).getImage();
		Image b = new ImageIcon(this.getClass().getResource("/b.png")).getImage();
		Image c = new ImageIcon(this.getClass().getResource("/c.png")).getImage();
		Image d = new ImageIcon(this.getClass().getResource("/d.png")).getImage();

		Image engel = new ImageIcon(this.getClass().getResource("/engel.png")).getImage();
		Image yol = new ImageIcon(this.getClass().getResource("/yol.png")).getImage();

		Image azman = new ImageIcon(this.getClass().getResource("/azman.png")).getImage();
		Image gargamel = new ImageIcon(this.getClass().getResource("/gargamel.png")).getImage();

		Image sirine = new ImageIcon(this.getClass().getResource("/sirine.png")).getImage();
		Image tembel = new ImageIcon(this.getClass().getResource("/tembel.png")).getImage();
		Image gozluklu = new ImageIcon(this.getClass().getResource("/gozluklu.png")).getImage();

		Image mavi = new ImageIcon(this.getClass().getResource("/mavi.png")).getImage();
		Image yesil = new ImageIcon(this.getClass().getResource("/yesil.png")).getImage();

		Image hedef = new ImageIcon(this.getClass().getResource("/hedef.png")).getImage();

		Image gozlukluIcon = new ImageIcon(this.getClass().getResource("/gozlukluicon.png")).getImage();
		Image tembelIcon = new ImageIcon(this.getClass().getResource("/tembelicon.png")).getImage();

		Image mantar = new ImageIcon(this.getClass().getResource("/mantar.png")).getImage();
		Image altin = new ImageIcon(this.getClass().getResource("/altin.png")).getImage();

		JLabel sirineX = new JLabel("");

		sirineX.setBounds(960, 470, 70, 60);
		contentPane.add(sirineX);
		sirineX.setIcon(new ImageIcon(sirine));

		for (int i = 0; i < sayac; i++) {
			for (int j = 0; j < boy; j++) {
				harita[i][j] = new JLabel("");
				contentPane.remove(harita[i][j]);
				contentPane.revalidate();
				contentPane.repaint();
			}
		}

		for (int i = 0; i < en; i++) {
			for (int j = 0; j < boy; j++) {
				if (dizi[i][j] == '1') {
					Koordinat x = new Koordinat(i, j);
					yol2.add(x);
				}
			}
		}

		for (int i = 0; i < yol2.size(); i++) {
			if (yol2.get(i).x == 0) {
				// dizi[yol2.get(i).x][yol2.get(i).y]='A';
				kapi.add(yol2.get(i));
			} else if (yol2.get(i).y == 0) {
				// dizi[yol2.get(i).x][yol2.get(i).y]='A';
				kapi.add(yol2.get(i));
			} else if (yol2.get(i).x == en - 1) {
				// dizi[yol2.get(i).x][yol2.get(i).y]='A';
				kapi.add(yol2.get(i));
			}
		}
		dizi[kapi.get(0).x][kapi.get(0).y] = 'A';
		dizi[kapi.get(1).x][kapi.get(1).y] = 'B';
		dizi[kapi.get(2).x][kapi.get(2).y] = 'C';
		dizi[kapi.get(3).x][kapi.get(3).y] = 'D';

		gozlukluLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		gozlukluLabel.setBounds(1192, 380, 272, 53);
		contentPane.add(gozlukluLabel);

		gozlukluLabel.setVisible(false);

		tembelLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		tembelLabel.setBounds(1192, 470, 272, 53);
		contentPane.add(tembelLabel);

		tembelLabel.setVisible(false);

		live = new Thread() {

			public void run() {

				while (true) {

					try {
						Thread.sleep(150);
					} catch (Exception e) {
						// TODO: handle exception
					}
					for (int i = 0; i < 11; i++) {

						for (int j = 0; j < 13; j++) {

							if (dizi[i][j] == '1') {
								harita[i][j].setIcon(new ImageIcon(yol));
							} else if (dizi[i][j] == '0') {
								harita[i][j].setIcon(new ImageIcon(engel));
							} else if (dizi[i][j] == 'A') {
								harita[i][j].setIcon(new ImageIcon(a));
							} else if (dizi[i][j] == 'B') {
								harita[i][j].setIcon(new ImageIcon(b));
							} else if (dizi[i][j] == 'C') {
								harita[i][j].setIcon(new ImageIcon(c));
							} else if (dizi[i][j] == 'D') {
								harita[i][j].setIcon(new ImageIcon(d));
							} else if (dizi[i][j] == 'N') {// azman
								harita[i][j].setIcon(new ImageIcon(azman));
							} else if (dizi[i][j] == 'L') {// gargamel
								harita[i][j].setIcon(new ImageIcon(gargamel));
							} else if (dizi[i][j] == 'U') {// gozluklu
								harita[i][j].setIcon(new ImageIcon(gozluklu));
							} else if (dizi[i][j] == 'E') {// sirine
								harita[i][j].setIcon(new ImageIcon(sirine));
							} else if (dizi[i][j] == 'T') {// tembel
								harita[i][j].setIcon(new ImageIcon(tembel));
							} else if (dizi[i][j] == 'M') {// mavi
								harita[i][j].setIcon(new ImageIcon(mavi));
							} else if (dizi[i][j] == 'F') {// hedef
								harita[i][j].setIcon(new ImageIcon(hedef));
							} else if (dizi[i][j] == 'Y') {// yesil
								harita[i][j].setIcon(new ImageIcon(yesil));
							} else if (dizi[i][j] == 'R') {// mantar
								harita[i][j].setIcon(new ImageIcon(mantar));
							} else if (dizi[i][j] == 'G') {// altin
								harita[i][j].setIcon(new ImageIcon(altin));
							}

							/*
							 * if(i==7 && j==12){
							 * System.out.println(harita[i][j].getBounds());
							 * //System.out.println(harita[i][j].getBounds());
							 * 
							 * }
							 */

							harita[i][j].setBounds(j * 70 + 50, i * 60 + 50, 70, 60);
							contentPane.add(harita[i][j]);
							harita[i][j].repaint();
						}

					}
				}
			}

		};

		live.start();
		JLabel lblNewLabel = new JLabel("Karakter Se\u00E7 Ve Oyuna Ba\u015Fla");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(1192, 58, 394, 74);
		contentPane.add(lblNewLabel);

		JButton tembelButton = new JButton("New button");
		tembelButton.setFocusable(false);

		gozlukluButton = new JButton("New button");
		gozlukluButton.setFocusable(false);
		gozlukluButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p = 'U';
				game.player = 'U';
				dizi[player.x][player.y] = p;
				gozlukluButton.setVisible(false);
				tembelButton.setVisible(false);
				lblNewLabel.setVisible(false);
				game.start(dizi, en, boy);
				game.game1.start();
				if (game.dusmanKarakterList2.size() == 2) {
					if (game.dusmanKarakterList2.get(0).dusman.equals("Azman")
							|| game.dusmanKarakterList2.get(1).dusman.equals("Azman")) {
						game.game3.start();
					}
					if (game.dusmanKarakterList2.get(0).dusman.equals("Gargamel")
							|| game.dusmanKarakterList2.get(1).dusman.equals("Gargamel")) {
						game.game4.start();
					}
				} else if (game.dusmanKarakterList2.size() == 1) {
					if (game.dusmanKarakterList2.get(0).dusman.equals("Azman")) {
						game.game3.start();
					}
					if (game.dusmanKarakterList2.get(0).dusman.equals("Gargamel")) {
						game.game4.start();
					}
				}
				game.altinEkle.start();
				game.altinSil.start();
				game.mantarEkle.start();
				game.mantarSil.start();
				gozlukluLabel.setVisible(true);
			}
		});
		gozlukluButton.setBounds(1157, 145, 210, 222);
		gozlukluButton.setIcon(new ImageIcon(gozlukluIcon));
		contentPane.add(gozlukluButton);

		tembelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = 'T';
				game.player = 'T';
				dizi[player.x][player.y] = p;
				gozlukluButton.setVisible(false);
				tembelButton.setVisible(false);
				lblNewLabel.setVisible(false);
				game.start(dizi, en, boy);

				game.game2.start();
				if (game.dusmanKarakterList2.size() == 2) {
					if (game.dusmanKarakterList2.get(0).dusman.equals("Azman")
							|| game.dusmanKarakterList2.get(1).dusman.equals("Azman")) {
						game.game3.start();
					}
					if (game.dusmanKarakterList2.get(0).dusman.equals("Gargamel")
							|| game.dusmanKarakterList2.get(1).dusman.equals("Gargamel")) {
						game.game4.start();
					}
				} else if (game.dusmanKarakterList2.size() == 1) {
					if (game.dusmanKarakterList2.get(0).dusman.equals("Azman")) {
						game.game3.start();
					}
					if (game.dusmanKarakterList2.get(0).dusman.equals("Gargamel")) {
						game.game4.start();
					}
				}
				game.altinEkle.start();
				game.altinSil.start();
				game.mantarEkle.start();
				game.mantarSil.start();
				tembelLabel.setVisible(true);
			}
		});
		tembelButton.setBounds(1407, 145, 215, 222);
		tembelButton.setIcon(new ImageIcon(tembelIcon));
		contentPane.add(tembelButton);

		kazanLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		kazanLabel.setBounds(1192, 624, 341, 66);
		contentPane.add(kazanLabel);

		kazanLabel.setVisible(false);

		kaybetLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		kaybetLabel.setBounds(1192, 539, 341, 66);
		contentPane.add(kaybetLabel);

		kaybetLabel.setVisible(false);

		dizi[player.x][player.y] = p;

		addKeyListener(new KeyAdapter() {
			@Override

			public void keyPressed(KeyEvent e) {

				if (p == 'U') {
					dongu = 2;
				}
				if (p == 'T') {
					dongu = 1;
				}
				for (int j = 0; j < dongu; j++) {
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						temizle();
						if (!(player.y + deger >= boy || player.y + deger < 0 || dizi[player.x][player.y + deger] == '0'

						)) {
							player.y += deger;
							dizi[player.x][player.y] = p;
							dizi[player.x][player.y - deger] = '1';
						}

					}

					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						temizle();
						if (!(player.y - deger > boy || player.y - deger < 0 || dizi[player.x][player.y - deger] == '0'

						)) {
							player.y -= deger;
							dizi[player.x][player.y] = p;
							dizi[player.x][player.y + deger] = '1';
						}

					}

					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						temizle();
						if (!(player.x + deger >= en || player.x + deger < 0 || dizi[player.x + deger][player.y] == '0'

						)) {
							player.x += deger;
							dizi[player.x][player.y] = p;
							dizi[player.x - deger][player.y] = '1';
						}

					}
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						temizle();
						if (!(player.x - deger > en || player.x - deger < 0 || dizi[player.x - 1][player.y] == '0'

						)) {
							player.x -= deger;
							dizi[player.x][player.y] = p;
							dizi[player.x + deger][player.y] = '1';
						}

					}

				}

			}
		});

	}

	protected void temizle() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ekran.yol2.size(); i++) {
			if (dizi[ekran.yol2.get(i).x][ekran.yol2.get(i).y] == 'F'
					|| dizi[ekran.yol2.get(i).x][ekran.yol2.get(i).y] == 'Y') {
				dizi[ekran.yol2.get(i).x][ekran.yol2.get(i).y] = '1';
			}
		}
	}
}
