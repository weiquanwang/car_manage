package edu.wwq.car.model;

import java.io.Serializable;
import java.util.Date;

public class CarUse implements Serializable {
    private Integer id;

    private String carUseNum;

    private String licensePlateNum;

    private String destination;

    private Date useDate;

    private Date returnDate;

    private String useReason;

    private String useUserName;

    private Integer status;

    private Date createTime;

    private Date modifyTime;

    private Integer isDeleted;

    private Integer useUserId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarUseNum() {
        return carUseNum;
    }

    public void setCarUseNum(String carUseNum) {
        this.carUseNum = carUseNum == null ? null : carUseNum.trim();
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum == null ? null : licensePlateNum.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getUseReason() {
        return useReason;
    }

    public void setUseReason(String useReason) {
        this.useReason = useReason == null ? null : useReason.trim();
    }

    public String getUseUserName() {
        return useUserName;
    }

    public void setUseUserName(String useUserName) {
        this.useUserName = useUserName == null ? null : useUserName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getUseUserId() {
        return useUserId;
    }

    public void setUseUserId(Integer useUserId) {
        this.useUserId = useUserId;
    }
}