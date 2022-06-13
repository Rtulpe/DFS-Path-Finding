package server.commonUtils;

import java.util.Random;

/**
 * Used for getting radar data.
 * This class is a singleton, in order to avoid
 * reading conflicting data.
 */
public class RadarInfo {
    private static RadarInfo instance = null;
    private static short data;

    private RadarInfo(){}

    public static RadarInfo getInstance(){
        if (instance == null) instance = new RadarInfo();
        return instance;
    }

    /**
     * This class should be getting radar data
     * from the hardware, however, there is no
     * hardware, thus random data is used.
     */
    private void refreshData(){
        Random random = new Random();
        int max = 255;

        data = (short) random.nextInt(max + 1);
    }

    public short getData(){
        refreshData();
        return data;
    }
}
