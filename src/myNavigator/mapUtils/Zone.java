package myNavigator.mapUtils;

import myNavigator.commonUtils.MyPosition;

import java.util.ArrayList;

/**
 * User specified zone with its area bounds
 * specified instructions
 */
public class Zone {
    private final String zoneName;
    private ArrayList<INSTRUCTION_ENUM> instructionList;
    private MyPosition topBound;
    private MyPosition bottomBound;

    /**
     * Create zone with multiple instructions
     * @param name of zone
     * @param list of instructions
     */
    public Zone (String name, ArrayList<INSTRUCTION_ENUM> list){
        this.zoneName = name;
        this.instructionList = list;
    }

    /**
     * Create zone with single instruction
     * @param name of zone
     * @param instruction singular instruction
     */
    public Zone (String name, INSTRUCTION_ENUM instruction){
        this.zoneName = name;
        instructionList = new ArrayList<>();
        instructionList.add(instruction);
    }

    public void setInstructionList(ArrayList<INSTRUCTION_ENUM> list){
        this.instructionList = list;
    }

    public ArrayList<INSTRUCTION_ENUM> getInstructionList(){
        return instructionList;
    }

    /**
     * Sets the bounds for zone area.
     * @param top left top most bound
     * @param bottom right bottom most bound
     */
    public void setBounds(MyPosition top, MyPosition bottom){
        topBound = top;
        bottomBound = bottom;
    }

    public MyPosition getTopBound(){
        return topBound;
    }

    public MyPosition getBottomBound(){
        return bottomBound;
    }
}
