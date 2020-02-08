import edu.duke.*;
/**
 * Decrypts two key encryption method
 * @course java programming arrays lists data
 * @week 1 
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/727CD/programming-exercise-breaking-the-caesar-cipher
 * @Assignment 2: Caesar Cipher Two Keys Decrypt
 */
public class CaesarBreaker {
    public int[] countLetters(String message){
        int[] counts=new int[26];
        String alph="abcdefghijklmnopqrstuvwxyz";
        for(int k=0;k<message.length();k++){
            char ch=Character.toLowerCase(message.charAt(k));
            int dex=alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]+=1;
            }
        }
    return counts;
    }
    
     public int maxIndex(int[] values) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                index = i;
            }
        }
        return index;
    }
    public int maxIndex1(int[] vals){
        int maxDex=0;
        for(int k=0;k<vals.length;k++){
            if(vals[k]>vals[maxDex])maxDex=k;
        }
        return maxDex;
    }
    public String halfOfString(String message,int start)
    {
        String ans="";
        for(int i=start;i<message.length();i+=2){
            ans=ans+message.charAt(i);
        }
        return ans;
    }
    public String decrypt(String encrypted,int key){
        CaesarCypher cc=new CaesarCypher();
        //String message= cc.encrypt(encrypted,26-key);
        int[] freqs= countLetters(encrypted);
        int maxDex=maxIndex(freqs);
        int dkey=maxDex-4;
        if(maxDex<4)dkey=26-(4-maxDex);
        return cc.encrypt(encrypted,26-dkey);
        //return message;
    }
    public int getKey(String s)
    {
        int[] countsArray=countLetters(s);
        int maxDex=maxIndex1(countsArray);
        int dkey=maxDex-4;
        if(maxDex<4)dkey=26-(4-maxDex);
        return dkey;
    }
    public String decryptTwoKeys(String encrypted){
        String s1=halfOfString(encrypted,0);
        String s2=halfOfString(encrypted,1);
        int maxDex1=getKey(s1);
        int maxDex2=getKey(s2);
        System.out.println("key1"+"\t"+maxDex1);
        System.out.println("key2"+"\t"+maxDex2);
        CaesarCypher cc=new CaesarCypher();
        return cc.encryptTwoKeys(encrypted,26-maxDex1,26-maxDex2);
    
    }
    public void testDecrypt(){
        //System.out.println(""+"\t"+halfOfString("",0));
        //System.out.println(""+"\t"+halfOfString("",1));
        //System.out.println("a"+"\t"+halfOfString("a",0));
        //System.out.println("a"+"\t"+halfOfString("a",1));
        //System.out.println("ab"+"\t"+halfOfString("ab",0));
        //System.out.println("ab"+"\t"+halfOfString("ab",1));
        //System.out.println("abc"+"\t"+halfOfString("abc",0));
        //System.out.println("abc"+"\t"+halfOfString("abc",1));
        //System.out.println("Qbkm Zgis"+"\t"+halfOfString("Qbkm Zgis",0));
        //System.out.println("Qbkm Zgis"+"\t"+halfOfString("Qbkm Zgis",1));
        
        //System.out.println(decrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",26-15));
        System.out.println(decryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy."));
        
        //FileResource fr=new FileResource();
        //String message = fr.asString();
        //System.out.println(decryptTwoKeys(message));
    }

}
