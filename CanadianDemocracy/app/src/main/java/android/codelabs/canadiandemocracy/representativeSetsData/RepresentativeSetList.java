package android.codelabs.canadiandemocracy.representativeSetsData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepresentativeSetList {
    @SerializedName("objects")
    private List<RepresentativeSet> representativeSets;

    public List<RepresentativeSet> getRepresentativeSets() {
        return representativeSets;
    }

    public void setRepresentativeSets(List<RepresentativeSet> representativeSets) {
        this.representativeSets = representativeSets;
    }
}
