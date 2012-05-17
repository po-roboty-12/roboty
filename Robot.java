
public abstract class Robot {
	private Punkt pozycja;
	private Punkt kierunek;
    public Punkt getPozycja() {
        return pozycja;
    }
    public Punkt getKierunek() {
        return kierunek;
    }
	protected int wytrzymalosc = 5;
    public int getWytrzymalosc() {
        return wytrzymalosc;
    }
	public Robot(Punkt poz, Punkt kier) {
		pozycja = poz;
		kierunek = kier;
	}
	public abstract Akcja[] wezAkcje();
}
