package myNavigator.pathUtils;

import myNavigator.blocks.FloorBlock;
import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;
import myNavigator.common.MyPosition;
import myNavigator.mapUtils.MyMap;
import myNavigator.mapUtils.Zone;

import java.util.ArrayList;
import java.util.Vector;

public class GetCleanPath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        ArrayList<Zone> zoneList = map.getZoneList();
        Vector<IBlock> pointsToVisit = new Vector<>();

        MyPosition topBound;
        MyPosition bottomBound;

        for (Zone zone : zoneList) {
            topBound = zone.getTopBound();
            bottomBound = zone.getBottomBound();
            pointsToVisit.clear();

            for (int i = topBound.x; i < bottomBound.x; i++){
                for (int j = topBound.y; j < bottomBound.y; j++)
                {
                   if (map.getBlockAt(i,j).getClass()== FloorBlock.class) pointsToVisit.add(matrix[i][j]);
                }
                if (map.getBlockAt(x,y).getClass()==FloorBlock.class) pointsToVisit.remove(map.getBlockAt(x,y));
            }
        }
        return null;
    }

    static class DestinationBlock extends FloorBlock{
    }

    @Override
    boolean endFound(MyPosition position) {
        return matrix[position.y][position.x].getClass() == DestinationBlock.class;
    }
}

