package ohtu.Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta, syotekentta;
    int edellinen = 0;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int syote = 0;
        try {
            this.edellinen = Integer.parseInt(syotekentta.getText());
            syote = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(syote);

        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinen);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

}
