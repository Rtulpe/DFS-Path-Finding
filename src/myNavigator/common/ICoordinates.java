package myNavigator.common;

import java.util.ArrayList;

public abstract class ICoordinates{
    Integer xCoord = null;
    Integer yCoord = null;

    ArrayList<Integer> getPosition(){
        ArrayList<Integer> retList = new ArrayList<>();
        retList.add(xCoord);
        retList.add(yCoord);
        return retList;
    }

    void setPosition(int x, int y){
        this.xCoord = x;
        this.yCoord = y;

    }
}
