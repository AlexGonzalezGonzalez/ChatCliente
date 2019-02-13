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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    JScrollPane panelChat;

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

        titulo.setBounds(panelChat.getX(), panelChat.getY() - 75, panelChat.getWidth(), 50);
        titulo.setText("Sala de chat");
        titulo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        titulo.setHorizontalAlignment(JLabel.CENTER);

        this.add(titulo);

        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(ventana,
                        "¿Quieres cerrar elchat?", "¿Cerrar el Chat??",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    try {
                        cli.clienteEscribir("/bye");
                        cli.clienteSocket.close();
                        System.exit(0);
                    } catch (IOException ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(500, 600);
        ventana.setLocationRelativeTo(null);
        ventana.add(this);
        ventana.setVisible(true);
        
        new Lector(contr.getCliente().ips);
    }

    private void posicionTxt() {

        txt.setBounds(panelChat.getX(), panelChat.getY() + panelChat.getHeight() + 75, panelChat.getWidth(), 50);
        txt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        enviar.setBounds(txt.getX() + txt.getWidth() + 5, txt.getY(), 80, 50);
        enviar.addActionListener(this);
        this.add(enviar);
        this.add(txt);

    }

    private void posicionChat() {

        panelChat = new JScrollPane();
        chat.setLineWrap(true);
        chat.setColumns(20);
        chat.setRows(5);
        chat.setWrapStyleWord(true);
        chat.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        chat.setEnabled(false);
        chat.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        panelChat.setBounds(50, 100, 250, 300);
        panelChat.setViewportView(chat);
        this.add(panelChat);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enviar) {
            
            contr.enviar(txt.getText());
            txt.setText("");
            Vista.chat.append(contr.leer());
            chat.append("\n");
            
        }
    }

}
