package myNavigator.pathUtils;

import myNavigator.mapUtils.MyMap;

/**
 * Interface used for selecting path-finding strategies.
 */
interface PathMakerStrategy {
    MyPath getPath(MyMap map, int x, int y);
}
