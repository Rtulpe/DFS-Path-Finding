package myNavigator.pathUtils;

import myNavigator.blocks.FloorBlock;
import myNavigator.blocks.IBlock;
import myNavigator.commonUtils.MyPosition;

import java.util.Stack;

/**
 * Implementation of Deep First Search Algorithm
 * Based on code in: https://www.careercup.com/question?id=5725353829990400
 */
public abstract class GetAbstractPath implements PathMakerStrategy {
    IBlock[][] matrix;
    MyPosition[] shortestPath;
    Stack<MyPosition> path;
    MyPosition start;

    /**
     * Inner IBlock class, used to temporarily mark block as visited.
     */
    static class VisitedBlock implements IBlock {
    }

    /**
     * Calls DFS algorithm
     * @return path in MyPosition[] form
     */
    public MyPosition[] getPathDFS() {
        path = new Stack<>();
        shortestPath = null;

        if (start != null) {
            next(start);
        }

        return shortestPath;
    }

    /**
     * Steps to new position
     * @param position new position to be visited
     */
    private void next(MyPosition position) {
        stepForward(position);

        if (shortestPath == null || path.size() < shortestPath.length) {
            if (!endFound(position)) {
                MyPosition nextPosition = new MyPosition(position.x + 1, position.y);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }

                nextPosition = new MyPosition(position.x, position.y + 1);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }

                nextPosition = new MyPosition(position.x - 1, position.y);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }

                nextPosition = new MyPosition(position.x, position.y - 1);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }
            } else {
                shortestPath = path.toArray(new MyPosition[0]);
            }
        }

        stepBack();
    }

    /**
     * Checks if block is of type FloorBlock, thus
     * could be visited.
     * @param position to be checked
     * @return true - can be visited
     */
    private boolean isVisitable(MyPosition position) {
        return position.y >= 0
                && position.x >= 0
                && position.y < matrix.length
                && position.x < matrix[position.y].length
                && (matrix[position.y][position.x].getClass() == FloorBlock.class || endFound(position));
    }

    /**
     * Implemented by child classes. Condition for ending the algorithm
     * @param position to be checked
     * @return true - end found
     */
    abstract boolean endFound(MyPosition position);

    /**
     * Marks block as visited
     * @param position to be marked as visited
     */
    private void stepForward(MyPosition position) {
        path.push(position);
        if (matrix[position.y][position.x].getClass() == FloorBlock.class) {
            matrix[position.y][position.x] = new VisitedBlock();
        }
    }

    /**
     * Steps back on the visited block
     */
    private void stepBack() {
        MyPosition position = path.pop();
        if (matrix[position.y][position.x].getClass() == VisitedBlock.class) {
            matrix[position.y][position.x] = new FloorBlock();
        }
    }

    void setStart(int x, int y) {
        start = new MyPosition(x,y);
    }

    void findStart(int x, int y) {
        if (start != null) {
            return;
        }
        start = new MyPosition(x,y);
    }
}
