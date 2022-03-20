package main.pojo;

public class BranchInfoData {
    Long id;
    Long version;
    Long bankInfoId;
    Long branchAddressId;
    String branchCode;
    String branchName;
    String contactNo;
    String contactPerson;
    Long domainStatusId;
    String refCode;
    String setupDate;
    String shortCode;

    public BranchInfoData() {
    }

    public BranchInfoData(Long id, Long version, Long bankInfoId, Long branchAddressId, String branchCode, String branchName, String contactNo, String contactPerson, Long domainStatusId, String refCode, String setupDate, String shortCode) {
        this.id = id;
        this.version = version;
        this.bankInfoId = bankInfoId;
        this.branchAddressId = branchAddressId;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactNo = contactNo;
        this.contactPerson = contactPerson;
        this.domainStatusId = domainStatusId;
        this.refCode = refCode;
        this.setupDate = setupDate;
        this.shortCode = shortCode;
    }

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public Long getBankInfoId() {
        return bankInfoId;
    }

    public Long getBranchAddressId() {
        return branchAddressId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public Long getDomainStatusId() {
        return domainStatusId;
    }

    public String getRefCode() {
        return refCode;
    }

    public String getSetupDate() {
        return setupDate;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setBankInfoId(Long bankInfoId) {
        this.bankInfoId = bankInfoId;
    }

    public void setBranchAddressId(Long branchAddressId) {
        this.branchAddressId = branchAddressId;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setDomainStatusId(Long domainStatusId) {
        this.domainStatusId = domainStatusId;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public void setSetupDate(String setupDate) {
        this.setupDate = setupDate;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
