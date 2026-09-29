package com.example.OutboundService.dto;

public class GRNRequestDTO {

    private String materialCode;
    private String materialDescription;
    private String vendorName;
    private String vechileNumber;
    private Double totalQty;
    private Double materialQty;

    public GRNRequestDTO() {
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVechileNumber() {
        return vechileNumber;
    }

    public void setVechileNumber(String vechileNumber) {
        this.vechileNumber = vechileNumber;
    }

    public Double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Double totalQty) {
        this.totalQty = totalQty;
    }

    public Double getMaterialQty() {
        return materialQty;
    }

    public void setMaterialQty(Double materialQty) {
        this.materialQty = materialQty;
    }
}