package apiEngine.Routes;

import java.lang.reflect.Field;

public class InternalVendorRoute {
    private static final String API = "/api";
    private static final String VERSION = "/v1";
    private static final String VENDOR = "/vendor/{vendorId}";
    private static final String BASIC = "/basic";
    private static final String CLOSE = "/close";
    private static final String OPEN = "/open";
    private static final String PAYMENT_TYPES = "/payment-types";
    private static final String WORKING_DAYS = "/working-days";

    public static String getVendor() {
        return API + VERSION + VENDOR;
    }

    public static String getVendorBasic(){
       return getVendor() + BASIC;
    }

    public static String closeVendor(){
        return getVendor() + CLOSE;
    }

    public static String openVendor(){
        return getVendor() + OPEN;
    }

    public static String vendorPaymentTypes(){
        return getVendor() + PAYMENT_TYPES;
    }

    public static String getWorkingDay(){
        return getVendor() + WORKING_DAYS;
    }

}


