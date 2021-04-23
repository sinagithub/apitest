package apiEngine.models.response.Vendor;


import java.util.List;
import javax.annotation.Generated;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Version",
        "InfoList",
        "Data",
        "TotalCount",
        "PageIndex",
        "PageSize",
        "HasNext",
        "HasPrev",
        "TotalPageCount"
})
@Generated("jsonschema2pojo")
public class VendorProductSearchResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;
    @JsonProperty("Data")
    private List<Product> products = null;
    @JsonProperty("TotalCount")
    private Integer totalCount;
    @JsonProperty("PageIndex")
    private Integer pageIndex;
    @JsonProperty("PageSize")
    private Integer pageSize;
    @JsonProperty("HasNext")
    private Boolean hasNext;
    @JsonProperty("HasPrev")
    private Boolean hasPrev;
    @JsonProperty("TotalPageCount")
    private Integer totalPageCount;

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("InfoList")
    public List<Info> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    @JsonProperty("Data")
    public List<Product> getData() {
        return products;
    }

    @JsonProperty("Data")
    public void setData(List<Product> data) {
        this.products = data;
    }

    @JsonProperty("TotalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("TotalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("PageIndex")
    public Integer getPageIndex() {
        return pageIndex;
    }

    @JsonProperty("PageIndex")
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    @JsonProperty("PageSize")
    public Integer getPageSize() {
        return pageSize;
    }

    @JsonProperty("PageSize")
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("HasNext")
    public Boolean getHasNext() {
        return hasNext;
    }

    @JsonProperty("HasNext")
    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    @JsonProperty("HasPrev")
    public Boolean getHasPrev() {
        return hasPrev;
    }

    @JsonProperty("HasPrev")
    public void setHasPrev(Boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    @JsonProperty("TotalPageCount")
    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    @JsonProperty("TotalPageCount")
    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

}
