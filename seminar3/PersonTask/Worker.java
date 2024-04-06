package S3.PersonTask;

public class Worker implements Person {
    @Override
    public void haveRest() {
        System.out.println("I always work");
    }
}
