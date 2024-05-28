import java.time.LocalTime;

public final class Zadanie extends Wpis {
    private String status;

    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String status) {
        super(czasPoczatku, czasZakonczenia, opis);
        this.status = status;
    }

    public String zwrocStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ZADANIE | Opis: " + opis + ", czas rozpoczęcia: " + czasPoczatku + ", czas zakończenia: " + czasZakonczenia + ", status " + status;
    }
}