package android.codelabs.canadiandemocracy;

import com.google.gson.annotations.SerializedName;

public class RepresentativeSet {

    // Using SerializedName because the name of the variable is different from the key in the json file
    @SerializedName("representatives_url")
    private String representativesUrl;

    private String name;

    public String getRepresentativesUrl() {
        return representativesUrl;
    }

    public String getName() {
        return name;
    }
}
