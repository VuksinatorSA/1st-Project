/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject8;

/**
 *
 * @author RC_Student_lab
 */
public class Mavenproject8 {

public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
              String Username="";
              String password ="";
              String register="";
              String login="";
              String name ="";
              String surname="";
        
            Scanner sc = new Scanner(System.in);
            
              System.out.println("Welcome to Stratcom Solutions to sucessfully register your profile of us, kindly fill in the "
                      + "required information");         
              
              System.out.println("Please enter your first name: ");
              name=sc.nextLine();
              System.out.print("Please enter your last name: ");
              surname = sc.nextLine();
              System.out.print("Please enter your username must contain an underscore : ");
              checkUserName(Username);
              
              
              
                checkUserName(Username);
                checkPasswordComplexity(password);
                
                registerUser(register);
                LoginUser(login);
                     
    }
    
    public static boolean checkUserName (String username1){
        
         Scanner sc = new Scanner(System.in);
    
        //System.out.print("Please enter your username must contain an underscore : ");
              String username = sc.nextLine();
              int x=0;
              String str="_";
                   
               if(username.contains(str)||username.length()<3){
                   System.out.print("Username successfully captured");
                   return true;
               }else{
                   System.out.println("Username is not correctly formatted please ensure that the username contain an underscore and is no more than 5 characters in length.");
               return false;
               } 
                   
          
    }
    
    public static boolean checkPasswordComplexity(String password){
    
    String regex = "^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[^a-zA-Z\\d]).{8,}$";
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter your password: ");
    String pass = sc.next();
    
    if(pass.matches(regex))
    {
        System.out.println("Password successfully captured");
        return true;
    }
    else{
        System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
   return false;
    }    
   
    
    }
    
    public static String registerUser(String user ){
           
        String Username="";
        String pass="";
        
        
        
    if(checkUserName(Username).matches(checkUserName(Username))||checkPasswordComplexity(pass))
    {
        System.out.println("Username is succussfully stored.");
    }
    else{
        System.out.println("User can not be registered!!!");
    }
    
    return user;
}
    
    public static boolean LoginUser(String User){
    
       Scanner sc = new Scanner(System.in);
       

        
        checkUserName(User);
        checkPasswordComplexity(User);
       
        System.out.println("Welcome back Please enter your username:");
        String Username =sc.nextLine();
        
        System.out.println("Please enter your password:");
        String pass =sc.nextLine();
        
        
        
        
        
        if(Username.matches(checkUserName(Username))&&checkPasswordComplexity(pass)){
            System.out.println("Successful login!!!");
           return true;        
        }
        else{
            System.out.println("incorrect username or Password!!!");
             return false;
        }
    }
    
    public static String returnLoginStatus(){
        
        String names="";
        String surname ="";
        
        checkUserName(names);
    
        if(checkUserName(names))
       {
        System.out.println("Welcome "+names+","+surname+"it is great to see you again");
        }
        else {
            System.out.println("Username or password incorrect please try again.");
        }
    
     return names; 
     
    }
