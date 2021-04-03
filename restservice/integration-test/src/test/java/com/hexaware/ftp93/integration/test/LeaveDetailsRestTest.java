package com.hexaware.ftp93.integration.test;
import static org.junit.Assert.*;

import java.net.URISyntaxException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {
    @Test
    public void testApplyLeave() throws AssertionError, URISyntaxException {
    
     String res=given().accept(ContentType.JSON)
                        .contentType("application/json")
                        .body("{\"empId\":\"3000\",\"lvdStartDate\":\"2019-02-06\",\"lvdEndDate\":\"2019-02-08\",\"lvdLeaveType\":\"EL\",\"lvdReason\":\"fever\"}").
         when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000")).getBody().asString();
    
      assertEquals("***** You have already applied for the leave. *****", res);
        
     }

     @Test
     public void testApproveDeny() throws AssertionError, URISyntaxException {
     String res=given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"3000\",\"lvdId\":\"11\",\"lvdLeaveStatus\":\"PENDING\",\"lvdManagerComments\":\"good\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/approvedeny/2000/APPROVED")).getBody().asString();
        assertEquals("Approved Successfully", res);

     }

}