package myNavigator.blocks;

import myNavigator.common.POSITION_ENUM;

public interface IBlock{
    public IBlock createBlock();
    public void linkUp(IBlock neighbor, POSITION_ENUM side);
    public void linkUpNoSwap(IBlock neighbor, POSITION_ENUM side);
}
