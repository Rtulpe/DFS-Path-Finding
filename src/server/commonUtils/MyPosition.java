package server.commonUtils;

/**
 * Basic coordinate unit used for navigation.
 * Previously ICoordinate.
 */
public class MyPosition {
    public int x;
    public int y;

    /**
     * Constructor
     * @param x position
     * @param y position
     */
    public MyPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyPosition other = (MyPosition) obj;
        if (x != other.x)
            return false;
        return y == other.y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
