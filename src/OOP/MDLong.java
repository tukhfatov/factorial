import java.util.*;

public class MDLong{
   
   private ArrayList<Integer> number = new ArrayList<Integer>();

   public MDLong(int initial){
      while(initial > 0)
      {
        int tmp = initial % 10;
        initial /= 10;
        number.add(tmp);
      }
   }
   
   public MDLong(){
      number.add(0);
   }
}