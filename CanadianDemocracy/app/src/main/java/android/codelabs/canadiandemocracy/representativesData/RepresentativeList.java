package android.codelabs.canadiandemocracy.representativesData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepresentativeList {
    @SerializedName("objects")
    private List<Representative> representatives;

    public List<Representative> getRepresentatives() {
        return representatives;
    }

    public void setRepresentatives(List<Representative> representatives) {
        this.representatives = representatives;
    }
}
