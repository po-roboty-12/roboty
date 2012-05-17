
public class Tertertertert {

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
	
}
