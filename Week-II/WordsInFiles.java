import edu.duke.*;
import java.util.*;
import java.io.File;
/**
 * Write a description of CodonCounter here.
 * @course 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/RnGtN/programming-exercise-improving-gladlibs 
 * @week 2
 * @Programming Exercise-Improving GladLibs
 * @assignment 1-Words in Files
 * 
 */
public class WordsInFiles {
    private HashMap <String,ArrayList<String>> map;
    public WordsInFiles() {
        map = new HashMap<String,ArrayList<String>>();
    }
    private void addWordsFromFile(File f){
        FileResource fr=new FileResource(f);
        String fname=f.getName();
        for(String word:fr.words())
        {
            if(!map.containsKey(word))
            {
                ArrayList<String> al=new ArrayList<String>();
                al.add(fname);
                map.put(word,al);
            }
            else
            {
                ArrayList<String> al=map.get(word);
                if(!al.contains(fname))al.add(fname);
            }
        }
    }
    private void buildWordFileMap(){
        map.clear();
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    private int maxNumber(){
        int maxCount=0;
        for(String s:map.keySet()){
           ArrayList<String> al=map.get(s);
           int u=al.size();
           if(u>maxCount){
                maxCount=u;
            }
        }
        return maxCount;
    }
    private ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String> al=new ArrayList<String>();
        for(String s:map.keySet()){
            int u =map.get(s).size();
            if(u==number)al.add(s);
        }
        return al;
    }
    private void printFilesIn(String word){
        ArrayList<String> al=new ArrayList<String>();
        for(String s:map.keySet()){
            if(s.equals(word)){
                al=map.get(s);
                break;
            }
        }
        for(String files:al){
            System.out.println(files);
        }
        //for(String fname:map.get(word))System.out.println(fname);
    }
    private void tester(){
        buildWordFileMap();
        System.out.println(maxNumber());
        //ArrayList<String> al=wordsInNumFiles(3);
        System.out.println("Number of words in 3 files: " 
		+ wordsInNumFiles(3).size());
        printFilesIn("cats");
        
    }
}
