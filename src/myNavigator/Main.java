package myNavigator;

import myNavigator.blocks.FloorBlock;
import myNavigator.blocks.HomeBlock;
import myNavigator.common.POSITION_ENUM;

public class Main {
    public static void main(String [] args){
        System.out.println("Hello");
        HomeBlock block1 = new HomeBlock();
        FloorBlock block2 = new FloorBlock();
        block2.linkUp(block1, POSITION_ENUM.EAST);
        System.out.println(block1.getNeighborsString());
        System.out.println(block2.getNeighborsString());
    }
}
