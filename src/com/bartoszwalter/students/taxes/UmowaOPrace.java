package com.bartoszwalter.students.taxes;

/**
 * Created by dariusz on 19.05.2017.
 */
public class UmowaOPrace extends Umowa {

  public UmowaOPrace(double podstawa) {
    super(podstawa);
  }

  @Override
  public void obliczKosztUzyskaniaPrzychodu() {
    this.kosztyUzyskania = Parametry.STALE_KOSZTY_UZYSKANIA_PRZYCHODU;

    this.podstawaOpodatkowania = podstawaWymiaruSkladkiNaUbezpieczenie - this.kosztyUzyskania;
    this.podstawaOpodatkowaniaZaokraglona = (int) this.podstawaOpodatkowania;
  }
}
