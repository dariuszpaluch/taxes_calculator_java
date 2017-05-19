package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.Parametry;
import com.bartoszwalter.students.taxes.umowa.Umowa;

import java.text.DecimalFormat;

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

    DecimalFormat df = new DecimalFormat("#");
    this.podstawaOpodatkowaniaZaokraglona = (int)Double.parseDouble(df.format(this.podstawaOpodatkowania));
  }

  @Override
  public void obliczKwoteWolnaOdPodatku() {
    this.kwotaWolnaodPodatku = 0;
  }
}
