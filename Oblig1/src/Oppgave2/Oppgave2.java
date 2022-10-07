package Oppgave2;

import java.util.Arrays;

public class Oppgave2 {

	public static void main(String[] args) {
		final String[] kokker = {"Anne", "Erik", "Knut"}; 
		  final String[] servitorer = {"Mia", "Per"}; 
		  final int KAPASITET = 4; 
		 
		  skrivUtHeader(kokker, servitorer, KAPASITET); 
		   
		  HamburgerBrett brett = new HamburgerBrett(KAPASITET); 
		   
		  for (String navn : kokker) { 
		   new Kokk(brett, navn).start(); 
		  } 
		  for (String navn : servitorer) { 
		   new Servitor(brett, navn).start(); 
		  } 
	
	

		
	}

	private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
		System.out.println("I denne simuleringen har vi");
		
		String kokkPrint = String.join(",", kokker);
		System.out.println("         " + kokker.length + " kokker" + Arrays.toString(kokker));
		
		String servitorPrint = String.join(",", servitorer);
		System.out.println("         " + servitorer.length + " servitører" + Arrays.toString(servitorer));
		
		System.out.println("         Kapasiteten til brettet er " + kapasitet + " hamburgere."
				+ "\nVi starter..."
				+ "\n");
	}

}
