package myNavigator;

import myNavigator.common.PositionMapper;
import myNavigator.mapUtils.MapUpdater;
import myNavigator.mapUtils.MyMap;
import myNavigator.pathUtils.GetHomePath;
import myNavigator.pathUtils.PathMaker;

/**
 * Main class of the Vertical Prototype for Use Cases SUC4 & SUC6
 * @author Rustenis Tolpeznikas
 * @version 0.1.0
 */
public class Main {
    public static void main(String [] args){
        System.out.println("Vertical Prototype: Map Generation and Path-Finding");

        MapUpdater upd = new MapUpdater(10);//Create 10x10 map

        PositionMapper mapper = PositionMapper.getInstance();

        upd.generateRandomMap();
        MyMap map = upd.getMap();
        map.setHome(9,9);//Put Home at 9:9

        System.out.println(map);

        PathMaker maker = new PathMaker(map);
        mapper.setPosition(4,4); //Put Robot at 4:4
        System.out.println("Travel to Home:");
        System.out.println(maker.requestPath(true));

        MapUpdater nUpd = new MapUpdater(10,6);
        nUpd.generateRandomMap();
        MyMap otherMap = nUpd.getMap();

        otherMap.setHome(3,4);
        System.out.println(otherMap);
        maker.setMap(otherMap);
        mapper.setPosition(1,0);
        System.out.println("Travel to Home:");
        System.out.println(maker.requestPath(true));

        System.out.println("Clean Entire Map:");
        System.out.println(maker.requestPath(false));
    }
}
