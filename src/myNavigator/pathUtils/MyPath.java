package myNavigator.pathUtils;

import myNavigator.common.MyPosition;
import myNavigator.mapUtils.INSTRUCTION_ENUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class MyPath {
    private ArrayList<INSTRUCTION_ENUM> instructions;
    private Vector<MyPosition> pathVector;

    public MyPath(ArrayList<INSTRUCTION_ENUM> instruction){
        this.instructions = instruction;
        pathVector = new Vector<>();
    }

    public MyPath(){
        pathVector = new Vector<>();
    }

    void addPath(MyPosition[] path){
        if (path == null){
            return;
        }
        pathVector.addAll(Arrays.asList(path));
    }

    public int getPathLength(){
        return pathVector.size();
    }

    public void setInstructions(ArrayList<INSTRUCTION_ENUM> instruction_enums){
        this.instructions = instruction_enums;
    }

    public ArrayList<INSTRUCTION_ENUM> getInstructions(){
        return this.instructions;
    }

    @Override
    public String toString(){
        return !pathVector.isEmpty() ? "Path:"+ pathVector : "No Path Found!";
    }
}
