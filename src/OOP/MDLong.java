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

   public MDLong(ArrayList<Integer> x){
      this.number = x;
   }

    private ArrayList<Integer> ArrayConverter(int input){
      
      ArrayList<Integer> result = new ArrayList<Integer>();      
      
      if (input == 0){
        result.add(0);
      }
     else
      while(input > 0)
      {
        int tmp = input % 10;
        input /= 10;
        result.add(tmp);
      }

      return result;

    }
 
    public void FacMargoPidr(MDLong input){

        ArrayList<Integer> helper = input.getNumber();
        int length = number.size() + helper.size() + 1;
        ArrayList<Integer> con = new ArrayList<Integer>();
        for (int i = 0; i <=length; i++) {
         con.add(0);
        }

        for (int ix = 0; ix < number.size(); ix++)
            for (int jx = 0; jx < helper.size(); jx++)
                con.set(ix + jx , number.get(ix) * helper.get(jx) + con.get(ix + jx) );
         
        for (int ix = 0; ix<length; ix++)
        {
            con.set(ix + 1,con.get(ix) / 10 + con.get(ix+1));
            con.set(ix,con.get(ix) % 10);
        }
        while(con.get(length) == 0){
            con.remove(length);
            length--;
        }
        
        this.number = con;
    }

   public ArrayList<Integer> getNumber(){
      return this.number;
   }
  
   public void setNumber(ArrayList<Integer> x){
      this.number = x;
   }
   public String toString(){
        String result = "";
        for(int i = number.size()-1;i>=0;i--)
            result +=number.get(i);
        return result;
   }
 

   public static void main(String []args){
      
      MDLong myLong = new MDLong( 234 );
      MDLong myLong2 = new MDLong( 765 );
      myLong.FacMargoPidr(myLong2);
      System.out.println(myLong.toString());
   }
}