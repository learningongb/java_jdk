package ru.gb;

import ru.gb.core.MontyHill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

    public static void main(String[] args) {

        MontyHill montyHill = new MontyHill(3, 1000);
        montyHill.startTest();
        montyHill.getStatistic();
        System.out.println("****************************");

        montyHill.setCountDoors(5);
        montyHill.startTest();
        montyHill.getStatistic();
        System.out.println("****************************");

        montyHill.setCountDoors(10);
        montyHill.startTest();
        montyHill.getStatistic();
    }
}
