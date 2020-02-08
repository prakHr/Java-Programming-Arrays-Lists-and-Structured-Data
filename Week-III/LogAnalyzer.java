import java.util.*;
import edu.duke.*;

/**
 * read files containing logs and parses them line by line
 * 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/cAl9o/programming-exercise-reading-log-files
 * @week 3
 * @Assignment-Reading Web Logs 
 */


public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    public LogAnalyzer(){
        records=new ArrayList<>();
    }
    public void readFile(String filename)
    {
        FileResource fr=new FileResource(filename);
        WebLogParser wb=new WebLogParser();
        for(String line:fr.lines())
        {
            records.add(WebLogParser.parseEntry(line));
        }
    }
    public void printAllHigherThanNum(int num)
    {
        for(LogEntry le:records){
            int status=le.getStatusCode();
            if(status>num)System.out.println(le);
        }
    }
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> unique=new ArrayList<>();
        for(LogEntry le:records){
            String date=le.getAccessTime().toString();
            if(date.contains(someday)){
                String s=le.getIpAddress();
                if(!unique.contains(s)){unique.add(s);}
            }
        }
        return unique;
    }
    public int countUniqueIPsInRange(int low,int high){
        
        ArrayList<String> uniqueIps = new ArrayList<>();
        for(LogEntry le:records){
            int status=le.getStatusCode();
            if(status>=low && status <=high){
                String s = le.getIpAddress();
                if(!uniqueIps.contains(s))
                    uniqueIps.add(s);
            }
        }
        return uniqueIps.size();
    }
    public void printAll(){
        for(LogEntry le:records)
        {
            System.out.println(le);
        }
    }
      public int countUniqueIPs(){
         ArrayList<String> uniqueIps = new ArrayList<>();
         for(LogEntry le : records){
             String s = le.getIpAddress();
             if(!uniqueIps.contains(s))
                uniqueIps.add(s);
         }
        return uniqueIps.size();
     } 
      public HashMap<String, Integer> countVisitsPerIP(){
          HashMap<String, Integer> counts = new HashMap<String, Integer>();
          for(LogEntry le : records){
             String ip = le.getIpAddress();
             if(!counts.containsKey(ip)){
                counts.put(ip,1);
             }else
                counts.put(ip, counts.get(ip)+1);
            }
          return counts;
     }
     private HashMap<String, Integer> countVisitsPerIP(String day) {
    	 HashMap<String, Integer> map = new HashMap<String, Integer>();
    	 
    	 for (LogEntry le : records) {
    	     String date=le.getAccessTime().toString();
             String thisDay=date.substring(4,10);
             
    	     if (!thisDay.equals(day)) continue;
    		 
    	     String ip = le.getIpAddress();
    	     if (!map.keySet().contains(ip)) map.put(ip, 1);
    	     else map.put(ip, map.get(ip)+1);
    	 }
    	 return map;
    	 
     }
     public int mostNumberVisitsByIP(HashMap<String,Integer> map){
         int max=0;
         for(String s:map.keySet())
         {
             int u=map.get(s);
             if(u>max)max=u;
         }
         return max;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map){
        ArrayList<String> uniqueIps = new ArrayList<>();
        int max=mostNumberVisitsByIP(map);
        for(String s:map.keySet()){
            int u=map.get(s);
            if(u==max){
                uniqueIps.add(s);
            }
        }
        return uniqueIps;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays(){
         HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
         for(LogEntry le : records){
             String date=le.getAccessTime().toString();
             String day=date.substring(4,10);
             String ip=le.getIpAddress();
             if(!map.containsKey(day))
             {
                 ArrayList<String> al=new ArrayList<String>();
                 al.add(ip);
                 map.put(day,al);
             }
             else
             {
                 map.get(day).add(ip);
             }
             
         }
         return map;
     }
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map)
     {
         String ans="";
         int max=Integer.MIN_VALUE;
         for(String day:map.keySet())
         {
             
             int u=map.get(day).size();
             if(u>max){
                 max=u;
                 ans=day;
             }
         }
         return ans;
     }
     public ArrayList<String> iPsWithMostVisitsOnDay( HashMap<String, ArrayList<String>> map
     , String day){
         ArrayList<String> ans=new ArrayList<String>();
         HashMap<String,Integer> u=new HashMap<String,Integer>();
         ans=map.get(day);
         for(String s:ans){
             if(!u.containsKey(s))u.put(s,1);
             else u.put(s,u.get(s)+1);
         }
         ans=iPsMostVisits(u);
         return ans;
     }
}
