package myNavigator.mapUtils;

import myNavigator.blocks.IBlock;

import java.util.ArrayList;

public class Zone {
    private String zoneName;
    private ArrayList<INSTRUCTION_ENUM> instructionList;
    private ArrayList<IBlock> blockList;

    public Zone (String name, ArrayList<INSTRUCTION_ENUM> list){
        this.zoneName = name;
        this.instructionList = list;
    }

    public void setInstructionList(ArrayList<INSTRUCTION_ENUM> list){
        this.instructionList = list;
    }

    public void setBlockList(ArrayList<IBlock> blocks){
        this.blockList = blocks;
    }

    public ArrayList<IBlock> getBlockList(){
        return this.blockList;
    }

    public ArrayList<IBlock> searchForBlocks(IBlock blockType){
        ArrayList<IBlock> retList = new ArrayList<>();
        for (IBlock iBlock : blockList) {
            if (iBlock.getClass() == blockType.getClass()) retList.add(iBlock);
        }
    return retList;
    }
}
