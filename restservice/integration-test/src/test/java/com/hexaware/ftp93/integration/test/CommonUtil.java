package com.hexaware.ftp93.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp93");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
    public int empId;
  private String empName;
  private String empEmail;
  private long empMobileNo;
  private Date empDoj;
  private String empDept;
  private int empLeaveBalance;
  private int empManagerId;

    public Employee() {
    }

    public Employee(final int empId) {
      this.empId = empId;
    }

  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmail, final long argMobileNo,
      final Date argEmpDoj, final String argEmpDept, final int argEmpLeaveBalance, final int argManagerId) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmail = argEmpEmail;
    this.empMobileNo = argMobileNo;
    this.empDoj = argEmpDoj;
    this.empDept = argEmpDept;
    this.empLeaveBalance = argEmpLeaveBalance;
    this.empManagerId = argManagerId;
  }
   /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee id.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }
  /**
   * @param argEmpEmail to set employee id.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }
  /**
   * Gets the EmployeeMobile number.
   * @return this Employee's Mobile number.
   */
  public final long getEmpMobileNo() {
    return empMobileNo;
  }
  /**
   *
   * @param argEmpMobileNo to set employee id.
   */
  public final void setEmpMobileNo(final long argEmpMobileNo) {
    this.empMobileNo = argEmpMobileNo;
  }
  /**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }
   /**
   *
   * @param argEmpDoj to set employee id.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }
  /**
   * Gets the Employee Department.
   * @return this Employee's Department.
   */
  public final String getEmpDept() {
    return empDept;
  }
  /**
   *
   * @param argEmpDept to set employee id.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's levae balance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }
  /**
   *
   * @param argEmpLeaveBalance to set employee id.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }
  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's ManagerId.
   */
  public final int getEmpManagerId() {
    return empManagerId;
  }
  /**
   *
   * @param argEmpManagerId to set employee id.
   */
  public final void setEmpManagerId(final int argEmpManagerId) {
    this.empManagerId = argEmpManagerId;
  }

    public final boolean equals(final Object obj) {
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Employee emp = (Employee) obj;
      if (Objects.equals(empId, emp.empId)) {
        return true;
      }
      return false;
    }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}

class LeaveDetails {
  private int empId;
  private int lvdId;
  private  int lvdNoOfDays;
  private Date lvdStartDate;
  private Date lvdEndDate;
  private LeaveType lvdLeaveType;
  private LeaveStatus lvdLeaveStatus;
  private String lvdReason;
  private Date lvdAppliedOn;
  private String lvdManagerComments;

  public LeaveDetails(final int argEmpId, final int argLvdId, final int arglvdNoOfDays, final Date arglvdStartDate,
      final Date arglvdEndDate, final LeaveType arglvdLeaveType, final LeaveStatus arglvdLeaveStatus,
      final String arglvdReason, final Date arglvdAppliedOn, final String arglvdManagerComments) {
    this.empId = argEmpId;
    this.lvdId = argLvdId;
    this.lvdNoOfDays = arglvdNoOfDays;
    this.lvdStartDate = arglvdStartDate;
    this.lvdEndDate = arglvdEndDate;
    this.lvdLeaveType = arglvdLeaveType;
    this.lvdLeaveStatus = arglvdLeaveStatus;
    this.lvdReason = arglvdReason;
    this.lvdAppliedOn = arglvdAppliedOn;
    this.lvdManagerComments = arglvdManagerComments;
  }
  public LeaveDetails()
  {
    
  }

  /**
   * Gets the EmployeId.
   * @return this Employee ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * Gets the LeaveId.
   * @return this Leave ID.
   */
  public final int getLvdId() {
    return lvdId;
  }

  /**
   * Gets the LeavesNoOfDays.
   * @return this Leaves No Of Days.
   */
  public  int getLvdNoOfDays() {
    return lvdNoOfDays;
  }

  /**
   * Gets the LeaveStartDate.
   * @return this Leave Start Date.
   */
  public final Date getLvdStartDate() {
    return lvdStartDate;
  }

  /**
   * Gets the LeaveEndDate.
   * @return this Leave End Date.
   */
  public final Date getLvdEndDate() {
    return lvdEndDate;
  }

  /**
   * Gets the LeaveType.
   * @return this Leave Type.
   */
  public final LeaveType getLvdLeaveType() {
    return lvdLeaveType;
  }

  /**
   * Gets the LeaveStatus.
   * @return this Leave Status.
   */
  public final LeaveStatus getLvdLeaveStatus() {
    return lvdLeaveStatus;
  }

  /**
   * Gets the LeaveReason.
   * @return this Leave Reason.
   */
  public final String getLvdReason() {
    return lvdReason;
  }

  /**
   * Gets the LeaveAppliedOn.
   * @return this Leave Applied On.
   */
  public final Date getLvdAppliedOn() {
    return lvdAppliedOn;
  }

  /**
   * Gets the ManagerComments.
   * @return this Leave Manager Comments.
   */
  public final String getManagerComments() {
    return lvdManagerComments;
  }

  /**
   * @param argEmpId to set leave id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * @param argLvdId to set leave id.
   */
  public final void setLvdId(final int argLvdId) {
    this.lvdId = argLvdId;
  }

  /**
   * @param argLvdNoOfDays to set leave No Of Days.
   */
  public final void setLvdNoOfDays(final int argLvdNoOfDays) {
    this.lvdNoOfDays = argLvdNoOfDays;
  }

  /**
   * @param argStartDate to set Leave Start Date.
   */
  public final void setStartDate(final Date argStartDate) {
    this.lvdStartDate = argStartDate;
  }

  /**
   * @param argLvdEndDate to set Leave End Date.
   */
  public final void setEndDate(final Date argLvdEndDate) {
    this.lvdEndDate = argLvdEndDate;
  }

  /**
   * @param argLvdLeaveType to set Leave Type.
   */
  public final void setLvdLeaveType(final LeaveType argLvdLeaveType) {
    this.lvdLeaveType = argLvdLeaveType;
  }

  /**
   * @param argLvdLeaveStatus to set Leave Status.
   */
  public final void setLvdLeaveStatus(final LeaveStatus argLvdLeaveStatus) {
    this.lvdLeaveStatus = argLvdLeaveStatus;
  }

  /**
   * @param argLvdReason to set Leave Reason.
   */
  public final void setLvdReason(final String argLvdReason) {
    this.lvdReason = argLvdReason;
  }

  /**
   * @param argLvdAppliedOn to set Leave Applied On.
   */
  public final void setLvdAppliedOn(final Date argLvdAppliedOn) {
    this.lvdAppliedOn = argLvdAppliedOn;
  }

  /**
   * @param argLvdManagerComments to set Leave Manager Comments.
   */
  public final void setLvdManagerComments(final String argLvdManagerComments) {
    this.lvdManagerComments = argLvdManagerComments;
  }
}


enum LeaveType {
  /**
      * EL is earned leave.
      */
     EL
 }
 enum LeaveStatus {
   /**
      * Shows leave is pending.
      */
     PENDING,
 
     /**
      * Shows leave is Approved.
      */
     APPROVED,
 
     /**
      * Shows leave is Denied.
      */
     DENIED
 }
 