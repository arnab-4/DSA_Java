public class StringCompression {

    public static String compress(String str)
    {
        String nwstr="";
        for(int i=0;i<str.length();i++)
        {
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
            {
                count++;
                i++;
            }
            nwstr+=str.charAt(i);
            if(count> 1)
            {
                nwstr+=count.toString();
            }
        }
        return nwstr;
    }
    public static void main(String[] args) {
        String str="aabbccddddde";
        System.out.println(compress(str));
    }
}