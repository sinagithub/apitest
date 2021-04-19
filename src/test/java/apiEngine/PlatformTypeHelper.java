package apiEngine;

public class PlatformTypeHelper {
    private String platformType;
    private static PlatformTypeHelper instance = null;

    private PlatformTypeHelper() {
    }

    public static PlatformTypeHelper getInstance() {
        if (instance == null) {
            instance = new PlatformTypeHelper();
        }
        return instance;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }
}
