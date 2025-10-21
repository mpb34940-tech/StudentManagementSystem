package StudentManagementSystem1;

public class Student 
{
private int id;
private String name;
private String email;
private String course;
private String password;
private String gender;
private String contactno;
private String address;


public Student(int id,String name,String email,String course,String password,String gender,String contactno,String address)
{
	this.id=id;
	this.name=name;
	this.email=email;
	this.course=course;
	this.password=password;
	this.gender=gender;
	this.contactno=contactno;
	this.address=address;
}

public int getId()
{
	return id;
}
public String getName()
{
	return name;
}
public String getEmail()
{
	return email;
}
public String getCourse()
{
	return course;
}
public String getPassword()
{
	return password;
}
public String getGender()
{
	return gender;
}
public String getContactNo()
{
	return contactno;
}
public String getAddress()
{
	return address;
}


public void setName(String name)
{
	this.name=name;
}
public void setCourse(String course)
{
	this.course=course;
}
public void setGender(String gender)
{
	this.gender=gender;
}
public void setContactNO(String contactno)
{
	this.contactno=contactno;
}
public void setAddrees(String address)
{
	this.address=address;
}
}
