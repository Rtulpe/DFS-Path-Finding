package myNavigator.common;

import myNavigator.blocks.IBlock;

import java.util.ArrayList;

public class PositionMapper extends MyPosition {
    private static PositionMapper instance = null;

    private PositionMapper(){
        super(0,0);
    }

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

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
