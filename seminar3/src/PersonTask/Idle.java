package S3.PersonTask;

public class Idle implements Person {
    @Override
    public void doWork() {
        System.out.println("I can't work");
    }
}
