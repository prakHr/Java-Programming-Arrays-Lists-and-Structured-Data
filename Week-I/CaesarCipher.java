
/**
 * Uses code of CaesarCypher in object oriented fashion
 * @course java programming arrays, structured lists and data
 * @week 1
 * @site https://www.coursera.org/learn/java-programming-arrays-lists-data/lecture/YvXUW/rewriting-with-encapsulation
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        mainKey=key;
    }
    public String encrypt(String input){
        StringBuilder sb=new StringBuilder(input);
        
        for(int i=0;i<sb.length();i++){
            char currChar=sb.charAt(i);
            char lch=Character.toLowerCase(currChar);
            char uch=Character.toUpperCase(currChar);
            int idx=alphabet.indexOf(currChar);
            
            if(idx!=-1)
            {
                char newChar=shiftedAlphabet.charAt(idx);
                if(currChar==lch){
                    newChar=Character.toLowerCase(newChar);
                }
                sb.setCharAt(i,newChar);
            }
            
        }
        return sb.toString();
    }
    public String decrypt(String input){
        
        mainKey=26-mainKey;
        //CaesarCipher cc= new CaesarCipher(mainKey);
        //return cc.encrypt(input);
        return encrypt(input);
    }
}
