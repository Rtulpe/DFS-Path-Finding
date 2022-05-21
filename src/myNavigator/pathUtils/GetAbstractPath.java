package myNavigator.pathUtils;

import myNavigator.blocks.FloorBlock;
import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;
import myNavigator.common.MyPosition;

import java.util.Stack;

/**
 * Implementation of Deep First Search Algorithm
 * Based on code in: https://www.careercup.com/question?id=5725353829990400
 */
public abstract class GetAbstractPath {
    IBlock[][] matrix;
    MyPosition[] shortestPath;
    Stack<MyPosition> path;
    MyPosition start;

    static class VisitedBlock implements IBlock {
    }

    public MyPosition[] getPathDFS() {
        path = new Stack<>();
        shortestPath = null;

        if (start != null) {
            next(start);
        }

        return shortestPath;
    }

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

    private boolean isVisitable(MyPosition position) {
        return position.y >= 0
                && position.x >= 0
                && position.y < matrix.length
                && position.x < matrix[position.y].length
                && (matrix[position.y][position.x].getClass() == FloorBlock.class || endFound(position));
    }

    private boolean endFound(MyPosition position) {
        return matrix[position.y][position.x].getClass() == HomeBlock.class;
    }

    private void stepForward(MyPosition position) {
        path.push(position);
        if (matrix[position.y][position.x].getClass() == FloorBlock.class) {
            matrix[position.y][position.x] = new VisitedBlock();
        }
    }

    private void stepBack() {
        MyPosition position = path.pop();
        if (matrix[position.y][position.x].getClass() == VisitedBlock.class) {
            matrix[position.y][position.x] = new FloorBlock();
        }
    }

    void findStart(int x, int y) {
        if (start != null) {
            return;
        }
        start = new MyPosition(x,y);
    }
}
