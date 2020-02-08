import edu.duke.*;
import java.util.*;
/**
 * Write a description of CodonCounter here.
 * @course 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/RnGtN/programming-exercise-improving-gladlibs 
 * @week 2
 * @Programming Exercise-Improving GladLibs
 * @assignment 1-Codon Count
 */
public class CodonCounter {
    private HashMap<String,Integer> map;
    public CodonCounter() {
        map = new HashMap<String,Integer>();
    }
    public void buildCodonMap(String dna,int start){
        map.clear();
        for(int i=start;i+3<dna.length();i+=3)
        {
            String currentdna=dna.substring(i,i+3);
            if(!map.containsKey(currentdna))
            {
                map.put(currentdna,1);
            }
            else{
                map.put(currentdna,map.get(currentdna)+1);
            }
            
        }
    }
    public void printCodonCounts(int start,int end)
    {
        for(String s:map.keySet()){
            int u=map.get(s);
            if(u>=start && u<end)
            {
                System.out.println(s+" "+u);
            }
        }
    }
    public String getMostCommonCodon(){
        int maxCount=0;
        String ans="";
        for(String s:map.keySet())
        {
            if(map.get(s)>maxCount){
                maxCount=map.get(s);
                ans=s;
            }
        }
        return ans;
    }
    public void tester(){
        FileResource resource = new FileResource();
        String dna=resource.asString();
        dna=dna.trim();
        dna=dna.toUpperCase();
        //String dna= "CGTTCAAGTTCAA" ;
        
        for(int i=0;i<3;i++){
            
        
            buildCodonMap(dna,i);
            System.out.println("Reading frame starting with "+(i)+" results in "+map.size()+" unique codons");
            String ans=getMostCommonCodon();
            System.out.println("and most common codon is "+ans+" with count "+map.get(ans));
            System.out.println("Counts of codons between 1 and 5 inclusive are:");
            printCodonCounts(1,5);
        }
    }
}
