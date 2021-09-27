package project1;

public class User {
String uname;
String password;
int budget;
String address;
public User(String u, String p,int b,String a)
{
	this.uname=u;
	this.password=p;
	this.budget=b;
	this.address=a;
}
public int login(String temp, String temp2) {
	if((temp.equals(this.uname))&&(temp2.equals(this.password)))
	return 1;
	else
		return 0;
}
}
