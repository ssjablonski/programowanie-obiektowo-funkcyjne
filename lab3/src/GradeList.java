import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> oceny = new ArrayList<Double>();
    public ArrayList<Double> zwrocOceny() {
        return oceny;
    }
    public double zwrocNajnizszaOcene() {
        if (oceny.isEmpty()) {
            return -1;
        }

        double min = oceny.get(0);
        for (double ocena : oceny) {
            if (ocena < min) {
                min = ocena;
            }
        }
        return min;
    }

    public double zwrocNajwyzszaOcene() {
        if (oceny.isEmpty()) {
            return -1;
        }

        double max = oceny.get(0);
        for (double ocena : oceny) {
            if (ocena > max) {
                max = ocena;
            }
        }
        return max;
    }

    public void dodajOcene(double ocena) {
        oceny.add(ocena);
    }

    public double obliczSrednia() {
        if (oceny.isEmpty()) {
            return -1;
        }

        double suma = 0.0;
        for (double ocena: oceny) {
            suma += ocena;
        }
        double srednia = suma / oceny.size();
        return srednia;

    }
}
