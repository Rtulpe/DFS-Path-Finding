package myNavigator.blocks;

public class EmptyBlock extends AbstractBlock {
    @Override
    public IBlock createBlock() {
        return this;
    }
}
