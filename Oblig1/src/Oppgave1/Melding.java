package Oppgave1;

public class Melding {
	private String tekst = "Hallo verden!";

	public synchronized String getTekst() {
		while (!harTekst()) {
			try {
				System.out.println("Venter på input");
				wait();
			} catch (InterruptedException e) {
			}
		}
		return tekst;
	}

	public synchronized void setTekst(String tekst) {
		this.tekst = tekst;
		notifyAll();
	}

	public synchronized boolean harTekst() {
		return tekst != null;
	}
}
