package ohtu.Komennot;

import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField syotekentta, tuloskentta;
    Deque<Integer> edelliset = new ArrayDeque<>();

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        int syote = 0;
        try {
            edelliset.add(Integer.parseInt(syotekentta.getText()));
            syote = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.miinus(syote);

        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.plus(edelliset.pollLast());
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

}
