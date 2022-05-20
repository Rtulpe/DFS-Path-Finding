package myNavigator.mapUtils;

import myNavigator.blocks.IBlock;
import myNavigator.common.PositionMapper;
import myNavigator.common.RadarInfo;

public class MapUpdater {
    private MyMap myMap;
    private PositionMapper mapper;
    private RadarInfo info;

    public MapUpdater(MyMap inputMyMap){
        this.myMap = inputMyMap;
        this.info = RadarInfo.getInstance();
        this.mapper = PositionMapper.getInstance();
    }

    public void updateMap(){

    }

    public IBlock checkOrCreate(int x, int y, IBlock blockType){

        return blockType;
    }

    public MyMap getMap() {
        return myMap;
    }
}
