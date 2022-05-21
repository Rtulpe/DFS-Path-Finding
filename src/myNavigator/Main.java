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

        mapper.setPosition(5,5);

        MyMap map = upd.getMap();
        map.setHome(9,9);

        GetHomePath path = new GetHomePath();

        System.out.println(map);
        PathMaker maker = new PathMaker(map);

        System.out.println(maker.requestPath(true));
    }
}
