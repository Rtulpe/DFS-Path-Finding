package myNavigator.blocks;

public class ObstacleBlock extends AbstractBlock {
    @Override
    public IBlock createBlock() {
        return this;
    }

    @Override
    public String toString(){
        return "X";
    }
}
