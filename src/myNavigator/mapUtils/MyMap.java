package myNavigator.mapUtils;

import myNavigator.blocks.HomeBlock;
import myNavigator.blocks.IBlock;
import myNavigator.commonUtils.MyPosition;

import java.util.ArrayList;

/**
 * Map class. Consists of 2D IBlock array for map representation.
 * @see IBlock
 */
public class MyMap {
    private final String mapName;
    private final ArrayList<Zone> zoneList;
    private final IBlock[][] map;

    /**
     * Instantiates square map
     * @param name name of map
     * @param size x:x size of map
     */
    public MyMap(String name, int size){
        this.mapName = name;
        this.map = new IBlock[size][size];
        Zone defaultZone = new Zone("default",INSTRUCTION_ENUM.NULL);

        MyPosition topBound = new MyPosition(0,0);
        MyPosition bottomBound = new MyPosition(size,size);


        defaultZone.setBounds(topBound,bottomBound);
        zoneList = new ArrayList<>();
        zoneList.add(defaultZone);
    }

    /**
     * Instanciates x by y sized map
     * @param name of the map
     * @param x width
     * @param y height
     */
    public MyMap(String name, int x, int y){
        this.mapName = name;
        this.map = new IBlock[y][x];
        Zone defaultZone = new Zone("default", INSTRUCTION_ENUM.NULL);

        MyPosition topBound = new MyPosition(0,0);
        MyPosition bottomBound = new MyPosition(x,y);

        defaultZone.setBounds(topBound,bottomBound);
        zoneList = new ArrayList<>();
        zoneList.add(defaultZone);
    }

    public void setHome(int x, int y) {
        map[y][x] = new HomeBlock();
    }

    public MyMap getMapCopy() throws CloneNotSupportedException {
        return (MyMap) this.clone();
    }

    /**
     * Update the block with different one
     * Note: This happens to be inverse. I will not touch it
     * as it breaks map generation for some reason
     * @param x array row
     * @param y array column
     * @param block block to be added at the position
     */
    public void update(int x, int y, IBlock block){
        map[x][y] = block;
    }

    /**
     * Checks if certain type of Block at x:y exists
     * @param x position
     * @param y position
     * @param block block type to be checked
     * @return true - exists
     */
    public boolean check(int x, int y, IBlock block){
        if (map[x][y]==null) return false;
        return map[x][y].getClass() == block.getClass();
    }

    public IBlock[][] get2DMap(){
        return map;
    }

    public IBlock getBlockAt(int x, int y){
        return map[x][y];
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
