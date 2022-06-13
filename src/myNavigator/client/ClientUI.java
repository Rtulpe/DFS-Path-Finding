package myNavigator.client;

import myNavigator.common.IPrint;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class ClientUI extends JFrame implements IPrint {

    private JTextArea textBox;

    public static void main(String[] args){
        ClientUI ui = new ClientUI();
        ui.print("Hello!");
    }

    public ClientUI(){
        super("Client");
        textBox = new JTextArea(10,20);
        makeFrame();
    }

    private void makeFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBorder(new EmptyBorder(1,1,1,1));

        JPanel botPane = new JPanel();
        {
            botPane.setLayout(new GridLayout(0,1));

            JButton button = new JButton("UpdateMap");
            //todo implement button
            botPane.add(button);
        }

        JPanel topPane = new JPanel();
        {
            topPane.setLayout(new BorderLayout(8,8));

            JScrollPane scrollPane = new JScrollPane(textBox);
            topPane.add(scrollPane, BorderLayout.SOUTH);
        }

        contentPane.add(botPane, BorderLayout.SOUTH);
        contentPane.add(topPane, BorderLayout.NORTH);

        pack();

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
        setVisible(true);
    }

    @Override
    public void print(String msg) {
        textBox.append(msg);
        textBox.append("\n");
    }
}
