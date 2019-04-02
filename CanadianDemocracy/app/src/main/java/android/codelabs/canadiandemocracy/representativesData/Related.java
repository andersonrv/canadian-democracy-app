package android.codelabs.canadiandemocracy.representativesData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Related {

    @SerializedName("representative_set_url")
    @Expose
    private String representativeSetUrl;
    @SerializedName("boundary_url")
    @Expose
    private String boundaryUrl;

    public String getRepresentativeSetUrl() {
        return representativeSetUrl;
    }

    public void setRepresentativeSetUrl(String representativeSetUrl) {
        this.representativeSetUrl = representativeSetUrl;
    }

    public String getBoundaryUrl() {
        return boundaryUrl;
    }

    public void setBoundaryUrl(String boundaryUrl) {
        this.boundaryUrl = boundaryUrl;
    }

}
