public class Symulacja {
	private Robot a, b;
	private PoleBitwy pole;
	final private Punkt poleStartoweA = new Punkt(3, 1);
	final private Punkt poleStartoweB = new Punkt(4, 2);
	final private Kierunek kierunki = new Kierunek()
	private PriorityQueue<Akcja> q = new PriorityQueue<Akcja>();
	private boolean startB = false;

	private void przeprowadzTure(){
		if (a.dajWytrzymalosc() * b.dajWytrzymalosc() != 0){
			if (q.size == 0){
				Akcja[] akcjeA = a.dajAkcja();
				Akcja[] akcjeB = b.dajAkcja();
				if (startB) {
					Akcja[] pom = akcjeA;
					akcjeA = akcjeB;
					akcjeB = pom;
				}
				int i;
				for (i = 0; i< akcjeA.length() && i< akcjeB.length(); i++){
					q.add(akcjeA[i]);
					q.add(akcjeB[i]);
				}
				Akcja[] reszta = akcjeA;
				if ( i > akcjeA.length()) {
					reszta = akcjeB;
				}
				int j;
				for (j = i; i< reszta.length(); i++){
					q.add(reszta[i]);
				}
				if (q.remove(Akcja akcja)){
					akcja.wykonaj();
				}
			}
		}
	}
	public Robot getA() {
		return a;
	}

	public Robot getB() {
		return b;
	}

	public Symulacja(){
		pole = new PoleBitwy();
		a = new Robot(poleStartoweA, kierunki.Polnoc);
		b = new Robot(poleStartoweB, kierunki.Poludnie);
	}
}
