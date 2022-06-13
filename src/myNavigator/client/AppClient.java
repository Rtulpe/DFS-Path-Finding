package myNavigator.client;

import myNavigator.common.ITraveler;

import java.rmi.Naming;

public class AppClient{
public static void main(String[] args) throws Exception{
    ITraveler subject = (ITraveler) Naming.lookup("rmi://127.0.0.1/subject");
    ClientUI ui = new ClientUI(subject);
    ui.print("Starting Presentation");
}
}
