package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter tw;
	
	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	@Test
	public void testVratiSvePorukeOk() {
		LinkedList<TwitterPoruka> poruke;
		tw.unesi("Nikola", "Jel sve ok?");
		tw.unesi("Andrija", "Sve je ok!");
		poruke = tw.vratiSvePoruke();
		assertEquals(poruke.size(), tw.vratiSvePoruke().size());
		assertEquals(poruke.get(0).getKorisnik(), tw.vratiSvePoruke().get(0).getKorisnik());
		assertEquals(poruke.get(0).getPoruka(), tw.vratiSvePoruke().get(0).getPoruka());
		assertEquals(poruke.get(1).getKorisnik(), tw.vratiSvePoruke().get(1).getKorisnik());
		assertEquals(poruke.get(1).getPoruka(), tw.vratiSvePoruke().get(1).getPoruka());
	}

	@Test
	public void testUnesiOk() {
		tw.unesi("Nikola", "Jel sve ok?");
		
		assertEquals(1, tw.vratiSvePoruke().size());
		assertEquals("Nikola", tw.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Jel sve ok?", tw.vratiSvePoruke().get(0).getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		tw.vratiPoruke(5, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazan() {
		tw.vratiPoruke(5, "");
	}
	
	@Test
	public void testVratiPorukeOk() {
		tw.unesi("Milos", "poruka Danas je lep dan");
		tw.unesi("Dusan", "poruka Slazem se sa tobom");
		
		TwitterPoruka[] nizPoruka = tw.vratiPoruke(2, "poruka");
		TwitterPoruka[] noviNiz = new TwitterPoruka[2];
		TwitterPoruka p1 = new TwitterPoruka();
		p1.setKorisnik("Milos");
		p1.setPoruka("poruka Danas je lep dan");
		TwitterPoruka p2 = new TwitterPoruka();
		p2.setKorisnik("Dusan");
		p2.setPoruka("poruka Slazem se sa tobom");
		noviNiz[0] = p1;
		noviNiz[1] = p2;
		
		assertEquals(noviNiz[0].getKorisnik(), nizPoruka[0].getKorisnik());
		assertEquals(noviNiz[0].getPoruka(), nizPoruka[0].getPoruka());
		assertEquals(noviNiz[1].getKorisnik(), nizPoruka[1].getKorisnik());
		assertEquals(noviNiz[1].getPoruka(), nizPoruka[1].getPoruka());
		
		
	}

}
