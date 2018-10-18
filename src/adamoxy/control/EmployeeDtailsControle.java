/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adamoxy.control;

import adamoxy.common.log;
import adamoxy.database.EmployeeDtailsDataSource;
import adamoxy.setget.EmployeeDetailsInfo;

/**
 *
 * @author adam
 */
public class EmployeeDtailsControle {

    /*
        public EmployeeDetailsInfo getEmployeeDetails(String id){}
     */
    public static EmployeeDetailsInfo getEmployeeDetails(String id) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        EmployeeDetailsInfo empdetails =null;
        try{
        empdetails = obj.getEmployeeDetails(id);
            
        }catch(Exception e){
            log.writeEvent(e.toString());
        }
        return empdetails;
    }

    /*
            public boolean insertEmployeeDetails(EmployeeDetailsInfo emp){}
     */
    public static boolean insertEmployeeDetails(EmployeeDetailsInfo emp) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        boolean flag = false;
        try{
        flag = obj.insertEmployeeDetails(emp);
            
        }catch(Exception e){
            log.writeEvent(e.toString());
        }
        return flag;
    }
    /*
            public boolean updateEmployeeDetails(EmployeeDetailsInfo emp){}
     */
    public static boolean updateEmployeeDetails(EmployeeDetailsInfo emp) {
        EmployeeDtailsDataSource obj = new EmployeeDtailsDataSource();
        boolean flag = false;
        try{
        flag = obj.updateEmployeeDetails(emp);
            
        }catch(Exception e){
            log.writeEvent(e.toString());
        }
        return flag;
    }

 /*
     */
 /*
     */
}
