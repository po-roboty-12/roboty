public class PoleBitwy {
	

	public Punkt obliczPrzesuniety(Punkt pierwszy, Punkt drugi) {
		int x = (pierwszy.getX() + drugi.getX()) % 8;
		int y = (pierwszy.getY() + drugi.getY()) % 8;
		return new Punkt(x,y);
	}

}
