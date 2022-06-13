package myNavigator.client;

import myNavigator.common.ITraveler;

import java.rmi.Naming;

public class AppClient{
public static void main(String[] args) throws Exception{
    ITraveler subject = (ITraveler) Naming.lookup("rmi://127.0.0.1/subject");

    subject.createMap(10);
    subject.setHome(9,9);
    System.out.println(subject.getMapString());
    subject.setPosition(4,4);
    System.out.println(subject.getPathString(true));

    subject.createMap(10,6);
    subject.setHome(3,4);
    System.out.println(subject.getMapString());
    subject.setPosition(1,0);
    System.out.println(subject.getPathString(true));
    System.out.println(subject.getPathString(false));

}
}
