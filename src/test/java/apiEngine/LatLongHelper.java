package apiEngine;

public class LatLongHelper {
    private double latitude;
    private double longitude;
    private static LatLongHelper instance = null;

    private LatLongHelper() {
    }

    public static LatLongHelper getInstance() {
        if (instance == null) {
            instance = new LatLongHelper();
        }
        return instance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
