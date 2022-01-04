import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      String normal = sc.nextLine();
      String ciphered= sc.nextLine();
      System.out.println(ciphering(normal));
      System.out.println(deciphering(ciphered));
    }
    public static String Ap="3"; 
    public static String ciphering(String normal){
        StringBuffer sb = new StringBuffer(normal);
        for(int i=0;i<normal.length();i++){
            Character ch = sb.charAt(i);
            if(Character.isLowerCase(ch)){
                sb.replace(i,i+1,Character.toUpperCase(ch)+"");
            }
            else{
                sb.replace(i,i+1,Character.toLowerCase(ch)+"");
            }
        }
        normal=sb.toString();
        StringBuilder inp = new StringBuilder();
        inp.append(normal);
        normal=(inp.reverse()).toString();
        StringBuilder SB = new StringBuilder();
        for(int i=0;i<normal.length();i++){
            if(i%2!=0){
                int m = normal.charAt(i);
                SB.append(m);
            }
            else{
                SB.append(normal.charAt(i));
            }
        }
        SB.append(Ap);
        String str1=SB.toString();
        str1=str1.replace(" ","*");
        return str1;
    }
    public static String deciphering(String ciphered){
        String newstr="";
        String sub = ciphered.substring(ciphered.length()-2,ciphered.length()-1);
        for(int i=0;i<ciphered.length()-2;i++){
            int num=0;
            if(Character.isDigit(ciphered.charAt(i)) && Character.isDigit(ciphered.charAt(i+1)) && Character.isDigit(ciphered.charAt(i+2)) == false && ciphered.charAt(i)>='3' && ciphered.charAt(i)<='9'){
              num=Integer.parseInt(String.valueOf(ciphered.charAt(i)))*10+Integer.parseInt(String.valueOf(ciphered.charAt(i+1)));
              if(num>=65 && num<=99){
                 newstr+=(char)num;
              }
              if(num>=32 && num<=63){
                  newstr+=(char)num;
              }
            
            }
            else{
                newstr+=ciphered.charAt(i);
            }
           
        }
        newstr+=sub;
        System.out.println(newstr);
        String Str1="";
        for(int i=0;i<newstr.length()-2;i++){
            int num=0;
            if(Character.isDigit(newstr.charAt(i)) && Character.isDigit(newstr.charAt(i+1)) && Character.isDigit(newstr.charAt(i+2))){
              num=Integer.parseInt(String.valueOf(newstr.charAt(i)))*100+Integer.parseInt(String.valueOf(newstr.charAt(i+1)))*10+Integer.parseInt(String.valueOf(newstr.charAt(i+2)));
              if(num>=100 && num<=127){
                 Str1+=(char)num;
              }
            }
            else{
                Str1+=newstr.charAt(i);
            }
            }
           // System.out.println(Str1);
            String Str2="";
            for(int i=0;i<Str1.length();i++){
              if(Str1.charAt(i)>='0' && Str1.charAt(i)<='9'){
                  continue;
              }
              else{
                  Str2+=Str1.charAt(i);
              }
            }
           // System.out.println(Str2);
            String Str="";
            for(int i=0;i<Str2.length();i++){
                if(Character.isLowerCase(Str2.charAt(i))){
                    Str+=Character.toUpperCase(Str2.charAt(i));
                }
                else if(Character.isUpperCase(Str2.charAt(i))){
                    Str+=Character.toLowerCase(Str2.charAt(i));
                }
                else{
                    Str+=Str2.charAt(i);
                }
            }
            StringBuilder SB = new StringBuilder(Str);
            Str=SB.reverse().toString();
            String FStr = Str.replace('*',' ');
            
            return FStr;
        }
        
    }
