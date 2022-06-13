package server;

import myNavigator.common.ITraveller;

import java.rmi.RemoteException;

public class Traveller implements ITraveller {
    @Override
    public void createMap(int size) throws RemoteException {

    }

    @Override
    public void createMap(int xSize, int ySize) throws RemoteException {

    }

    @Override
    public void setHome(int x, int y) throws RemoteException {

    }

    @Override
    public String getMapString() throws RemoteException {
        return null;
    }

    @Override
    public void setPosition(int x, int y) throws RemoteException {

    }

    @Override
    public String getPathString(boolean isHomePath) throws RemoteException {
        return null;
    }
}
