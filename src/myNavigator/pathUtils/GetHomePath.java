package myNavigator.pathUtils;

import myNavigator.mapUtils.MyMap;
import myNavigator.common.MyPosition;

import java.util.Arrays;

public class GetHomePath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        findStart(x,y);

        MyPosition[] path = getPathDFS();
        if (path != null) {
            System.out.println("DFS: " + Arrays.toString(path));
        } else {
            System.out.println("No path found!");
        }

        MyPath myPath = new MyPath();
        // TODO: 5/21/22 this can cause error
        for (MyPosition position1 : path) {
            myPath.addPoint(map.get(position1.x, position1.y));
        }
        return myPath;
        }
}
