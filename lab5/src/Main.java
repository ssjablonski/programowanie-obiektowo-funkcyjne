import java.util.Scanner;
import java.time.LocalTime;
import java.util.List;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Kalendarz kalendarz = new Kalendarz();

    private static void displayDni() {
        System.out.println("1. Poniedziałek");
        System.out.println("2. Wtorek");
        System.out.println("3. Środa");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
    }

    public static int podajDzien() {
        while (true) {
            System.out.println("Podaj dzień spotkania: ");
            displayDni();
            int dzien = scanner.nextInt();
            scanner.nextLine();
            if (dzien < 1 || dzien > 7) {
                System.out.println("Zły dzień!");
                continue;
            }
            return dzien;
        }
    }

    public static String podajOpis() {
        System.out.println("Podaj opis spotkania: ");
        String opis = scanner.nextLine();
        return opis;
    }

    public static LocalTime podajGodzineRozpoczecia() {
        while (true) {
            System.out.println("Podaj godzinę rozpoczęcia spotkania: (gg:mm)");
            String godzinaRozpoczeciaString = scanner.nextLine();
            LocalTime godzinaRozpoczecia = LocalTime.parse(godzinaRozpoczeciaString);
            if (godzinaRozpoczecia.isBefore(Spotkanie.getNajwczesniejszaGodzina())) {
                System.out.println("Godzina rozpoczęcia jest za wcześnie!");
                continue;
            }
            return godzinaRozpoczecia;
        }
    }

    public static LocalTime podajGodzineZakonczenia() {
        System.out.println("Podaj godzinę zakończenia spotkania: (gg:mm)");
        String godzinaZakonczeniaString = scanner.nextLine();
        LocalTime godzinaZakonczenia = LocalTime.parse(godzinaZakonczeniaString);
        return godzinaZakonczenia;
    }

    public static String podajPriorytet() {
        while (true) {
            System.out.println("Podaj priorytet: (normalny, wysoki, najwyższy)");
            String priorytet = scanner.nextLine().trim().toLowerCase();

            if (priorytet.equals("normalny") || priorytet.equals("wysoki") || priorytet.equals("najwyższy")) {
                return priorytet;
            }
            System.out.println("Zły priorytet!");
        }
    }
    public static void dodajSpotkanie() {
        int dzien = podajDzien();
        String opis = podajOpis();
        LocalTime godzinaRozpoczecia = podajGodzineRozpoczecia();
        LocalTime godzinaZakonczenia = podajGodzineZakonczenia();
        String priorytet = podajPriorytet();

        Spotkanie spotkanie = new Spotkanie(opis, godzinaRozpoczecia, godzinaZakonczenia, priorytet);
        kalendarz.DodajSpotkanie(dzien, spotkanie);
    }

    public static void usunSpotkanie() {
        int dzien = podajDzien();
        List<Spotkanie> spotkania = kalendarz.ZwrocSpotkaniaPoFilter(dzien, spotkanie -> true);
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            while (true) {
                System.out.println("Wybierz spotkanie do usunięcia: ");
                for (int i = 0; i < spotkania.size(); i++) {
                    Spotkanie spotkanie = spotkania.get(i);
                    System.out.println(i+1 + ". " + spotkanie);
                }
                int indexSpotkanie = scanner.nextInt();
                scanner.nextLine();
                if (indexSpotkanie < 1 || indexSpotkanie > spotkania.size()) {
                    System.out.println("Zły numer spotkania!");
                    continue;
                }
                kalendarz.UsunSpotkanie(dzien, spotkania.get(indexSpotkanie - 1));
                break;
            }
        }

    }

    public static void wyswietlSpotkaniaDnia() {
        int dzien = podajDzien();
        List<Spotkanie> spotkania = kalendarz.ZwrocSpotkaniaPoFilter(dzien, spotkanie -> true);
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Spotkanie spotkanie = spotkania.get(i);
                System.out.println(i+1 + ". " + spotkanie);
            }
        }
    }

    public static void wyswietlSpotkaniaDniaPriorytet() {
        int dzien = podajDzien();
        String priorytet = podajPriorytet();
        List<Spotkanie> spotkania = kalendarz.ZwrocSpotkaniaPoFilter(dzien, spotkanie -> spotkanie.getPriorytet().equals(priorytet));
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Spotkanie spotkanie = spotkania.get(i);
                System.out.println(i+1 + ". " + spotkanie);
            }
        }
    }

    public static void wyswietlSpotkaniaDniaOdGodziny() {
        int dzien = podajDzien();
        LocalTime godzina = podajGodzineRozpoczecia();
        List<Spotkanie> spotkania = kalendarz.ZwrocSpotkaniaPoFilter(dzien, (spotkanie) -> spotkanie.getCzasPoczatku().isAfter(godzina) || spotkanie.getCzasPoczatku().equals(godzina));
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Spotkanie spotkanie = spotkania.get(i);
                System.out.println(i+1 + ". " + spotkanie);
            }
        }
    }

    public static void wyswietlSpotkaniaOdGodzinyDoGodziny() {
        int dzien = podajDzien();
        LocalTime godzinaRozpoczecia = podajGodzineRozpoczecia();
        LocalTime godzinaZakonczenia = podajGodzineZakonczenia();
        List<Spotkanie> spotkania = kalendarz.ZwrocSpotkaniaPoFilter(dzien, (spotkanie) -> spotkanie.getCzasPoczatku().isAfter(godzinaRozpoczecia) || spotkanie.getCzasPoczatku().equals(godzinaRozpoczecia) && spotkanie.getCzasZakonczenia().isBefore(godzinaZakonczenia) || spotkanie.getCzasZakonczenia().equals(godzinaZakonczenia));
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Spotkanie spotkanie = spotkania.get(i);
                System.out.println(i+1 + ". " + spotkanie);
            }
        }
    }

    public static void wyswietlSpotkaniaPriorytetOdGodziny() {
        int dzien = podajDzien();
        LocalTime godzina = podajGodzineRozpoczecia();
        String priorytet = podajPriorytet();
        List<Spotkanie> spotkania = kalendarz.ZwrocSpotkaniaPoFilter(dzien, (spotkanie) -> spotkanie.getCzasPoczatku().isAfter(godzina) || spotkanie.getCzasPoczatku().equals(godzina)  && spotkanie.getPriorytet().equals(priorytet));
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Spotkanie spotkanie = spotkania.get(i);
                System.out.println(i+1 + ". " + spotkanie);

            }
        }
    }

    public static void testowaFunkcja() {
        Spotkanie spotkanie1 = new Spotkanie("Spotkanie1", LocalTime.of(7, 0), LocalTime.of(8, 0), "normalny");
        Spotkanie spotkanie2 = new Spotkanie("Spotkanie2", LocalTime.of(8, 0), LocalTime.of(9, 0), "wysoki");
        Spotkanie spotkanie3 = new Spotkanie("Spotkanie3", LocalTime.of(9, 0), LocalTime.of(10, 0), "najwyższy");
        Spotkanie spotkanie4 = new Spotkanie("Spotkanie4", LocalTime.of(10, 0), LocalTime.of(11, 0), "normalny");
        Spotkanie spotkanie5 = new Spotkanie("Spotkanie5", LocalTime.of(11, 0), LocalTime.of(12, 0), "wysoki");
        Spotkanie spotkanie6 = new Spotkanie("Spotkanie6", LocalTime.of(12, 0), LocalTime.of(13, 0), "najwyższy");
        Spotkanie spotkanie7 = new Spotkanie("Spotkanie7", LocalTime.of(13, 0), LocalTime.of(14, 0), "normalny");
        kalendarz.DodajSpotkanie(1, spotkanie1);
        kalendarz.DodajSpotkanie(1, spotkanie2);
        kalendarz.DodajSpotkanie(1, spotkanie3);
        kalendarz.DodajSpotkanie(1, spotkanie4);
        kalendarz.DodajSpotkanie(1, spotkanie5);
        kalendarz.DodajSpotkanie(1, spotkanie6);
        kalendarz.DodajSpotkanie(1, spotkanie7);
    }

    private static void displayMenu() {
        System.out.println("Wybierz opcje:");
        System.out.println("1. Dodaj nowe spotkanie");
        System.out.println("2. Usuń wybrane spotkanie");
        System.out.println("3. Wyświetl spotkania danego dnia");
        System.out.println("4. Wyświetl spotkania o danym priorytecie");
        System.out.println("5. Wyświetl spotkania zaczynające się od podanej godziny");
        System.out.println("6. Wyświetl spotania odbywające się pomiędzy danymi godzinami (włącznie)");
        System.out.println("7. Wyświetl spotkania o danym priorytecie oraz zaczynające się od podanej godzinie");
        System.out.println("8. Testowa funkcja");
        System.out.println("9. Wyjść z programu");
        System.out.println("Co chciałbyś zrobić? (Wybierz jedną z opcji)");
    }

    public static void main(String[] args) {
        System.out.println("Program ten służy do przechowywania spotkań w kalendarzu");
        boolean working = true;
        while (working) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> dodajSpotkanie();
                case "2" -> usunSpotkanie();
                case "3" -> wyswietlSpotkaniaDnia();
                case "4" -> wyswietlSpotkaniaDniaPriorytet();
                case "5" -> wyswietlSpotkaniaDniaOdGodziny();
                case "6" -> wyswietlSpotkaniaOdGodzinyDoGodziny();
                case "7" -> wyswietlSpotkaniaPriorytetOdGodziny();
                case "8" -> testowaFunkcja();
                case "9" -> {
                    System.out.println("Do widzenia");
                    working = false;
                }
                default -> System.out.println("Zły parametr!");
            }
        }
    }
}