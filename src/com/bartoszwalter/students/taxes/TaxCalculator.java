package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public class TaxCalculator {
	
	public static double podstawa = 0;
	public static RodzajUmowy rodzajUmowy;

	// składki na ubezpieczenia społeczne
	public static double s_emerytalna = 0; // 9,76% podstawyy
	public static double s_rentowa = 0; // 1,5% podstawy
	public static double u_chorobowe = 0; // 2,45% podstawy
	// składki na ubezpieczenia zdrowotne

	public static double kosztyUzyskania = 0;
	public static double s_zdrow1 = 0; // od podstawy wymiaru 9%
	public static double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %
	public static double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
	public static double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
	public static double zaliczkaUS = 0;
	public static double zaliczkaUS0 = 0;

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
		
		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");
		
		if (rodzajUmowy == RodzajUmowy.PRACA) {
			umowa = new UmowaOPrace(podstawa);


//			System.out.println("UMOWA O PRACĘ");
//			System.out.println("Podstawa wymiaru składek " + podstawa);
//			double oPodstawa = obliczonaPodstawa(podstawa);
//			System.out.println("Składka na ubezpieczenie emerytalne "
//					+ df00.format(s_emerytalna));
//			System.out.println("Składka na ubezpieczenie rentowe    "
//					+ df00.format(s_rentowa));
//			System.out.println("Składka na ubezpieczenie chorobowe  "
//					+ df00.format(u_chorobowe));
//			System.out
//					.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
//							+ oPodstawa);
//


//			obliczUbezpieczenia(oPodstawa);
//			System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
//					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
//

//			System.out.println("Koszty uzyskania przychodu w stałej wysokości "
//					+ Parametry.STALE_KOSZTY_UZYSKANIA_PRZYCHODU);
//
//			double podstawaOpodat = oPodstawa - Parametry.STALE_KOSZTY_UZYSKANIA_PRZYCHODU;
//			double podstawaOpodat0 = Double
//					.parseDouble(df.format(podstawaOpodat));
//			System.out.println("Podstawa opodatkowania " + podstawaOpodat
//					+ " zaokrąglona " + df.format(podstawaOpodat0));


//			obliczPodatek(podstawaOpodat0);
//			System.out.println("Zaliczka na podatek dochodowy 18 % = "
//					+ zaliczkaNaPod);
//			System.out.println("Kwota wolna od podatku = " + kwotaZmiejsz);
//			double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
//			System.out.println("Podatek potrącony = "
//					+ df00.format(podatekPotracony));
//			obliczZaliczke();
//			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
//			System.out.println("Zaliczka do urzędu skarbowego = "
//					+ df00.format(zaliczkaUS) + " po zaokrągleniu = "
//					+ df.format(zaliczkaUS0));
//			double wynagrodzenie = podstawa
//					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
//			System.out.println();
//			System.out
//					.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
//							+ df00.format(wynagrodzenie));



		} else if (rodzajUmowy == RodzajUmowy.ZLECENIE) {
			umowa = new UmowaZlecenie(podstawa);


//			System.out.println("UMOWA-ZLECENIE");
//			System.out.println("Podstawa wymiaru składek " + podstawa);
//			double oPodstawa = obliczonaPodstawa(podstawa);
//			System.out.println("Składka na ubezpieczenie emerytalne "
//					+ df00.format(s_emerytalna));
//			System.out.println("Składka na ubezpieczenie rentowe    "
//					+ df00.format(s_rentowa));
//			System.out.println("Składka na ubezpieczenie chorobowe  "
//					+ df00.format(u_chorobowe));
//			System.out
//					.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
//							+ oPodstawa);
//			obliczUbezpieczenia(oPodstawa);
//			System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
//					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
//			kwotaZmiejsz = 0;
//			kosztyUzyskania = oPodstawa * Parametry.PROCENT_KOSZTY_UZYSKANIA_PRZYCHODU;
//			System.out.println("Koszty uzyskania przychodu (stałe) "
//					+ kosztyUzyskania);
//			double podstawaOpodat = oPodstawa - kosztyUzyskania;
//			double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
//			System.out.println("Podstawa opodatkowania " + podstawaOpodat
//					+ " zaokrąglona " + df.format(podstawaOpodat0));
//




//
//			obliczPodatek(podstawaOpodat0);
//			System.out.println("Zaliczka na podatek dochodowy 18 % = "
//					+ zaliczkaNaPod);
//			double podatekPotracony = zaliczkaNaPod;
//			System.out.println("Podatek potrącony = "
//					+ df00.format(podatekPotracony));
//			obliczZaliczke();
//			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
//			System.out.println("Zaliczka do urzędu skarbowego = "
//					+ df00.format(zaliczkaUS) + " po zaokrągleniu = "
//					+ df.format(zaliczkaUS0));
//			double wynagrodzenie = podstawa
//					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
//			System.out.println();
//			System.out
//					.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
//							+ df00.format(wynagrodzenie));
//



		}

		if(umowa != null) {
			Interfejs.wyswietlWynik(umowa);
		}
	}

	public static void obliczZaliczke() {
		zaliczkaUS = zaliczkaNaPod - s_zdrow2 - kwotaZmiejsz;
	}

	public static void obliczPodatek(double podstawa) {
		zaliczkaNaPod = podstawa * Parametry.PROCENT_ZALICZKI_NA_PODATEK;
	}

	public static double obliczonaPodstawa(double podstawa) {
		s_emerytalna = podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_EMERYTALNEGO;
		s_rentowa = podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_RENTOWEGO;
		u_chorobowe = podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_CHOROBOWEGO;
		return (podstawa - s_emerytalna - s_rentowa - u_chorobowe);
	}

	public static void obliczUbezpieczenia(double podstawa) {
		s_zdrow1 = podstawa * Parametry.PROCENT_SKLADKI_ZDROWOTNEJ;
		s_zdrow2 = podstawa * Parametry.PROCENT_ODLICZENIA_SKLADKI_ZDROWOTNEJ;
	}
}
