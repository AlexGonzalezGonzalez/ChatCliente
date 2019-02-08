/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author agonzalezgonzalez
 */
public final class Vista extends JPanel implements ActionListener {

    static JFrame ventana;
    static JTextArea chat;
    static JTextField txt;
    JLabel titulo;
    JButton enviar;
    Cliente cli;
    Controlador contr;
    Lector leer;
    
    Vista() {
        cli = new Cliente();
        contr = new Controlador(cli);
        
        
        ventana = new JFrame();
        chat = new JTextArea();
        txt = new JTextField();
        titulo = new JLabel();
        enviar = new JButton("Enviar");

        this.setLayout(null);

        posicionChat();
        posicionTxt();

        titulo.setBounds(chat.getX(), chat.getY() - 75, chat.getWidth(), 50);
        titulo.setText("Sala de chat");
        titulo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        titulo.setHorizontalAlignment(JLabel.CENTER);

        this.add(titulo);

        ventana.setDefaultCloseOperation(3);
        ventana.setSize(500, 600);
        ventana.setLocationRelativeTo(null);
        ventana.add(this);
        ventana.setVisible(true);
    }

    private void posicionTxt() {

        txt.setBounds(chat.getX(), chat.getY() + chat.getHeight() + 75, chat.getWidth(), 50);
        txt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        enviar.setBounds(txt.getX() + txt.getWidth() + 5, txt.getY(), 80, 50);
        enviar.addActionListener(this);
        this.add(enviar);
        this.add(txt);

    }

    private void posicionChat() {

        chat.setBounds(50, 100, 250, 300);
        chat.setLineWrap(true);
        chat.setEnabled(false);
        chat.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.add(chat);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==enviar){
            contr.enviar(txt.getText());
            Vista.chat.setText(chat.getText()+contr.leer());
        }
    }

}
