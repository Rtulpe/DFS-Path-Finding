package myNavigator.blocks;

import myNavigator.common.POSITION_ENUM;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class AbstractBlock implements IBlock {
    private IBlock North = null;
    private IBlock East = null;
    private IBlock South = null;
    private IBlock West = null;

    AbstractBlock (){}

    public void linkUp(IBlock neighbor, POSITION_ENUM side){
        linkUpNoSwap(neighbor,side);
        neighbor.linkUpNoSwap(this,side.invertPosition());
    }

    public void linkUpNoSwap(IBlock neighbor, @NotNull POSITION_ENUM side){
        switch (side) {
            case NORTH:
                this.North = neighbor;
                break;
            case EAST:
                this.East = neighbor;
                break;
            case SOUTH:
                this.South = neighbor;
                break;
            case WEST:
                this.West = neighbor;
                break;
        }
    }

    public ArrayList<IBlock> getNeighbors(){
        ArrayList<IBlock> retList = new ArrayList<>();
        if (North != null) retList.add(North);
        if (East != null) retList.add(East);
        if (South != null) retList.add(South);
        if (West != null) retList.add(West);
        return retList;
    }

    public String getNeighborsString(){
        return "North: "+North+"  East: "+East+"  South: "+South+"  West: "+West;
    }
}
