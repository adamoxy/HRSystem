package adamoxy.setget;

/**
 *
 * @author adam
 */
public class AttachmentInfo {

    int empno, id;
    String filename, description;

    public int getAttachmentId() {
        return id;
    }

    public void setAttachmentId(int id) {
        this.id = id;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }
}
