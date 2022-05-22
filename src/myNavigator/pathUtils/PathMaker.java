package myNavigator.pathUtils;

import myNavigator.common.PositionMapper;
import myNavigator.mapUtils.MyMap;

public class PathMaker {
    MyMap map;
    PositionMapper mapper;
    PathMakerStrategy pathStrategy;

    public PathMaker(MyMap mapIn){
        this.map = mapIn;
        this.mapper = PositionMapper.getInstance();
    }

    public void setMap(MyMap mapIn){
        this.map = mapIn;
    }

    public MyPath requestPath(boolean isHomePath){
        pathStrategy = isHomePath ? new GetHomePath() : new GetCleanPath();
        return pathStrategy.getPath(map, mapper.x, mapper.y);
    }

}
