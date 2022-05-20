package myNavigator.blocks;

public abstract class AbstractBlock implements IBlock {
    private IBlock NORTH;
    private IBlock EAST;
    private IBlock SOUTH;
    private IBlock WEST;

    AbstractBlock (){
        NORTH =  new EmptyBlock();
        EAST =  new EmptyBlock();
        SOUTH =  new EmptyBlock();
        WEST =  new EmptyBlock();
    }

    public void setNeighbors(IBlock north, IBlock east, IBlock south, IBlock west){
        this.NORTH = north!= null ? north : NORTH;
        this.EAST = east!= null ? east : EAST;
        this.SOUTH = south!= null ? south : SOUTH;
        this.WEST = west!= null ? west : WEST;
    }
}
