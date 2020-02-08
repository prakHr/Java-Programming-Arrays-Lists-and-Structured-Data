
/**
 * combination of key1 and key2 encryption using object oriented approach
 * 
 * @course java programming arrays structured lists data
 * @week 1
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/DBSYj/programming-exercise-object-oriented-caesar-cipher
 * @assignment 1 One key
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1,int key2){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        mainKey1=key1;
        mainKey2=key2;
        
    }
    public String encrypt(String input){
        StringBuilder encrypted=new StringBuilder(input);
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
    
    
    
    public String decrypt(String input){
        mainKey1=26-mainKey1;
        mainKey2=26-mainKey2;
        CaesarCipherTwo cc= new CaesarCipherTwo(mainKey1,mainKey2);
        return cc.encrypt(input);
        
    }
}
