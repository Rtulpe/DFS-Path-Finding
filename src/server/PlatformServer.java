package server;

import myNavigator.common.ITraveller;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

public class PlatformServer {
    public static void startRegistry() throws Exception{
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        RemoteServer.setLog( System.err);
    }

    public static void main(String [] args) throws Exception{
        startRegistry();
        RemoteServer.setLog(System.err);
        ITraveller subject = new Traveller();
        Naming.rebind("subject",subject);
    }
}
