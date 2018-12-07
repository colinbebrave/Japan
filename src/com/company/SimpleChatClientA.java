package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.awt.event.*;

public class SimpleChatClientA {

    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public void go()
    {
        JFrame frame = new JFrame("Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking()
    {
        //make a Socket, then make a PrintWriter
        //assign the PrintWriter to writer instance variable
        try
        {
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }//close setUpNetworking

    public class SendButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent ev)
        {
            //get the text from the text field and
            //send it to the server using the writer(a PrintWriter)
            try
            {
                writer.println(outgoing.getText());
                writer.flush();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }//close SendButtonListener inner class

    public static void main(String[] args)
    {
        new SimpleChatClientA().go();
    }
}//close outer class