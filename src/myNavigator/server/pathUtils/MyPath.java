package myNavigator.server.pathUtils;

import myNavigator.server.commonUtils.MyPosition;
import myNavigator.server.mapUtils.INSTRUCTION_ENUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 *  Path unit used by the Travel Use Case.
 *  Nested Lists for instructions and pathVectors
 *  were introduced, each zone could have
 *  its own cleaning path.
 */
public class MyPath {
    private final ArrayList<ArrayList<INSTRUCTION_ENUM>> instructions;
    private final ArrayList<Vector<MyPosition>> pathVector;
    private Vector<MyPosition> singlePath = null;

    public MyPath(ArrayList<INSTRUCTION_ENUM> instruction){
        instructions = new ArrayList<>();
        instructions.add(instruction);
        pathVector = new ArrayList<>();
    }

    public MyPath(){
        instructions = new ArrayList<>();
        pathVector = new ArrayList<>();
    }

    /**
     * Add positions to singular path
     * @param path to be added
     */
    void addPath(MyPosition[] path){
        if (path == null){
            return;
        }
        if (singlePath == null) singlePath = new Vector<>();
        singlePath.addAll(Arrays.asList(path));
    }

    /**
     * Finish singular path
     */
    void finalizePath(){
        if (singlePath == null) return;
        pathVector.add(singlePath);
        singlePath = null;
    }

    /**
     * Not used, but will be used for Travel Use Case
     * @return length of the calculated path
     */
    public int getPathLength(){
        return pathVector.size();
    }

    public void setInstructions(ArrayList<INSTRUCTION_ENUM> instruction_enums){
        instructions.add(instruction_enums);
    }

    public void setSingleInstruction(INSTRUCTION_ENUM instruction_enum){
        ArrayList<INSTRUCTION_ENUM> ins = new ArrayList<>();
        ins.add(instruction_enum);
        instructions.add(ins);
    }

    public ArrayList<ArrayList<INSTRUCTION_ENUM>> getInstructions(){
        return this.instructions;
    }

    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        int i = 0;
        if (pathVector.isEmpty()) return "No Path Found!\n";

        for (Vector<MyPosition> ignored : pathVector) {
            retString.append("Zone: ").append(i).append("\n");
            retString.append("With instructions: ").append(instructions.get(i)).append("\n");
            retString.append(pathVector.get(i));
            i++;
        }
        return retString.toString();
    }
}
