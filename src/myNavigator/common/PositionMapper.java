package myNavigator.common;

import myNavigator.blocks.IBlock;

import java.util.ArrayList;

public class PositionMapper extends ICoordinates {
    private static PositionMapper instance = null;
    private static IBlock position;
    Integer xCoord = null;
    Integer yCoord = null;

    private PositionMapper(){}

    public static PositionMapper getInstance(){
        if (instance == null) instance = new PositionMapper();
        return instance;
    }

    /**
     * Unimplemented: with the robot moving, robot's position would change
     * requiring for a refresh.
     * However, with this prototype, robot will remain static
     */
    public void refreshPosition(){
       // in here we would get the updated position
    }

    public ArrayList<Integer> getPosition(){
        ArrayList<Integer> retList = new ArrayList<>();
        retList.add(xCoord);
        retList.add(yCoord);
        return retList;
    }

    public void setPosition(int x, int y){
        this.xCoord = x;
        this.yCoord = y;

    }
}
