package ru.gb.core;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Random;

@RequiredArgsConstructor
@Setter
public class MontyHill {
    @NonNull
    private Integer countDoors;
    @NonNull
    private Integer countTests;
    private final HashMap<Integer, Boolean> testResults = new HashMap<>();

    public void startTest() {
        Random random = new Random();
        int answer;

        for (int i = 0; i < countTests; i++) {
            boolean[] doors = new boolean[countDoors];
            // Случайно определяем выигрышную дверь
            doors[random.nextInt(countDoors)] = true;
            // Выбор двери игроком
            answer = random.nextInt(countDoors);
            // Если игрок выбрал выигрышную дверь, то значит после смены двери он проиграет.
            // Аналогично, если выбрал проигрышную дверь, то после смены двери он точно выиграет.
            testResults.put(i+1, !doors[answer]);
        }

    }

    public void getStatistic() {
        int countOfWin = 0;
        for (Integer key : testResults.keySet()) {
            countOfWin += testResults.get(key) ? 1 : 0;
        }
        System.out.println("Стратегия: изменять ранее принятое решение, когда остается 2 не открытых двери.");
        System.out.println("Количество дверей: " + countDoors);
        System.out.println("Процент побед: " +  100 * countOfWin / testResults.size() + "%");
    }

}
