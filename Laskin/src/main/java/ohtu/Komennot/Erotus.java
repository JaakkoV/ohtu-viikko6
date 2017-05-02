package ohtu.Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField syotekentta, tuloskentta;
    int edellinen = 0;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        int syote = 0;
        try {
            edellinen = Integer.parseInt(syotekentta.getText());
            syote = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(syote);

        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

}
