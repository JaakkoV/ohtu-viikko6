package ohtu.Komennot;

import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta, syotekentta;
    private Deque<Integer> edelliset = new ArrayDeque<>();

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int syote = 0;
        try {
            this.edelliset.add(Integer.parseInt(syotekentta.getText()));
            syote = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(syote);

        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.miinus(edelliset.pollLast());
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

}
