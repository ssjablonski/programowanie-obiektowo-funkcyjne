import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GradeList oceny = new GradeList();

    private static void displayMenu() {
        System.out.println("Wybierz opcje:");
        System.out.println("1. Dodaj nową ocene");
        System.out.println("2. Oblicz średnią ocen");
        System.out.println("3. Wyświetl najniższą ocene");
        System.out.println("4. Wyświetl najwyższą ocene");
        System.out.println("5. Wyjść z programu");
        System.out.println("Co chciałbyś zrobić? (Wybierz jedną z opcji.)");
    }

    private static void dodajOcene() {
        System.out.println("Podaj ocene którą chcesz dodać:");
        Double ocena = scanner.nextDouble();
        if (ocena < 0) {
            System.out.println("Nie można dodać oceny niższej niż 0");
            return;
        }
        scanner.nextLine();
        oceny.dodajOcene(ocena);
    }

    private static void znajdzNajwyzszaOcene() {
        double ocena = oceny.zwrocNajwyzszaOcene();
        if (ocena == -1) {
            System.out.println("Nie ma żadnych ocen!");
            return;
        }
        System.out.println("Najwyższa ocena to: " + ocena);
    }

    private static void znajdzNajnizszaOcene() {
        double ocena = oceny.zwrocNajnizszaOcene();
        if (ocena == -1) {
            System.out.println("Nie ma żadnych ocen!");
            return;
        }
        System.out.println("Najniższa ocena to: " + ocena);
    }

    private static void wywietlSrednia() {
        double srednia = oceny.obliczSrednia();
        if (srednia == -1) {
            System.out.println("Nie ma żadnych ocen!");
            return;
        }
        System.out.println("Średnia twoich ocen to: " + srednia);
    }

    public static void main(String[] args) {
        System.out.println("Program ten służy do przechowywania ocen studenta");
        boolean working = true;
        while (working) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> dodajOcene();
                case "2" -> wywietlSrednia();
                case "3" -> znajdzNajnizszaOcene();
                case "4" -> znajdzNajwyzszaOcene();
                case "5" -> {
                    System.out.println("Do widzenia");
                    working = false;
                }
                default -> System.out.println("Zły parametr!");
            }
        }
    }
}