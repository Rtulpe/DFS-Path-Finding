package myNavigator.pathUtils;

import myNavigator.blocks.IBlock;
import myNavigator.mapUtils.INSTRUCTION_ENUM;

import java.util.ArrayList;
import java.util.Vector;

public class MyPath {
    private ArrayList<INSTRUCTION_ENUM> instructions;
    private Vector<IBlock> pathVector;

    public MyPath(ArrayList<INSTRUCTION_ENUM> instruction){
        this.instructions = instruction;
        pathVector = new Vector<>();
    }

    public MyPath(){
        pathVector = new Vector<>();
    }

    public void addPoint(IBlock point){
        pathVector.add(point);
    }

    public void removePoint(IBlock point){
        pathVector.remove(point);
    }

    public Vector<IBlock> getVector(){
        return pathVector;
    }
}
