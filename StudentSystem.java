package StudentManagementSystem1;

import java.util.Scanner;

public class StudentSystem 
{
	Student[] students = new Student[20];
	int studentcount = 0;
	int id = 1;

	Scanner sc = new Scanner(System.in);
	final String adminEmail = "admin@gmail.com";
	final String adminpassword = "admin";

	public void start() 
	{
		int choice;
		do 
		{
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("|                        STUDENT MANAGEMENT SYSTEM                        |");
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("| 1. Register                                                             |");
			System.out.println("| 2. Student Login                                                        |");
			System.out.println("| 3. Admin Login                                                          |");
			System.out.println("| 4. Exit                                                                 |");
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			switch (choice)
			{
			case 1:
				register();
				break;
			case 2:
				login(); 
				break;
			case 3: 
				adminlogin(); 
				break;
			case 4: 
				System.out.println(">>>>Exiting the system. Goodbye!"); 
				break;
			default: 
				System.out.println("!!!!Invalid choice. Please try again.");
			}
		} while (choice != 4);
	}

	private void register() 
	{
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                           STUDENT REGISTRATION                          |");
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.print("Enter Name         : ");
		String name = sc.next();
		System.out.print("Enter Email        : "); 
		String email = sc.next();
		System.out.print("Enter Course       : "); 
		String course = sc.next();
		System.out.print("Enter Password     : "); 
		String password = sc.next();
		System.out.print("Enter Gender       : "); 
		String gender = sc.next();
		System.out.print("Enter Contact No   : "); 
		String contactno = sc.next();
		System.out.print("Enter Address      : "); 
		String address = sc.next();
		students[studentcount++] = new Student(id++, name, email, course, password, gender, contactno, address);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(">>>>>>Registration Successful!");
		System.out.println("---------------------------------------------------------------------------");

	}

	private void login()
	{
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                              STUDENT LOGIN                              |");
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.print("Enter Email        : ");
		String email = sc.next();
		System.out.print("Enter Password     : "); 
		String password = sc.next();
		for (Student s : students) 
		{
			if (s != null && s.getEmail().equals(email) && s.getPassword().equals(password))
			{
			    System.out.println("------------------------------------------------------");
				System.out.println(" >>>>Student Login Successful!");
			    System.out.println("------------------------------------------------------");
				studentMenu(s);
				return;
			}
		}
	    System.out.println("------------------------------------------------------");
		System.out.println("!!!!Invalid Email or Password.Please try again");
	    System.out.println("------------------------------------------------------");
	}

	private void studentMenu(Student s)
	{
		int choice;
		do 
		{
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("|                               STUDENT MENU                              |");
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("| Welcome, " + s.getName());
			System.out.println("+=========================================================================+");
			System.out.println("| 1. View Profile                                                         |");
			System.out.println("| 2. Update Profile                                                       |");
			System.out.println("| 3. Logout                                                               |");
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.print("Enter your choice: "); 
			choice = sc.nextInt();
			switch (choice)
			{
			case 1: 
				viewProfile(s); 
				break;
			case 2: 
				updateProfile(s); 
				break;
			case 3: 
			    System.out.println("------------------------------------------------------");
				System.out.println(">>>Logged out."); 
			    System.out.println("------------------------------------------------------");
				break;
			default:
			    System.out.println("------------------------------------------------------");
				System.out.println("!!!!Invalid choice.");
			    System.out.println("------------------------------------------------------");
			}
		}
		while (choice != 3);
	}
	private void viewProfile(Student s) 
	{
		System.out.println("+---------------------------- STUDENT PROFILE ----------------------------+");
		System.out.println("| ID          : " + s.getId());
		System.out.println("| Name        : " + s.getName());
		System.out.println("| Course      : " + s.getCourse());
		System.out.println("| Gender      : " + s.getGender());
		System.out.println("| Contact No  : " + s.getContactNo());
		System.out.println("| Address     : " + s.getAddress());
		System.out.println("+-------------------------------------------------------------------------+");
	}

	private void updateProfile(Student s) 
	{
		System.out.println("+--------------------------- UPDATE PROFILE ------------------------------+");
		System.out.print("Enter new Name       : ");
		String name = sc.next();
		System.out.print("Enter new Course     : "); 
		String course = sc.next();
		System.out.print("Enter new Gender     : "); 
		String gender = sc.next();
		System.out.print("Enter new Contact No : "); 
		String contactno = sc.next();
		System.out.print("Enter new Address    : "); 
		String address = sc.next();
		s.setName(name);
		s.setCourse(course);
		s.setGender(gender);
		s.setContactNO(contactno); 
		s.setAddrees(address);
		System.out.println("-------------------------------------------------------------------");
		System.out.println(">>>>Profile Updated Successfully!");
		System.out.println("-------------------------------------------------------------------");

	}

	private void adminlogin() 
	{
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.println("|                               ADMIN LOGIN                               |");
		System.out.println("+-------------------------------------------------------------------------+");
		System.out.print("Enter Admin Email    : ");
		String email = sc.next();
		System.out.print("Enter Admin Password : "); 
		String password = sc.next();
		if (email.equals(adminEmail) && password.equals(adminpassword))
		{
		    System.out.println("------------------------------------------------------");
			System.out.println(">>>>Admin login successful!");
		    System.out.println("------------------------------------------------------");
			adminMenu();
		} 
		else
		{
		    System.out.println("------------------------------------------------------");
			System.out.println("!!!!Invalid Admin Email or Password.Please Try Again!!");
		    System.out.println("------------------------------------------------------");
		}
	}

