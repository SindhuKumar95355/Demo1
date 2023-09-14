package simpleCrud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class display {
	
	public static void main(String[] args) throws IOException {
		
		call();
		
		
	}
	
	public static void call() throws IOException
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String ch = " ";
		
		do {
			
			System.out.println("Enter 1 to insert the studnet");
			System.out.println("Enter 2 to display all the studnet");
			System.out.println("Enter 3 to detele the studnet");
			System.out.println("Enter 4 to update the studnet");
			System.out.println("Enter 5 to exit our sever");

			int num = Integer.parseInt(br.readLine());
			
			switch(num)
			{
			case 1 : System.out.println("enter name");
					 String name = br.readLine();
					 
					 System.out.println("enter USN");
					 String usn = br.readLine();
					 
					 System.out.println("enter the password");
					 int pass = Integer.parseInt(br.readLine());
					 
					 entities en = new entities();
					 en.setName(name);
					 en.setUSN(usn);
					 en.setPassword(pass);
					
					 
					 Session s1 = Factory.fact().openSession();
						s1.beginTransaction();
						
						s1.save(en);
						
						s1.getTransaction().commit();
						
						s1.close();
						
					 
					 break;
			case 2 :
				
//				entities en1 = new entities();
				
				Session s = Factory.fact().openSession();
				s.beginTransaction();
				
				
				Query q = s.createQuery("from entities");
				List<entities> list = q.list();
				
				for(entities l : list)
				{
					System.out.println(l.getId() + ":" + l.getName() + ":" + l.getUSN()+ ":" +l.getPassword()+ ":" +l.getLoginDate());
				}
				
				break;
					 
			case 3 : 
				
				System.out.println("Enter the id to delete the profile");
				int id = Integer.parseInt(br.readLine());
				
				entities en1 = new entities();
				Session s2 = Factory.fact().openSession();
				s2.beginTransaction();
				
				entities delete = s2.get(entities.class, id);
				s2.delete(delete);
				
				s2.getTransaction().commit();
				s2.close();
				
				System.out.println("the profile is deleted successfully");
				break;
				
			case 4 : 
				
				System.out.println("Enter the id to update the profile");
				int id1 = Integer.parseInt(br.readLine());
				
				System.out.println("Enter the name to update");
				String Uname = br.readLine();
				
				System.out.println("Enter the updated USN");
				String Uusn = br.readLine();
				
				System.out.println("enter the updated password");
				int Upass = Integer.parseInt(br.readLine());
				
				Session s3 = Factory.fact().openSession();
				s3.beginTransaction();
				
//				Query q1 = s3.createQuery("select Sname,USN,Password from entities where id=?");
//				q1.uniqueResult();
				entities e =  s3.get(entities.class, id1);
				
				System.out.println("Previous details :" + e.getId()+","+ e.getName()+","+ e.getPassword()+","+ e.getUSN() +","+
				e.getLoginDate());
				
				e.setName(Uname);
				e.setUSN(Uusn);
				e.setPassword(Upass);
				
				System.out.println("Updated details :" + e.getId()+","+ e.getName()+","+ e.getPassword()+","+ e.getUSN() +","+
						e.getLoginDate());
				
				s3.getTransaction().commit();
				s3.close();
				
				
				break;
				
			case 5 : 
				
				System.out.println("Thank you for using our server");
							 break;
			}
			
		
			System.out.println("Enter c to continue and t to terminate");
			ch = br.readLine();
		}
		
		while (ch.equals("c") || ch.equals("C"));
				
	}

}
