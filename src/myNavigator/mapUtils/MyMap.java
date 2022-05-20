package myNavigator.mapUtils;

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

    @Override
    public String toString(){
        String outString = "";

        for (IBlock[] iBlocks : map) {
            for (IBlock index : iBlocks) {
                outString += index;
            }
            outString += "\n";
        }
        return outString;
    }
}
