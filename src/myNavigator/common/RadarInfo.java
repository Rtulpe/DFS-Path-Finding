package myNavigator.common;

public class RadarInfo {
    private static RadarInfo instance = null;
    private static byte data[];

    private RadarInfo(){}

    public static RadarInfo getInstance(){
        return instance == null ? new RadarInfo() : instance;
    }

    public void refreshData(){
        // TODO: 5/20/22 implement data
    }

    public byte[] getData(){
        return data;
    }
}
