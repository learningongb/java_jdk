package S3.PersonTask;

import java.util.NoSuchElementException;

public class Club<T extends Person> {
    T[] arrayT;
    int current = 0;

    public Club(T[] arrayT) {
        this.arrayT = arrayT;
    }

    public void start() {
        while (hasNext()) {
            next().haveRest();
        }
    }

    public boolean hasNext() {
        return  (current < arrayT.length);
    }

    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return arrayT[current++];
    }
}
