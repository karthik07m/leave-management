package com.hexaware.ftp93.util;

import javax.ws.rs.GET;
//import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp93.model.LeaveDetails;

import javax.ws.rs.POST;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;


/**
 * This class provides a REST interface for the leaveDetails.
 */
@Path("/leaveDetails")
public class LeaveDetailsRest {

    /**
   * Returns a leave pending details.
   * @param mgrId the id of the manager.
   * @return the employee details
   */
  @GET
  @Path("/pending/{mgrId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavePendingList(@PathParam("mgrId") final int mgrId) {
    LeaveDetails[] l = LeaveDetails.listPending(mgrId);
    return l;
  }
  /**
   * @param ldt    the object of leaveDetails.
   * @param empId the id of the employee.
   * @throws ParseException throws parse exception.
   * @return a list of all the employees
  */
  @POST
  @Path("/applyleave/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
    public final String applyLeave(@PathParam("empId") final int empId, final LeaveDetails ldt) throws ParseException {
    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
    String leavetype = ldt.getLvdLeaveType().toString();
    String result = LeaveDetails.applyProcess(empId, dt.format(ldt.getLvdStartDate()),
            dt.format(ldt.getLvdEndDate()), leavetype, ldt.getLvdReason());
    return result;
  }

  // /**
  //  * Returns a specific employee's leave details.
  //  * @param empId the id of the Employee
  //  * @param led   the object of the LeaveDetails
  //  * @throws ParseException for Parsing errors.
  //  * @return the Leave details
  //  */
  // @POST
  // @Path("/approvedeny/{empId}")
  // @Consumes(MediaType.APPLICATION_JSON)
  // @Produces(MediaType.APPLICATION_JSON)
  // public final String employeeapproveDeny(final LeaveDetails led, @PathParam("empId") final int empId)
  //     throws ParseException {
  //   String leStatus = led.getLvdLeaveStatus().toString();
  //   String status = null;
  //   if (leStatus.equals("APPROVED")) {
  //     status = "APPROVED";
  //   } else if (leStatus.equals("DENIED")) {
  //     status = "DENIED";
  //   }
  //   String results = LeaveDetails.managerAction(empId, led.getLvdId(), status, led.getManagerComments());
  //   return results;
  // }
  /**
   * Manager approve or denies the employee leave id's.
   * @param empId the id of the manager.
   * @param status   status of the leave.
   * @param ma       reference.
   * @return the leave details.
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/approvedeny/{empId}/{status}")
  public final String approveDenyRest(@PathParam("empId") final int empId,
      @PathParam("status") final String status, final LeaveDetails ma) {
    // LeaveDetails ldm = new LeaveDetails();
    String s = ma.managerAction(empId, ma.getLvdId(), status, ma.getManagerComments());
    return s;
  }

  /**
   * Returns a leave history details.
   * @param empId the id of the employee.
   * @return the employee details
   */
  @GET
  @Path("/leaveHistory/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveHistoryList(@PathParam("empId") final int empId) {
    System.out.println("Leave history");
    LeaveDetails[] l = LeaveDetails.leaveHis(empId);
    return l;
  }
}
