import java.util.PriorityQueue;


public class Symulacja {
	
	private Robot a;
	private Robot b;
	private PoleBitwy pole;
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
	
	
}
