package myNavigator.pathUtils;

import myNavigator.mapUtils.MyMap;
import myNavigator.common.MyPosition;

import java.util.Arrays;

public class GetHomePath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        findStart(x,y);

        MyPath myPath = new MyPath();
        myPath.addPath(getPathDFS());

        return myPath;
        }
}
