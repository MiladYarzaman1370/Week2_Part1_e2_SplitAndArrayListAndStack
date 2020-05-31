package week2_part1_e2_splitandarraylistandstack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
public class Main {
    static ArrayList<String> list=new ArrayList<String>();
   static Stack<String>  stack=new Stack<String>();
    public static void main(String[] args)
    {
        
        Scanner sc=new Scanner(System.in);
        
        String inpoutString="";
        String strTemp = "";
        
        while(true)
        {
            System.out.println(" \nplease insert next line for ArrayList: ");
            inpoutString=sc.nextLine();
            insertToArrayList(inpoutString);
            System.out.println("\nplease insert next line for Stack:");
            inpoutString=sc.nextLine();
            insertToStack(inpoutString);
           System.out.println("\nArrayList Content:");
           for(String str:list)
               System.out.print(" "+str);
           System.out.println("\nStack Content:");
           while(!stack.isEmpty())
               System.out.print(" "+stack.pop());
           
            
        }
    }

    private static void insertToArrayList(String inpoutString) {
        String[] strTemp=MySplit(inpoutString);
        if (strTemp!=null){
        for(String s:strTemp)
            list.add(s);
             
        }else{
             System.out.print("invalid word");
          }
    }

    private static void insertToStack(String inpoutString) {
        String[] strTemp=MySplit(inpoutString);
        if (strTemp!=null){
        for(String s:strTemp)
            stack.push(s);
        
             
        }else{
             System.out.print("invalid word");
          }
    }

    private static String[] MySplit(String inpoutString) {
        boolean boolTemp=false;
        if (inpoutString.length()==0)
            return null;
         for(int c=0;c<inpoutString.length();c++)
         {
             if(inpoutString.charAt(c)!=' ')
                 boolTemp=true;
         }
         if(!boolTemp)
             return null;
        int intTemp=0;
        for(int j=0;j<inpoutString.length();j++)
        {
              if(j<inpoutString.length()-1)
              {
                  
                if(inpoutString.charAt(j)==' '&&inpoutString.charAt(j+1)!=' ')
                {
                    intTemp++;
                   
                }
              }
              else
              {
                  
                if(inpoutString.charAt(j)==' ')
                {
                    intTemp++;
                   
                }
                
              }
        }
        if(inpoutString.charAt(inpoutString.length()-1)!=' ')
            intTemp++;
      //  else 
           // intTemp--;
            if(inpoutString.charAt(0)==' ')
                intTemp--;
        String[] result=new String[intTemp];
        int index=0;
        String strTemp="";
        for(int i=0;i<inpoutString.length();i++)
        {
            
                if(inpoutString.charAt(i)==' ')
                {
                  if(strTemp.equals(""))
                  {
                      
                  }
                  else
                  {
                      //list.add(strTemp);
                      if(i<inpoutString.length()-1)
                      {
                      result[index]=strTemp;
                      index++;
                      strTemp="";
                      }
                  }
                }
                 else
                {
                  strTemp+=inpoutString.charAt(i);
                }
                
        }
        if(strTemp.equals(""))
            {}
            else
            {
               // index=0;
                if(!strTemp.contains(" "))
                {
                result[index]=strTemp;
                      index++;
                      strTemp="";
                }
            }
        return result;
           
    }
}


