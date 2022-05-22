package myNavigator.pathUtils;

import myNavigator.common.PositionMapper;
import myNavigator.mapUtils.MyMap;

/**
 * Class responsible for selecting path finding strategy
 */
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

    /**
     * Sets the path finding strategy.
     * @param isHomePath true - requests home path, false - requests cleaning path.
     * @return calculated path
     */
    public MyPath requestPath(boolean isHomePath){
        pathStrategy = isHomePath ? new GetHomePath() : new GetCleanPath();
        return pathStrategy.getPath(map, mapper.x, mapper.y);
    }

}
