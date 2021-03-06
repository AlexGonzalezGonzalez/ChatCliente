/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author agonzalezgonzalez
 */
public class Vista extends JPanel {

    static Cliente c;
    Lector lector;
    public static JTextArea chat;
    public static JTextField txt;
    public static JPanel panelUsuarios;
    public static JLabel usuario;
    public static JFrame ventana;
    public static JLabel username;
    public static JButton enviar;

    Vista() {

        c = new Cliente();

        c.datos();

        txt = new JTextField();
        chat = new JTextArea();
        ventana = new JFrame();
        panelUsuarios = new JPanel();
        enviar = new JButton("enviar");
        lector = new Lector(c);
        c.setLector(lector);

        //Null para posiciones absolutas
        this.setLayout(null);

        enviar.addActionListener((ActionEvent ae) -> {
            enviarMensaje(Vista.txt.getText());
        });

        this.addKeyListener(new Teclado());

        //Caracteristicas TextArea
        chat.setBounds(35, 35, 375, 375);
        chat.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        chat.setLineWrap(true);
        chat.setEditable(false);

        //Caracteristicas txt
        txt.setBounds(chat.getX(), chat.getY() + chat.getHeight() + 10, chat.getWidth(), 65);

        //Cracteristica panelUsuarios
        panelUsuarios.setBounds(chat.getX() + chat.getWidth() + 10, chat.getY(), 100, chat.getHeight());
        panelUsuarios.setLayout(new GridLayout(10, 1));
        panelUsuarios.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        enviar.setBounds(panelUsuarios.getX(), txt.getY(), panelUsuarios.getWidth(), txt.getHeight());

        this.add(enviar);
        this.add(panelUsuarios);
        this.add(chat);
        this.add(txt);

        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(ventana,
                        "¿Quieres cerrar el chat?", "¿Cerrar el Chat?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    try {
                        c.clienteEscribir("/bye");
                        c.clienteSocket.close();
                        System.exit(0);
                    } catch (IOException ex) {
                    }
                }
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setSize(600, 550);
        ventana.add(this);
        ventana.setDefaultCloseOperation(3);
        ventana.setVisible(true);
    }

    public static void nuevoUsuario(String nickname) {
        System.out.println("En nuevo usuario: " + nickname);
        username = new JLabel(nickname);
        username.setHorizontalAlignment(JLabel.CENTER);
        panelUsuarios.add(username);

    }

    public static void enviarMensaje(String mensaje) {

        c.clienteEscribir(mensaje);

        Vista.txt.setText("");
    }

    public class Teclado extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                enviarMensaje(Vista.txt.getText());

            }
        }

    }

}
