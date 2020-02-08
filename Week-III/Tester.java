import java.util.*;
/**
 * added test methods
 * 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/cAl9o/programming-exercise-reading-log-files
 * @week 3
 * @Assignment-Reading Web Logs 
 */

public class Tester {
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        
    }
    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        int u=la.countUniqueIPs();
        System.out.println("There are "+u+" IPs\n");
        System.out.println();
        la.printAllHigherThanNum(400);
        System.out.println();
        ArrayList<String> uniqueIpsDay = la.uniqueIPVisitsOnDay("Sep 24");
        for(String le : uniqueIpsDay){
                System.out.println(le);
         }
        System.out.println("Size of arraylist " + uniqueIpsDay.size() );
        System.out.println("Number of unique IPs in the range: " + la.countUniqueIPsInRange(200,299));
        
    }
    public void testCountingVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
        int maxValue = la.mostNumberVisitsByIP(counts);
        System.out.println(maxValue);
        ArrayList<String> ips = la.iPsMostVisits(counts);
        System.out.println(ips);
        
    }
    
    public void testIpsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String,ArrayList<String>> ips = la.iPsForDays();
        System.out.println(ips);
        String day = la.dayWithMostIPVisits(ips);
        System.out.println(day);
        ArrayList<String> ip = la.iPsWithMostVisitsOnDay(ips,"Sep 30");
        System.out.println(ip);
    }

}
