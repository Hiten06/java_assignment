import java.util.*;
class Passanger{
    int id;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public float getFare(){
        return fare;
    }
    public void setFare(float fare){
        this.fare=fare;
    }
    float fare;
    public Passanger(int id,float fare){
        this.id=id;
        this.fare=fare;
    }
}
class BusProb{
    public String output(int capacity,int stops,List<String> listOfInputStrings,String query){
        String  outstring ="";
        String s1 = query.substring(0,1);
        String s2 = query.substring(3);
        
        if(s1.equalsIgnoreCase("1")){
            int n = onBus(listOfInputStrings);
            int rem = offBus(listOfInputStrings);
            outstring=n+" number of passanger got on the bus "+rem+" number of passanger got off the bus ";
        }
        else if(s1.equalsIgnoreCase("2")){
            outstring = fare(listOfInputStrings,capacity);
        }
        else if(s1.equalsIgnoreCase("3")){
            outstring = Fare(listOfInputStrings,capacity,s2);
        }
        else if(s1.equalsIgnoreCase("4")){
            
           // System.out.println(s);
            int n = onBus(listOfInputStrings,s2);
            outstring = "Passanger with id "+s2+" has got "+n+" times";
        }
        else if(s1.equalsIgnoreCase("5")){
           boolean n = lastRow(listOfInputStrings.get(listOfInputStrings.size()-1), s2);
           if(n){
            outstring="Passanger with id "+ s2 +"on the bus";
           }
           else{
               outstring = "Passanger with id "+ s2 +" off the bus";
           }
        }
        
        return outstring;
    }
    public int onBus(List<String> lst){
        int count=0;
        
        for(String str : lst){
            for(char ch : str.toCharArray()){
                if(ch == '+'){
                    count+=1;
                }
            }
        }    
        
        return count;
    }
    public int offBus(List<String> lst){
        int count=0;
        
        for(String str : lst){
            for(char ch : str.toCharArray()){
                if(ch == '-'){
                    count+=1;
                }
            }
        }    
        
        return count;
    }
    
    public int onBus(List<String> lst,String id){
        int count=0;
        
        for(String str : lst){
            for(String s : str.split(" ")){
                  if(s.substring(1).equalsIgnoreCase(id) && s.substring(0,1).equals("+")){
                      count+=1;
                  }
        }    
        }
        
        return count;
    }
    
    public boolean lastRow(String lst,String id){
        for(String str : lst.split(" ")){
            if(str.substring(1).equalsIgnoreCase(id) && str.substring(0,1).equals("-")){
                return false;
            }
        }
        return true;
    }
    
    public String fare(List<String> lst,int capacity){
        double fare25=0,fare50 =0 ,faren =0;
         int Np25=0,Np50=0,Np=0;
        int countP=0,countM=0;
        for(String str: lst){
           
            for(char ch: str.toCharArray()){
                if(ch == '+'){
                    countP+=1;
                }
                else if(ch == '-'){
                    countM+=1;
                }
            }
            if((countP-countM)<= 0.25*capacity || ((countP-countM)%2 !=0 && (countP-countM)%4!=0)){
                for(char ch :str.toCharArray()){
                    if(ch == '+'){
                        Np25+=1;
                    }
                }
                fare25 = capacity+capacity*0.6;
            }
            else if((countP-countM)>0.25*capacity && (countP-countM) <= 0.5*capacity){
               for(char ch :str.toCharArray()){
                    if(ch == '+'){
                        Np50+=1;
                    }
                }
                fare50 = capacity+capacity*0.3;
            }
            else{
                for(char ch :str.toCharArray()){
                    if(ch == '+'){
                        Np+=1;
                    }
                }
                faren = capacity;
                
            }
            
            
        }
        return "In total "+Np25+" passanger spent a fare of "+fare25+","+Np50+" passanger spent a fare of "+fare50+" and "+Np+" passengers paid a fare of "+faren;
    }
    
    public String Fare(List<String> lst, int capacity, String id){
         double fare25=0,fare50 =0 ,faren =0;
        double total=0;
        int countP=0,countM=0;
        for(String str: lst){
           
            for(char ch: str.toCharArray()){
                if(ch == '+'){
                    countP+=1;
                }
                else if(ch == '-'){
                    countM+=1;
                }
            }
            if((countP-countM)<= 0.25*capacity || ((countP-countM)%2 !=0 && (countP-countM)%4!=0)){
                fare25 = capacity+capacity*0.6;
                for(String s :str.split(" ")){
                    if(s.substring(1).equals(id) && s.substring(0,1).equals("+")){
                        total+=fare25;
                       
                    }
                }
               
            }
            else if((countP-countM)>0.25*capacity && (countP-countM) <= 0.5*capacity){
                fare50 = capacity+capacity*0.3;
                 for(String s :str.split(" ")){
                    if(s.substring(1).equals(id) && s.substring(0,1).equals("+")){
                        total+=fare50;
                        
                    }
                }
            }
            else{
                faren = capacity;
                 fare50 = capacity+capacity*0.3;
                 for(String s :str.split(" ")){
                    if(s.substring(1).equals(id)&& s.substring(0,1).equals("+")){
                        total+=faren;
                       
                    }
                }
            }
            
    }
   
    
    return "Passanger with Id "+id+" has spent a fare of "+total;
}
}

public class MyClass {
    public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     List<String> listOfInputStrings = new ArrayList<>();
     BusProb obj = new BusProb();
     int capacity=sc.nextInt();
     int x=sc.nextInt();
     sc.nextLine();
     for(int i=0;i<x;i++){
         listOfInputStrings.add(sc.nextLine());
     }
     String query=sc.nextLine();
     System.out.println(obj.output(capacity,x,listOfInputStrings,query));
    }
}
