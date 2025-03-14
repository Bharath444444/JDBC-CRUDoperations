package websiteoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class crudopeations {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String password="root";
	private static final String username="root";
	private static final String url="jdbc:mysql://localhost:3306/telegram";
	private static Connection conn;
	private static PreparedStatement pmst;
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int ch;
    	do {
    		getdetails();
    		ch=Integer.parseInt(sc.next());
    		switch (ch) {
    		case 1:
    		       login();
    		       break;
    		case 2:
    		       registration();
    		       break;
    		case 3:
    		       adduser();
    		       break;
    		case 4:
    		      deleteuser();
    		      break;
    		case 5:
    		       modifyuserdetails();
    		       break;
    	    case 6:
    		       getall();
    		       break;
    		case 7:
    		       getbyemail();
    		       break;
    		case 8:
    			  System.exit(0);
    			  break;
    		          
    		default:
    			System.out.println("invalid operations");
    			break;
    		}
    	}while(ch>0);
    }

	private static void getbyemail() {
	   	  try {
	   		  Scanner sc=new Scanner(System.in);
	   		  Class.forName(Driver);
	   		  conn=DriverManager.getConnection(url, username, password);
	   		  System.out.println("enter table name");
	   		  String sql="select * from "+sc.next()+" where email=?";
	   		  pmst = conn.prepareStatement(sql);
	   		  System.out.println("enter email");
	   		  pmst.setString(1, sc.next());
	   		  ResultSet rs=pmst.executeQuery();
	   		  while(rs.next()) {
	   			  System.out.println("id : "+rs.getInt("id"));
	   			  System.out.println("name : "+rs.getString("name"));
	   			  System.out.println("email : "+rs.getString("email"));
	   			  System.out.println("password: "+rs.getString("password"));
	   		  }
	 			  
	 			conn.close();
	 			pmst.close();
	 			
	   	  }catch(Exception e) {
	   		  e.printStackTrace();
	   	  }
	}

	private static void getall() {
		 try {
   		  Scanner sc=new Scanner(System.in);
   		  Class.forName(Driver);
   		  conn=DriverManager.getConnection(url, username, password);
   		  System.out.println("enter table name");
   		  String sql="select * from "+sc.next();
   		  pmst = conn.prepareStatement(sql);
   		  ResultSet rs=pmst.executeQuery();
   		  while(rs.next()) {
   			  System.out.println("id : "+rs.getInt("id"));
   			  System.out.println("name : "+rs.getString("name"));
   			  System.out.println("email : "+rs.getString("email"));
   			  System.out.println("password: "+rs.getString("password")); 
   		  }
 			  
 			conn.close();
 			pmst.close();
 			
   	  }catch(Exception e) {
   		  e.printStackTrace();
   	  }
    	
	}

	private static void modifyuserdetails() {
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, username, password);
			Scanner sc=new Scanner(System.in);
			System.out.println("enter table name");
			String sql="update "+sc.next()+" set id=?,name=?,email=?,password=? where id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("enter name");
			pmst.setString(2, sc.next());
			System.out.println("enter email");
			pmst.setString(3,sc.next());
			System.out.println("enter password");
			pmst.setString(4, sc.next());
			System.out.println("provide id");
			pmst.setInt(5, sc.nextInt());
			int i = pmst.executeUpdate();
			  if (i > 0) {
				System.out.println("successfully updated");
			  } 
			  else {
				System.out.println("error");
			  }
			conn.close();
			pmst.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteuser() {
		try {
	   		  Scanner sc=new Scanner(System.in);
	   		  Class.forName(Driver);
	   		  conn=DriverManager.getConnection(url, username, password);
	   		  System.out.println("enter table name");
	   		  String sql="delete from "+sc.next()+" where id=?";
	   		  pmst = conn.prepareStatement(sql);
	   		  System.out.println("enter id");
	   		  pmst.setInt(1, sc.nextInt());
	   		 
	 			  int i = pmst.executeUpdate();
	 			  if (i > 0) {
	 				System.out.println("successfully deleted");
	 			  } 
	 			  else {
	 				System.out.println("error");
	 			  }
	 			conn.close();
	 			pmst.close();
	 			
	   	  }catch(Exception e) {
	   		  e.printStackTrace();
	   	  }
		
	}

	private static void adduser() {
		try {
  		  Scanner sc=new Scanner(System.in);
  		  Class.forName(Driver);
  		  conn=DriverManager.getConnection(url, username, password);
  		  String sql="insert into details(name,email,password) values(?,?,?)";
  		  pmst = conn.prepareStatement(sql);
  		  System.out.println("enter name");
  		  pmst.setString(1, sc.next());
  		  System.out.println("enter email");
  		  pmst.setString(2, sc.next());
  		  System.out.println("enter password");
  		  pmst.setString(3, sc.next());
			  int i = pmst.executeUpdate();
			  if (i > 0) {
				System.out.println("successfully inserted");
			  } 
			  else {
				System.out.println("error");
			  }
			conn.close();
			pmst.close();
		
  	  }catch(Exception e) {
  		  e.printStackTrace();
  	  }
	}

	private static void registration() {
		try {
	  		  Scanner sc=new Scanner(System.in);
	  		  Class.forName(Driver);
	  		  conn=DriverManager.getConnection(url, username, password);
	  		  String sql="insert into details(name,email,password) values(?,?,?)";
	  		  pmst = conn.prepareStatement(sql);
	  		  System.out.println("enter name");
	  		  pmst.setString(1, sc.next());
	  		  System.out.println("enter email");
	  		  pmst.setString(2, sc.next());
	  		  System.out.println("enter password");
	  		  pmst.setString(3, sc.next());
				  int i = pmst.executeUpdate();
				  if (i > 0) {
					System.out.println("successfully inserted");
				  } 
				  else {
					System.out.println("error");
				  }
				conn.close();
				pmst.close();
				
	  	  }catch(Exception e) {
	  		  e.printStackTrace();
	  	  }
		
	}

	private static void login() {
		   	  try {
		   		  Scanner sc=new Scanner(System.in);
		   		  Class.forName(Driver);
		   		  conn=DriverManager.getConnection(url, username, password);
		   		  System.out.println("enter email");
		   		  String username=sc.next();
		   		  System.out.println("enter password");
		   		  String password=sc.next();
		   		  String sql="select * from details where email=? and password=?";
		   		  pmst = conn.prepareStatement(sql);
		   		  pmst.setString(1,username);
		   		  pmst.setString(2, password);
		   		  ResultSet rs=pmst.executeQuery();
		   		  if(rs.next()) {
		   			  System.out.println("successfully login");  
		   		  }
		   		  else{
		   			  System.out.println("error");
		   		  }  
		 			conn.close();
		 			pmst.close();
		 		
		   	  }catch(Exception e) {
		   		  e.printStackTrace();
		   	  }
    
   }

	private static void getdetails() {
		System.out.println("website operations");
		System.out.println("__________________");
		System.out.println("choose an option");
		System.out.println("\t 1.login");
		System.out.println("\t 2.registration");
		System.out.println("\t 3.adduser");
		System.out.println("\t 4.deleteuser");
		System.out.println("\t 5.modifyuserdetails");
		System.out.println("\t 6.getalluserdetails");
		System.out.println("\t 7.getuserdetailsbyemail");
		System.out.println("\t 8.exit");
		System.out.println("__________________");
		
		
	}
    
}
