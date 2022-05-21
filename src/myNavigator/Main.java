package myNavigator;

import myNavigator.blocks.*;
import myNavigator.common.PositionMapper;
import myNavigator.mapUtils.MapUpdater;
import myNavigator.mapUtils.MyMap;
import myNavigator.pathUtils.GetCleanPath;
import myNavigator.pathUtils.GetHomePath;
import myNavigator.pathUtils.MyPath;

public class Main {
    public static void main(String [] args){
        System.out.println("Hello");

        HomeBlock block11 = new HomeBlock();
        FloorBlock block12 = new FloorBlock();
        FloorBlock block13 = new FloorBlock();
        ObstacleBlock block21 = new ObstacleBlock();
        FloorBlock block22 = new FloorBlock();
        FloorBlock block23 = new FloorBlock();
        EmptyBlock block31 = new EmptyBlock();
        FloorBlock block32 = new FloorBlock();
        EmptyBlock block33 = new EmptyBlock();

        IBlock[][] blockMap = {{block11,block12,block13},{block21,block22,block23},{block31,block32,block33}};
        //MyMap map = new MyMap("Map",blockMap);

        //MapUpdater updater = new MapUpdater();

        MapUpdater upd = new MapUpdater(10);
        //upd.checkOrCreate(0,0, block11);

        //System.out.println(map);

        PositionMapper mapper = PositionMapper.getInstance();

        System.out.println(mapper);

        for (int x = 0; x < 10; x++){
            for (int y =0; y < 10; y++){
                mapper.setPosition(x,y);
                upd.updateMap();
            }
            x++;
            for (int y = 9; y >= 0; y--){
                mapper.setPosition(x,y);
                upd.updateMap();
            }
        }
        MyMap map = upd.getMap();
        map.setHome(9,9);

        GetHomePath path = new GetHomePath();

        System.out.println(map);
        MyPath path1 = path.getPath(map, mapper.getPosition());
    }
}
