package myNavigator.pathUtils;

import myNavigator.common.PositionMapper;
import myNavigator.mapUtils.MyMap;

/**
 * Class responsible for selecting path-cleaning strategy
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
     *
     * @param isHomePath true - requests home path, false - requests cleaning path.
     * @return calculated path
     */
    public MyPath requestPath(boolean isHomePath){
        pathStrategy = isHomePath ? new GetHomePath() : new GetCleanPath();
        return pathStrategy.getPath(map, mapper.x, mapper.y);
    }

}
