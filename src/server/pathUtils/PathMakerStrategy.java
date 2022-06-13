package server.pathUtils;

import server.mapUtils.MyMap;

/**
 * Interface used for selecting path-finding strategies.
 */
interface PathMakerStrategy {
    MyPath getPath(MyMap map, int x, int y);
}
