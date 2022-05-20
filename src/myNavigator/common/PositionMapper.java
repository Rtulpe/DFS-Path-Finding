package myNavigator.common;

public class PositionMapper extends ICoordinates {
    private static PositionMapper instance = null;

    private PositionMapper(){}

    public static PositionMapper getInstance(){
        return instance == null ? new PositionMapper() : instance;
    }

    public void refreshPosition(){
        // TODO: 5/20/22 add refresh position
    }
}
