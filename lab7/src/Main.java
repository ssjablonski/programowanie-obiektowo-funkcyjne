import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ListaOfert listaOfert = new ListaOfert();

    private static void displayMenu() {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj ofertę sprzedaży domu");
        System.out.println("2. Dodaj ofertę sprzedaży mieszkania");
        System.out.println("3. Wyświetl wszystkie aktualne oferty sprzedaży domów");
        System.out.println("4. Wyświetl wszystkie aktualne oferty sprzedaży mieszkań");
        System.out.println("5. Wyświetl wszystkie aktualne oferty sprzedaży domów w podanej miejscowości o powierzchni nie mniejszej niż podana");
        System.out.println("6. Wyświetl wszystkie aktualne oferty sprzedaży mieszkań w podanej miejscowości, nie droższych niż podana wartość i od podanego piętra wzwyż");
        System.out.println("7. Wyjście");
    }

    public static String podajUliceDomu() {
        System.out.println("Podaj ulicę:");
        return scanner.nextLine();
    }

    public static int podajNumerDomu() {
        System.out.println("Podaj numer domu:");
        int numerDomu = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        return numerDomu;
    }

    public static String podajMiejscowosc() {
        System.out.println("Podaj miejscowość:");
        return scanner.nextLine();
    }

    public static String podajKodPocztowy() {
        System.out.println("Podaj kod pocztowy:");
        return scanner.nextLine();
    }

    public static double podajPowierzchnie() {
        System.out.println("Podaj powierzchnię:");
        double powierzchnia = scanner.nextDouble();
        scanner.nextLine(); // Clear newline
        return powierzchnia;
    }

    public static double podajCene() {
        System.out.println("Podaj cenę:");
        double cena = scanner.nextDouble();
        scanner.nextLine(); // Clear newline
        return cena;
    }

    public static LocalDate podajDate() {
        System.out.println("Podaj datę obowiązywania oferty (YYYY-MM-DD):");
        return LocalDate.parse(scanner.nextLine());
    }

    public static double podajPowierzchnieDzialki() {
        System.out.println("Podaj powierzchnię działki:");
        double powierzchniaDzialki = scanner.nextDouble();
        scanner.nextLine(); // Clear newline
        return powierzchniaDzialki;
    }

    public static int podajNumerMieszkania() {
        System.out.println("Podaj numer mieszkania:");
        int numerMieszkania = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        return numerMieszkania;
    }

    public static int podajNumerPietra() {
        System.out.println("Podaj numer piętra:");
        int numerPietra = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        return numerPietra;
    }

    public static void dodajOferteDomu() {
        String ulica = podajUliceDomu();
        int numerDomu = podajNumerDomu();
        String miejscowosc = podajMiejscowosc();
        String kodPocztowy = podajKodPocztowy();
        double powierzchnia = podajPowierzchnie();
        double cena = podajCene();
        LocalDate data = podajDate();
        double powierzchniaDzialki = podajPowierzchnieDzialki();
        Dom dom = new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, powierzchniaDzialki, data);
        listaOfert.dodajOferte(dom);
    }

    public static void dodajOferteMieszkania() {
        String ulica = podajUliceDomu();
        int numerDomu = podajNumerDomu();
        int numerMieszkania = podajNumerMieszkania();
        String miejscowosc = podajMiejscowosc();
        String kodPocztowy = podajKodPocztowy();
        double powierzchnia = podajPowierzchnie();
        int numerPietra = podajNumerPietra();
        double cena = podajCene();
        LocalDate data = podajDate();
        Mieszkanie mieszkanie = new Mieszkanie(ulica, numerDomu, numerMieszkania, miejscowosc, kodPocztowy, powierzchnia, numerPietra, cena, data);
        listaOfert.dodajOferte(mieszkanie);
    }

    public static void wyswietlOfertyDomow() {
        listaOfert.wyswietlOferty(oferta -> oferta instanceof Dom && !oferta.getDataObowiazywaniaOferty().isBefore(LocalDate.now()));
    }

    public static void wyswietlOfertyMieszkan() {
        listaOfert.wyswietlOferty(oferta -> oferta instanceof Mieszkanie && !oferta.getDataObowiazywaniaOferty().isBefore(LocalDate.now()));
    }

    public static void wyswietlOfertyDomowFiltr() {
        String miejscowosc = podajMiejscowosc();
        System.out.println("Podaj minimalną powierzchnię:");
        double minPowierzchniaDom = scanner.nextDouble();
        scanner.nextLine(); // Clear newline
        listaOfert.wyswietlOferty(oferta -> oferta instanceof Dom && !oferta.getDataObowiazywaniaOferty().isBefore(LocalDate.now())
                && oferta.getMiejscowosc().equalsIgnoreCase(miejscowosc) && oferta.getPowierzchnia() >= minPowierzchniaDom);
    }

    public static void wyswietlOfertyMieszkanFiltr() {
        String miejscowosc = podajMiejscowosc();
        System.out.println("Podaj maksymalną cenę:");
        double maxCenaMieszkanie = scanner.nextDouble();
        System.out.println("Podaj minimalny numer piętra:");
        int minPietro = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        listaOfert.wyswietlOferty(oferta -> oferta instanceof Mieszkanie && !oferta.getDataObowiazywaniaOferty().isBefore(LocalDate.now())
                && oferta.getMiejscowosc().equalsIgnoreCase(miejscowosc) && oferta.getCena() <= maxCenaMieszkanie
                && ((Mieszkanie) oferta).getNumerPietra() >= minPietro);
    }

    public static void main(String[] args) {
        listaOfert.dodajPrzykladoweOferty();
        System.out.println("Program ten służy do przechowywania ofert sprzedaży domów oraz mieszkań");
        boolean working = true;
        while (working) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> dodajOferteDomu();
                case "2" -> dodajOferteMieszkania();
                case "3" -> wyswietlOfertyDomow();
                case "4" -> wyswietlOfertyMieszkan();
                case "5" -> wyswietlOfertyDomowFiltr();
                case "6" -> wyswietlOfertyMieszkanFiltr();
                case "7" -> {
                    System.out.println("Do widzenia");
                    working = false;
                }
                default -> System.out.println("Zły parametr!");
            }
        }
    }
}
