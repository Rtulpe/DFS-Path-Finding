package myNavigator.server.commonUtils;

/**
 * Responsible for tracking robot's position relative to the map.
 * This class is a singleton, as changes in Robot's position
 * should reflect on all other classes using the singular object.
 */
public class PositionMapper extends MyPosition {
    private static PositionMapper instance = null;

    /**
     * Instantiates with position set to 0:0;
     */
    private PositionMapper(){
        super(0,0);
    }

    /**
     *
     * @return single instance of the class
     */
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

    /**
     * Used for artificially "moving" the robot.
     * @param x X position
     * @param y Y position
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
