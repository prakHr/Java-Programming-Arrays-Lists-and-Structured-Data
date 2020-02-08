
import edu.duke.*;
import java.util.*;
/**
 * This program creates a story from a template and replaces the tags from the files included.
 * It detects the kind of tags like Adjective, Noun, Color, Country, Time, Verb and etc. 
 *
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GladLibMap {
    
    private HashMap<String,ArrayList<String>> myMap;
    private ArrayList<String> usedWords;
    private ArrayList<String> usedLabels;
    private Random myRandom;
    private int wordCount = 0;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    private String source;
    
    /*
     * Creating a constructor the initialize the instance variables.
     * We use initializeFromSource function to load its content from the text file stored in source directory
     * The source can be a URL or a text file. 
     */
    public GladLibMap(){
        this.source=source;
        usedLabels = new ArrayList<String>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        this.source=source;
        usedLabels = new ArrayList<String>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        myMap = new HashMap<String, ArrayList<String>>();
        String[] fnameArray = {"adjective","noun","color","country","name",
            "animal","timeframe","verb","fruit"};
        for(String fname:fnameArray){
            myMap.put(fname,readIt(source+"/"+fname+".txt"));
        }
        ArrayList<String> nums = new ArrayList<String>();
        for (int i=0;i<50;i++) nums.add(Integer.toString(i));
        myMap.put("number", nums);
        usedWords = new ArrayList<String>();
    }
    
    /*
     * This function chooses and returns a random number 
     */
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
    return source.get(index);
        
    }
    
    /*
     * This function uses the ArrayList of tags stored from the text file.
     */
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
	}
        if(myMap.containsKey(label)){
            usedLabels.add(label);
            return randomFrom(myMap.get(label));
            
        }
        /*for(String s:myMap.keySet()){
            if(s.equals(label)){
                return randomFrom(myMap.get(s));
            }
        }*/
        return "**UNKNOWN**";
    }
    
    /*
     * This function locates the index of '<' & '>' and finds the tag. 
     * It calls getSubstitute method to find a substitute for the tag inside the barckets.
     */
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = "";
        while(true){
            sub = getSubstitute(w.substring(first+1,last));
            int usedIndex = usedWords.indexOf(sub);
           
            if(usedIndex == -1)   {
             usedWords.add(sub);
             wordCount++;
             //return randWord;
             break;
            }
        }
        return prefix+sub+suffix;
    }
    private int totalWordsInMap(){
     //int total=0;
     //for(String s:myMap.keySet()){
     //       int u =myMap.get(s).size();
     //       total+=u;
     //   }
     //return total;
     
     //int cnt = 0;
     //   for (String key : myMap.keySet()) {
     //       for (String word : myMap.get(key)) cnt++;
     //   }
     //   return cnt;
     int total = 0;
     for(Map.Entry<String, ArrayList<String>> entry : myMap.entrySet()){
         total += entry.getValue().size();
     }
     return total;
    }
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        usedWords.clear(); 
        return story;
    }
    /*
     * Reads the data from a URL or a File in the source directory
     */
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    private int totalWordsConsidered()
    {
        int cnt=0;
        for(String label:usedLabels){
            cnt+=myMap.get(label).size();
        }
        return cnt;
        
    }
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate.txt");
        printOut(story, 60);
        System.out.println("\nTotal words present in map: "+totalWordsInMap());
        System.out.println("\nTotal words considered: "+totalWordsConsidered());
        
        System.out.println("\nReplaced words: "+wordCount);
        wordCount = 0;
    }
}
