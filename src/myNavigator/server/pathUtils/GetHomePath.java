package myNavigator.server.pathUtils;

import myNavigator.server.blocks.HomeBlock;
import myNavigator.server.mapUtils.INSTRUCTION_ENUM;
import myNavigator.server.mapUtils.MyMap;
import myNavigator.server.commonUtils.MyPosition;

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
