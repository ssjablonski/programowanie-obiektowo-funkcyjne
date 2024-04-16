import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Walec walec = new Walec();

    private static void displayMenu() {
        System.out.println("Wybierz opcje:");
        System.out.println("1. Ustawienie wartości wysokosci walca");
        System.out.println("2. Ustawienie wartości promienia walca");
        System.out.println("3. Wyświetlenie wartości parametrów walca");
        System.out.println("4. Obliczenie i wyświetlenie pól powierzchni walca");
        System.out.println("5. Obliczenie i wyświetlenie objętości walca");
        System.out.println("6. Wyjście z programu");
        System.out.println("Co chciałbyś zrobić? (Wybierz jedną z opcji.)");
    }

    private static void ustawPromien() {
        System.out.println("Podaj promień walca:");
        double promien = scanner.nextDouble();
        scanner.nextLine();
        walec.ustawPromien(promien);
    }

    private static void ustawWysokosc() {
        System.out.println("Podaj wysokość walca:");
        double wysokosc = scanner.nextDouble();
        scanner.nextLine();
        walec.ustawWysokosc(wysokosc);
    }

    private static void obliczPowierzchnie() {
        double pp = walec.obliczPolePodstawy();
        double pb = walec.obliczPoleBocznej();
        double pc = walec.obliczPoleCalkowitej();
        System.out.println("Pole podstawy wynosi: " + pp);
        System.out.println("Pole powierzchni bocznej wynosi: " + pb);
        System.out.println("Pole powierzchni całkowitej wynosi: " + pc);
    }

    private static void wyswietlParametry() {
        System.out.println("Wysokość wynosi: " + walec.zwrocWysokosc());
        System.out.println("Promien wynosi: " + walec.zwrocPromien());
    }

    private static void obliczObjetosc() {
        double objetosc = walec.obliczObjetosc();
        System.out.println("Objętość walca wynosi: " + objetosc);
    }

    public static void main(String[] args) {
        System.out.println("Program ten służy do liczenie powierzchni oraz objętości walca");
        boolean working = true;
        while (working) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> ustawWysokosc();
                case "2" -> ustawPromien();
                case "3" -> wyswietlParametry();
                case "4" -> obliczPowierzchnie();
                case "5" -> obliczObjetosc();
                case "6" -> {
                    System.out.println("Dowidzenia");
                    working = false;
                }
                default -> System.out.println("Zły parametr!");
            }
        }
    }

}