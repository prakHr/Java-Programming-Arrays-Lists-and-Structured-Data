import java.util.*;
import edu.duke.*;
/**
 * Takes words from file using FileResource and gives # of unique words using arrays size as large as FileResource size
 * 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/lecture/B50g7/arraylist-advantages-and-issues 
 * @week 2
 */

public class WordsWithArrays {
    StorageResource myWords;
    public WordsWithArrays(){
        myWords=new StorageResource();
    }
    public void readWords(){
        myWords.clear();
        FileResource resource =new FileResource();
        for(String word:resource.words())
        {
            myWords.add(word.toLowerCase());
        }
    }
    public boolean contains(String[] list,String word,int number){
        for(int k=0;k<number;k++)
        {
            if(list[k].equals(word))return true;
        }
        return false;
    }
    public int numberOfUniqueWords(){
        int numStored=0;
        String[] words=new String [myWords.size()];
        for(String s:myWords.data()){
            if(!contains(words,s,numStored)){
                words[numStored]=s;
                numStored++;
            }
        }
        return numStored;
    }
    public void tester(){
        readWords();
        System.out.println("Size of array "+myWords.size());
        System.out.println("# of unique words "+numberOfUniqueWords());
    }

}
