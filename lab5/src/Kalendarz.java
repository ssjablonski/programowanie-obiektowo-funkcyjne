import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Kalendarz {
    private List<ArrayList<Spotkanie>> tydzien;

    public Kalendarz() {
        tydzien = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            tydzien.add(new ArrayList<>());
        }
    }

    public void DodajSpotkanie(int dzien, Spotkanie spotkanie) {
        tydzien.get(dzien - 1).add(spotkanie);
    }

    public void UsunSpotkanie(int dzien, Spotkanie spotkanie) {
        tydzien.get(dzien-1).remove(spotkanie);
    }

    public ArrayList<Spotkanie> ZwrocSpotkaniaPoFilter(int dzien, Predicate<Spotkanie> predicate) {
        ArrayList<Spotkanie> result = new ArrayList<>();
        for (Spotkanie spotkanie: tydzien.get(dzien - 1)) {
            if (predicate.test(spotkanie)) {
                result.add(spotkanie);
            }
        }
        return result;
    }

}
