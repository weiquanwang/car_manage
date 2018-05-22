package edu.wwq.car.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DrivePrice implements Serializable {
    private Integer id;

    private String drivePriceNum;

    private String licensePlateNum;

    private BigDecimal price;

    private Date driveDate;

    private String remark;

    private String handStaff;

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

    public String getDrivePriceNum() {
        return drivePriceNum;
    }

    public void setDrivePriceNum(String drivePriceNum) {
        this.drivePriceNum = drivePriceNum == null ? null : drivePriceNum.trim();
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum == null ? null : licensePlateNum.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(Date driveDate) {
        this.driveDate = driveDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getHandStaff() {
        return handStaff;
    }

    public void setHandStaff(String handStaff) {
        this.handStaff = handStaff == null ? null : handStaff.trim();
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