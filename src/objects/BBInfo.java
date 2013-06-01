package objects;

/**
 *
 * @author alexisvincent
 */
public class BBInfo {
    private int bbID;
    String subject, info;

    public BBInfo() {
    }

    public BBInfo(int bbID, String subject, String info) {
        this.bbID = bbID;
        this.subject = subject;
        this.info = info;
    }

    public int getBbID() {
        return bbID;
    }

    public void setBbID(int bbID) {
        this.bbID = bbID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "BBInfo{" + "bbID=" + bbID + ", subject=" + subject + ", info=" + info + '}';
    }
    
}
