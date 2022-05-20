package myNavigator.blocks;

public class FloorBlock extends AbstractBlock {
    @Override
    public IBlock createBlock() {
        return this;
    }

    @Override
    public String toString(){
        return "+";
    }
}
