package ru.aserdyuchenko.testQuestions;

import java.time.LocalTime;

public class Person {
/**
 * @param timeVisite - Время когда человек пришел в банк.
 */
  public LocalTime timeVisite;

  Person(){
  }
  Person(LocalTime time) {
    this.timeVisite = time;
  }
  public void setTimeVisit(LocalTime time) {
    this.timeVisite = time;
  }
  public LocalTime getTimeVisit() {
    return this.timeVisite;
  }
}
