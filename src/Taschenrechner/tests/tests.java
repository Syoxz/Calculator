package Taschenrechner.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Taschenrechner.Controller;
import Taschenrechner.View;

public class tests {
	Controller c = new Controller();
	View b = c.getView();
	@Test
	//Test ob zwei Operatoren nacheinander nicht funktionieren + Ergebnis der Rechnung + Eingabe nach Rechnung	
	public void opUndEingNachErgTest() {
		b.getZahlenButton(3).doClick();
		b.getPlus().doClick();
		b.getMal().doClick();
		b.getZahlenButton(5).doClick();
		b.getMinus().doClick();
		String doppeltOP = b.getDisplayField().getText();
		b.getEquals().doClick();
		String ergebnis = b.getDisplayField().getText();
		b.getZahlenButton(9).doClick();;
		String wertNachErgUndEingabe = b.getDisplayField().getText();
		assertEquals("3+5", doppeltOP);
		assertEquals("8.0", ergebnis);
		assertEquals("9", wertNachErgUndEingabe);
	}
	@Test
	//Mehrere Punkte hintereinander nicht moeglich; Mehr als einen Punkt in einem Wert nicht moeglich;
	//Operator nach Rechnung bezieht sich direkt auf die Rechnung;
	//C Button cleared Feld	
	public void punktOhneWertTestUndOPNachErgUndClear() {
		b.getPunkt().doClick();
		b.getZahlenButton(1).doClick();
		b.getPlus().doClick();
		b.getMinus().doClick();
		b.getPunkt().doClick();
		b.getPunkt().doClick();
		b.getZahlenButton(5).doClick();
		b.getPunkt().doClick();
		String punkt = b.getDisplayField().getText();
		
		b.getEquals().doClick();
		String erg = b.getDisplayField().getText();
		
		b.getMal().doClick();
		b.getZahlenButton(2).doClick();
		String malNachErg = b.getDisplayField().getText(); 
		
		b.getZahlenButton(0).doClick();
		String cleared = b.getDisplayField().getText();
		
		assertEquals("", cleared);
		assertEquals ("0.1+-0.5", punkt);
		assertEquals ("-0.4", erg);
		assertEquals ("-0.4*2", malNachErg);
		}
}
