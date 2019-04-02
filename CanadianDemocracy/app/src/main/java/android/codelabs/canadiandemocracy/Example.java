package android.codelabs.canadiandemocracy;

import android.codelabs.canadiandemocracy.representativeSetsData.RepresentativeSet;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("objects")
    @Expose
    private List<RepresentativeSet> representativeSets = null;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<RepresentativeSet> getRepresentativeSets() {
        return representativeSets;
    }

    public void setRepresentativeSets(List<RepresentativeSet> representativeSets) {
        this.representativeSets = representativeSets;
    }

}
