import edu.duke.*;
/**
 * added additional tests and methods that breaks caesar cipher assuming 'e' as most frequently occuring word
 * 
 * @course java programming arrays structured lists data
 * @week 1
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/DBSYj/programming-exercise-object-oriented-caesar-cipher
 * @assignment 1 One key
 */
public class TestCaesarCipherTwo {
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
    
    public int maxIndex(int[] vals){
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
    public void simpleTests(){
        //FileResource fr=new FileResource();
        //String message = fr.asString();
        //CaesarCipherTwo cc=new CaesarCipherTwo(17,3);
        //String encryptedString=cc.encrypt(message);
        //System.out.println(encryptedString);
        //String decryptedString=cc.decrypt(encryptedString);
        
        //String message="Hfs cpwewloj loks cd Hoto kyg Cyy.";
        //CaesarCipherTwo cc=new CaesarCipherTwo(14,24);
        //String encryptedString=message;
        //String decryptedString=cc.decrypt(encryptedString);
        //System.out.println("decryptedString:"+decryptedString);
        
        //String message="Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        //breakCaesarCipher(message);
        FileResource fr=new FileResource();
        String message = fr.asString();
        breakCaesarCipher(message);
    }
    public int maxIndex1(int[] vals){
        int maxDex=0;
        for(int k=0;k<vals.length;k++){
            if(vals[k]>vals[maxDex])maxDex=k;
        }
        return maxDex;
    }
    public int getKey(String s)
    {
        int[] countsArray=countLetters(s);
        int maxDex=maxIndex1(countsArray);
        int dkey=maxDex-4;
        if(maxDex<4)dkey=26-(4-maxDex);
        return dkey;
    }
    public void breakCaesarCipher(String input){
        String s1=halfOfString(input,0);
        String s2=halfOfString(input,1);
        int maxDex1=getKey(s1);
        int maxDex2=getKey(s2);
        
        CaesarCipherTwo cc=new CaesarCipherTwo(26-maxDex1,26-maxDex2);
        System.out.println("key1"+"\t"+(26-maxDex1));
        System.out.println("key1"+"\t"+(26-maxDex2));
        String decryptedString=cc.encrypt(input);
        System.out.println(decryptedString);
        
    }
}
