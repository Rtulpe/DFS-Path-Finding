package myNavigator.pathUtils;

import myNavigator.blocks.*;
import myNavigator.mapUtils.MyMap;

import java.util.*;

public class GetCleanPath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, ArrayList<Integer> position) {
        matrix = map.get2DMap();

        Position[] path = getPathDFS();
        if (path != null) {
            System.out.println("DFS: " + Arrays.toString(path));
        } else {
            System.out.println("No path found!");
        }

        MyPath myPath = new MyPath();
        // TODO: 5/21/22 this can cause error 
        for (Position position1 : path) {
            myPath.addPoint(map.get(position1.x, position1.y));
        }
        return myPath;
    }
}

