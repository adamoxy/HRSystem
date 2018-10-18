
package adamoxy.database;

import adamoxy.common.log;
import adamoxy.setget.DepartmentInfo;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class DepartmentDataSource {
    public ArrayList<DepartmentInfo> getAllDepartments(){
       ArrayList list=null;
       String sql="select * from departments ";
       try{
       DepartmentInfo depinfo=new DepartmentInfo();
       
       
       }catch(Exception e){
           log.writeEvent(e.toString());
       }
        
       return list;
    }
}
