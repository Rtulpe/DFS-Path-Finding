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

    public MyPath requestPath(boolean isHomePath){
        pathStrategy = isHomePath ? new GetHomePath() : new GetCleanPath();
        return pathStrategy.getPath(map, mapper.getPosition());
    }
}
