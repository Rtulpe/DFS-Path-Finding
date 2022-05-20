package myNavigator.mapUtils;

public enum INSTRUCTION_ENUM {
    NO_GO(0x0),
    HARD_CLEAN(0x1),
    SOFT_CLEAN(0x2),
    FAST_CLEAN(0x3),
    SLOW_CLEAN(0x4),
    NULL(0xF);

    private final int hexCode;

    INSTRUCTION_ENUM(int code){
        this.hexCode = code;
    }

    public int getHex(){
        return hexCode;
    }
    }
