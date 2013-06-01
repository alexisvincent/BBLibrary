package objects;

import java.util.Date;

/**
 *
 * @author alexisvincent
 */
public class News {
    private int newsID;
    private String subject, info;
    private Date timestamp;

    public News() {
    }

    public News(int newsID, String subject, String info, Date timestamp) {
        this.newsID = newsID;
        this.subject = subject;
        this.info = info;
        this.timestamp = timestamp;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "News{" + "newsID=" + newsID + ", subject=" + subject + ", info=" + info + ", timestamp=" + timestamp + '}';
    }
    
}
