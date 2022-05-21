package myNavigator.mapUtils;

import java.util.ArrayList;

public class Zone {
    private String zoneName;
    private ArrayList<INSTRUCTION_ENUM> instructionList;
    int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

    public Zone (String name, ArrayList<INSTRUCTION_ENUM> list){
        this.zoneName = name;
        this.instructionList = list;
    }

    public Zone (String name, INSTRUCTION_ENUM instruction){
        instructionList = new ArrayList<>();
        instructionList.add(instruction);
    }

    public void setInstructionList(ArrayList<INSTRUCTION_ENUM> list){
        this.instructionList = list;
    }

    public ArrayList<INSTRUCTION_ENUM> getInstructionList(){
        return instructionList;
    }

    public void setBounds(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public boolean isInBounds(int x, int y){
        return (x>=x1&&x<=x2)&&(y>=y1&&y<=y2);
    }
}
