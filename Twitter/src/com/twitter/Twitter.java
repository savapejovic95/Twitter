package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa koja sadrzi listu twitter poruka
 * @author Sava
 * @version 1.5
 */
public class Twitter {
	/**
	 * Lista poruka na Twitter-u
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	/**
	 * Vraca listu svih poruka
	 * @return Sve poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Pravi se nova poruka i popunjava se ime korisnika i sadrzaj poruke, i zatim se poruka ubacuje na kraj liste poruka.
	 * @param korisnik ime korisnika
	 * @param poruka sadrzaj poruke
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * vraca sve poruke sa odgovarajucim tagom do popunjenja maksimalnog broja
	 * @throws java.lang.RuntimeException ako uneti tag ima vrednosti
 	 * <ul> 
 	 * 		<li>null</li>
 	 * 		<li>prazan String</li>
 	 * </ul>
	 * @param maxBroj najveci broj poruka koje se vracaju
	 * @param tag oznaka za prepoznavanje poruka
	 * @return niz poruka sa odgovarajucim tagom
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
				throw new RuntimeException("Morate uneti tag");
		
		//Ako je maxBroj <=0, maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
				int brojac = 0; 
		
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
			TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
			//Pretrazuju se poruke i traze se one koje sadrze tag.
			//Ako se nadje neka takva, i ako nije prekoracen maxBroj
			//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
			//se prekida.
				for (int i = 0; i < poruke.size(); i++)
					if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
						if (brojac < maxBroj){
							rezultat[brojac+1]=poruke.get(i);
							brojac++;
						}
						else break;
				
				return rezultat;
	}
} 



