import java.util.*;
import edu.duke.*;
/**
 * Write a description of CharactersInPlay here.
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/AbpYj/programming-exercise-telling-a-random-story
 * @week 2
 * @assignment 1-Most Frequent words
 */
public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> freqs;
    public void update(String person){
        String s=person.toLowerCase();
        int index=names.indexOf(s);
        if(index==-1){
            names.add(s);
            freqs.add(1);
        }
        else
        {
            int freq=freqs.get(index);
            freqs.set(index,freq+1);
        }
        
    }
    public void findAllCharacters(){
        names.clear();
        freqs.clear();
        FileResource resource = new FileResource();
        int index=0;
        for(String s:resource.lines()){
            index=s.indexOf(".");
            String subs=s.substring(0,index+1);
            update(subs);
        }
    }
    public void charactersWithNumParts(int num1, int num2){
        for(int i=0;i<names.size();i++)
        {
            if(freqs.get(i)>num1 && freqs.get(i)<num2){
                System.out.println(freqs.get(i)+"\t"+names.get(i));
            }
        }
    }
    public void tester(){
        findAllCharacters();
        //for(int i=0;i<names.size();i++){System.out.println(freqs.get(i)+"\t"+names.get(i));}
        charactersWithNumParts(10,900);
    }
  
  
    
}
