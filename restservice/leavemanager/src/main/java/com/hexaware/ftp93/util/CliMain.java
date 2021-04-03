package com.hexaware.ftp93.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import com.hexaware.ftp93.model.Employee;
import com.hexaware.ftp93.model.LeaveDetails;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() throws ParseException {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Leave History");
    System.out.println("5. Leave Pending");
    System.out.println("6. Manager's Action");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }

  private void mainMenuDetails(final int selectedOption) throws ParseException {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistory();
        break;
      case 5:
        leavePending();
        break;
      case 6:
        managerAction();
        break;
      case 7:
      // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee.getEmpId() + " " + employee.getEmpName() + " " + employee.getEmpEmail() + " "
          + employee.getEmpDoj() + " " + employee.getEmpDept() + " " + employee.getEmpMobileNo() + " "
          + employee.getEmpManagerId() + " " + employee.getEmpLeaveBalance());
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getEmpEmail() + " " + e.getEmpDoj() + " "
          + e.getEmpDept() + " " + e.getEmpMobileNo() + " " + e.getEmpManagerId() + " " + e.getEmpLeaveBalance());
    }
  }
  private void managerAction() {
    int leaveId = 0;
    int empid = 0;
    try {
      System.out.println("**** Enter Employee(Manager) id: ****");
      String employeeId = option.next();
      empid = Integer.parseInt(employeeId);
      Employee employee = Employee.listById(empid);
      if (employee == null) {
        System.out.println("**** Invalid employee id!!! ****");
      } else {
        while (true) {
          try {
            System.out.println("*****Enter leave id:*****");
            String id = option.next();
            leaveId = Integer.parseInt(id);
            LeaveDetails l = LeaveDetails.listById(leaveId);
            int a = l.getLvdId();
            if (a == leaveId) {
              break;
            }
          } catch (InputMismatchException e) {
            System.out.println("*****Enter valid LeaveId*****");
          } catch (Exception e) {
            System.out.println("*****Enter valid LeaveId*****");
          }
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("**** Enter valid ManagerId **** ");
    } catch (Exception e) {
      System.out.println("**** Enter valid manager Id ****");
    }
    LeaveDetails lvdId = LeaveDetails.listById(leaveId);
    if (lvdId == null) {
      System.out.println("*****Enter valid LeaveId*****");
    } else {
      System.out.println("*****Approved/Denied:*****");
      String status = option.next();
      System.out.println("*****Manager Comments:*****");
      String mgrcomm = option.next();
      String result = LeaveDetails.managerAction(empid, leaveId, status, mgrcomm);
      System.out.println(result);
    }
  }
  private void leavePending() {
    int mgrId = 0;
    System.out.println("Enter Manager Id");
    try {
      mgrId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("ManagerId should be in Numbers");
    }
    if (mgrId > 0) {
      LeaveDetails[] pending = LeaveDetails.listPending(mgrId);
      int size = pending.length;
      if (size == 0) {
        System.out.println("no records");
      } else {
        for (LeaveDetails e : pending) {
          System.out.println(e.getEmpId() + " " + e.getLvdId() + " " + e.getLvdNoOfDays() + " " + e.getLvdStartDate()
              + " " + e.getLvdEndDate() + " " + e.getLvdLeaveType() + " " + e.getLvdLeaveStatus() + " "
              + e.getLvdReason() + e.getLvdAppliedOn() + " " + e.getManagerComments());
        }
      }
    } else {
      System.out.println("Enter valid ID");
    }
  }
  private void leaveHistory() {
    int empId = 0;
    while (true) {
      try {
        System.out.println("Enter the Employee Id");
        String id = option.next();
        empId = Integer.parseInt(id);
        Employee e = Employee.listById(empId);
        int a = e.getEmpId();
        if (a == empId) {
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("No Such Records!!!");
      } catch (Exception e) {
        System.out.println("Enter a valid Employee Id !!");
      }
    }
    LeaveDetails[] leaves = LeaveDetails.leaveHis(empId);
    int size = leaves.length;
    if (size == 0) {
      System.out.println("No Such Record!!");
    } else {
      System.out.println("EmpId" + " " + "LeaveId" + " " + "LeaveNoofDays" + " " + "LeaveStartDate " + " "
          + "LeaveEndDate" + " " + "LeaveType" + " " + "LeaveStatus" + " " + "LeaveReason" + " " + "LeaveAppliedOn"
          + " " + "ManagerComments");
      System.out.println(
          "------------------------------------------------------------------------------------------------------"
              + "------------------------------");
      for (LeaveDetails e : leaves) {
        System.out.println(e.getEmpId() + "     " + e.getLvdId() + "     " + e.getLvdNoOfDays() + "     "
            + e.getLvdStartDate() + "        " + e.getLvdEndDate() + "         " + e.getLvdLeaveType() + "        "
            + e.getLvdLeaveStatus() + "      " + e.getLvdReason() + "    " + e.getLvdAppliedOn() + "        "
            + e.getManagerComments());
      }
    }
  }
  private void applyLeave() throws ParseException {
    System.out.println("**************************");
    System.out.println("Enter Employee Id: ");
    try {
      int empId = Integer.parseInt(option.next());
      Employee emp = Employee.listById(empId);
      if (emp == null) {
        System.out.println("No such employee. Please enter a valid Employee id");
      } else {
        System.out.println("****************************************************");
        System.out.println("            " + "Welcome " + emp.getEmpName());
        System.out.println("      " + " Avaliable leave balance: " + emp.getEmpLeaveBalance());
        System.out.println("****************************************************");
        System.out.println("*****************************");
        System.out.println("Enter Start Date (yyyy-MM-dd): ");
        System.out.println("*****************************");
        String startDate = option.next();
        System.out.println("*****************************");
        System.out.println("Enter End Date (yyyy-MM-dd): ");
        System.out.println("*****************************");
        String endDate = option.next();
        int days = LeaveDetails.countDays(startDate, endDate);
        String prntday = "";
        if (days == 1) {
          prntday = "day";
        } else {
          prntday = "days";
        }
        System.out.println("***************************************************************************************");
        System.out.println("Applying leave from: " + startDate + " to " + endDate + " for: " + days + " " + prntday);
        System.out.println("***************************************************************************************");
        System.out.println("*****************************");
        System.out.println("Enter LeaveType (EL/SSL): ");
        String leaveType = option.next();
        System.out.println("*****************************");
        System.out.println("Enter LeaveReason: ");
        System.out.println("*****************************");
        String leaveReason = option.next();
        System.out.println("*****************************");
        try {
          String msg = LeaveDetails.applyProcess(empId, startDate, endDate, leaveType, leaveReason);
          System.out.println(msg);
        } catch (ParseException e) {
          System.out.println("******************************************");
          System.out.println("**** Entered date format is invalid ! ****");
          System.out.println("******************************************");
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("**********************************************");
      System.out.println("**** Employe id should be in numbers only ****");
      System.out.println("**********************************************");
    }
  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   * @throws ParseException throws date parse exception
   */
  public static void main(final String[] ar) throws ParseException {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
