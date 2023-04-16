package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //implementuji formulář podle zadání

        //Husy
        husyField = new JTextField();
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        JLabel husyLabel = new JLabel("Husy");
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        //Králíci
        JLabel kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setLabelFor(kraliciField);
        kraliciField = new JTextField();
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);

        // Tlačítko Vypočítat
        JButton vypocitatButton = new JButton("Vypočítat");
        add(vypocitatButton, "span,center");

        // Počet hlav
        JLabel pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField = new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        add(pocetHlavLabel);
        add(pocetHlavField);

        // Počet nohou
        JLabel pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField = new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();

        vypocitatButton.addActionListener(this::handleVypocitat);

    }


    private void handleVypocitat(ActionEvent actionEvent) {

        // nahraju si proměnné
        int pocetHus = Integer.parseInt(husyField.getText());
        int pocetKraliku = Integer.parseInt(kraliciField.getText());

        // výpočet
        int VypocetPocetNoh = (pocetHus * 2) + (pocetKraliku * 4);
        int VypocetPocetHlav = pocetHus + pocetKraliku;

        // vložím výsledky
        pocetNohouField.setText(Integer.toString(VypocetPocetNoh));
        pocetHlavField.setText(Integer.toString(VypocetPocetHlav));

    }
}


