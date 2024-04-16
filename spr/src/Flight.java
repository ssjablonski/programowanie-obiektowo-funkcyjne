import java.util.function.Predicate;

public class Flight {
    public static void main(String[] args) {
        System.out.println(test((i) ->{return i == 5;}));
    }

    private static boolean test(Predicate<Integer> p) {
        return p.test(5);
    }
}
