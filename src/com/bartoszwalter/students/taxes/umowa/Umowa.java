package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.Parametry;

/**
 * Created by dariusz on 18.05.2017.
 */

public abstract class  Umowa {
  private double podstawa = 0;

  // składki na ubezpieczenia społeczne
  private double s_emerytalna = 0; // 9,76% podstawyy
  private double s_rentowa = 0; // 1,5% podstawy
  private double u_chorobowe = 0; // 2,45% podstawy
  double podstawaWymiaruSkladkiNaUbezpieczenie = 0;
  // składki na ubezpieczenia zdrowotne

  private double s_zdrow1 = 0; // od podstawy wymiaru 9%
  private double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %

  double kosztyUzyskania = 0;
  private double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
  private double zaliczkaUS = 0;
  private double zaliczkaUSZaokraglona = 0;
  private double podatekPotrącony = 0;

  double kwotaWolnaodPodatku = 0;

  double podstawaOpodatkowania = 0;
  int podstawaOpodatkowaniaZaokraglona = 0;
  private double wynagrodzenie = 0;

  Umowa(double podstawa) {
    this.podstawa = podstawa;

    this.obliczonaPodstawa();
    this.obliczUbezpieczenie();
    this.obliczKosztUzyskaniaPrzychodu();
    this.obliczPodatek();
    this.obliczKwoteWolnaOdPodatku();
    this.obliczPodatekPotrącony();
    this.obliczZaliczke();
    this.obliczWynagrodzenie();
  }

  private double obliczonaPodstawa() {
    s_emerytalna = this.podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_EMERYTALNEGO;
    s_rentowa = this.podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_RENTOWEGO;
    u_chorobowe = this.podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_CHOROBOWEGO;
    this.podstawaWymiaruSkladkiNaUbezpieczenie = this.podstawa - s_emerytalna - s_rentowa - u_chorobowe;

    return this.podstawaWymiaruSkladkiNaUbezpieczenie;
  }

  private void obliczUbezpieczenie() {
    s_zdrow1 = this.podstawaWymiaruSkladkiNaUbezpieczenie * Parametry.PROCENT_SKLADKI_ZDROWOTNEJ;
    s_zdrow2 = this.podstawaWymiaruSkladkiNaUbezpieczenie * Parametry.PROCENT_ODLICZENIA_SKLADKI_ZDROWOTNEJ;
  }

  public abstract void obliczKosztUzyskaniaPrzychodu();

  private void obliczPodatek() {
    zaliczkaNaPod = this.podstawaOpodatkowaniaZaokraglona * Parametry.PROCENT_ZALICZKI_NA_PODATEK;
  }

  public abstract void obliczKwoteWolnaOdPodatku();

  private void obliczPodatekPotrącony() {
    this.podatekPotrącony = zaliczkaNaPod - this.kwotaWolnaodPodatku;
  }

  private void obliczZaliczke() {
    this.zaliczkaUS = this.zaliczkaNaPod - this.s_zdrow2 - this.kwotaWolnaodPodatku;
    this.zaliczkaUSZaokraglona = (int) this.zaliczkaUS;
  }

  private void obliczWynagrodzenie() {
    this.wynagrodzenie = this.podstawa - ((this.s_emerytalna + this.s_rentowa + this.u_chorobowe) + s_zdrow1 + this.zaliczkaUSZaokraglona);
  }

  public double getPodstawa() {
    return podstawa;
  }

  public double getS_emerytalna() {
    return s_emerytalna;
  }

  public double getS_rentowa() {
    return s_rentowa;
  }

  public double getU_chorobowe() {
    return u_chorobowe;
  }

  public double getPodstawaWymiaruSkladkiNaUbezpieczenie() {
    return podstawaWymiaruSkladkiNaUbezpieczenie;
  }

  public double getS_zdrow1() {
    return s_zdrow1;
  }

  public double getS_zdrow2() {
    return s_zdrow2;
  }

  public double getKosztyUzyskania() {
    return kosztyUzyskania;
  }

  public double getPodstawaOpodatkowania() {
    return podstawaOpodatkowania;
  }

  public int getPodstawaOpodatkowaniaZaokraglona() {
    return podstawaOpodatkowaniaZaokraglona;
  }


  public double getZaliczkaNaPod() {
    return zaliczkaNaPod;
  }

  public double getKwotaWolnaodPodatku() {
    return kwotaWolnaodPodatku;
  }


  public double getPodatekPotrącony() {
    return podatekPotrącony;
  }

  public double getZaliczkaUS() {
    return zaliczkaUS;
  }

  public double getZaliczkaUSZaokraglona() {
    return zaliczkaUSZaokraglona;
  }

  public double getWynagrodzenie() {
    return wynagrodzenie;
  }
}
