package seminar05.ru.gb.philosophers;

public class DinningRoom {
    private Philosopher lastClient;

    /**
     * Прием пищи. Контролируется, что перед этим приемом был другой философ.
     * Прием пищи длится 500 миллисекунд. В это время никто другой не может начать прием пищи.
     * @param client
     * @return
     */
    public synchronized boolean startDinner(Philosopher client) {
        if (lastClient == client)
            // Нельзя пользоваться столовой 2 раза подряд
            return false;
        System.out.println(client + " start dinner");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(client + " stop dinner");
        lastClient = client;
        return true;
    }

}
