/*
  Task #1 by Anshuman Singhal
    FileName: Login.java
    Objective: Create a blogging site with user Login capabilities.
    Further Details: The user can create an account. They can login with credentials. Users can create blogs and add comments to blogs and users can exit program or create more accounts.

    Changelogs:
    Version 1.0 - Completed Program
    Version 1.1 - 06/02/2022 Added detailed comments under code blocks to increase comprehension and readability of code
      
  
*/

import java.util.ArrayList;

//Login object that creates an object to store user information and blogs and comments
public class Login
{
  //String variables are used to store and validate user account login
  String userName;
  String userPassword;
  String userEmail;
  //ArrayLists are used to store comments and blogs specific to each user
  ArrayList<Integer> blogNumber = new ArrayList<Integer>();
  ArrayList<String> userBlogs = new ArrayList<String>();
  ArrayList<String> userComments = new ArrayList<String>();

  //initalize object with basic parameters using a mutator/setter method
  public Login (String name, String password, String email)
  {
    userName = name;
    userEmail = email;
    userPassword = password;
  }

  //Function to add comment and push it into userComments ArrayList
  public void addComment(String comment, int number)
  {
    userComments.add(comment);
    blogNumber.add(number);
  }

  //print all comments in user object
  public void printComments()
  {
    System.out.println("Your comments:");
    for(int i = 0; i < userComments.size(); i++)
      {
        System.out.println("  Comment on Blog number " + blogNumber.get(i) + ": " + userComments.get(i));
      }
  }

  //Function to add blog and push it into userBlogs ArrayList
  public void addBlog(String blog)
  {
    userBlogs.add(blog);
  }

  //Function to print all blogs in user object
  public void printBlogs()
  {
    System.out.println("Your Blogs:");
    for(int i = 0; i < userBlogs.size(); i++)
      {
        System.out.println("  Blog " + i + ": " + userBlogs.get(i));
        
      }
  }
}
  