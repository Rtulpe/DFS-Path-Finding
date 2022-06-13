package myNavigator.client;

import myNavigator.common.IPrint;
import myNavigator.common.ITraveler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ClientUI extends JFrame implements IPrint {

    private JTextArea textBox;
    private ITraveler iTravel;

    public ClientUI(ITraveler iTravel){
        super("Client");
        textBox = new JTextArea(10,20);
        this.iTravel = iTravel;
        makeFrame();
    }

    private void makeFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBorder(new EmptyBorder(1,1,1,1));

        JPanel botPane = new JPanel();
        {
            botPane.setLayout(new CardLayout());

            //Initial Screen
            JPanel card1 = new JPanel();
            {
                card1.setLayout(new GridLayout(1,0));
                JButton button = new JButton("Update Map");
                //todo implement button
                button.addActionListener(e ->
                {
                    CardLayout cardLayout = (CardLayout) botPane.getLayout();
                    cardLayout.show(botPane,"Map");
                });
                card1.add(button);

                button = new JButton("Set Home Position");
                button.addActionListener(e ->
                {
                    CardLayout cardLayout = (CardLayout) botPane.getLayout();
                    cardLayout.show(botPane,"Home");
                });
                card1.add(button);

                button = new JButton("Set Robot Position");
                button.addActionListener(e ->
                {
                    CardLayout cardLayout = (CardLayout) botPane.getLayout();
                    cardLayout.show(botPane,"Robot");
                });
                card1.add(button);

                button = new JButton("Get Home Path");
                button.addActionListener(e ->
                {
                    try {
                        print(iTravel.getPathString(true));
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                });
                card1.add(button);

                button = new JButton("Get Clean Path");
                button.addActionListener(e ->
                {
                    try {
                        print(iTravel.getPathString(false));
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                });
                card1.add(button);
            }

            //Map Generation
            JPanel card2 = new JPanel();
            {
                card2.setLayout(new GridLayout(1,0));

                JTextField xField = new JTextField();
                xField.setToolTipText("X size of map");
                card2.add(xField);

                JTextField yField = new JTextField();
                yField.setToolTipText("X size of map");
                card2.add(yField);

                JButton button = new JButton("OK");
                button.addActionListener(e ->
                {
                    String xText = xField.getText();
                    String yText = yField.getText();
                    if (!xText.isBlank() && !yText.isBlank()){
                        try {
                            print("Generating new map of dimensions: "+xText+":" + yText);
                            iTravel.createMap(Integer.parseInt(xText),Integer.parseInt(yText));
                            print(iTravel.getMapString());
                        } catch (RemoteException ex) {
                            ex.printStackTrace();
                        }
                    } else print("Empty Parameters!");
                    CardLayout cardLayout = (CardLayout) botPane.getLayout();
                    cardLayout.show(botPane,"General");
                });
                card2.add(button);
            }

            //Position Mapper
            JPanel card3 = new JPanel();
            {
                card3.setLayout(new GridLayout(1,0));

                JTextField xField = new JTextField();
                xField.setToolTipText("X coordinate");
                card3.add(xField);

                JTextField yField = new JTextField();
                yField.setToolTipText("Y coordinate");
                card3.add(yField);

                JButton button = new JButton("OK");
                button.addActionListener(e ->
                {
                    String xText = xField.getText();
                    String yText = yField.getText();
                    if (!xText.isBlank() && !yText.isBlank()){
                        try {
                            print("Home set to: "+xText+":" + yText);
                            iTravel.setHome(Integer.parseInt(xText),Integer.parseInt(yText));
                        } catch (RemoteException ex) {
                            ex.printStackTrace();
                        }
                    } else print("Empty Parameters!");
                    CardLayout cardLayout = (CardLayout) botPane.getLayout();
                    cardLayout.show(botPane,"General");
                });
                card3.add(button);
            }

            JPanel card4 = new JPanel();
            {
                card4.setLayout(new GridLayout(1,0));

                JTextField xField = new JTextField();
                xField.setToolTipText("X coordinate");
                card4.add(xField);

                JTextField yField = new JTextField();
                yField.setToolTipText("Y coordinate");
                card4.add(yField);

                JButton button = new JButton("OK");
                button.addActionListener(e ->
                {
                    String xText = xField.getText();
                    String yText = yField.getText();
                    if (!xText.isBlank() && !yText.isBlank()){
                        try {
                            print("Robot set to: "+xText+":" + yText);
                            iTravel.setPosition(Integer.parseInt(xText),Integer.parseInt(yText));
                        } catch (RemoteException ex) {
                            ex.printStackTrace();
                        }
                    } else print("Empty Parameters!");
                    CardLayout cardLayout = (CardLayout) botPane.getLayout();
                    cardLayout.show(botPane,"General");
                });
                card4.add(button);
            }

            botPane.add(card1,"General");
            botPane.add(card2, "Map");
            botPane.add(card3, "Home");
            botPane.add(card4, "Robot");
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
