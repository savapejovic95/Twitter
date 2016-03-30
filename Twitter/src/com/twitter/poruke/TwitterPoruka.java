package com.twitter.poruke;

/**
 * Klasa koja predstavlja twitter poruku
 * @author Sava Pejovic
 * @version 1.0
 *
 */
public class TwitterPoruka {

	/**
	 * Ime korisnika
	 */
	private String korisnik;
	/**
	 * Sadrzaj poruke
	 */
	private String poruka;
	
	/**
	 * Vraca ime korisnika
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Postavlja novu vrednost za ime korisnika
	 * @param korisnik Nova vrednost za ime korisnika
	 * @throws java.lang.RuntimeException ako je uneto ime
 	 * <ul> 
 	 * 		<li>null</li>
 	 * 		<li>prazan String</li>
 	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca sadrzaj poruke
	 * @return sadrzaj poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Postavlja novi sadrzaj poruke
	 * @param poruka Novi sadrzaj poruke
	 * @throws java.lang.RuntimeException ako sadrzaj poruke ima null vrednost 
	 * ili ako ima vise od 140 znakova
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		
		this.poruka = poruka;
	}
	
	/**
	 * @return ime korisnika & sadrzaj poruke
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
	
	
}
