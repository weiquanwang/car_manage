package edu.wwq.car.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CarMaintenance implements Serializable {
    private Integer id;

    private String carMaintenanceNum;

    private String licensePlateNum;

    private String maintenanceCause;

    private BigDecimal maintenancePrice;

    private Date maintenanceDate;

    private String handStaff;

    private String remark;

    private Date createTime;

    private Date modifyTime;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarMaintenanceNum() {
        return carMaintenanceNum;
    }

    public void setCarMaintenanceNum(String carMaintenanceNum) {
        this.carMaintenanceNum = carMaintenanceNum == null ? null : carMaintenanceNum.trim();
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum == null ? null : licensePlateNum.trim();
    }

    public String getMaintenanceCause() {
        return maintenanceCause;
    }

    public void setMaintenanceCause(String maintenanceCause) {
        this.maintenanceCause = maintenanceCause == null ? null : maintenanceCause.trim();
    }

    public BigDecimal getMaintenancePrice() {
        return maintenancePrice;
    }

    public void setMaintenancePrice(BigDecimal maintenancePrice) {
        this.maintenancePrice = maintenancePrice;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getHandStaff() {
        return handStaff;
    }

    public void setHandStaff(String handStaff) {
        this.handStaff = handStaff == null ? null : handStaff.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}