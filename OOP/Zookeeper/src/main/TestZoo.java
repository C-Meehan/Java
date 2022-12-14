package main;


public class TestZoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla rilla = new Gorilla();
		GiantBat bat = new GiantBat();
		System.out.println(rilla.throwSomething(3));
		System.out.println(rilla.eatBananas(2));
		System.out.println(rilla.climb(1));
		
		System.out.println(bat.attackTown(3));
		System.out.println(bat.eatHumans(2));
		System.out.println(bat.fly(2));
		
		
	}

}
