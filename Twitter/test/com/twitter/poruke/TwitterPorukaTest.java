package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tp;
	
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnikSveOk() {
		String korisnik = "Pera";
		
		tp.setKorisnik(korisnik);
		
		assertEquals(korisnik, tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan() {
		String korisnik = "";
		
		tp.setKorisnik(korisnik);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		String korisnik = null;
		
		tp.setKorisnik(korisnik);
	}

	@Test
	public void testSetPorukaSveOk() {
		String poruka = "Zdravo Marija, kako si?";
		
		tp.setPoruka(poruka);
		
		assertEquals(poruka, tp.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		String poruka = null;
		
		tp.setPoruka(poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzaOd140() {
		String poruka = "Boze pravde, ti sto spase "
				+ "od propasti dosad nas, "
				+ "cuj i odsad nase glase"
				+ "i od sad nam budi spas"
				+ "Mocnom rukom vodi, brani"
				+ "buducnosti srpski brod,"
				+ "Boze spasi, Boze hrani"
				+ "srpske zemlje, srpski rod!"
				+ ""
				+ "Slozi srpsku bracu dragu"
				+ "na svak dican slavan rad"
				+ "sloga bice poraz vragu"
				+ "a najjaci srpstvu grad."
				+ ""
				+ "Nek na srpskoj blista grani"
				+ "bratske sloge znatan plod"
				+ "Boze spasi, Boze hrani"
				+ "srpske zemlje, srpski rod!";
		
		tp.setPoruka(poruka);
	}

	@Test
	public void testToStringSveOk() {
		String korisnik = "Andrija";
		String poruka = "Cao, sta radis?";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		String s = "KORISNIK:"+korisnik+" PORUKA:"+poruka;
		
		assertEquals(s, tp.toString());
	}

}
