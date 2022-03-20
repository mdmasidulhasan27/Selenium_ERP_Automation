package main.pojo;

import javafx.fxml.LoadException;

public class MemberInfoData {
    Long id;
    Long assignedpoId;
    Long branchInfoId;
    Long countryId;
    Long createdBy;
    Long domainStatusId;
    String fName;
    Long groupInfoId;
    Boolean isTransferredMember;
    String lName;
    String lastUpdated;
    Long loanCycleNo;
    String mName;
    String memberName;
    String memberNo;
    Long memberStatusId;
    String projectRefCode;
    Integer incidentStatus;

    public MemberInfoData() {
    }

    public MemberInfoData(Long id, Long assignedpoId, Long branchInfoId, Long countryId, Long createdBy, Long domainStatusId, String fName, Long groupInfoId, Boolean isTransferredMember, String lName, String lastUpdated, Long loanCycleNo, String mName, String memberName, String memberNo, Long memberStatusId, String projectRefCode, Integer incidentStatus) {
        this.id = id;
        this.assignedpoId = assignedpoId;
        this.branchInfoId = branchInfoId;
        this.countryId = countryId;
        this.createdBy = createdBy;
        this.domainStatusId = domainStatusId;
        this.fName = fName;
        this.groupInfoId = groupInfoId;
        this.isTransferredMember = isTransferredMember;
        this.lName = lName;
        this.lastUpdated = lastUpdated;
        this.loanCycleNo = loanCycleNo;
        this.mName = mName;
        this.memberName = memberName;
        this.memberNo = memberNo;
        this.memberStatusId = memberStatusId;
        this.projectRefCode = projectRefCode;
        this.incidentStatus = incidentStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getAssignedpoId() {
        return assignedpoId;
    }

    public Long getBranchInfoId() {
        return branchInfoId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public Long getDomainStatusId() {
        return domainStatusId;
    }

    public String getfName() {
        return fName;
    }

    public Long getGroupInfoId() {
        return groupInfoId;
    }

    public Boolean getTransferredMember() {
        return isTransferredMember;
    }

    public String getlName() {
        return lName;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Long getLoanCycleNo() {
        return loanCycleNo;
    }

    public String getmName() {
        return mName;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public Long getMemberStatusId() {
        return memberStatusId;
    }

    public String getProjectRefCode() {
        return projectRefCode;
    }

    public Integer getIncidentStatus() {
        return incidentStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAssignedpoId(Long assignedpoId) {
        this.assignedpoId = assignedpoId;
    }

    public void setBranchInfoId(Long branchInfoId) {
        this.branchInfoId = branchInfoId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setDomainStatusId(Long domainStatusId) {
        this.domainStatusId = domainStatusId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setGroupInfoId(Long groupInfoId) {
        this.groupInfoId = groupInfoId;
    }

    public void setTransferredMember(Boolean transferredMember) {
        isTransferredMember = transferredMember;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setLoanCycleNo(Long loanCycleNo) {
        this.loanCycleNo = loanCycleNo;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public void setMemberStatusId(Long memberStatusId) {
        this.memberStatusId = memberStatusId;
    }

    public void setProjectRefCode(String projectRefCode) {
        this.projectRefCode = projectRefCode;
    }

    public void setIncidentStatus(Integer incidentStatus) {
        this.incidentStatus = incidentStatus;
    }
}
