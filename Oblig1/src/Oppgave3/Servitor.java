package Oppgave3;

import java.util.Random;


public class Servitor extends Thread {
	private HamburgerBrett brett;
	private String navn;

	
	public Servitor(HamburgerBrett brett, String navn) {
		this.setBrett(brett);
		this.setNavn(navn);
	}


	public HamburgerBrett getBrett() {
		return brett;
	}


	public void setBrett(HamburgerBrett brett) {
		this.brett = brett;
	}


	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	@Override
	public void run() {
	Random rand = new Random();
		
		while(true) {
			int tid = rand.nextInt((6-2) + 1) + 2;
			brett.fjern();
			
			try {
				Thread.sleep(tid*500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}