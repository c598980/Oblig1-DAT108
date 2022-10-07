package Oppgave3;

import java.util.Random;

import Oppgave2.Hamburger;
import Oppgave2.HamburgerBrett;

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
			
			brett.leggTil(nyBurger, navn);
			try {
				Thread.sleep(tid*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}