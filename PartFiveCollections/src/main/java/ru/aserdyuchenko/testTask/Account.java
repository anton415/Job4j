package ru.aserdyuchenko.testTask;

/**
 * Created by anton on 05.05.17.
 */
public class Account {
    /**
     * @param value - кол-во денег.
     */
    private double value;
    /**
     * @param requisites - реквизиты счёта.
     */
    private int requisites;

    /**
     * Account - это банковский счёт.
     */
    public Account(double accountValue, int accountRequisites) {
        this.value = accountValue;
        this.requisites = accountRequisites;
    }

    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", requisites=" + requisites +
                '}';
    }

    public double getValue() {
        return value;
    }

    public int getRequisites() {
        return requisites;
    }
}
