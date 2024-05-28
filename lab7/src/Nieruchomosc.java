import java.time.LocalDate;

public abstract class Nieruchomosc {
    private String ulica;
    private int numerDomu;
    private String miejscowosc;
    private String kodPocztowy;
    private double powierzchnia;
    private double cena;
    private LocalDate dataObowiazywaniaOferty;

    public Nieruchomosc(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia, double cena, LocalDate dataObowiazywaniaOferty) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataObowiazywaniaOferty = dataObowiazywaniaOferty;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public double getCena() {
        return cena;
    }

    public LocalDate getDataObowiazywaniaOferty() {
        return dataObowiazywaniaOferty;
    }

    @Override
    public abstract String toString();
}
