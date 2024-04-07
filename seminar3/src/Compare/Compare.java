package S3.Compare;

public class Compare {

    public static void main(String[] args) {

        Integer[] a = {1, 2, 3};
        Integer[] b = {1, 2, 4};
        System.out.println(compareArrays(a, b));

        Double[] c = {1.0, 2.0, 3.0};
        Double[] d = {1.0, 2.0, 3.0};
        System.out.println(compareArrays(c, d));


    }

    static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }
}
