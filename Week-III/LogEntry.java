import java.util.*;
/**
 * From a string of log entries in a website, this program finds different fields.
 * The fields being investigated are ip address, access time, request, status codes and bytes returned
 * 
 * @author (Prakhar Gandhi) 
 * @site (https://www.coursera.org/learn/java-programming-arrays-lists-data/lecture/MEsTZ/logentry-class-with-tostring)
 */
public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;
    public LogEntry(String ip,Date time,String req,int status,int bytes){
        ipAddress=ip;
        accessTime=time;
        request=req;
        statusCode=status;
        bytesReturned=bytes;
    }
    public String getIpAddress(){
        return ipAddress;
    }
    public Date getAccessTime(){
        return accessTime;
    }
    public String getRequest(){
        return request;
    }
    public int getStatusCode(){
        return statusCode;
    }
    public int getBytesReturned(){
        return bytesReturned;
    }
    public String toString(){
        return ipAddress+" "+accessTime+" "+request+" "
        +statusCode+" "+bytesReturned;
    }
}
