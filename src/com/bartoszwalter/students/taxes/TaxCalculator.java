package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.umowa.Umowa;
import com.bartoszwalter.students.taxes.umowa.UmowaOPrace;
import com.bartoszwalter.students.taxes.umowa.UmowaZlecenie;

public class TaxCalculator {
	
	public static double podstawa = 0;
	public static RodzajUmowy rodzajUmowy;

	public  static void main(String[] args) {
		Umowa umowa = null;
		try {
			Interfejs interfejs = new Interfejs();
			podstawa = interfejs.odczytajKwoteDochodu();
			rodzajUmowy = interfejs.odczytajTypUmowy();
			
		} catch (Exception ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}
		
		if (rodzajUmowy == RodzajUmowy.PRACA) {
			umowa = new UmowaOPrace(podstawa);

		} else if (rodzajUmowy == RodzajUmowy.ZLECENIE) {
			umowa = new UmowaZlecenie(podstawa);
		}

		if(umowa != null) {
			Wydruk wydruk = new WydrukKonsoli(umowa);
			wydruk.wyswietl();
		}
	}


}
