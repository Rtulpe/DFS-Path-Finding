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
     * @param inputMyMap use already generated map
     */
    public MapUpdater(MyMap inputMyMap){
        this.myMap = inputMyMap;
        this.info = RadarInfo.getInstance();
        this.mapper = PositionMapper.getInstance();
    }

    public MapUpdater(int size){
        this.myMap = new MyMap("Default Square Map", size);
        this.info = RadarInfo.getInstance();
        this.mapper = PositionMapper.getInstance();
    }

    public MapUpdater(int xSize, int ySize){
        this.myMap = new MyMap("Default Rectangle Map",xSize,ySize);
        this.info = RadarInfo.getInstance();
        this.mapper = PositionMapper.getInstance();
    }

    public void generateRandomMap(){
        for (int x = 0; x < myMap.getXSize(); x++){
            for (int y = 0; y < myMap.getYSize(); y++){
                mapper.setPosition(x,y);
                updateMap();
            }
        }
    }

    public void updateMap(){
        int x = mapper.x;
        int y = mapper.y;
        short data = info.getData();

        IBlock block = data < 10 ? new EmptyBlock() : data > 200 ? new ObstacleBlock() : new FloorBlock();

        checkOrCreate(x,y, block);
    }

    /**
     *
     * @param x position
     * @param y position
     * @param block to be checked
     */
    public void checkOrCreate(int x, int y, IBlock block){
        if (!myMap.check(x,y,block)){
            myMap.update(x,y,block);
        }
    }

    public MyMap getMap() {
        return myMap;
    }

}
