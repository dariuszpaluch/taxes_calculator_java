package com.bartoszwalter.students.taxes;

/**
 * Created by dariusz on 19.05.2017.
 */
public class UmowaZlecenie extends Umowa {

  public UmowaZlecenie(double podstawa) {
    super(podstawa);
  }

  @Override
  public void obliczKosztUzyskaniaPrzychodu() {
    this.kosztyUzyskania = podstawaWymiaruSkladkiNaUbezpieczenie * Parametry.PROCENT_KOSZTY_UZYSKANIA_PRZYCHODU;

    this.podstawaOpodatkowania = podstawaWymiaruSkladkiNaUbezpieczenie - this.kosztyUzyskania;
    this.podstawaOpodatkowaniaZaokraglona = (int) this.podstawaOpodatkowania;
  }
}
