import java.time.LocalDate;

public final class Mieszkanie extends Nieruchomosc {
    private int numerMieszkania;
    private int numerPietra;

    public Mieszkanie(String ulica, int numerDomu, int numerMieszkania, String miejscowosc, String kodPocztowy, double powierzchnia, int numerPietra, double cena, LocalDate dataObowiazywaniaOferty) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.numerMieszkania = numerMieszkania;
        this.numerPietra = numerPietra;
    }

    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    public int getNumerPietra() {
        return numerPietra;
    }

    @Override
    public String toString() {
        return "MIESZKANIE - " +
                "Ulica: " + getUlica() +
                ", Numer Domu: " + getNumerDomu() +
                ", Numer Mieszkania: " + getNumerMieszkania() +
                ", Miejscowosc: " + getMiejscowosc() +
                ", Kod Pocztowy: " + getKodPocztowy() +
                ", Powierzchnia: " + getPowierzchnia() +
                ", Numer Piętra: " + getNumerPietra() +
                ", Cena: " + getCena() +
                ", Data Obowiazywania Oferty: " + getDataObowiazywaniaOferty();
    }
}
