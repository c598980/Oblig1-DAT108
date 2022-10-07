package Oppgave2;

import java.util.Random;

public class Kokk extends Thread{
	private HamburgerBrett brett;
	private String navn;

	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public HamburgerBrett getBrett() {
		return brett;
	}

	public void setBrett(HamburgerBrett brett) {
		this.brett = brett;
	}
	
	@Override
	public void run() {
		Random rand = new Random();
		
		while(true) {
			int tid = rand.nextInt((6-2) + 1) + 2;
			Hamburger nyBurger = new Hamburger();
			
			synchronized(brett) {
				
			
			if(brett.erLedig()) {
				try {
					
					brett.leggTil(nyBurger, navn);
					brett.notify();
					Thread.sleep(tid*500);
				
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				
			}else {
				System.out.println(navn + " (Kokk) klar med hamburger, men brettet er fult");
				try {
					brett.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			}
		}	
	}
}
