package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

  public RodzajUmowy odczytajTypUmowy() throws IOException {
    System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
    Character type = br.readLine().charAt(0);

    switch(type) {
      case 'P': return RodzajUmowy.PRACA;
      case 'Z': return RodzajUmowy.ZLECENIE;
    }
  }
}
