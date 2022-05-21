package myNavigator.pathUtils;

import myNavigator.common.MyPosition;
import myNavigator.mapUtils.MyMap;
import myNavigator.mapUtils.Zone;

import java.util.ArrayList;

public class GetCleanPath extends GetAbstractPath implements PathMakerStrategy{

    @Override
    public MyPath getPath(MyMap map, int x, int y) {
        matrix = map.get2DMap();
        ArrayList<Zone> zoneList = map.getZoneList();
        ArrayList<MyPosition> pointsToVisit = new ArrayList<>();

        MyPosition topBound;
        MyPosition bottomBound;

        for (Zone zone : zoneList) {
            topBound = zone.getTopBound();
            bottomBound = zone.getBottomBound();




        }
        return null;
    }
}

