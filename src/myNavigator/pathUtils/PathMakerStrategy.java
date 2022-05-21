package myNavigator.pathUtils;

import myNavigator.mapUtils.MyMap;

interface PathMakerStrategy {
    public MyPath getPath(MyMap map, int x, int y);
}
