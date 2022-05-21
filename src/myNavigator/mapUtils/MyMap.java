package myNavigator.mapUtils;

import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;

import java.util.ArrayList;

public class MyMap {
    private final String mapName;
    private ArrayList<Zone> zoneList;
    private final IBlock[][] map;

    public MyMap(String name, int size){
        this.mapName = name;
        this.map = new IBlock[size][size];
        Zone defaultZone = new Zone("default",INSTRUCTION_ENUM.NULL);
        defaultZone.setBounds(0,0,size,size);
    }

    public void setHome(int x, int y) {
        map[x][y] = new HomeBlock();
    }

    public MyMap getMapCopy() throws CloneNotSupportedException {
        return (MyMap) this.clone();
    }

    public void update(int x, int y, IBlock block){
        map[x][y] = block;
    }

    public boolean check(int x, int y, IBlock block){
        if (map[x][y]==null) return false;
        return map[x][y].getClass() == block.getClass();
    }

    public IBlock get(int x, int y){
        return map[x][y];
    }

    public IBlock[][] get2DMap(){
        return map;
    }

    @Override
    public String toString(){
        StringBuilder outString = new StringBuilder();

        outString.append(mapName).append("\n");

        for (IBlock[] iBlocks : map) {
            for (IBlock index : iBlocks) {
                outString.append(index).append(" ");
            }
            outString.append("\n");
        }
        return outString.toString();
    }
}
