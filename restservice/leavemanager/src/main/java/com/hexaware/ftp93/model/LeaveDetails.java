package com.hexaware.ftp93.model;

import java.util.Objects;

import com.hexaware.ftp93.persistence.DbConnection;
import com.hexaware.ftp93.persistence.LeaveDetailsDAO;



import com.hexaware.ftp93.persistence.EmployeeDAO;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * LeaveDetails class to store leave manager details.
 * @author hexa   ware
 */
public class LeaveDetails {

  /**
   * lvdId to store leave id. lvdNoOfDays to store no of days of leave.
   * lvdStarDate to store start date of leave. lvdEndDate to store end date of
   * date. lvdLeaveType to store leave type. lvdStatus to store the leave status.
   * lvdReason to store the leave reason. lvdAppliedOn to store the applied date.
   * lvdManagerComments to store manager comments.
   */
  private int empId;
  private int lvdId;
  private int lvdNoOfDays;
  private Date lvdStartDate;
  private Date lvdEndDate;
  private LeaveType lvdLeaveType;
  private LeaveStatus lvdLeaveStatus;
  private SslAppliedStatus lvdSSLStatus;
  private String lvdReason;
  private Date lvdAppliedOn;
  private String lvdManagerComments;


  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lvd = (LeaveDetails) obj;
    if (Objects.equals(empId, lvd.empId) && Objects.equals(lvdId, lvd.lvdId)
        && Objects.equals(lvdNoOfDays, lvd.lvdNoOfDays) && Objects.equals(lvdStartDate, lvd.lvdStartDate)
        && Objects.equals(lvdEndDate, lvd.lvdEndDate) && Objects.equals(lvdLeaveType, lvd.lvdLeaveType)
        && Objects.equals(lvdLeaveStatus, lvd.lvdLeaveStatus) && Objects.equals(lvdReason, lvd.lvdReason)
        && Objects.equals(lvdAppliedOn, lvd.lvdAppliedOn)
        && Objects.equals(lvdManagerComments, lvd.lvdManagerComments)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, lvdId, lvdNoOfDays, lvdStartDate, lvdEndDate, lvdLeaveType, lvdLeaveStatus, lvdReason,
        lvdAppliedOn, lvdManagerComments);
  }

  /**
   * @param argEmpId              to initialize employee id.
   * @param argLvdId              to initialize leave id.
   * @param arglvdNoOfDays        to initialize lvdNoOfDays.
   * @param arglvdStartDate       to initialize lvdStartDate.
   * @param arglvdEndDate         to initialize lvdEndDate.
   * @param arglvdLeaveType       to initialize lvdLeaveType
   * @param arglvdLeaveStatus     to initialize lvdLeaveStatus
   * @param arglvdReason          to initialize lvdReason.
   * @param arglvdAppliedOn       to initialize lvdAppliedOn.
   * @param arglvdManagerComments to initialize lvdManagerComments.
   * @param arglvdSSLStatus        to initialize lvdSlStatus.
   */

  public LeaveDetails(final int argEmpId, final int argLvdId, final int arglvdNoOfDays, final Date arglvdStartDate,
      final Date arglvdEndDate, final LeaveType arglvdLeaveType, final LeaveStatus arglvdLeaveStatus,
      final String arglvdReason, final Date arglvdAppliedOn, final String arglvdManagerComments,
      final SslAppliedStatus arglvdSSLStatus) {
    this.empId = argEmpId;
    this.lvdId = argLvdId;
    this.lvdNoOfDays = arglvdNoOfDays;
    this.lvdStartDate = arglvdStartDate;
    this.lvdEndDate = arglvdEndDate;
    this.lvdLeaveType = arglvdLeaveType;
    this.lvdLeaveStatus = arglvdLeaveStatus;
    this.lvdSSLStatus =  arglvdSSLStatus;
    this.lvdReason = arglvdReason;
    this.lvdAppliedOn = arglvdAppliedOn;
    this.lvdManagerComments = arglvdManagerComments;
  }
  /**
   * Default Constructor LeaveDeatils.
   */
  public LeaveDetails() {

  }
  /**
   * Gets the EmployeId.
   * @return this Employee ID.
   */
  public final SslAppliedStatus getSSLStatus() {
    return lvdSSLStatus;
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
  public final int getLvdNoOfDays() {
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
   * @param arglvdSSLStatus to set leave id.
   */
  public final void setSSLStatus(final SslAppliedStatus arglvdSSLStatus) {
    this.lvdSSLStatus = arglvdSSLStatus;
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

  @Override
  public final String toString() {
    return "EmployeeID:" + empId + "LeaveId:" + lvdId + "NoOfDays:" + lvdNoOfDays + "StartDate:" + lvdStartDate
        + "EndDate:" + lvdEndDate + "lvdleavetype:" + lvdLeaveType + "lvdstatus:" + lvdLeaveStatus + "lvdReason:"
        + lvdReason + "lvdAppliedOn:" + lvdAppliedOn + "lvdmanagercomments:" + lvdManagerComments;
  }

  /**
   * Method for Approve or Deny the Leave.
   * @param leaveId     to enter LeaveId to approve/deny.
   * @param status      to enter status to approve/deny.
   * @param mgrComments to get manager comments.
   * @param mgrId       to get employee id.
   * @return String.
   */
  public static String managerAction(final int mgrId, final int leaveId, final String status,
      final String mgrComments) {
    LeaveDetails ld = dao().findLeave(leaveId);
    int noOfDays = ld.getLvdNoOfDays();
    int getMgrId = dao().getManager(leaveId);
    int empID = ld.getEmpId();
    Employee employee = edao().find(empID);
    int availaBal = employee.getEmpLeaveBalance();
    int remainingBal = availaBal - noOfDays;
    int total = availaBal + noOfDays;
    String dbstatus = null;
    String result = "";
    String status1 = status.toLowerCase();
    if (mgrId != getMgrId) {
      result = "You are not authorized!!";
    } else if (status1.equals("approved")) {
      if (ld.getLvdLeaveStatus().toString().equals("APPROVED")) {
        result = "**** You have already aprroved ****";
      } else {
        dbstatus = "APPROVED";
        dao().mgrcommnets(mgrComments, dbstatus, leaveId);
        result = "Approved Successfully";
        edao().updateBal(empID, remainingBal);
      }
    } else if (status1.equals("denied")) {
      if (ld.getLvdLeaveStatus().toString().equals("DENIED")) {
        result = "**** You have already denied ****";
      } else if (ld.getLvdLeaveStatus().toString().equals("APPROVED")) {
        dbstatus = "DENIED";
        edao().updateBal(empID, total);
        dao().mgrcommnets(mgrComments, dbstatus, leaveId);
        result = "Denied Permission";
      } else {
        dbstatus = "DENIED";
        dao().mgrcommnets(mgrComments, dbstatus, leaveId);
        result = "Denied Permission";
      }
    } else {
      result = "Please enter valid String";
    }
    return result;
  }

  /**
   * The dao for EmployeeDetails.
   */
  private static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * /** The dao for LeaveDetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * list all employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listAll() {
    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list all employee leave details.
   * @param mgrId id to get employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listPending(final int mgrId) {
    List<LeaveDetails> es = dao().pending(mgrId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list leave details by id.
   * @param leaveId id to get leave details.
   * @return LeaveDetails
   */
  public static LeaveDetails listById(final int leaveId) {
    return dao().findLeave(leaveId);
  }

  /**
   * list leave details by id.
   * @param empID id to get leave details.
   * @return LeaveDetail
   */
  public static LeaveDetails[] leaveHis(final int empID) {
    List<LeaveDetails> es = dao().empHistory(empID);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * Applyy Leave for employee.
   * @param empid       id to set employee id.
   * @param startDate   id to set employee startDate.
   * @param endDate     id to set employee endDate.
   * @param leaveType   id to set employee leaveType.
   * @param leaveReason id to set employee leaveReason.
   * @throws ParseException throws parse exception.
   * @return error messages
   */
  public static String applyProcess(final int empid, final String startDate, final String endDate,
                                      final String leaveType, final String leaveReason) throws ParseException {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    Employee emp = Employee.listById(empid);
    String msg = " ";
    Date today = new Date();
    Date doj = emp.getEmpDoj();
    Date strDate = sf.parse(startDate);
    //Date enDate = sf.parse(endDate);
    long diff = strDate.getTime() - doj.getTime();
    long slLeaveDays = diff / (1000 * 60 * 60 * 24);
    System.out.println(slLeaveDays);
    //leavedays = leavedays + 1;
    int leavedays = countDays(startDate, endDate);
    //System.out.println("No of Days :" + leavedays);
    int availableBal = emp.getEmpLeaveBalance() - (int) leavedays;
    int overLap = countNo(empid, startDate, endDate);
    String eL = LeaveType.valueOf("EL").toString().toUpperCase();
    System.out.println(leaveType);
    //String ssL = LeaveType.valueOf("SSL").toString().toUpperCase();
    if (overLap > 0) {
      msg = "***** You have already applied for the leave. *****";
    } else if (strDate.compareTo(today) == -1) {
      msg = "**** Invalid start date. Start date cann't be past ****";
    } else if (leavedays <= 0) {
      System.out.println("**** Start date is greater than End date or You are applying leave on holidays. ****");
    // } else if (leaveType.toUpperCase().equals(ssL)) {
    //   if (slLeaveDays < 182) {
    //     msg = "You are not eligible (Min 6 months required";
    //   }
    } else {
      System.out.println("Hello");
      dao().insert(empid, leavedays, startDate, endDate, leaveType, leaveReason, sf.format(today));
      msg = "**** Your leave request succcessfully recored " + "form :" + startDate + " - " + endDate + " for: "
          + leavedays + "days" + " ****";
      int mgrId = emp.getEmpManagerId();
      if (mgrId == 0) {
        if (leaveType.equals(eL)) {
          System.out.println("in el");
          dao().updateCEO(empid);
          edao().updateBal(empid, availableBal);
        } else {
          System.out.println("in sl");
          int days = emp.getEmpLeaveBalance() - leavedays;
          if (days < 0) {
            int dy = leavedays - emp.getEmpLeaveBalance();
            int sldays = emp.getEmpSSLBal() - dy;
            int eldays = leavedays - dy;
            int fi = eldays - emp.getEmpLeaveBalance();
            edao().updateBal(empid, fi);
            edao().updateSBal(empid, sldays);
          } else {
            edao().updateBal(empid, days);
          }
          dao().updateCEO(empid);
        }
      }
    }
    return msg;
  }

  /**
   * No overlapping Leaves.
   * @param empid     id to get employee details.
   * @param startDate start date.
   * @param endDate   end date.
   * @return count of no of employee.
   */
  public static int countNo(final int empid, final String startDate, final String endDate) {
    int count = dao().count(empid, startDate, endDate);
    return count;
  }

  /**
   * @param startDate start date.
   * @param endDate   end date.
   * @return no of days
   * @throws ParseException date format
   */
  public static int countDays(final String startDate, final String endDate) throws ParseException {
    int workingDays = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar startdate = Calendar.getInstance();
    startdate.setTime(sdf.parse(startDate));
    Calendar enddate = Calendar.getInstance();
    enddate.setTime(sdf.parse(endDate));
    while (!startdate.after(enddate)) {
      int day = startdate.get(Calendar.DAY_OF_WEEK);
      if (day != Calendar.SATURDAY && day != Calendar.SUNDAY) {
        workingDays++;
      }
      startdate.add(Calendar.DATE, 1);
    }
    return workingDays;
  }
}
