import edu.duke.*;
import java.util.*;
/**
 * Takes words from file using FileResource and gives # of unique words 
 * using two parallel arraylist or a hashmap
 * @week 2
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/lecture/aHZ0o/arraylist-for-unique-words
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    private HashMap<String,Integer> map;
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
        map = new HashMap<String,Integer>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
            if(!map.containsKey(s)){
                map.put(s,1);
            }
            else{
                map.put(s,map.get(s)+1);
            }
        }
    }
    public void printWords(){
        for(String s:map.keySet()){
            System.out.println(map.get(s)+"\t"+s);
        }
    }
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        int index = findIndexOfMax();
        int sum = 0;
       System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));
       for(int i=0; i<Math.min(10,myWords.size()); i++){
           System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
           sum++;
       } 
        
    }
    public int findIndexOfMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
