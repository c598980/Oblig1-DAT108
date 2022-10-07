package Oppgave2;

import java.util.LinkedList;

public class HamburgerBrett {
	private LinkedList<Hamburger> brett;
	private int kapasitet;
	private int antall;
	private int antallLagd;
	
	
	public HamburgerBrett(int kapasitet) {
		brett = new LinkedList<>();
		this.kapasitet = kapasitet;
		antall = 0;
		antallLagd = 0;
	}
	
	public int getAntall() {
		return antall;
	}
	
	public boolean erLedig() {
		return antall < kapasitet;
	}
	
	public boolean erTom() {
		return antall == 0;
	}
	
	public synchronized boolean leggTil(Hamburger burger, String navn){
		boolean lagtTil = true;
		if(erLedig()) {
			brett.add(burger);
			antall++;
			antallLagd++;
			burger.setNr(antallLagd);
			System.out.println(navn + " (kokk) legger på hamburger ◖"+ antallLagd +"◗. Brett: " + utPrint());
		}else {
			lagtTil = false;
		}
		return lagtTil;
	}
	
	public String utPrint() {
		String ut = "[";
		for(int i = 0; i < antall; i++) {
			ut += "◖ ";
			ut += brett.get(i).getNr();
			ut += " ◗";
		}
		
		ut += "]";
		return ut;
	}
	
	 
	public Hamburger fjern(Servitor servitor) {
		Hamburger burger = null;
		if(!erTom()) {
			burger = brett.removeFirst();
			antall--;
		
			
			System.out.println(servitor.getNavn() + " (servitør) tar av hamburger ◖" + burger.getNr() + "◗. Brett: " +  utPrint());
		}
		return burger;
	}
	
	
}
