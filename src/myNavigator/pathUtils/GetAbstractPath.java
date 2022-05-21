package myNavigator.pathUtils;

import myNavigator.blocks.FloorBlock;
import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;

import java.util.Stack;

/**
 * Implementation of Deep First Search Algorithm
 * Based on code in: https://www.careercup.com/question?id=5725353829990400
 */
public abstract class GetAbstractPath {
    IBlock[][] matrix;
    Position[] shortestPath;
    Stack<Position> path;
    Position start;

    static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Position other = (Position) obj;
            if (x != other.x)
                return false;
            return y == other.y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }

    static class VisitedBlock implements IBlock {
    }

    public Position[] getPathDFS() {
        findStart();
        path = new Stack<>();
        shortestPath = null;

        if (start != null) {
            next(start);
        }

        return shortestPath;
    }

    private void next(Position position) {
        stepForward(position);

        if (shortestPath == null || path.size() < shortestPath.length) {
            if (!endFound(position)) {
                Position nextPosition = new Position(position.x + 1, position.y);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }

                nextPosition = new Position(position.x, position.y + 1);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }

                nextPosition = new Position(position.x - 1, position.y);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }

                nextPosition = new Position(position.x, position.y - 1);
                if (isVisitable(nextPosition)) {
                    next(nextPosition);
                }
            } else {
                shortestPath = path.toArray(new Position[0]);
            }
        }

        stepBack();
    }

    private boolean isVisitable(Position position) {
        return position.y >= 0
                && position.x >= 0
                && position.y < matrix.length
                && position.x < matrix[position.y].length
                && (matrix[position.y][position.x].getClass() == FloorBlock.class || endFound(position));
    }

    private boolean endFound(Position position) {
        return matrix[position.y][position.x].getClass() == HomeBlock.class;
    }

    private void stepForward(Position position) {
        path.push(position);
        if (matrix[position.y][position.x].getClass() == FloorBlock.class) {
            matrix[position.y][position.x] = new VisitedBlock();
        }
    }

    private void stepBack() {
        Position position = path.pop();
        if (matrix[position.y][position.x].getClass() == VisitedBlock.class) {
            matrix[position.y][position.x] = new FloorBlock();
        }
    }

    private void findStart() {
        if (start != null) {
            return;
        }
        start = new Position(0,0);
    }
}
