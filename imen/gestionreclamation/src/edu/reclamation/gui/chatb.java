/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reclamation.gui;

/**
 *
 * @author imen
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChatLogic {

    public void processMessage(String message, JTextArea chatArea) {
        message = message.toLowerCase();
        chatArea.append("You: " + message + "\n");
        if (message.contains("hi")||message.contains("hello")||message.contains("hey")||message.contains("good morning")) {
            reply("Hi there, welcome to Voleco!", chatArea);
        } else if (message.contains("how are you")||message.contains("hru")) {
            reply("I'm good :). Thank you for asking.", chatArea);
        } else if (message.contains("i have a problem")||message.contains("problem")) {
            reply("OK, your reclamation will be treated! You just have to fill out the form", chatArea);
        } else if (message.contains("bye")||message.contains("goodbye") ||message.contains("goodbye")) {
            reply("Goodbye!", chatArea);
        } else {
            reply("I'm sorry, I don't understand what you mean. Please try again using specific words", chatArea);
        }
    }

    private void reply(String message, JTextArea chatArea) {
        chatArea.append("ChatBot: " + message + "\n");
    }
}

class ChatGUI extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private JTextArea chatArea = new JTextArea();
    private JTextField chatField = new JTextField();
    private JButton sendButton = new JButton("SEND");
    private ChatLogic chatLogic = new ChatLogic();

    ChatGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setTitle("Voleco ChatBot");

        // Panel containing the chat history and the text field to enter messages
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBackground(Color.WHITE);

        // Chat history
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatPanel.add(scrollPane, BorderLayout.CENTER);

        // Text field to enter messages
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(chatField, BorderLayout.CENTER);

        // Send button
        sendButton.setPreferredSize(new Dimension(100, 50));
        sendButton.setFocusable(false);
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = chatField.getText();
                if (!message.isEmpty()) {
                    chatLogic.processMessage(message, chatArea);
                    chatField.setText("");
                }
            }
        });
        inputPanel.add(sendButton, BorderLayout.EAST);

        chatPanel.add(inputPanel, BorderLayout.SOUTH);

        // Panel containing the logo and the chat panel
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.WHITE);

        // Logo
        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/edu/reclamation/images/vol.png")));
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(logoLabel, BorderLayout.NORTH);

        contentPane.add(chatPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
    }
}

public class chatb {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatGUI chatGUI = new ChatGUI();
            chatGUI.setVisible(true);
        });
    }
}