package android.codelabs.canadiandemocracy.representativeSetsData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Related {

    @SerializedName("boundaries_url")
    @Expose
    private String boundariesUrl;
    @SerializedName("boundary_set_url")
    @Expose
    private String boundarySetUrl;
    @SerializedName("representatives_url")
    @Expose
    private String representativesUrl;

    public String getBoundariesUrl() {
        return boundariesUrl;
    }

    public void setBoundariesUrl(String boundariesUrl) {
        this.boundariesUrl = boundariesUrl;
    }

    public String getBoundarySetUrl() {
        return boundarySetUrl;
    }

    public void setBoundarySetUrl(String boundarySetUrl) {
        this.boundarySetUrl = boundarySetUrl;
    }

    public String getRepresentativesUrl() {
        return representativesUrl;
    }

    public void setRepresentativesUrl(String representativesUrl) {
        this.representativesUrl = representativesUrl;
    }

}
