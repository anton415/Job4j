package ru.aserdyuchenko.testQuestions;

import java.time.LocalTime;

class Momento {
/**
 * @param countVisitors - Число людей пришедших в данную минуту.
 */
  int countVisitors;
/**
 * @param time - Время, когда работал банк.
 * Например: 08:15.
 */
  LocalTime time;
  Momento(){
  }
  public void setTime(LocalTime time) {
    this.time = time;
  }
  public LocalTime getTime() {
    return this.time;
  }
  public void setCountVisitors(int count) {
    this.countVisitors += count;
  }
  public int getCountVisitors() {
    return this.countVisitors;
  }
}
