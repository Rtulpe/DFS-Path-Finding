package myNavigator.pathUtils;

import myNavigator.mapUtils.MyMap;

public class GetCleanPath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();

        return null;
    }
}

