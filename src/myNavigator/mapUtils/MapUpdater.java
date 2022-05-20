package myNavigator.mapUtils;

import myNavigator.blocks.IBlock;
import myNavigator.common.PositionMapper;
import myNavigator.common.RadarInfo;

public class MapUpdater {
    private Map map;
    private PositionMapper mapper;
    private RadarInfo info;

    public MapUpdater(Map inputMap){
        this.map = inputMap;
        this.info = RadarInfo.getInstance();
        this.mapper = PositionMapper.getInstance();
    }

    public void updateMap(){

    }

    public IBlock checkOrCreate(int x, int y, IBlock blockType){

        return blockType;
    }

    public Map getMap() {
        return map;
    }
}
