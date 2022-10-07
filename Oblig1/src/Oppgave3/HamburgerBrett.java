package Oppgave3;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Oppgave2.Hamburger;
import Oppgave2.Servitor;

public class HamburgerBrett {
	private BlockingQueue<Hamburger> brett;
	private int kapasitet;
	private int antall;
	private int antallLagd;
	
	
	public HamburgerBrett(int kapasitet) {
		brett =  new LinkedBlockingQueue<>(kapasitet);
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
	
	public void leggTil(Hamburger hamburger) {
		
		try {
			brett.put(hamburger);
			antall++;
			antallLagd++;
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
	}
	
	public void fjern() {
			try {
				Hamburger fjern = brett.take();
				antall--;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	
	
	
	
}
