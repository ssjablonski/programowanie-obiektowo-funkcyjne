import java.time.LocalDate;
import java.time.LocalTime;



class Spotkanie {
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private String priorytet;
    private static final LocalTime NAJWCZESNIEJSZA_GODZINA = LocalTime.of(7, 0);


    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String priorytet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = priorytet;
    }

    public String getOpis() {
        return opis;
    }

    public LocalTime getCzasPoczatku() {
        return czasPoczatku;
    }

    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public String getPriorytet() {
        return priorytet;
    }

    public static LocalTime getNajwczesniejszaGodzina() {
        return NAJWCZESNIEJSZA_GODZINA;
    }

    @Override
    public String toString() {
        return "Opis: " + opis + ", czas rozpoczęcia: " + czasPoczatku + ", czas zakończenia: " + czasZakonczenia + ", priorytet " + priorytet;
    }


}