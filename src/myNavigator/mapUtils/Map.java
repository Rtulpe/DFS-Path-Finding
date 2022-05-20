package myNavigator.mapUtils;

import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;

import java.util.ArrayList;

class Map {
    private String mapName;
    private ArrayList<Zone> zoneList;
    private IBlock homeBlock;

    public Map(String name, ArrayList<Zone> zones){
        this.mapName = name;
        this.zoneList = zones;
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

    public Map getMapCopy() throws CloneNotSupportedException {
        return (Map) this.clone();
    }
}
