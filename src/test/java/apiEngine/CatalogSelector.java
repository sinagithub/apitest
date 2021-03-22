package apiEngine;

public class CatalogSelector {
    private String catalogName;
    private static CatalogSelector instance = null;

    private CatalogSelector() {
    }

    public static CatalogSelector getInstance() {
        if (instance == null) {
            instance = new CatalogSelector();
        }
        return instance;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
}
