import java.util.Random;
/**
 * Simulate rolling 2 6-sided die, keep statistics
 * 
 * @site (https://www.coursera.org/learn/java-programming-arrays-lists-data/lecture/m6tM1/random-numbers-and-arrays) 
 * 
 */
public class DiceRolling {
    public void simulate(int rolls){
        Random rand = new Random();
        int [] counts= new int[13];
        for(int k=0;k<rolls;k++){
            int d1=rand.nextInt(6)+1;
            int d2=rand.nextInt(6)+1;
            int sum=d1+d2;
            counts[d1+d2]+=1;
        }
        for(int k=2;k<13;k++){
            System.out.println(k+"'s=\t"+counts[k]+"\t"+100.0*counts[k]/rolls);
        }
        
    }

    public void simpleSimulate(int rolls){
        Random rand = new Random();
        int twos=0,twelves=0;
        for(int k=0;k<rolls;k++){
            int d1=rand.nextInt(6)+1;
            int d2=rand.nextInt(6)+1;
            int sum=d1+d2;
            if(sum==2)twos+=1;
            if(sum==12)twelves+=1;
        }
        System.out.println("2's=\t"+twos+"\t"+100.0*twos/rolls);
        System.out.println("12's=\t"+twelves+"\t"+100.0*twelves/rolls);
    }

}
