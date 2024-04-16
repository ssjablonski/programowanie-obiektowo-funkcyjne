public class Walec {
    private double promien;
    private double wysokosc;

    public Walec(double wysokosc, double promien) {
        this.wysokosc = wysokosc;
        this.promien = promien;
    }

    public Walec () {}

    public void ustawPromien(double promien) {
        this.promien = promien;
    }

    public void ustawWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double zwrocPromien() {
        return promien;
    }

    public double zwrocWysokosc() {
        return wysokosc;
    }

    public double obliczPolePodstawy() {
        return Math.PI * Math.pow(this.promien, 2);
    }

    public double obliczPoleBocznej() {
        return 2 * Math.PI * promien * wysokosc;
    }

    public double obliczPoleCalkowitej() {
        return 2 * obliczPolePodstawy() + obliczPoleBocznej();
    }

    public double obliczObjetosc() {
        return obliczPolePodstawy() * wysokosc;
    }

}