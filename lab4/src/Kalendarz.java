import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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

    public List<Spotkanie> ZwrocSpotkaniaZDnia(int dzien) {
        return tydzien.get(dzien-1);
    }

    public List<Spotkanie> ZwrocSpotkaniaZDniaPriorytet(int dzien, String priorytet) {
        List<Spotkanie> helper = tydzien.get(dzien-1);
        List<Spotkanie> result = new ArrayList<>();
        for (Spotkanie spotkanie : helper) {
            if (spotkanie.getPriorytet().equals(priorytet)) {
                result.add(spotkanie);
            }
        }
        return result;
    }

    public List<Spotkanie> ZwrocSpotaniaZDniaOdGodziny(int dzien, LocalTime godzina) {
        List<Spotkanie> helper = tydzien.get(dzien-1);
        List<Spotkanie> result = new ArrayList<>();
        for (Spotkanie spotkanie : helper) {
            if (spotkanie.getCzasPoczatku().isAfter(godzina)) {
                result.add(spotkanie);
            }
        }
        return result;
    }
}
