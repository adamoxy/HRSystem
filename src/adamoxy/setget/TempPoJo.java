package adamoxy.setget;

/**
 *
 * @author adam
 */
// THIS TO HELP YOU TO CARRY ANY LOAD AS YOU HAD NO SET AND GET FOR IT 
// YOU CAN 'T MAKE SET GET CLASS FOR EVERY COLUMN
public class TempPoJo {

    public String STRING;
    public String param;
    public String value;
    public int INT;
    public double DOUBLE;
    public boolean BOOLEAN;
    public Object OBJECT;

    public void setParam(String param){
        this.param=param;
    }
    public void setValue(String value){
        this.value=value;
    }
    public String getParam(){
        return param;
    }
    public String getValue(){
        return value;
    }
    public void setBOOLEAN(boolean BOOLEAN){
        this.BOOLEAN=BOOLEAN;
    }
    public boolean getBOOLEAN(){
        return BOOLEAN;
    }
    public void setSTRING(String STRING) {
        this.STRING = STRING;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public void setDOUBLE(double DOUBLE) {
        this.DOUBLE = DOUBLE;
    }
    public void setOBJECT(Object obj){
        this.OBJECT=obj;
    }

    public String getSTRING() {
        return STRING;
    }

    public int getINT() {
        return INT;
    }

    public double getDOUBLE() {
        return DOUBLE;
    }
    public Object getOBJECT(){
        return OBJECT;
    }
}
