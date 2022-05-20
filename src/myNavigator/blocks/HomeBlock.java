package myNavigator.blocks;

public class HomeBlock extends AbstractBlock {
    @Override
    public IBlock createBlock() {
        return this;
    }

    @Override
    public String toString(){
        return "H";
    }
}
