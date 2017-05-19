package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.umowa.Umowa;
import com.bartoszwalter.students.taxes.umowa.UmowaOPrace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by dariusz on 18.05.2017.
 */
public class WydrukKonsoli extends Wydruk {
  InputStreamReader isr;
  BufferedReader br;

  public WydrukKonsoli(Umowa umowa) {
    super(umowa);
  }


  public void wyswietl() {
    DecimalFormat df00 = new DecimalFormat("#.00");
    DecimalFormat df = new DecimalFormat("#");

    System.out.println("UMOWA O PRACĘ");
    System.out.println("Podstawa wymiaru składek: " + this.umowa.getPodstawa());
    System.out.println("Składka na ubezpieczenie emerytalne: " + df00.format(this.umowa.getS_emerytalna()));
    System.out.println("Składka na ubezpieczenie rentowe   : " + df00.format(this.umowa.getS_rentowa()));
    System.out.println("Składka na ubezpieczenie chorobowe : " + df00.format(this.umowa.getU_chorobowe()));
    System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + this.umowa.getPodstawaWymiaruSkladkiNaUbezpieczenie());
    System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + df00.format(this.umowa.getS_zdrow1()) + " 7,75% = " + df00.format(this.umowa.getS_zdrow2()));
    System.out.println("Koszty uzyskania przychodu:  " + this.umowa.getKosztyUzyskania());
    System.out.println("Podstawa opodatkowania " + this.umowa.getPodstawaOpodatkowania() + " zaokrąglona " + df.format((int)this.umowa.getPodstawaOpodatkowaniaZaokraglona()));
    System.out.println("Zaliczka na podatek dochodowy 18 % = " + this.umowa.getZaliczkaNaPod());

    if(this.umowa instanceof UmowaOPrace) {
      			System.out.println("Kwota wolna od podatku = " + this.umowa.getKwotaWolnaodPodatku());

    }

    System.out.println("Podatek potrącony = " + df00.format(this.umowa.getPodatekPotrącony()));
    System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(this.umowa.getZaliczkaUS()) + " po zaokrągleniu = " + df.format(this.umowa.getZaliczkaUSZaokraglona()));
    System.out.println();
    System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = " + df00.format(this.umowa.getWynagrodzenie()));
  }
}
