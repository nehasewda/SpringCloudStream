package test.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataModel {
    private String equipId;
    private String Equipment;

    @JsonCreator
    public DataModel(@JsonProperty(value = "equipId", required = true) String equipId, @JsonProperty(value = "equipment", required = true) String equipment) {
        this.equipId = equipId;
        Equipment = equipment;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "equipId='" + equipId + '\'' +
                ", Equipment='" + Equipment + '\'' +
                '}';
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getEquipment() {
        return Equipment;
    }

    public void setEquipment(String equipment) {
        Equipment = equipment;
    }
}
