package android.codelabs.canadiandemocracy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("previous")
    @Expose
    private java.lang.Object previous;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("next")
    @Expose
    private String next;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public java.lang.Object getPrevious() {
        return previous;
    }

    public void setPrevious(java.lang.Object previous) {
        this.previous = previous;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
