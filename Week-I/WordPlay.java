
/**
 * Replaces vowels present in a string with another character 
 * 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/DvNzQ/programming-exercise-implementing-the-caesar-cipher 
 * @assignment 1-Word Play
 */
public class WordPlay {
    public boolean isVowel(char ch){
        
        String vowels="aeiouAEIOU";
        for(int i=0;i<vowels.length();i++){
            char v=vowels.charAt(i);
            if(ch==v)return true;
        }
        return false;    
    }
    public String replaceVowels(String phrase,char ch){
        StringBuilder newphrase=new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            char current=phrase.charAt(i);
            if(isVowel(current)){
                newphrase.setCharAt(i,ch);
            }
           
        }
        return newphrase.toString();
    }
    public String emphasize(String phrase,char ch){
        ch=Character.toLowerCase(ch);
        StringBuilder newphrase=new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            char current=phrase.charAt(i);
            char lch=Character.toLowerCase(current);
            char uch=Character.toUpperCase(current);
                
            if(lch==ch){
                if((i+1)%2==0)newphrase.setCharAt(i,'+');
                else newphrase.setCharAt(i,'*');
            }
        }
        return newphrase.toString();
    }
    public void testWordPlay(){
        
        System.out.println(replaceVowels("HEllo wOrld",'*'));
        System.out.println(emphasize("dna ctgaaactga",'a'));
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
    }
    
    public void textFingerPrint(String s){
        String alpha="abcdefghijklmnopqrstuvwxyz";
        int[] counters= new int[26];
        for(int k=0;k<s.length();k++){
            char ch=s.charAt(k);
            int index=alpha.indexOf(Character.toLowerCase(ch));
            if(index!=-1){
                counters[index]+=1;
            }
        }
        for(int k=0;k<counters.length;k++){
            System.out.println(alpha.charAt(k)+"\t"+counters[k]);
        }
    }
    
}
