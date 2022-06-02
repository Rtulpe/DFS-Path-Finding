package myNavigator.pathUtils;

import myNavigator.blocks.HomeBlock;
import myNavigator.mapUtils.INSTRUCTION_ENUM;
import myNavigator.mapUtils.MyMap;
import myNavigator.common.MyPosition;

/**
 * Strategy for getting the path to home
 */
public class GetHomePath extends GetAbstractPath{

    /**
     * Using DFS algorithm, generate a path from x:y to home block
     *
     * @param map used for pathfinding
     * @param x starting position
     * @param y starting position
     * @return generated path
     */
    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        findStart(x,y);

        MyPath myPath = new MyPath();
        myPath.addPath(getPathDFS());
        myPath.finalizePath();
        myPath.setSingleInstruction(INSTRUCTION_ENUM.NULL);

        return myPath;
        }

    /**
     * End is set to home block
     * @param position position to be checked
     * @return true - position is home block
     */
    @Override
    boolean endFound(MyPosition position) {
        return matrix[position.y][position.x].getClass() == HomeBlock.class;
    }
}
