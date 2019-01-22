
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.html.HTML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author agonzalezgonzalez
 */
public class Interfaz extends JPanel implements ActionListener {

    Cliente c = new Cliente();
    char raiz = '\u221A';
    String msg = "";
    int x = 10, y = 80;

    JFrame ventana;
    JLabel txt;
    JLabel nombre;

    JButton b0, bRetroceso = new JButton("DEL"), bOff = new JButton("OFF");

    JButton[] botones = new JButton[]{new JButton("1"), new JButton("2"), new JButton("3"),
        new JButton("4"), new JButton("5"), new JButton("6"),
        new JButton("7"), new JButton("8"), new JButton("9")};

    JButton[] operaciones = new JButton[]{new JButton("+"), new JButton("-"), new JButton("x"), bRetroceso,
        new JButton("/"), new JButton("" + raiz), new JButton(new String("x<html><sup>" + y + "</sup></html>")), new JButton("=")};

    JPanel pBotones, pNombre;

    Interfaz() {

        ventana = new JFrame("Calculadora");
        pBotones = new JPanel();
        pNombre = new JPanel();
        nombre = new JLabel("Calculadora");

        this.setLayout(null);

        posicionComponentes();

        //JPanel que contienes los botones
        pBotones.setLayout(null);
        pBotones.setBounds(txt.getX(), txt.getY() + txt.getHeight() + 10, txt.getWidth(), bRetroceso.getY() + bRetroceso.getHeight() + 50);
        pBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        //JPanel que contiene el JLabel `Calculadora´
        pNombre.setBounds(txt.getX(), 10, txt.getWidth(), txt.getHeight());
        pNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.add(pNombre);
        this.add(pBotones);

        ventana.add(this);
        ventana.setSize(600, 550);
        ventana.setLocationRelativeTo(null);
        ventana.setUndecorated(true);
        ventana.setVisible(true);
    }

    public void posicionComponentes() {
        posicionBotones();
        posicionOperaciones();
        posicionCuadroTexto();

        nombre.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 35));
        pNombre.add(nombre);
    }

    public void posicionBotones() {

        for (int i = 0; i < botones.length; i++) {
            botones[i].addActionListener(this);
            botones[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));

            switch (i) {
                case 0:
                    break;

                case 3:
                    x += 100;
                    y = 80;
                    break;

                case 6:
                    x += 100;
                    y = 80;
                    break;

                default:
                    y += 63;
                    break;

            }
            botones[i].setBounds(0 + x, 0 + y, 70, 45);
            botones[i].setBorder(BorderFactory.createRaisedBevelBorder());

            pBotones.add(botones[i]);
        }

        b0 = new JButton("0");
        b0.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        b0.setBounds(10, 80 + 63 * 3, (35 * 2) + (65 * 3), 45);

        bOff.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        bOff.setBounds(botones[6].getX() + 197, botones[6].getY() - 63, 80, 45);

        b0.setBorder(BorderFactory.createRaisedBevelBorder());
        bOff.setBorder(BorderFactory.createRaisedBevelBorder());

        b0.addActionListener(this);
        bOff.addActionListener(this);

        pBotones.add(b0);
        pBotones.add(bOff);
    }

    public void posicionOperaciones() {

        x = botones[6].getX() + 100;
        y = botones[6].getY();

        for (int i = 0; i < operaciones.length; i++) {
            
            operaciones[i].addActionListener(this);
            operaciones[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
            
            if (i == 4) {
                x = x + 97;
                y = botones[6].getY();
            }
            
            operaciones[i].setBounds(x, y, 80, 45);
            operaciones[i].setBorder(BorderFactory.createRaisedBevelBorder());

            y = y + 63;
            pBotones.add(operaciones[i]);
        }
    }

    public void posicionCuadroTexto() {
        
        txt = new JLabel();
        txt.setBounds(50, 75, 500, 60);
        txt.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
        txt.setHorizontalAlignment((int) JTextField.RIGHT);
        txt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.add(txt);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!((JButton) e.getSource()).getText().equalsIgnoreCase("=")
                && e.getSource() != bRetroceso
                && e.getSource() != bOff) {

            msg = msg + ((JButton) e.getSource()).getText();
            txt.setText(txt.getText() + ((JButton) e.getSource()).getText());

        } else if (e.getSource() == bRetroceso) {

            try {

                msg = txt.getText().substring(0, txt.getText().length() - 1);
                txt.setText(msg);

            } catch (StringIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(this, "Ningun valor para borrar");
            }

        } else if (e.getSource() == bOff) {

            System.exit(0);

        } else {

            try {

                corregir(msg);
                //enviarOperacion(msg);
                //txt.setText(leerResultado());

            } catch (ExcepcionOperador ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void corregir(String msg) throws ExcepcionOperador {
        int x = 0;
        for (int i = 0; i < msg.length(); i++) {

            for (int j = 0; j < operaciones.length; j++) {

                if (msg.charAt(i) == operaciones[j].getText().charAt(0)) {

                    for (int k = 0; k < operaciones.length; k++) {
                        //comparar si existe i+1 y si no se lanza no hay segundo operando
                        if (msg != null) {
                            if (msg.charAt(i + 1) == operaciones[k].getText().charAt(0)) {
                                throw new ExcepcionOperador("No puede haber dos operadores seguidos");
                            }
                        }
                    }
                }

            }

        }
    }

    public void enviarOperacion(String operacion) {
        c.clienteEscribir(msg);
    }

    public String leerResultado() {
        return c.clienteLeerResultado();
    }

    public class ExcepcionOperador extends Exception {

        ExcepcionOperador() {

        }

        ExcepcionOperador(String mensaje) {
            JOptionPane.showMessageDialog(pBotones.getParent(), mensaje);
        }

    }
}
