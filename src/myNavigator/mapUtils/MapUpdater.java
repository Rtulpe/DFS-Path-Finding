package myNavigator.mapUtils;

import myNavigator.blocks.EmptyBlock;
import myNavigator.blocks.FloorBlock;
import myNavigator.blocks.IBlock;
import myNavigator.blocks.ObstacleBlock;
import myNavigator.common.PositionMapper;
import myNavigator.common.RadarInfo;

public class MapUpdater {
    private MyMap myMap;
    private PositionMapper mapper;
    private RadarInfo info;

    /**
     * This constructor would be used in Travel case
     * @param inputMyMap
     */
    public MapUpdater(MyMap inputMyMap){
        this.myMap = inputMyMap;
        this.info = RadarInfo.getInstance();
        this.mapper = PositionMapper.getInstance();
    }

    public MapUpdater(int size){
        this.myMap = new MyMap("new Map", size);
        this.info = RadarInfo.getInstance();
        this.mapper = PositionMapper.getInstance();
        System.out.println(mapper);
    }

    public void updateMap(){
        int x = mapper.x;
        int y = mapper.y;
        short data = info.getData();

        IBlock block = data < 10 ? new EmptyBlock() : data > 200 ? new ObstacleBlock() : new FloorBlock();

        checkOrCreate(x,y, block);
    }

    public void checkOrCreate(int x, int y, IBlock block){
        if (myMap.check(x,y,block)){
            return;
        }
        else {
            myMap.update(x,y,block);
        }
    }

    public MyMap getMap() {
        return myMap;
    }

}
