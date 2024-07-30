import java.util.*;
public class ShortestPath {
    
    public static float direction(String str) {
        int x = 0;
        int y = 0;
        
        
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(c=='w')
            {
                x--;
            }
           else if(c=='e')
            {
                x++;
            }
           else if(c=='n')
            {
                y++;
            }
            else if(c=='s'){
                y--;
            }
        }
        int dir=(x*x)+(y*y);
        float ans=(float)Math.sqrt(dir);
        return ans;
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the direction USING {n/s/w/e}:-");
        String dirt = sc.nextLine();
        String mn=dirt.toLowerCase();
       System.out.println("Distance is:"+direction(mn));
    }
}