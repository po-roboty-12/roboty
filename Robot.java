
public abstract class Robot {
	private Punkt pozycja;
	private Punkt kierunek;
	protected int wytrzymalosc = 5;
	public Robot(Punkt poz, Punkt kier) {
		pozycja = poz;
		kierunek = kier;
	}
	public abstract Akcja[] wezAkcje();
}
