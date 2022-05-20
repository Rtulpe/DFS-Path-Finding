package myNavigator.pathUtils;

import myNavigator.blocks.IBlock;
import myNavigator.mapUtils.MyMap;

import java.util.ArrayList;

interface PathMakerStrategy {
    public MyPath getPath(MyMap map, ArrayList<Integer> position);
}
