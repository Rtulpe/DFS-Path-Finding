package myNavigator.server.pathUtils;

import myNavigator.server.mapUtils.MyMap;

/**
 * Interface used for selecting path-finding strategies.
 */
interface PathMakerStrategy {
    MyPath getPath(MyMap map, int x, int y);
}
