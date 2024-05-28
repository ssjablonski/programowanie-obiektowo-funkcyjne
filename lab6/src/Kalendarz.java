import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Kalendarz {
    private List<ArrayList<Wpis>> tydzien;

    public Kalendarz() {
        tydzien = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            tydzien.add(new ArrayList<>());
        }
    }

    public void DodajWpis(int dzien, Wpis wpis) {
        tydzien.get(dzien - 1).add(wpis);
    }

    public void UsunWpis(int dzien, Wpis wpis) {
        tydzien.get(dzien-1).remove(wpis);
    }

    public ArrayList<Wpis> ZwrocWpisPoFilter(int dzien, Predicate<Wpis> predicate) {
        ArrayList<Wpis> result = new ArrayList<>();
        for (Wpis wpis: tydzien.get(dzien - 1)) {
            if (predicate.test(wpis)) {
                result.add(wpis);
            }
        }
        return result;
    }

}
