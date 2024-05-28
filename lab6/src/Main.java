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
            if (godzinaRozpoczecia.isBefore(Wpis.zwrocNajwczesniejszaGodzineWpisu())) {
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

    public static String podajStatus() {
        while (true) {
            System.out.println("Podaj status: (planowane, potwierdzone, realizowane, wykonane)");
            String priorytet = scanner.nextLine().trim().toLowerCase();

            if (priorytet.equals("planowane") || priorytet.equals("potwierdzone") || priorytet.equals("realizowane") || priorytet.equals("wykonane")) {
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
        kalendarz.DodajWpis(dzien, spotkanie);
    }

    public static void dodajZadanie() {
        int dzien = podajDzien();
        String opis = podajOpis();
        LocalTime godzinaRozpoczecia = podajGodzineRozpoczecia();
        LocalTime godzinaZakonczenia = podajGodzineZakonczenia();
        String status = podajStatus();

        Zadanie zadanie = new Zadanie(opis, godzinaRozpoczecia, godzinaZakonczenia, status);
        kalendarz.DodajWpis(dzien, zadanie);
    }

    public static void usunSpotkanie() {
        int dzien = podajDzien();
        List<Wpis> wpisy = kalendarz.ZwrocWpisPoFilter(dzien, spotkanie -> spotkanie instanceof Spotkanie);
        if (wpisy.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            while (true) {
                System.out.println("Wybierz spotkanie do usunięcia: ");
                for (int i = 0; i < wpisy.size(); i++) {
                    Wpis wpis = wpisy.get(i);
                    System.out.println(i+1 + ". " + wpis);
                }
                int indexSpotkanie = scanner.nextInt();
                scanner.nextLine();
                if (indexSpotkanie < 1 || indexSpotkanie > wpisy.size()) {
                    System.out.println("Zły numer spotkania!");
                    continue;
                }
                kalendarz.UsunWpis(dzien, wpisy.get(indexSpotkanie - 1));
                break;
            }
        }

    }

    public static void usunZadanie() {
        int dzien = podajDzien();
        List<Wpis> wpisy = kalendarz.ZwrocWpisPoFilter(dzien, zadanie -> zadanie instanceof Zadanie);
        if (wpisy.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            while (true) {
                System.out.println("Wybierz zadanie do usunięcia: ");
                for (int i = 0; i < wpisy.size(); i++) {
                    Wpis wpis = wpisy.get(i);
                    System.out.println(i+1 + ". " + wpis);
                }
                int indexSpotkanie = scanner.nextInt();
                scanner.nextLine();
                if (indexSpotkanie < 1 || indexSpotkanie > wpisy.size()) {
                    System.out.println("Zły numer zadania!");
                    continue;
                }
                kalendarz.UsunWpis(dzien, wpisy.get(indexSpotkanie - 1));
                break;
            }
        }

    }

    public static void wyswietlSpotkaniaDnia() {
        int dzien = podajDzien();
        List<Wpis> spotkania = kalendarz.ZwrocWpisPoFilter(dzien, spotkanie -> spotkanie instanceof Spotkanie);
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Wpis wpis = spotkania.get(i);
                System.out.println(i+1 + ". " + wpis);
            }
        }
    }

    public static void wyswietlZadaniaDnia() {
        int dzien = podajDzien();
        List<Wpis> zadania = kalendarz.ZwrocWpisPoFilter(dzien, zadanie -> zadanie instanceof Zadanie);
        if (zadania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < zadania.size(); i++) {
                Wpis wpis = zadania.get(i);
                System.out.println(i+1 + ". " + wpis);
            }
        }
    }


    public static void wyswietlSpotkaniaDniaPriorytet() {
        int dzien = podajDzien();
        String priorytet = podajPriorytet();
        List<Wpis> spotkania = kalendarz.ZwrocWpisPoFilter(dzien, spotkanie -> spotkanie instanceof Spotkanie && ((Spotkanie) spotkanie).zwrocPriorytet().equals(priorytet));
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Wpis spotkanie = spotkania.get(i);
                System.out.println(i+1 + ". " + spotkanie);
            }
        }
    }

    public static void wyswietlZadaniaDniaStatus() {
        int dzien = podajDzien();
        String status = podajStatus();
        List<Wpis> zadania = kalendarz.ZwrocWpisPoFilter(dzien, zadanie -> zadanie instanceof Zadanie && ((Zadanie) zadanie).zwrocStatus().equals(status));
        if (zadania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < zadania.size(); i++) {
                Wpis zadanie = zadania.get(i);
                System.out.println(i+1 + ". " + zadanie);
            }
        }
    }

    public static void wyswietlSpotkaniaPriorytetOdGodziny() {
        int dzien = podajDzien();
        LocalTime godzina = podajGodzineRozpoczecia();
        String priorytet = podajPriorytet();
        List<Wpis> spotkania = kalendarz.ZwrocWpisPoFilter(dzien, (spotkanie) -> spotkanie instanceof Spotkanie && (spotkanie.zwrocCzasPoczatku().isAfter(godzina) || spotkanie.zwrocCzasPoczatku().equals(godzina))  && ((Spotkanie) spotkanie).zwrocPriorytet().equals(priorytet));
        if (spotkania.isEmpty()) {
            System.out.println("Nie ma żadnych spotkań tego dnia!");
        } else {
            for (int i = 0; i < spotkania.size(); i++) {
                Wpis spotkanie = spotkania.get(i);
                System.out.println(i+1 + ". " + spotkanie);

            }
        }
    }

    public static void wyswietlZadaniaStatusDoGodziny() {
        int dzien = podajDzien();
        LocalTime godzina = podajGodzineZakonczenia();
        String status = podajStatus();
        List<Wpis> zadania = kalendarz.ZwrocWpisPoFilter(dzien, (zadanie) -> zadanie instanceof Zadanie && (zadanie.zwrocCzasZakonczenia().isBefore(godzina) || zadanie.zwrocCzasZakonczenia().equals(godzina))  && ((Zadanie) zadanie).zwrocStatus().equals(status));
        if (zadania.isEmpty()) {
            System.out.println("Nie ma żadnych zadań tego dnia!");
        } else {
            for (int i = 0; i < zadania.size(); i++) {
                Wpis zadanie = zadania.get(i);
                System.out.println(i+1 + ". " + zadanie);

            }
        }
    }

    public static void testowaFunkcjaSpotkania() {
        Spotkanie spotkanie1 = new Spotkanie("Spotkanie1", LocalTime.of(7, 0), LocalTime.of(8, 0), "normalny");
        Spotkanie spotkanie2 = new Spotkanie("Spotkanie2", LocalTime.of(8, 0), LocalTime.of(9, 0), "wysoki");
        Spotkanie spotkanie3 = new Spotkanie("Spotkanie3", LocalTime.of(9, 0), LocalTime.of(10, 0), "najwyższy");
        Spotkanie spotkanie4 = new Spotkanie("Spotkanie4", LocalTime.of(10, 0), LocalTime.of(11, 0), "normalny");
        Spotkanie spotkanie5 = new Spotkanie("Spotkanie5", LocalTime.of(11, 0), LocalTime.of(12, 0), "wysoki");
        Spotkanie spotkanie6 = new Spotkanie("Spotkanie6", LocalTime.of(12, 0), LocalTime.of(13, 0), "najwyższy");
        Spotkanie spotkanie7 = new Spotkanie("Spotkanie7", LocalTime.of(13, 0), LocalTime.of(14, 0), "normalny");
        kalendarz.DodajWpis(1, spotkanie1);
        kalendarz.DodajWpis(1, spotkanie2);
        kalendarz.DodajWpis(1, spotkanie3);
        kalendarz.DodajWpis(1, spotkanie4);
        kalendarz.DodajWpis(1, spotkanie5);
        kalendarz.DodajWpis(1, spotkanie6);
        kalendarz.DodajWpis(1, spotkanie7);
    }

    public static void testowaFunkcjaZadania() {
        Zadanie zadanie1 = new Zadanie("Zadania1", LocalTime.of(7, 0), LocalTime.of(8, 0), "planowane");
        Zadanie zadanie2 = new Zadanie("Zadanie2", LocalTime.of(8, 0), LocalTime.of(9, 0), "potwierdzone");
        Zadanie zadanie3 = new Zadanie("Zadanie3", LocalTime.of(9, 0), LocalTime.of(10, 0), "realizowane");
        Zadanie zadanie4 = new Zadanie("Zadanie4", LocalTime.of(10, 0), LocalTime.of(11, 0), "wykonane");
        Zadanie zadanie5 = new Zadanie("Zadanie5", LocalTime.of(11, 0), LocalTime.of(12, 0), "planowane");
        Zadanie zadanie6 = new Zadanie("Zadanie6", LocalTime.of(12, 0), LocalTime.of(13, 0), "potwierdzone");
        Zadanie zadanie7 = new Zadanie("Zadanie7", LocalTime.of(13, 0), LocalTime.of(14, 0), "wykonane");
        kalendarz.DodajWpis(1, zadanie1);
        kalendarz.DodajWpis(1, zadanie2);
        kalendarz.DodajWpis(1, zadanie3);
        kalendarz.DodajWpis(1, zadanie4);
        kalendarz.DodajWpis(1, zadanie5);
        kalendarz.DodajWpis(1, zadanie6);
        kalendarz.DodajWpis(1, zadanie7);
    }

    private static void displayMenu() {
        System.out.println("Wybierz opcje:");
        System.out.println("1. Dodaj nowe spotkanie");
        System.out.println("2. Dodaj nowe zadanie");
        System.out.println("3. Usuń wybrane spotkanie");
        System.out.println("4. Usuń wybranie zadanie");
        System.out.println("5. Wyświetl spotkania danego dnia");
        System.out.println("6. Wyświetl zadania danego dnia");
        System.out.println("7. Wyświetl spotkania z danego dnia o danym priorytecie");
        System.out.println("8. Wyświetl zadania z danego dnia o danym statusie");
        System.out.println("9. Wyświetl spotkania z danego dnia o danym priorytecie zaczynające się od podanej godziny");
        System.out.println("10. Wyświetl zadania z danego dnia o danym statusie kończących się nie pózniej od podanego czasu");
        System.out.println("11. Testowa funkcja spotkania (dodaje 7 spotkan w poniedziałek)");
        System.out.println("12. Testowa funkcja zadania (dodaje 7 zadan w poniedziałek)");
        System.out.println("13. Wyjść z programu.");
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
                case "2" -> dodajZadanie();
                case "3" -> usunSpotkanie();
                case "4" -> usunZadanie();
                case "5" -> wyswietlSpotkaniaDnia();
                case "6" -> wyswietlZadaniaDnia();
                case "7" -> wyswietlSpotkaniaDniaPriorytet();
                case "8" -> wyswietlZadaniaDniaStatus();
                case "9" -> wyswietlSpotkaniaPriorytetOdGodziny();
                case "10" -> wyswietlZadaniaStatusDoGodziny();
                case "11" -> testowaFunkcjaSpotkania();
                case "12" -> testowaFunkcjaZadania();
                case "13" -> {
                    System.out.println("Do widzenia");
                    working = false;
                }
                default -> System.out.println("Zły parametr!");
            }
        }
    }
}