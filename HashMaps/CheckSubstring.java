
/*-- Check if B is a substring of A or not, if yes then return the index of first occurrence else return -1 --*/

import java.util.*;

public class CheckSubstring {
    
    static int subString(String A, String B) {

        if(A.length()==0 || B.length()==0)
            return -1;

        if(A.length()==B.length() && A.equals(B))
            return 0;

        HashMap<Integer, String> hm = new HashMap<>();

        for(int i=0; i<(A.length() - B.length()); i++){

            hm.put(i, A.substring(i, i + B.length()));

        }


        try{
            for(int i=0; i<hm.size(); i++){
            if(hm.get(i).equals(B))
                return i;

            }
        }

        catch(Exception e){
            return -1;
        }

        return -1;

    }
    
    /*-- Inputs from the main method --*/
    
    public static void main(String[] args){
    
        System.out.println(subString("WhoIsJohnson","John"));
        
    }
    
}




