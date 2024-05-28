import java.time.LocalDate;

public final class Dom extends Nieruchomosc {
    private double powierzchniaDzialki;

    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia, double cena, double powierzchniaDzialki, LocalDate dataObowiazywaniaOferty) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }

    public double getPowierzchniaDzialki() {
        return powierzchniaDzialki;
    }

    @Override
    public String toString() {
        return "DOM - " +
                "Ulica: " + getUlica() + '\'' +
                ", Numer Domu: " + getNumerDomu() +
                ", Miejscowosc: " + getMiejscowosc() + '\'' +
                ", KodPocztowy: " + getKodPocztowy() + '\'' +
                ", Powierzchnia: " + getPowierzchnia() +
                ", Cena: " + getCena() +
                ", Powierzchnia Dzialki: " + powierzchniaDzialki +
                ", Data Obowiazywania Oferty: " + getDataObowiazywaniaOferty();
    }
}
