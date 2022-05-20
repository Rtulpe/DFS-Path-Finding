package myNavigator.pathUtils;

import myNavigator.mapUtils.MyMap;

import java.util.ArrayList;

interface PathMakerStrategy {
    public MyPath getPath(MyMap map, ArrayList<Integer> position);
}
