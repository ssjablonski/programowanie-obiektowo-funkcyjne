import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListaOfert {
    private List<Nieruchomosc> oferty;

    public ListaOfert() {
        this.oferty = new ArrayList<>();
    }

    public void dodajOferte(Nieruchomosc nieruchomosc) {
        oferty.add(nieruchomosc);
    }

    public List<Nieruchomosc> filtrujOferty(Predicate<Nieruchomosc> predicate) {
        List<Nieruchomosc> result = new ArrayList<>();
        for (Nieruchomosc nieruchomosc : oferty) {
            if (predicate.test(nieruchomosc)) {
                result.add(nieruchomosc);
            }
        }
        return result;
    }

    public void wyswietlOferty(Predicate<Nieruchomosc> kryterium) {
        filtrujOferty(kryterium).forEach((nieruchomosc) -> System.out.println(nieruchomosc));
    }

    public void dodajPrzykladoweOferty() {
        dodajOferte(new Dom("Lipowa", 10, "Gdańsk", "00-001", 200, 1000000, 500, LocalDate.of(2024, 6, 1)));
        dodajOferte(new Dom("Długa", 20, "Kraków", "30-002", 150, 800000, 300, LocalDate.of(2024, 5, 30)));
        dodajOferte(new Dom("Krótka", 5, "Gdańsk", "80-003", 180, 900000, 400, LocalDate.of(2024, 5, 29)));
        dodajOferte(new Dom("Szeroka", 15, "Gdańsk", "60-004", 220, 1100000, 600, LocalDate.of(2024, 5, 28)));
        dodajOferte(new Dom("Wąska", 25, "Wrocław", "50-005", 160, 850000, 350, LocalDate.of(2024, 5, 27)));

        dodajOferte(new Mieszkanie("Mazowiecka", 30, 1, "Gdańsk", "00-001", 50, 1, 300000, LocalDate.of(2024, 6, 1)));
        dodajOferte(new Mieszkanie("Śląska", 40, 2, "Kraków", "30-002", 70, 2, 400000, LocalDate.of(2024, 5, 30)));
        dodajOferte(new Mieszkanie("Pomorska", 50, 3, "Gdańsk", "80-003", 60, 3, 350000, LocalDate.of(2024, 5, 29)));
        dodajOferte(new Mieszkanie("Wielkopolska", 60, 4, "Wrocław", "60-004", 80, 4, 450000, LocalDate.of(2024, 5, 28)));
        dodajOferte(new Mieszkanie("Dolnośląska", 70, 5, "Wrocław", "50-005", 90, 5, 500000, LocalDate.of(2024, 5, 27)));
        dodajOferte(new Mieszkanie("Malopolska", 80, 6, "Gdańsk", "00-001", 55, 2, 320000, LocalDate.of(2024, 6, 1)));
        dodajOferte(new Mieszkanie("Lubelska", 90, 7, "Kraków", "30-002", 75, 3, 430000, LocalDate.of(2024, 5, 30)));
    }
}
