package ru.aserdyuchenko.testQuestions;

import java.time.LocalTime;
import java.util.Random;
/**
 * В течении дня в банк заходят люди, у каждого человека есть время захода в банк и время выхода.
 * Всего за день у банка было N посетителей. Банк работает с 8:00 до 20:00.
 * Человек посещает банк только один раз за день.
 * Написать программу, которая определяет периоды времени,
 * когда в банке было максимальное количество посетителей.
 */
public class Tracker {
  Random random = new Random();
/**
 * @param arrayPerson - Количество человек посетивших банк.
 * В данном случае, банк посетило 1000 человек.
 */
  Person[] arrayPerson = new Person[1000];
/**
 * @param arrayMomento - время которое работал банк.
 * Время отображается как 08:00. Т.е. 8 часов, 0 минут.
 */
  Momento[] arrayMomento = new Momento[720];
  int positionForPerson = 0;
  int positionForMomento = 0;
/**
 * Метод для создания человека, который посетил банк.
 * Каждый человек имеет параметр время (когда он пришел).
 */
  public Person createNewPerson(Person person) {
    person.setTimeVisit(LocalTime.of(random.nextInt(12) + 8, random.nextInt(60)));
    this.arrayPerson[positionForPerson++] = person;
    return person;
  }
/**
 * Метод создает новый момент времени, когда работал банк
 * и соответственно в этот момент мог прейти человек.
 * Всего таких моментов 720. Количество минут от 8:00 до 20:00.
 */
  public Momento createNewMomento(Momento momento, LocalTime time) {
    momento.setTime(time);
    this.arrayMomento[positionForMomento++] = momento;
    return momento;
  }
/**
 * Метод выводит на экран всех посетителей банка и время когда они пришли.
 */
  public void showAllPerson() {
    int index = 1;
    for (Person person: arrayPerson) {
      System.out.println("Person №" + index + " visit in: " + person.getTimeVisit());
      index++;
    }
  }
/**
 * Метод заполняет массив людей, которые пришли в банк.
 * Всего 1000 человек, посетило банк.
 */
  public void createAllPerson() {
    for (Person person : arrayPerson) {
      createNewPerson(new Person());
    }
  }
/**
 * Метод заполняет массив времени. 720 эллементов.
 */
  public void createAllMomento() {

    LocalTime time;
    for (int index = 0; index < arrayMomento.length; ) {
      for (int hour = 8; hour < 20; hour++) {
        for (int minute = 0; minute < 60 ; minute++) {
          time = LocalTime.of(hour, minute);
          createNewMomento(new Momento(), time);
          index++;
        }
      }
    }
  }
/**
 * Метод для регистрации человека и момента времени.
 * Берется значение из массива времени и сравнивается со временем прибытия человека в банк.
 * Если они совподают, то в данном моменте времени, увеличивается количество посетителей.
 */
  public void registrateVisit() {
    for (Momento momento : arrayMomento) {
      for (Person person : arrayPerson) {
        if(momento.getTime().equals(person.getTimeVisit())) {
          momento.setCountVisitors(1);
        }
      }
    }
  }
/**
 * Метод для вывода всех минут работы банка.
 * И количества человек посетивших данный банк в эту минуту.
 */
  public void showAllCountVisitorInMomento() {
    for (Momento momento : arrayMomento) {
      System.out.println("В " + momento.getTime() + " было " + momento.getCountVisitors() + " посетителей.");
    }
  }
/**
 * Метод для поиска наибольшего количества посещений в ту или иную минуту.
 * Если было одиноковое максимально количество посещений в несколько моментов времени.
 * То на экран выводится самый ранний момент.
 */
  public void findMaxCountVisitInMomento() {
    Momento maxCountVisitorInMomento = new Momento();
    int maxCount = 0;
    for (Momento momento : arrayMomento) {
      if (momento.getCountVisitors() > maxCount) {
        maxCountVisitorInMomento = momento;
        maxCount = momento.getCountVisitors();
      }
    }
    System.out.println("В " + maxCountVisitorInMomento.getTime() + " было больше всего посетителей (" + maxCountVisitorInMomento.getCountVisitors() + ").");
  }
/**
 * Я не успел придумать, как написать тест для данной программы.
 * Поэтому я всё протестировал с помощью метода main.
 * Воспользовавшись методами:
 * showAllPerson()
 * showAllCountVisitorInMomento()
 * можно вывести на экран массивы посетителей и моментов времени.
 */
  public static void main(String[] args) {
    Tracker tracker = new Tracker();
    tracker.createAllPerson();
    tracker.createAllMomento();
    tracker.registrateVisit();
    tracker.findMaxCountVisitInMomento();
  }
}
