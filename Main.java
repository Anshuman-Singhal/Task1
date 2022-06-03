/*
  Task #1 by Anshuman Singhal
    FileName: Main.java
    Objective: Create a blogging site with user Login capabilities.
    Further Details: The user can create an account. They can login with credentials. Users can create blogs and add comments to blogs and users can exit program or create more accounts.

    Changelogs:
    Version 1.0 - Completed Program
    Version 1.1 - 06/02/2022 Added detailed comments under code blocks to increase comprehension and readability of code
      
  
*/
import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    
    //ArrayList of objects to store users and following variables that are used to classify users
    ArrayList<Login> userRegistration = new ArrayList<Login>();
    String name, password, email;
    //object of user account which is used to login
    Login userInfo;
    int userValue = 0;
    
    //boolean variable used to exit iteration if user would like to do so (using a do while loop)
    boolean exit = false;
    
    do
      {
        //Prompt user if they need to create a new account or if they already have an account 
        System.out.println("  Press 1 if you are a new user\n  Press 2 if you are an existing user");
        int userStatus = input.nextInt();
        input.nextLine();

        //Code block to create a user account by taking classifiers and storing them in an object and adding object into ArrayList
        if (userStatus == 1)
        {
          System.out.println("Welcome new user! Please create an account.");
          System.out.println("  Please enter your email address:");
          email = input.nextLine();
          System.out.println("  Please enter your Name:");
          name = input.nextLine();
          System.out.println("  Please enter your password:");
          password = input.nextLine();

          userInfo = new Login(name, password, email);
          userRegistration.add(userInfo);

          System.out.println("Your account has been created!");
          
          //**The use of continue here is solely for the purpose of creating more accounts for testing in a more streamlined fashion, remove continue for smoother transition after creating account **  
          continue;
        }
          
        // To check for false inputs
        else if (userStatus != 2)
        {
          System.out.println("Invalid input, please try again.");
          break;
        }

        //Prompt user to login with credentials and use boolean to validate login
        boolean validLogin = false;
        System.out.println("  Please login by entering your email address:");
        email = input.nextLine();
        
        System.out.println("  Please enter your password:");
        password = input.nextLine();

        //Loop through ArrayList of user accounts and check if email and password match the object data
        for(int i = 0; i < userRegistration.size(); i++)
          {
            userInfo = userRegistration.get(i);
            if (userInfo.userEmail.equals(email) && userInfo.userPassword.equals(password)) 
            {
              validLogin = true;
              System.out.println("Successful Login!");
              userValue = i;
              break;
            }
          }
// end of User Registration and User Login -------------------------------------------------------

        //Beginning the blog code, Logged in User  will continue on to blog site if validLogin is true
        if(validLogin)
        {
          //boolean to loop prompting user to interact with blog website. int to take in choice. Temp string to take in parameters. Intialized userInfo again to satisfy compiler conditions
          boolean exitBlog = true;
          int blogChoice;
          String tempString;
          userInfo = userRegistration.get(userValue);

          //While loop to prompt user for blog choices(create blog, list blogs, comment on blog, list all comments, exit blog choices) until they would like to exit
          while(exitBlog)
            {
              System.out.println("  Press 1 to create a new blog\n  Press 2 to list all blogs\n  Press 3 to comment on a blog\n  Press 4 to see all comments\n  Press 5 to exit");
              blogChoice = input.nextInt();
              input.nextLine();

              //switch case to execute user choice
              switch(blogChoice)
                {
                  case 1:
                    System.out.println("    Please enter blog entry:");
                    tempString = input.nextLine();
                    userInfo.addBlog(tempString);
                    break;
                  case 2:
                    userInfo.printBlogs();
                    break;
                  case 3:
                    System.out.println("    What blog number would you like to comment on:");
                    int blogNum = input.nextInt();
                    input.nextLine();
                    System.out.println("    Please enter comment:");
                    tempString = input.nextLine();
                    userInfo.addComment(tempString, blogNum);
                    break;
                  case 4:
                    userInfo.printComments();
                    break;
                  case 5:
                    System.out.println("    exiting...");
                    exitBlog = false;
                    break;
                  default:
                    System.out.println("    Invalid entry");
                }   
            }
        }
        //If user entered invalid email and password to login they will be prompted with an invalid login
        else
        {
          System.out.println("Invalid Login id, please double check and try again.");
        }

        //Prompts user if they would like to exit the iteration or restart
        System.out.println("Would you like to exit the program? (\"yes\" or \"no\")");
        String userExit = input.nextLine();
        if (userExit.equals("yes")) 
        {
          exit = true;
        }
      } while(!exit);
    
  }
}