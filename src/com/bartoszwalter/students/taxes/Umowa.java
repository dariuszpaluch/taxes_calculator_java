package com.bartoszwalter.students.taxes;

/**
 * Created by dariusz on 18.05.2017.
 */

public abstract class  Umowa {
  protected double podstawa = 0;

  // składki na ubezpieczenia społeczne
  protected double s_emerytalna = 0; // 9,76% podstawyy
  protected double s_rentowa = 0; // 1,5% podstawy
  protected double u_chorobowe = 0; // 2,45% podstawy
  protected double podstawaWymiaruSkladkiNaUbezpieczenie = 0;
  // składki na ubezpieczenia zdrowotne

  protected double s_zdrow1 = 0; // od podstawy wymiaru 9%
  protected double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %

  protected double kosztyUzyskania = 0;
  public static double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
  public static double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
  public static double zaliczkaUS = 0;
  public static double zaliczkaUS0 = 0;

  protected double podstawaOpodatkowania = 0;
  protected int podstawaOpodatkowaniaZaokraglona = 0;

  public Umowa(double podstawa) {
    this.podstawa = podstawa;

    this.obliczonaPodstawa();
    this.obliczUbezpieczenie();
    this.obliczKosztUzyskaniaPrzychodu();
  }

  public double obliczonaPodstawa() {
    s_emerytalna = this.podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_EMERYTALNEGO;
    s_rentowa = this.podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_RENTOWEGO;
    u_chorobowe = this.podstawa * Parametry.PROCENT_SKLADKI_UBEZPIECZENIA_CHOROBOWEGO;
    this.podstawaWymiaruSkladkiNaUbezpieczenie = this.podstawa - s_emerytalna - s_rentowa - u_chorobowe;

    return this.podstawaWymiaruSkladkiNaUbezpieczenie;
  }

  public void obliczUbezpieczenie() {
    s_zdrow1 = this.podstawaWymiaruSkladkiNaUbezpieczenie * Parametry.PROCENT_SKLADKI_ZDROWOTNEJ;
    s_zdrow2 = this.podstawaWymiaruSkladkiNaUbezpieczenie * Parametry.PROCENT_ODLICZENIA_SKLADKI_ZDROWOTNEJ;
  }

  public abstract void obliczKosztUzyskaniaPrzychodu();


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
}
