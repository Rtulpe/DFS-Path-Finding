package myNavigator.common;

import myNavigator.blocks.IBlock;

public class PositionMapper extends ICoordinates {
    private static PositionMapper instance = null;
    private static IBlock position;
    private static POSITION_ENUM robotRotation;

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

    public POSITION_ENUM getRotation() { return robotRotation; }
}
