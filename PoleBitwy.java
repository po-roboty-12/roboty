public class PoleBitwy {
	

	public Punkt obliczPrzesuniety(Punkt pierwszy, Punkt drugi) {
		int x = (pierwszy.dajX() + drugi.dajX()) % 8;
		int y = (pierwszy.dajY() + drugi.dajY()) % 8;
		return new Punkt(x,y);
	}

}