	private void adminMenu()
	{
		int choice;
		do 
		{
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("|                                ADMIN MENU                               |");
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("| 1. Show All Students                                                    |");
			System.out.println("| 2. Search Student By ID                                                 |");
			System.out.println("| 3. Search Student By Name or Course                                     |");
			System.out.println("| 4. Update Student By ID                                                 |");
			System.out.println("| 5. Delete Student By ID                                                 |");
			System.out.println("| 6. Sort Students (By ID or Name)                                        |");
			System.out.println("| 7. Logout                                                               |");
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.print("Enter your choice: "); 
			choice = sc.nextInt();
			switch (choice)
			{
			case 1:
				showAllStudents();
				break;
			case 2: 
				searchStudentById();
				break;
			case 3: 
				searchStudentByNameOrCourse(); 
				break;
			case 4: 
				updateStudentById();
				break;
			case 5: 
				deleteStudentById();
				break;
			case 6: 
				sortStudents(); 
				break;
			case 7: 
			    System.out.println("------------------------------------------------------");
				System.out.println(">>>Logged out."); 
			    System.out.println("------------------------------------------------------");
				break;
			default:
			    System.out.println("------------------------------------------------------");
				System.out.println("!!!!Invalid choice.");
			    System.out.println("------------------------------------------------------");

			}
		} 
		while (choice != 7);
	}

	private void showAllStudents() 
	{
		if (studentcount == 0) 
		{ 
		    System.out.println("------------------------------------------------------");
			System.out.println("!!!!No students registered yet."); 
		    System.out.println("------------------------------------------------------");
			return; 
		}
		System.out.println("+---------------------------- ALL STUDENTS -------------------------------+");
		for (int i = 0; i < studentcount; i++) 
		{
			viewProfile(students[i]);
		}
	}

	private void searchStudentById() 
	{
		System.out.print("Enter Student ID to search: ");
		int id = sc.nextInt();
		for (int i = 0; i < studentcount; i++)
		{
			if (students[i].getId() == id) 
			{ 
				viewProfile(students[i]);
				return;
			}
		}
	    System.out.println("------------------------------------------------------");
		System.out.println("!!!!No Student found with ID: " + id);
	    System.out.println("------------------------------------------------------");
	}

	private void searchStudentByNameOrCourse()
	{
		System.out.print("Enter Name or Course keyword: ");
		String keyword = sc.next();
		boolean found = false;
		for (int i = 0; i < studentcount; i++)
		{
			Student s = students[i];
			if (s.getName().equalsIgnoreCase(keyword) || s.getCourse().equalsIgnoreCase(keyword)) 
			{
				viewProfile(s);
				found = true;
			}
		}
		if (!found) System.out.println("No students found with name or course: " + keyword);
	}

	private void updateStudentById()
	{
		System.out.print("Enter Student ID to update: "); 
		int idToUpdate = sc.nextInt();
		for (int i = 0; i < studentcount; i++) 
		{
			if (students[i].getId() == idToUpdate)
			{
				Student s = students[i];
				System.out.print("Enter new Name       : "); 
				String name = sc.next();
				System.out.print("Enter new Course     : ");
				String course=sc.next();
				System.out.print("Enter new Gender     : "); 
				String gender=sc.next();
				System.out.print("Enter new Contact No : ");
				String contactno=sc.next();
				System.out.print("Enter new Address    : "); 
				String address=sc.next();
				s.setName(name);
				s.setCourse(course);
				s.setGender(gender);
				s.setContactNO(contactno);
				s.setAddrees(address);
			    System.out.println("------------------------------------------------------");
				System.out.println(">>>>>>Student details updated successfully!");
			    System.out.println("------------------------------------------------------");
				return;
			}
		}
	    System.out.println("------------------------------------------------------");
		System.out.println("!!!!!No Student found with ID: " + idToUpdate);
	    System.out.println("------------------------------------------------------");

	}

	private void deleteStudentById() 
	{
		System.out.print("Enter Student ID to delete: "); 
		int idToDelete = sc.nextInt();
		for (int i = 0; i<studentcount; i++) 
		{
			if (students[i].getId() == idToDelete)
			{
				for (int j = i; j < studentcount - 1; j++) 
					students[j] = students[j + 1];
				students[--studentcount] = null;
				System.out.println("Student with ID " + idToDelete + " deleted successfully!");
				return;
			}
		}
		System.out.println("No Student found with ID: " + idToDelete);
	}

	private void sortStudents() 
	{
		System.out.println("Sort Students: 1. By ID   2. By Name");
		int choice = sc.nextInt();
		for (int i = 0; i < studentcount - 1; i++) 
		{
			for (int j = i + 1; j < studentcount; j++) 
			{
				boolean swap = false;
				if (choice == 1 && students[i].getId() > students[j].getId()) swap = true;
				else if (choice == 2 && students[i].getName().compareToIgnoreCase(students[j].getName()) > 0) swap = true;
				if (swap) { Student temp = students[i]; students[i] = students[j]; students[j] = temp; }
			}
		}
	    System.out.println("------------------------------------------------------");
		System.out.println(">>>>>>Students sorted successfully!");
	    System.out.println("------------------------------------------------------");
		showAllStudents();
	}

	public static void main(String[] args)
	{
		StudentSystem stud = new StudentSystem();
		stud.start();
	}
}
