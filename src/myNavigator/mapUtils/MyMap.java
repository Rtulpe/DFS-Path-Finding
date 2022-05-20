package myNavigator.mapUtils;

import myNavigator.blocks.AbstractBlock;
import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;
import myNavigator.common.POSITION_ENUM;

import java.util.ArrayList;

public class MyMap {
    private String mapName;
    private ArrayList<Zone> zoneList;
    private IBlock homeBlock;
    private IBlock[][] map;

    public MyMap(String name, IBlock[][] mapInput){
        this.mapName = name;
        this.map = mapInput;
        setHome();
    }

    public MyMap(String name, int size){
        this.mapName = name;
        this.map = new IBlock[size][size];
    }

    void setHome() {
        try{
            IBlock home;
            ArrayList<IBlock> tmpList = new ArrayList<>();
            for (Zone zone : zoneList) {
                tmpList.addAll(zone.searchForBlocks(new HomeBlock()));
            }
            if (tmpList.size() != 1)throw new RuntimeException();
            else home = tmpList.get(0);

        } catch (Exception e){
            System.out.println("Unable to set home : " + e.getMessage());
        }
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

    @Override
    public String toString(){
        String outString = "";

        for (IBlock[] iBlocks : map) {
            for (IBlock index : iBlocks) {
                outString += index + " ";
            }
            outString += "\n";
        }
        return outString;
    }
}
