package myNavigator.common;

public enum POSITION_ENUM {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public POSITION_ENUM invertPosition(){
        POSITION_ENUM retEnum;
        switch (this) {
            case NORTH:
                retEnum = SOUTH;
                break;
            case EAST:
                retEnum = WEST;
                break;
            case SOUTH:
                retEnum = NORTH;
                break;
            case WEST:
                retEnum = EAST;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
        return retEnum;
    }
}
