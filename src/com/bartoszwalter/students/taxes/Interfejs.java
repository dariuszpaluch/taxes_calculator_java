package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by dariusz on 18.05.2017.
 */
public class Interfejs {
  InputStreamReader isr;
  BufferedReader br;

  public Interfejs() {
    isr = new InputStreamReader(System.in);
    br = new BufferedReader(isr);
  }

  public double odczytajKwoteDochodu() throws IOException {
    System.out.print("Podaj kwotę dochodu: ");
    return Double.parseDouble(this.br.readLine());
  }

  public RodzajUmowy odczytajTypUmowy() throws IOException, NieznanaUmowaException {
    System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
    Character type = br.readLine().charAt(0);

    switch(type) {
      case 'P': return RodzajUmowy.PRACA;
      case 'Z': return RodzajUmowy.ZLECENIE;
    }

    throw new NieznanaUmowaException();
  }

  public static void wyswietlWynik(Umowa umowa) {
    DecimalFormat df00 = new DecimalFormat("#.00");
    DecimalFormat df = new DecimalFormat("#");

    System.out.println("UMOWA O PRACĘ");
    System.out.println("Podstawa wymiaru składek: " + umowa.getPodstawa());
    System.out.println("Składka na ubezpieczenie emerytalne: " + df00.format(umowa.getS_emerytalna()));
    System.out.println("Składka na ubezpieczenie rentowe   : " + df00.format(umowa.getS_rentowa()));
    System.out.println("Składka na ubezpieczenie chorobowe : " + df00.format(umowa.getU_chorobowe()));
    System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + umowa.getPodstawaWymiaruSkladkiNaUbezpieczenie());
    System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + df00.format(umowa.getS_zdrow1()) + " 7,75% = " + df00.format(umowa.getS_zdrow2()));
    System.out.println("Koszty uzyskania przychodu:  " + umowa.getKosztyUzyskania());
    System.out.println("Podstawa opodatkowania " + umowa.getPodstawaOpodatkowania() + " zaokrąglona " + df.format((int)umowa.getPodstawaOpodatkowaniaZaokraglona()));
  }
}
