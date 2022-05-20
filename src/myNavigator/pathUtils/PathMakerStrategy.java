package myNavigator.pathUtils;

import myNavigator.blocks.IBlock;
import myNavigator.mapUtils.MyMap;

interface PathMakerStrategy {
    MyPath getPath(MyMap map, IBlock position);
}
