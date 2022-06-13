package myNavigator.server;

import myNavigator.common.ITraveler;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

/**
 * RMI Server of the Vertical Prototype
 * @author Rustenis Tolpeznikas
 * @version 0.2.0
 */
public class PlatformServer {
    /**
     * Starts the RMI Registry
     * @throws Exception random errors
     */
    public static void startRegistry() throws Exception{
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        RemoteServer.setLog( System.err);
    }

    public static void main(String [] args) throws Exception{
        startRegistry();
        RemoteServer.setLog(System.err);
        ITraveler subject = new Traveler();
        Naming.rebind("subject",subject);
    }
}
