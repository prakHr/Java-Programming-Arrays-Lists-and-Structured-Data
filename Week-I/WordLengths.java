import edu.duke.*;
/**
 * Counts words from a file and return most commonly occuring word
 * 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/727CD/programming-exercise-breaking-the-caesar-cipher 
 * @assignment 1-Word Lengths
 */
public class WordLengths {
    public int indexOfMax(int[] values){
        int max=0,index=0;
        for(int k=0;k<values.length;k++){
            if(values[k]>max){
                max=values[k];
                index=k;
            }
        }
        return index;
    }
    
    public void countWordLengths(FileResource resource,int[] counts){
        for(String word: resource.words()){
            int l=word.length();
            if(!Character.isLetter(word.charAt(0))){
                l--;
            }
            if(!Character.isLetter(word.charAt(word.length()-1)) && word.length()!=1){
                l--;
            }
            counts[l]++;
        }
        for(int i=0;i<counts.length;i++){
            if(counts[i]!=0)
            {
                String word_to_represent="";
                int iterator=0;
                
                for(String word: resource.words()){
                    
                    int l=word.length();
                    if(!Character.isLetter(word.charAt(0))){
                        l--;
                        
                    }
                    
                    if(!Character.isLetter(word.charAt(word.length()-1)) && word.length()!=1){
                        l--;
                    }
                  
                    if (l==i){
                        word_to_represent=word_to_represent+" "+word;
                        iterator+=1;
                    }
                }
                System.out.println(iterator+" words of length "+i+":"+
                word_to_represent);
            }
        }
        int index=indexOfMax(counts);
        System.out.println("The most common word length is "+ index);
    }
    public void testCountWordLengths(){
        int[] counts =new int[31];
        FileResource resource=new FileResource();
        countWordLengths(resource,counts);
        
    }
}
