import edu.duke.*;
/**
 * added tests and object oriented methods
 * 
 * @course java programming arrays structured lists data
 * @week 1
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/DBSYj/programming-exercise-object-oriented-caesar-cipher
 * @assignment 1 One key
 */
public class TestCaesarCipher {
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
    public void breakCaesarCipher(String input)
    {
        //automatically founds key
        int[] freqs= countLetters(input);
        int maxDex=maxIndex(freqs);
        int dkey=maxDex-4;
        if(maxDex<4)dkey=26-(4-maxDex);
        //then creates an object using that key
        CaesarCipher cc = new CaesarCipher(26-dkey);
        String decryptedMessage = cc.encrypt(input);
        System.out.println(decryptedMessage);
    }
    public void simpleTests(){
        FileResource fr=new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encryptedMessage = cc.encrypt(message);
        System.out.println(encryptedMessage);
        String decryptedMessage = cc.decrypt(encryptedMessage);
        breakCaesarCipher(message);
    }
}
