package httpRequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourierAllocation {

    @SerializedName("selected_type")
    @Expose
    private String selectedType;
    @SerializedName("rule")
    @Expose
    private String rule;
    @SerializedName("applied_type")
    @Expose
    private String appliedType;

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getAppliedType() {
        return appliedType;
    }

    public void setAppliedType(String appliedType) {
        this.appliedType = appliedType;
    }

}
