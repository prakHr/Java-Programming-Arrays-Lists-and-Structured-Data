
import java.util.*;
import edu.duke.*;
import java.io.*;
/**
 * 
 * 
 * @week 4 
 * @Assignment - English Language, Known Key Length 
 */
public class VigenereBreaker {
    public String sliceString(String message,int whichSlice,int totalSlices){
        StringBuilder ans=new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            ans.append(message.substring(i,i+1));
        }
        return ans.toString();
    }
    public int[] tryKeyLength(String encrypted,int klength,char mostCommon)
    {
        int[] keys=new int[klength];
        String[] groups=new String[klength];
        //i=0 to klength-1
        for(int i=0;i<klength;i++)groups[i]=sliceString(encrypted,i,klength);
        CaesarCracker cc=new CaesarCracker(mostCommon);
        for(int i=0;i<klength;i++)keys[i]=cc.getKey(groups[i]);
        return keys;
    }
    public void breakVigenere()
    {
        //FileResource fr=new FileResource();
        //String message=fr.asString();
        //int[] keys= tryKeyLength(message,5,'e');
        //VigenereCipher vc=new VigenereCipher(keys);
        //String decryptedMessage=vc.decrypt(message);
        //System.out.println(decryptedMessage);
        
        //FileResource fr=new FileResource();
        //String message=fr.asString();
        //FileResource fr1=new FileResource();
        //HashSet<String> englishDict=readDictionary(fr1);
        //String decryptedMessage=breakForLanguage(message,englishDict);
        //System.out.println(decryptedMessage);
        
        FileResource fr=new FileResource();
        String message=fr.asString();
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            FileResource fr2=new FileResource(f.toString());
            HashSet<String> result=new HashSet<String>();
            for(String line:fr2.lines())
            {
                line=line.toLowerCase();
                result.add(line);
            }
            languages.put(f.getName(),result);
            System.out.println("Finished reading "+f.getName());
        }
        HashMap<String, String>decryptedMessages=breakForAllLangs(message,languages);
        System.out.println(decryptedMessages.get("English"));
    }
    
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> result=new HashSet<String>();
        for(String line:fr.lines())
        {
            result.add(line.toLowerCase());
        }
        return result;
    }
    public Integer countWords(String message, HashSet<String> dictionary)
    {
        int cnt=0;
        for(String word:message.split("\\W"))
        {
            if(dictionary.contains(word.toLowerCase()))cnt+=1;
        }
        return cnt;
    }
    public String breakForLanguage(String encrypted, HashSet<String> dictionary,String mostCommon)
    {
        int max=0;
        String ans="";
        int []bestKeys=new int[100];
        for(int k=1;k<=100;k++)
        {
            int[] keys=tryKeyLength(encrypted,k,mostCommon.charAt(0));
            VigenereCipher vc=new VigenereCipher(keys);
            String decryptedMessage=vc.decrypt(encrypted);
            int num=countWords(decryptedMessage,dictionary);
            if(num>max){
                max=num;
                ans=decryptedMessage;
                bestKeys=keys;
            }
        }
        /*System.out.println("______________");
        for(int k=0;k<bestKeys.length;k++)
            System.out.println(bestKeys[k]);
        System.out.println("______________");*/
        return ans;
    }
    public String breakForLanguage(String encrypted, HashSet<String> dictionary)
    {
        int max=0;
        String ans="";
        int []bestKeys=new int[100];
        for(int k=1;k<=100;k++)
        {
            int[] keys=tryKeyLength(encrypted,k,'e');
            VigenereCipher vc=new VigenereCipher(keys);
            String decryptedMessage=vc.decrypt(encrypted);
            int num=countWords(decryptedMessage,dictionary);
            if(num>max){
                max=num;
                ans=decryptedMessage;
                bestKeys=keys;
            }
        }
        /*System.out.println("______________");
        for(int k=0;k<bestKeys.length;k++)
            System.out.println(bestKeys[k]);
        System.out.println("______________");*/
        return ans;
    }
    public String mostCommonCharIn(HashSet<String> dictionary)
    {
        HashMap<String,Integer> m=new HashMap<String,Integer>();
        String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabets=alphabets.toLowerCase();
        for(int k=0;k<alphabets.length();k++)
        {
            m.put(alphabets.substring(k,k+1),0);
        }
        for(String word:dictionary)
        {
            word=word.toLowerCase();
            String[] letters=word.split("");
            for(String letter:m.keySet()){
                for(String le:letters)
                {
                    if(le.equals(letter))m.put(letter,m.get(letter)+1);
                }
            }
        }
        int max=0;
        String ans=null;
        for(String letter:m.keySet())
        {
            if(m.get(letter)>max)
            {
                max=m.get(letter);
                ans=letter;
            }
        }
        return ans;
    }
    public HashMap<String, String> breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages)
    {
        HashMap<String, String> result = new HashMap<String, String>();
        for(String language:languages.keySet() )
        {
            HashSet<String> dict=languages.get(language);
            String m= mostCommonCharIn(dict);
            String lanstring=breakForLanguage(encrypted,dict,m);
            result.put(language,lanstring);
        }
        return result;
        
    }
}
