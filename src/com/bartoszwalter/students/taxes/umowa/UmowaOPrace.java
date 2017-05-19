package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.Parametry;
import com.bartoszwalter.students.taxes.umowa.Umowa;

import java.text.DecimalFormat;

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
    DecimalFormat df = new DecimalFormat("#");
    this.podstawaOpodatkowaniaZaokraglona = (int)Double.parseDouble(df.format(this.podstawaOpodatkowania));
  }

  @Override
  public void obliczKwoteWolnaOdPodatku() {
    this.kwotaWolnaodPodatku = Parametry.KWOTA_ZMNIEJSZAJACA_PODATEK;
  }
}
