public class MathFunctions {
    public static void AddToInt(int x, int amountToAdd) {
        x = x + amountToAdd;
        System.out.println(x);
    }
    public static void main(String[] args) {
        var a = 15;
        var b = 10;
        MathFunctions.AddToInt(a, b);
        System.out.println(a);
    }
}
