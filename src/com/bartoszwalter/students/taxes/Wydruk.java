/**
 * Created by dpaluch on 19.05.2017.
 */
package com.bartoszwalter.students.taxes;

import com.bartoszwalter.students.taxes.umowa.Umowa;

import java.text.DecimalFormat;

public abstract class Wydruk {
    protected Umowa umowa;

    protected DecimalFormat dfSetne = new DecimalFormat("#.00");
    protected DecimalFormat dfCalkowite = new DecimalFormat("#");

    public Wydruk(Umowa umowa) {
        this.umowa = umowa;
    }

    public abstract void wyswietl();
}