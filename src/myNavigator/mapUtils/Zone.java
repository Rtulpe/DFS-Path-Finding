package myNavigator.mapUtils;

import myNavigator.common.MyPosition;

import java.util.ArrayList;

public class Zone {
    private String zoneName;
    private ArrayList<INSTRUCTION_ENUM> instructionList;
    private MyPosition topBound;
    private MyPosition bottomBound;

    public Zone (String name, ArrayList<INSTRUCTION_ENUM> list){
        this.zoneName = name;
        this.instructionList = list;
    }

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
