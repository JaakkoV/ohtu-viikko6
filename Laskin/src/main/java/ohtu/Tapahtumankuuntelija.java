package ohtu;

import ohtu.Komennot.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton nollaa;
    private JButton undo;
    private Sovelluslogiikka sovellus;
    private Map<JButton, Komento> komennot;
    private Deque<Komento> edelliset;
    private Deque<Integer> edellisetLuvut;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.edelliset = new ArrayDeque<>();
        this.edelliset.add(new NoCommand());
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(sovellus, tuloskentta, syotekentta));
        komennot.put(miinus, new Erotus(sovellus, tuloskentta, syotekentta));
        komennot.put(nollaa, new Nollaa(sovellus, tuloskentta, syotekentta));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        Komento komento = komennot.get(ae.getSource());
        if (komento != null) {
            komento.suorita();
            edelliset.add(komento);
        } else {
            // toiminto oli undo
            edelliset.pollLast().peru();
        }

        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(!(edelliset.peekLast() instanceof NoCommand));
    }

}
