package Oppgave1;

import static javax.swing.JOptionPane.showInputDialog;

public class Oppgave1 {

	public static void main(String[] args) {
		
		Melding melding = new Melding();
		String stopp = "quit";

		Thread printlnTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!melding.getTekst().equals(stopp)) {
				
				System.out.println(melding.getTekst());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}});

		Thread giVerdiTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!melding.getTekst().equals(stopp)) {
				String inn = showInputDialog("Hva vil du skal skrives?");
				melding.setTekst(inn);
				}
			}
		});

		printlnTraad.start();
		giVerdiTraad.start();
	}
}

	
		
	

