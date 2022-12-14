package main;

public class Gorilla extends Mammals {
	
	public Gorilla() {
		super(100);
	}

	public String throwSomething(int timesThrown) {
		setEnergyLevel(getEnergyLevel()- (5 * timesThrown));
		return String.format("The gorilla threw the barrel. Current energy level: %s", getEnergyLevel());
	}
	
	public String eatBananas(int numEaten) {
		setEnergyLevel(getEnergyLevel()+ (10 * numEaten));
		return String.format("The gorilla ate bananas. Current energy level: %s", getEnergyLevel());
	}
	
	public String climb(int timesClimbed) {
		setEnergyLevel(getEnergyLevel()- (10 * timesClimbed));
		return String.format("The gorilla did some climbing. Current energy level: %s", getEnergyLevel());
	}
}

