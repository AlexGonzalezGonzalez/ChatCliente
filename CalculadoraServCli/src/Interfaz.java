
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase que contiene la interfaz grafica de la calculadora
 *
 * @author agonzalezgonzalez
 */
public class Interfaz extends JPanel implements ActionListener {

    Teclado teclado = new Teclado();
    Cliente c = new Cliente();
    
    char raiz = '\u221A';
    String msg = "";
    int x = 10, y = 80;

    JFrame ventana;
    JLabel txt;
    JLabel titulo;

    JButton b0 = new JButton("0"), bRetroceso = new JButton("DEL"), bOff = new JButton("OFF");

    JButton[] botones = new JButton[]{new JButton("1"), new JButton("4"), new JButton("7"),
        new JButton("2"), new JButton("5"), new JButton("8"),
        new JButton("3"), new JButton("6"), new JButton("9")};

    JButton[] operaciones = new JButton[]{new JButton("+"), new JButton("-"), new JButton("x"), bRetroceso,
        new JButton("/"), new JButton("" + raiz), new JButton(new String("*")), new JButton("=")};

    JPanel pBotones, pTitulo;

    /*
    Constructor
     */
    Interfaz() {

        //Instancia de objetos
        ventana = new JFrame("Calculadora");
        pBotones = new JPanel();
        pTitulo = new JPanel();
        titulo = new JLabel("Calculadora");

        //Layout null para posiciones absolutas
        this.setLayout(null);

        this.addKeyListener(teclado);

        this.setFocusable(true);

        //Metodo que posiciona los componentes
        posicionComponentes();

        //JPanel que contienes los botones
        pBotones.setLayout(null);
        pBotones.setBounds(txt.getX(), txt.getY() + txt.getHeight() + 10, txt.getWidth(), bRetroceso.getY() + bRetroceso.getHeight() + 35);
        pBotones.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        //JPanel que contiene el JLabel `Calculadora´
        pTitulo.setBounds(txt.getX(), 10, txt.getWidth(), txt.getHeight());
        pTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        //Añadimos los paneles al JFrame
        this.add(pTitulo);
        this.add(pBotones);

        //Modificaciones de la ventana
        ventana.add(this);
        ventana.setSize(600, 550);
        ventana.setLocationRelativeTo(null);
        ventana.setUndecorated(true);
        ventana.setVisible(true);
    }

    /**
     * Metodo que llama a los metodos que posicionan los componentes y añade una
     * fuente al JLabel y lo añade al panel del titulo
     */
    public void posicionComponentes() {
        posicionBotones();
        posicionOperaciones();
        posicionCuadroTexto();

        //JLabel que muestra el titulo ``Calculadora´´
        titulo.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 35));
        pTitulo.add(titulo);
    }

    /**
     * Metodo que posiciona los botones del array (botones) y del boton 0 (b0) y
     * el boton de apagado (bOff). Tambien les añade el ActionListener, una
     * fuente de texto y los añade al panel botones (pBotones).
     */
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
            botones[i].setFocusable(false);

            pBotones.add(botones[i]);
        }

        b0.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        b0.setBounds(10, 80 + 63 * 3, (35 * 2) + (65 * 3), 45);
        b0.setBorder(BorderFactory.createRaisedBevelBorder());
        b0.setFocusable(false);
        b0.addActionListener(this);
        pBotones.add(b0);

        bOff.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        bOff.setBounds(botones[6].getX() + 197, botones[6].getY() - 63, 80, 45);
        bOff.setBorder(BorderFactory.createRaisedBevelBorder());
        bOff.setFocusable(false);
        bOff.addActionListener(this);
        pBotones.add(bOff);

    }

    /**
     * Metodo que posiciona los botones del array (operaciones), la posicion de
     * estos depende del boton '3' (posicion 6 del array), es decir, si mueves
     * el boton '3' mueves todas las operaciones. Tambien les añade el
     * ActionListener, una fuente de texto y los añade al panel botones
     * (pBotones).
     */
    public void posicionOperaciones() {

        x = botones[6].getX() + 100;
        y = botones[6].getY();

        for (int i = 0; i < operaciones.length; i++) {

            operaciones[i].addActionListener(this);
            operaciones[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
            operaciones[i].setFocusable(false);

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

    /**
     * Metodo que instancia, posiciona, añade una fuente, alinea el texto a la
     * derecha, añade un borde al JLabel donde se muestran las operaciones y
     * resultados y añade este al panel principal (this).
     */
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

        }
        if (e.getSource() == bRetroceso) {

            try {

                msg = txt.getText().substring(0, txt.getText().length() - 1);
                txt.setText(msg);

            } catch (StringIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(this, "Ningun valor para borrar");
            }

        }

        if (e.getSource() == bOff) {

            System.exit(0);

        }

        if (((JButton) e.getSource()).getText().equalsIgnoreCase("=")) {

            

                
                //enviarOperacion(msg);
                //txt.setText(leerResultado());

            
        }

    }

    /**
     *
     * @param msg String que contiene las operaciones.
     * @throws ExcepcionOperador Excepcion que maneja los errores (en este caso
     * que no pueda haber dos operadores seguidos.)
     */
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

    /**
     * Clase que gestiona los eventos de teclado para poder escribir en la
     * calculadora.
     */
    public class Teclado extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == '1') {
                txt.setText(txt.getText() + "1");
            }
            if (e.getKeyChar() == '4') {
                txt.setText(txt.getText() + "4");
            }
            if (e.getKeyChar() == '7') {
                txt.setText(txt.getText() + "7");
            }
            if (e.getKeyChar() == '2') {
                txt.setText(txt.getText() + "2");
            }
            if (e.getKeyChar() == '5') {
                txt.setText(txt.getText() + "5");
            }
            if (e.getKeyChar() == '8') {
                txt.setText(txt.getText() + "8");
            }
            if (e.getKeyChar() == '3') {
                txt.setText(txt.getText() + "3");
            }
            if (e.getKeyChar() == '6') {
                txt.setText(txt.getText() + "6");
            }
            if (e.getKeyChar() == '9') {
                txt.setText(txt.getText() + "9");
            }
            if (e.getKeyChar() == '0') {
                txt.setText(txt.getText() + "0");
            }

            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                bRetroceso.doClick();
            }

        }

    }

    /**
     * Clase que gestiona las excepciones que puede crear la calculadora
     */
    public class ExcepcionOperador extends Exception {

        ExcepcionOperador() {

        }

        ExcepcionOperador(String mensaje) {
            JOptionPane.showMessageDialog(pBotones.getParent(), mensaje);
        }

    }
}
