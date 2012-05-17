import java.util.Random;
public class SpanikowanyRobot extends Robot {

	public SpanikowanyRobot(Punkt poz, Punkt kier) {
		super(poz, kier);
	}

	@Override
	public Akcja[] wezAkcje() {
		Akcja[] odp = new Akcja[wytrzymalosc];
		Random generator = new Random();
		for (int i = 0; i < odp.length; ++i)
			odp[i] = Akcja.AKCJE[generator.nextInt(Akcja.AKCJE.length)];
		return odp;
	}

}
