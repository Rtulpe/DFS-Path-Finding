package myNavigator.pathUtils;

import myNavigator.blocks.FloorBlock;
import myNavigator.common.MyPosition;
import myNavigator.mapUtils.MyMap;
import myNavigator.mapUtils.Zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class GetCleanPath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        ArrayList<Zone> zoneList = map.getZoneList();
        Stack<MyPosition> pointsToVisit = new Stack<>();
        MyPosition topBound;
        MyPosition bottomBound;
        MyPath myPath = new MyPath();

        int startX = x;
        int startY = y;

        for (Zone zone : zoneList) {
            topBound = zone.getTopBound();
            bottomBound = zone.getBottomBound();
            pointsToVisit.clear();

            for (int i = topBound.y; i < bottomBound.y; i++){
                for (int j = topBound.x; j < bottomBound.x; j++)
                {
                   if (map.getBlockAt(i,j).getClass()== FloorBlock.class && (!matrix[i][j].equals(matrix[x][y]))) pointsToVisit.add(new MyPosition(i,j));
                }
            }

            MyPosition destination;

            while (!pointsToVisit.isEmpty()){
                destination = pointsToVisit.pop();

                matrix[destination.x][destination.y] = new DestinationBlock();
                setStart(startY,startX);

                MyPosition[] subPath = getPathDFS();

                if (subPath!=null) {
                    subPath = Arrays.copyOf(subPath, subPath.length - 1);
                    for (MyPosition myPosition : subPath) {
                        pointsToVisit.remove(myPosition);
                    }
                }

                myPath.addPath(subPath);

                if (subPath != null) {
                    startX = destination.x;
                    startY = destination.y;
                }
                matrix[destination.x][destination.y] = new FloorBlock();
            }
        }

        return myPath;
    }

    static class DestinationBlock extends FloorBlock{
    }

    @Override
    boolean endFound(MyPosition position) {
        return matrix[position.y][position.x].getClass() == DestinationBlock.class;
    }
}

