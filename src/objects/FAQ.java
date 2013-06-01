package objects;

/**
 *
 * @author alexisvincent
 */
public class FAQ {
    private int faqID;
    private String subject, info;

    public FAQ() {
    }

    public FAQ(int faqID, String subject, String info) {
        this.faqID = faqID;
        this.subject = subject;
        this.info = info;
    }

    public int getFaqID() {
        return faqID;
    }

    public void setFaqID(int faqID) {
        this.faqID = faqID;
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
        return "FAQ{" + "faqID=" + faqID + ", subject=" + subject + ", info=" + info + '}';
    }
    
}
