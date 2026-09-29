package com.example.OutboundService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AT_logGRN_Request")
public class GRNRequest {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "GrnNumber", unique = true)
	    private String grnNumber;

	    @Column(name = "MaterialCode")
	    private String materialCode;

	    @Column(name = "MaterialDescription")
	    private String materialDescription;

	    @Column(name = "VendorName")
	    private String vendorName;

	    @Column(name = "VechileNumber")
	    private String vechileNumber;

	    @Column(name = "TotalQty")
	    private Double totalQty;

	    @Column(name = "MaterialQty")
	    private Double materialQty;

	    public GRNRequest() {
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getGrnNumber() {
	        return grnNumber;
	    }

	    public void setGrnNumber(String grnNumber) {
	        this.grnNumber = grnNumber;
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
