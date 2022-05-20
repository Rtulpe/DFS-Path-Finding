package myNavigator.common;

import myNavigator.blocks.IBlock;

public class PositionMapper {
    private static PositionMapper instance = null;
    private static IBlock position;
    private static POSITION_ENUM robotRotation;

    private PositionMapper(){}

    public static PositionMapper getInstance(){
        return instance == null ? new PositionMapper() : instance;
    }

    /**
     * Unimplemented: with the robot moving, robot's position would change
     * requiring for a refresh.
     * However, with this prototype, robot will remain static
     */
    public void refreshPosition(){
       // in here we would get the updated position
    }

    public IBlock getPosition(){
        return position;
    }

    public POSITION_ENUM getRotation() { return robotRotation; }
}
