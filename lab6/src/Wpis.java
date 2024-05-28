import java.time.LocalTime;

public sealed abstract class Wpis permits Zadanie, Spotkanie {

    protected LocalTime czasPoczatku;
    protected LocalTime czasZakonczenia;
    protected String opis;

    static final LocalTime MIN_GODZINA_ROZPOCZECIA = LocalTime.of(9, 0);

    public Wpis(LocalTime czasPoczatku, LocalTime czasZakonczenia, String opis) {
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.opis = opis;
    }

    public Wpis(LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
    }

    public LocalTime zwrocCzasPoczatku() {
        return czasPoczatku;
    }

    public LocalTime zwrocCzasZakonczenia() {
        return czasZakonczenia;
    }

    public static LocalTime zwrocNajwczesniejszaGodzineWpisu() {
        return MIN_GODZINA_ROZPOCZECIA;
    }
}