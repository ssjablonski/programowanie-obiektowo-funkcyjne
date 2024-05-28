import java.time.LocalTime;

public final class Spotkanie extends Wpis {
    private String priorytet;

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String priorytet) {
        super(czasPoczatku, czasZakonczenia, opis);
        this.priorytet = priorytet;
    }

    public String zwrocPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "SPOTKANIE | Opis: " + opis + ", czas rozpoczęcia: " + czasPoczatku + ", czas zakończenia: " + czasZakonczenia + ", priorytet " + priorytet;
    }
}
