package apiEngine.Utilies;
import java.util.UUID;

public class GuidHelper {
    private String guid;
    private static GuidHelper instance = null;

    private GuidHelper() {
    }

    public static GuidHelper getInstance() {
        if (instance == null) {
            instance = new GuidHelper();
        }
        return instance;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid() {
        UUID uuid = UUID.randomUUID();
        this.guid = uuid.toString();
    }
}
