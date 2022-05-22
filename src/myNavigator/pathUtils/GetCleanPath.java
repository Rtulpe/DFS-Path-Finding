package myNavigator.pathUtils;

import myNavigator.blocks.FloorBlock;
import myNavigator.common.MyPosition;
import myNavigator.mapUtils.INSTRUCTION_ENUM;
import myNavigator.mapUtils.MyMap;
import myNavigator.mapUtils.Zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Strategy for getting cleaning path.
 */
public class GetCleanPath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        ArrayList<Zone> zoneList = map.getZoneList();
        Stack<MyPosition> pointsToVisit = new Stack<>();

        MyPosition topBound;
        MyPosition bottomBound;
        MyPath myPath = new MyPath();

        //Set start variables
        int startX = x;
        int startY = y;

        for (Zone zone : zoneList) {
            // Ignore No-Go zones
            if (zone.getInstructionList().contains(INSTRUCTION_ENUM.NO_GO)) break;

            //set zone bounds
            topBound = zone.getTopBound();
            bottomBound = zone.getBottomBound();

            pointsToVisit.clear();

            //add must visit points within bounds
            for (int i = topBound.y; i < bottomBound.y; i++){
                for (int j = topBound.x; j < bottomBound.x; j++)
                {
                   if (map.getBlockAt(i,j).getClass()== FloorBlock.class && (!matrix[i][j].equals(matrix[x][y]))) pointsToVisit.add(new MyPosition(i,j));
                }
            }

            MyPosition destination;

            //Continue until all points are visited
            while (!pointsToVisit.isEmpty()){
                destination = pointsToVisit.pop();

                //Marks Destination and start
                matrix[destination.x][destination.y] = new DestinationBlock();
                setStart(startX,startY);

                //Gets Path
                MyPosition[] subPath = getPathDFS();

                //Path post-processing
                if (subPath!=null) {
                    //Removes duplicate finish-start position
                    subPath = Arrays.copyOf(subPath, subPath.length - 1);
                    //Removes visited points
                    for (MyPosition myPosition : subPath) {
                        pointsToVisit.remove(myPosition);
                    }

                    startX = destination.y;
                    startY = destination.x;
                }
                myPath.addPath(subPath);

                matrix[destination.x][destination.y] = new FloorBlock();
            }
            myPath.finalizePath();
            myPath.setInstructions(zone.getInstructionList());
        }
        return myPath;
    }

    /**
     * Inner IBlock class to mark Destination for
     * Path finding algorithm
     */
    static class DestinationBlock extends FloorBlock{
    }

    /**
     *
     * @param position to be checked
     * @return true - found destination
     */
    @Override
    boolean endFound(MyPosition position) {
        return matrix[position.y][position.x].getClass() == DestinationBlock.class;
    }
}

