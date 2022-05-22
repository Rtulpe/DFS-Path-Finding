package myNavigator.pathUtils;

import myNavigator.blocks.HomeBlock;
import myNavigator.mapUtils.MyMap;
import myNavigator.common.MyPosition;

public class GetHomePath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        findStart(x,y);

        MyPath myPath = new MyPath();
        myPath.addPath(getPathDFS());

        return myPath;
        }

    @Override
    boolean endFound(MyPosition position) {
        return matrix[position.y][position.x].getClass() == HomeBlock.class;
    }
}
