package seminar05.ru.gb.philosophers;

public class Philosopher implements Runnable {
    static private int count = 0;

    final private int id;
    private int eatingCount = 0;
    final private Thread thread;
    final private DinningRoom dinningRoom;

    public Philosopher(DinningRoom dinningRoom) {
        this.id = ++count;
        this.thread = new Thread(this);
        this.dinningRoom = dinningRoom;
    }

    @Override
    public void run() {
        startCycle();
    }

    /**
     * Запускает выполнение потока.
     */
    public void start() {
        this.thread.start();
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    /**
     * Имитация приема пищи
     */
    public void eat() {
        if (this.dinningRoom.startDinner(this))
        {
            this.eatingCount++;
        }


    }

    /**
     * Имитация отдыха
     */
    public void rest() {
        System.out.println(this + " resting");
    }

    /**
     * Запускает цикл из приемов пищи и отдыха. Цикл прекращается после 3-го приема пищи.
     */
    public void startCycle() {
        while (eatingCount < 3)
        {
            eat();
            rest();
        }
        System.out.println(this + " is finished");
    }
}
