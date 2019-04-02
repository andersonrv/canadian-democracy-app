package android.codelabs.canadiandemocracy.representativeSetsData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepresentativeSet {

    @SerializedName("data_url")
    @Expose
    private String dataUrl;
    @SerializedName("related")
    @Expose
    private Related related;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data_about_url")
    @Expose
    private String dataAboutUrl;

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public Related getRelated() {
        return related;
    }

    public void setRelated(Related related) {
        this.related = related;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataAboutUrl() {
        return dataAboutUrl;
    }

    public void setDataAboutUrl(String dataAboutUrl) {
        this.dataAboutUrl = dataAboutUrl;
    }

    @Override
    public String toString() {
        return name;
    }
}
