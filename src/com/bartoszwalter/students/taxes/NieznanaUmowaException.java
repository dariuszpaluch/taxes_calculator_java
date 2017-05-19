package com.bartoszwalter.students.taxes;

/**
 * Created by dariusz on 19.05.2017.
 */
public class NieznanaUmowaException extends Exception {
  public NieznanaUmowaException() {
    super("Nieznany typ umowy");
    System.out.println("Nieznany typ umowy!");
  }
}
