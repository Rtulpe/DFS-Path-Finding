package myNavigator.pathUtils;

import myNavigator.blocks.IBlock;
import myNavigator.mapUtils.MyMap;

import java.util.ArrayList;
import java.util.Arrays;

public class GetHomePath extends GetAbstractPath implements PathMakerStrategy{
    @Override
    public MyPath getPath(MyMap map, ArrayList<Integer> position) {
        matrix = map.get2DMap();

        GetAbstractPath.Position[] path = getPathDFS();
        if (path != null) {
            System.out.println("DFS: " + Arrays.toString(path));
        } else {
            System.out.println("No path found!");
        }

        MyPath myPath = new MyPath();
        // TODO: 5/21/22 this can cause error
        for (GetAbstractPath.Position position1 : path) {
            myPath.addPoint(map.get(position1.x, position1.y));
        }
        return myPath;
        }
}
