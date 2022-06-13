package server.blocks;

/**
 * Unknown block, caused by radar signal not returning.
 */
public class EmptyBlock implements IBlock {

    @Override
    public String toString(){
        return "0";
    }
}
