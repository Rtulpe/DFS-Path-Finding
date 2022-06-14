package myNavigator.server;

import myNavigator.common.ITraveler;
import myNavigator.server.commonUtils.PositionMapper;
import myNavigator.server.mapUtils.MapUpdater;
import myNavigator.server.pathUtils.PathMaker;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Unifying class for remote method calling
 */
public class Traveler extends UnicastRemoteObject  implements ITraveler, Serializable {
    private MapUpdater upd;
    private PositionMapper psm;

    public Traveler() throws RemoteException {
        psm = PositionMapper.getInstance();
        psm.setPosition(0,0);
    }

    @Override
    public void createMap(int size) throws RemoteException {
        upd = new MapUpdater(size);
        upd.generateRandomMap();
    }

    @Override
    public void createMap(int xSize, int ySize) throws RemoteException {
        upd = new MapUpdater(xSize,ySize);
        upd.generateRandomMap();
    }

    @Override
    public void setHome(int x, int y) throws RemoteException {
        upd.setHome(x,y);
    }

    @Override
    public String getMapString() throws RemoteException {
        return upd.getMap().toString();
    }

    @Override
    public void setPosition(int x, int y) throws RemoteException {
        psm.setPosition(x,y);
    }

    @Override
    public String getPathString(boolean isHomePath) throws RemoteException {
        PathMaker mkr = new PathMaker(upd.getMap());
        return mkr.requestPath(isHomePath).toString();
    }
}
