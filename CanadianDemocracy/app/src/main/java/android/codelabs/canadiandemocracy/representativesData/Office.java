package android.codelabs.canadiandemocracy.representativesData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Office {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("tel")
    @Expose
    private String tel;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
