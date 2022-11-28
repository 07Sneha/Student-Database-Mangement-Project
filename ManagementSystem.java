package defPack;
import java.sql.*;
import java.util.HashSet;
import java.util.*;
import java.util.Scanner;
public class ManagementSystem {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
        Statement statement=null;
        ResultSet result=null;
        String url ="jdbc:mysql://localhost:3306/studentprojectdatabase";
        String user="root";
        String password ="$neh@2002";
        Scanner scan = new Scanner(System.in); 
        
        Scanner scani = new Scanner(System.in);
        try {
         connection =DriverManager.getConnection(url, user, password);
         if(connection!= null)
         {statement=connection.createStatement();
           System.out.println("Enter command"
           		+ "\n1.Insert Entry \n2.Update table\n3.delete Entry\n4.Read Table");
           System.out.println();
           int choice =scan.nextInt();
           if(statement!= null)
            switch(choice)
       {case(4):{//read
    	   String readQuery="Select * from student";
                 if(statement!= null)
                  {result=statement.executeQuery(readQuery);
                  if(result!=null)
                  {while(result.next())
                    {int id =result.getInt(1);
                      String name=result.getString(2);
                      String branch=result.getString(3);
                      String dept=result.getString(4);
                      int year=result.getInt(5);
                      String email=result.getString(6);
                      Double contactNu=result.getDouble(7);
                      String Address=result.getString(8);
                      String hosteller=result.getString(9);                     
                     System.out.println(id+"\t\t"+name+"\t\t"+branch+"\t\t"+dept+"\t\t"+
                      year+"\t\t"+email+"\t\t"+contactNu+"\t\t"+Address+"\t\t"+hosteller);                     
                      }
                  } break;}
           }//case1 close
       case(2):       	 
       {//updation
    	   System.out.println("Enter field you want to update");
       System.out.println("1.name\n2.branch\n3.dept"+
       		 "\n4.year\n5.email\n6.contactNu\n7.Address\n8.hosteller"); 
       int choice2=scan.nextInt();
    	System.out.println("Enter student Id");   	
    	   int id=scani.nextInt();
    	   
    	   String queryid=String.format("select student_id from student where exists(select student_id from student where student_id=%d);",id);
    	   
    	   if(statement!=null)
    	   {
    	      result=statement.executeQuery(queryid);
    		   if(result==null)
    		   { 
    		     System.out.println("Entered student_id does not exist");
    		     
    		     System.exit(0);
    	   }}
    	switch(choice2)
    	{case 1:{System.out.println("Enter student Name");
	             String name=scan.next();
    		      String queryUp=String.format("update student set stu_name='%s' where (student_id='%d')",name,id);
    		      if(statement!= null)
    		      {statement.executeUpdate(queryUp);
    	    	    System.out.println("Updated successfully");    		    	  
    		      }break;
    	      }
    	 case 2:{ System.out.println("Enter student Branch");
 	              String branch=scan.next();
 	            String queryUp=String.format("update student set branch='%s' where student_id='%d'",branch,id);
	             if(statement!= null)
	            {statement.executeUpdate(queryUp);
 	                 System.out.println("Updated successfully");
 	                 System.out.println("please check out corresponding branch");
	                 }break;
    	       }
    	 case 3:{System.out.println("Enter student department");
 	              String dept=scan.next();
 	             String queryUp=String.format("update student set department='%s' where student_id='%d'",dept,id);
 	            if(statement!= null)
	             {statement.executeUpdate(queryUp);
 	                System.out.println("Updated successfully");    		    	  
	              }break;
    	      }
    	 case 4:{System.out.println("Enter student year"); 
 	            int year=scani.nextInt();   
 	    	   HashSet<Integer> h= new HashSet<>();
 	    	   h.add(1);
 	    	   h.add(2);
 	    	   h.add(3);
 	    	   h.add(4);
 	    	     if(!h.contains(year))
 	    	     {System.out.println("Year value should be matched with corresponding degree Duration");
 	    	    	 System.out.println("Enter year again");
 	    	    	 year=scani.nextInt();
 	    	     }
 	            String queryUp=String.format("update student set year=%d where student_id=%d",year,id);
 	             if(statement!= null)
	             {statement.executeUpdate(queryUp);
 	              System.out.println("Updated successfully");    		    	  
	              }break;
    	         }
    	 case 5:{System.out.println("Enter student Email");
 	            String Email=scan.next(); 
 	            String queryUp=String.format("update student set email_id=%s where student_id=%d",Email,id);
 	            if(statement!= null)
	            {statement.executeUpdate(queryUp);
 	             System.out.println("Updated successfully");    		    	  
	           }break;
    	 }
    	 case 6:{System.out.println("Enter student phoneNumber (should be of 10 digits )");
 	               Double phnNu=scan.nextDouble();
 	               
 	              String queryUp=String.format("update student set contact_no='%lf' where student_id='%d'",phnNu,id);
 	               if(statement!= null)
	              {statement.executeUpdate(queryUp);
 	              System.out.println("Updated successfully");    		    	 
 	              }break;
    	       }
    	 case 7:{
    		 System.out.println("Enter student address {if not want to give write not available}");
     	    String address=scan.next();
     	    String queryUp=String.format("update student set address='%s' where student_id='%d'",address,id);
     	   if(statement!= null)
		      {statement.executeUpdate(queryUp);
	    	    System.out.println("Updated successfully");    		    	  
		      }break;
    	 }
    	 case 8:{System.out.println("Enter student is hosteller or Not");
 	         String hosteller=scan.next();
 	         String queryUp=String.format("update student set hosteller='%s'where student_id='%d'",hosteller,id);
 	          if(statement!= null)
	          {statement.executeUpdate(queryUp);
 	          System.out.println("Updated successfully");    		    	  
	            }break;
    		 
    	 }
         default :
         {
        	System.out.println("Enter correct attribute"); 
         }}
    	  break; 
    	      
       }//case2 close	 
       case (1):  	 
       {//insertion 
    	   System.out.println("Enter Student id");
    	   int id=scan.nextInt();
    	   
    	   System.out.println("Enter student Name");
    	   String name=scan.next();
    	   
        System.out.println("Enter student Branch");
    	    String branch=scan.next(); 
    	    
    	System.out.println("Enter student department");
    	    String dept=scan.next();   
    	    
        System.out.println("Enter student year");
    	   int year=scani.nextInt();   
    	   HashSet<Integer> h= new HashSet<>();
    	   h.add(1);
    	   h.add(2);
    	   h.add(3);
    	   h.add(4);
    	     if(!h.contains(year))
    	     {System.out.println("Year value should be matched with corresponding degree Duration");
    	    	 System.out.println("Enter year again");
    	    	 year=scani.nextInt();
    	     }
    	System.out.println("Enter student Email");
    	    String Email=scani.next();
    	    
        System.out.println("Enter student phoneNumber (should be of 10 digits )");
        
    	    Double phnNu=scan.nextDouble(); 
    	    
    	    
    	System.out.println("Enter student address{if not want to give write not available}");
    		
    	    String address=scan.next(); 
    	    
    	System.out.println("Enter student is hosteller or Not");
    	    String hosteller=scan.next();
    	    
    	 String query2=String.format("insert "
    	 		+ "into student(student_id,stu_name,branch,department,year,email_id,contact_no,address,hosteller) "
    	 		+ "values ('%d','%s','%s','%s','%d','%s','%s','%s','%s')"
    	 		,id,name,branch,dept,year,Email,phnNu,address,hosteller);   
    	  if(statement!=null)
    	  { statement.execute(query2);
    	    System.out.println("Entry inserted successfully");
    	  }
    	   break;
       } //case3 close
       case(3):{
    	  System.out.println("Enter Student id for deletion");
    	  int id=scan.nextInt();
    	  String queryid=String.format("select student_id from student where exists(select student_id from student where student_id=%d);",id);  	   
   	   if(statement!=null)
   	   {
   	      result=statement.executeQuery(queryid);
   		   if(result==null)
   		   { 
   		     System.out.println("Entered student_id does not exist");
   		     
   		     System.exit(0);
   	   }}
    	  String query3=String.format("delete from student where student_id=%d",id);
    		if(statement!= null)
    		{statement.execute(query3);
    	    System.out.println("Entry Deleted sucessfully ");   			
    		}break;
       }//case deleted close 	
       default:
       {
    	  System.out.println("Enter appropriate value"); 
       }
       }//switchClose        	 
           }   	 
        //if connection end
	 	} 
        catch(SQLIntegrityConstraintViolationException sq1)
        {System.out.println("given student_id is already enrolled give another one");
    	     sq1.printStackTrace();       	
        }
        catch(InputMismatchException ime)
        {System.out.println("last given input is not matching with corresponding data type");
    	   ime.printStackTrace();
        	
        }
        catch(SQLException sq)
        {System.out.println("SQl exception occured");
        	sq.printStackTrace();
        }
        catch(Exception e)
        {System.out.println("Exception occured");
    	  e.printStackTrace();        	
        }
        finally
        {  if(result!=null) 
        	{result.close();}
             statement.close();
             connection.close();
        	scan.close();
        	scani.close();
        }
	}
}

