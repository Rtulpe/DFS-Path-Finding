package myNavigator.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITraveller extends Remote {
    void createMap(int size) throws RemoteException;
    void createMap(int xSize, int ySize) throws RemoteException;
    void setHome(int x,int y) throws RemoteException;
    String getMapString() throws RemoteException;
    void setPosition(int x, int y) throws RemoteException;
    String getPathString(boolean isHomePath) throws RemoteException;

}
