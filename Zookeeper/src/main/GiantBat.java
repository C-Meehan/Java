package main;

public class GiantBat extends Mammals {
		
	public GiantBat() {
		setEnergyLevel(300);
	}

	public String fly(int timesFlown) {
		setEnergyLevel(getEnergyLevel() - (50 * timesFlown));
		return String.format("Woosh-Woosh...energy level: %s", getEnergyLevel());
	}
	
	public int eatHumans(int humansEaten) {
		setEnergyLevel(getEnergyLevel() + (25 * humansEaten));
		return getEnergyLevel();
	}
	
	public String attackTown(int townsAttacked) {
		setEnergyLevel(getEnergyLevel() - (100 * townsAttacked));
		return String.format("AHHHHHH-HELPPPPPP...energy level: %s", getEnergyLevel());
	}
}
