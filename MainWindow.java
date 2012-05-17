import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;


public class MainWindow {

	private JFrame frame;
	private JLabel statusLabel;
	private Canvas canvas;
	private Symulacja symulacja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		symulacja = new Symulacja();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.SOUTH);
		
		statusLabel = new JLabel("Gracze mają dużo hp, ok?");
		splitPane.setRightComponent(statusLabel);
		
		Button button = new Button("Koniec tury");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// statusLabel.setText("Hello world!");
				//Random rand = new Random();
				/*
				int x = rand.nextInt(canvas.getWidth());
				int y = rand.nextInt(canvas.getHeight());
				int w = rand.nextInt(canvas.getWidth() - x);
				int h = rand.nextInt(canvas.getHeight() - y);
				canvas.getGraphics().drawRect(x, y, w, h);
				*/
				/*
				String alph = "abcdefghijklmnopqrstuvwxyz";
				String lines[] = new String[8];
				
				for (int j = 1; j < 8; ++j) {
					String txt = "";
					int txtlen = rand.nextInt(40);
					
					for (int i = 0; i < txtlen; ++i) {
						int pos = rand.nextInt(alph.length());
						txt = txt.concat(alph.substring(pos, pos + 1));
					}
					lines[j] = txt;
				}
				lines[0] = "tutaj jest poczatek";
				*/
				
				// canvas.getGraphics().drawString(txt, rand.nextInt(canvas.getWidth() - 100), rand.nextInt(canvas.getHeight() - 60));
				paintCanvas(getCokolwiek(symulacja));
			}
		});
		splitPane.setLeftComponent(button);
		
		canvas = new Canvas();
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
	}
	
	private String[] getCokolwiek(Symulacja s) {
		Robot a = s.getA();
		Robot b = s.getB();
		String pustaLinia = " _ _ _ _ _ _ _ _";
		String[] wynik = new String[8];
		for (int i = 0; i < 8; i++) {
			wynik[i] = pustaLinia;
		}
		Punkt poz = a.getPozycja();
		int x = poz.getX();
		int y = poz.getY();
		String str = wynik[x].substring(0, y * 2 - 1);
		Punkt k = a.getKierunek();
		if (k == Kierunek.Polnoc) {
			str += "^A";
		} else if (k == Kierunek.Poludnie) {
			str += "VA";
		} else if (k == Kierunek.Wschod) {
			str += ">A";
		} else {
			str += "<A";
		}
		str += wynik[x].substring(y * 2 + 1);
		wynik[x] = str;
		poz = b.getPozycja();
		x = poz.getX();
		y = poz.getY();
		str = wynik[x].substring(0, y * 2 - 1);
		k = b.getKierunek();
		if (k == Kierunek.Polnoc) {
			str += "^B";
		} else if (k == Kierunek.Poludnie) {
			str += "VB";
		} else if (k == Kierunek.Wschod) {
			str += ">B";
		} else {
			str += "<B";
		}
		str += wynik[x].substring(y * 2 + 1);
		wynik[x] = str;
		return wynik;
	}
	
	private void paintCanvas(String[] linie) {
		Graphics g = canvas.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		g.setColor(Color.black);
		Font font = new Font("Monospaced", Font.BOLD, 28);
		g.setFont(font);
		int x = 10, y = 30;
		for (String s : linie) {
			g.drawString(s, x, y);
			y += 30;
		}
	}
}
