package seminar05.ru.gb.philosophers;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        DinningRoom dinningRoom = new DinningRoom();
        List<Philosopher> philosopherList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            philosopherList.add(new Philosopher(dinningRoom));
        }

        philosopherList.forEach(Philosopher::start);
    }
}
