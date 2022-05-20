package myNavigator;

import myNavigator.blocks.*;
import myNavigator.common.POSITION_ENUM;
import myNavigator.mapUtils.MyMap;

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
        MyMap map = new MyMap("Map",blockMap);

        System.out.println(map);
    }
}
