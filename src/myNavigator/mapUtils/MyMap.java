package myNavigator.mapUtils;

import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;
import myNavigator.common.MyPosition;

import java.util.ArrayList;

public class MyMap {
    private final String mapName;
    private ArrayList<Zone> zoneList;
    private final IBlock[][] map;

    public MyMap(String name, int size){
        this.mapName = name;
        this.map = new IBlock[size][size];
        Zone defaultZone = new Zone("default",INSTRUCTION_ENUM.NULL);

        MyPosition topBound = new MyPosition(0,0);
        MyPosition bottomBound = new MyPosition(size,size);


        defaultZone.setBounds(topBound,bottomBound);
    }

    public MyMap(String name, int x, int y){
        this.mapName = name;
        this.map = new IBlock[y][x];
        Zone defaultZone = new Zone("default", INSTRUCTION_ENUM.NULL);

        MyPosition topBound = new MyPosition(0,0);
        MyPosition bottomBound = new MyPosition(x,y);

        defaultZone.setBounds(topBound,bottomBound);
    }

    public void setHome(int x, int y) {
        map[y][x] = new HomeBlock();
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

    public IBlock[][] get2DMap(){
        return map;
    }

    public ArrayList<Zone> getZoneList() {
        return zoneList;
    }

    public int getXSize(){
        return map.length;
    }

    public int getYSize(){
        return map[0].length;
    }

    @Override
    public String toString(){
        StringBuilder outString = new StringBuilder();

        outString.append(mapName).append("\n");

        for (IBlock[] iBlocks : map) {
            for (IBlock index : iBlocks) {
                outString.append(index).append("  ");
            }
            outString.append("\n");
        }
        return outString.toString();
    }
}
