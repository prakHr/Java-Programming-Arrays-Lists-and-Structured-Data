import edu.duke.*;
/**
 * encryption methods encrypts the original message by shifting it according to a key
 * decryption then decrypts it according to most frequently occuring word 'e' in english vocab
 *
 * @course java programming arrays, structured lists and data
 * @week 1
 * @assignment 2-caesar cipher
 */
public class CaesarCypher
{
    public String encrypt(String input,int key){
        StringBuilder encrypted=new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++){
            char currChar=encrypted.charAt(i);
            char lch=Character.toLowerCase(currChar);
            char uch=Character.toUpperCase(currChar);
            int idx=alphabet.indexOf(uch);
            if(idx!=-1){
                char newChar=shiftedAlphabet.charAt(idx);
                if(currChar==lch){
                    newChar=Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }
    public String encryptTwoKeys(String input,int key1,int key2){
        StringBuilder encrypted=new StringBuilder(input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        for(int i=0;i<encrypted.length();i++){
            if(i%2==0){
                char currChar=encrypted.charAt(i);
                char lch=Character.toLowerCase(currChar);
                char uch=Character.toUpperCase(currChar);
                int idx=alphabet.indexOf(uch);
                if(idx!=-1){
                    char newChar=shiftedAlphabet1.charAt(idx);
                    if(currChar==lch){
                        newChar=Character.toLowerCase(newChar);
                    }
                    encrypted.setCharAt(i,newChar);
                }
            }
            else{
                char currChar=encrypted.charAt(i);
                char lch=Character.toLowerCase(currChar);
                char uch=Character.toUpperCase(currChar);
                int idx=alphabet.indexOf(uch);
                if(idx!=-1){
                    char newChar=shiftedAlphabet2.charAt(idx);
                    if(currChar==lch){
                        newChar=Character.toLowerCase(newChar);
                    }
                    encrypted.setCharAt(i,newChar);
                }
            }
                
        }
        return encrypted.toString();
    }
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
    
    public void testCaesar(){
        /**
        int key=17;
        FileResource fr=new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted,26-key);
        System.out.println(decrypted);
        **/
        int key1=21,key2=8;
        System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?",15));
        System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?",key1,key2));
    }
    public int maxIndex(int[] vals){
        int maxDex=0;
        for(int k=0;k<vals.length;k++){
            if(vals[k]>vals[maxDex])maxDex=k;
        }
        return maxDex;
    }
    
    public String decrypt(String encrypted){
        CaesarCypher cc=new CaesarCypher();
        int[] freqs= countLetters(encrypted);
        int maxDex=maxIndex(freqs);
        int dkey=maxDex-4;
        if(maxDex<4)dkey=26-(4-maxDex);
        return cc.encrypt(encrypted,26-dkey);
    }
}

