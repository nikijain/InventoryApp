package sfatechgroup.inventory.model;

public class DetailsModel {

    private String drugName;
    private String drugFullName;
    private String category;
    private String drugType;
    private String packingSize;
    private String unitPrize;

    public DetailsModel(String drugName, String drugFullName, String category, String drugType, String packingSize, String unitPrize) {
        this.drugName = drugName;
        this.drugFullName = drugFullName;
        this.category = category;
        this.drugType = drugType;
        this.packingSize = packingSize;
        this.unitPrize = unitPrize;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getPackingSize() {
        return packingSize;
    }

    public void setPackingSize(String packingSize) {
        this.packingSize = packingSize;
    }

    public String getUnitPrize() {
        return unitPrize;
    }

    public void setUnitPrize(String unitPrize) {
        this.unitPrize = unitPrize;
    }

    public String getDrugFullName() {
        return drugFullName;
    }

    public void setDrugFullName(String drugFullName) {
        this.drugFullName = drugFullName;
    }

    @Override
    public String toString() {
        return "DetailsModel{" +
                "drugName='" + drugName + '\'' +
                ", drugFullName='" + drugFullName + '\'' +
                ", category='" + category + '\'' +
                ", drugType='" + drugType + '\'' +
                ", packingSize='" + packingSize + '\'' +
                ", unitPrize='" + unitPrize + '\'' +
                '}';
    }
}
