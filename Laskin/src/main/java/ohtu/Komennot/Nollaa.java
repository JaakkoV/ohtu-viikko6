package ohtu.Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField syotekentta, tuloskentta;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        syotekentta.setText("0");
        tuloskentta.setText("0");
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
