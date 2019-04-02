package android.codelabs.canadiandemocracy.representativesData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Representative {

    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("extra")
    @Expose
    private Extra extra;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("elected_office")
    @Expose
    private String electedOffice;
    @SerializedName("source_url")
    @Expose
    private String sourceUrl;
    @SerializedName("party_name")
    @Expose
    private String partyName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("representative_set_name")
    @Expose
    private String representativeSetName;
    @SerializedName("offices")
    @Expose
    private List<Office> offices = null;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("photo_url")
    @Expose
    private String photoUrl;
    @SerializedName("related")
    @Expose
    private Related related;
    @SerializedName("personal_url")
    @Expose
    private String personalUrl;
    @SerializedName("gender")
    @Expose
    private String gender;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getElectedOffice() {
        return electedOffice;
    }

    public void setElectedOffice(String electedOffice) {
        this.electedOffice = electedOffice;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepresentativeSetName() {
        return representativeSetName;
    }

    public void setRepresentativeSetName(String representativeSetName) {
        this.representativeSetName = representativeSetName;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Related getRelated() {
        return related;
    }

    public void setRelated(Related related) {
        this.related = related;
    }

    public String getPersonalUrl() {
        return personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
