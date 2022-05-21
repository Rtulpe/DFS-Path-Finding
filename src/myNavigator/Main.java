package myNavigator;

import myNavigator.common.PositionMapper;
import myNavigator.mapUtils.MapUpdater;
import myNavigator.mapUtils.MyMap;
import myNavigator.pathUtils.GetHomePath;
import myNavigator.pathUtils.MyPath;
import myNavigator.pathUtils.PathMaker;

public class Main {
    public static void main(String [] args){
        System.out.println("Hello");

        MapUpdater upd = new MapUpdater(10);

        PositionMapper mapper = PositionMapper.getInstance();

        mapper.setPosition(5,5);

        upd.generateRandomMap();
        MyMap map = upd.getMap();
        map.setHome(9,9);

        GetHomePath path = new GetHomePath();

        System.out.println(map);
        PathMaker maker = new PathMaker(map);

        mapper.setPosition(4,4);
        System.out.println(maker.requestPath(true));

        MapUpdater nupd = new MapUpdater(10,6);
        nupd.generateRandomMap();
        MyMap otherMap = nupd.getMap();

        otherMap.setHome(1,2);
        System.out.println(otherMap);
        maker.setMap(otherMap);
        System.out.println(maker.requestPath(true));
    }
}
