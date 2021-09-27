package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int n,i,m,j,flag,z=0,count=0,r,k;
		File f1 = new File("f8.txt");
Scanner sc = new Scanner(f1);
n=sc.nextInt();
sc.nextLine();
Products[] pro=new Products[n];
for(i=0;i<n;i++)
{
	String[] field = new String[5];
	field=sc.nextLine().split(" ");
	pro[i]=new Products(field[0],Integer.parseInt(field[1]),field[2],Integer.parseInt(field[3]),Integer.parseInt(field[4]));
}
File f2 = new File("f9.txt");
Scanner sc2= new Scanner(f2);
m=sc2.nextInt();
sc2.nextLine();
User[] u = new User[m];
for(i=0;i<m;i++)
{
	String[] field = new String[4];
	field=sc2.nextLine().split(" ");
	u[i]= new User(field[0],field[1],Integer.parseInt(field[2]),field[3]);
}
Scanner sc3 = new Scanner(System.in);
String temp,temp2,temp3;
System.out.println();
System.out.println("                                                                           HELLO! User");
System.out.println();
System.out.println("*******************************************************************~  WELCOME   TO   FLIPAZON  ~***************************************************************");
System.out.println();
System.out.println();
System.out.println("CATAGORIES---:");
System.out.println();
System.out.println("--> Electronics:\t\t\t-> phones\n                \t\t\t-> tv\n                \t\t\t-> laptops\n                \t\t\t-> pendrives\n");
System.out.println();
System.out.println("-->Clothing & Accessories:\t\t-> watches\n                      \t\t\t-> shoes\n                      \t\t\t-> shirts\n");
System.out.println("-->Reader's corner:\t\t\t-> generalbooks\n                   \t\t\t-> magazines\n");
System.out.println();
while(true)
{
	System.out.println("\nWhat are you looking for?\n");
	temp=sc3.nextLine();
	System.out.println("Items matching your search : \n");
	for(j=0;j<n;j++)
	{
	 pro[j].search(temp);
	}
	r=pro[0].checknull();
	if(r==1)
	{
		for(j=0;j<n;j++)
		{
			r=pro[j].suggested(temp);
			if(r==1)
				break;
		}
		continue;
	}

	System.out.println("\nHow you want to filter by : price or popularity?\n");
	while(true)
	{
		temp2=sc3.nextLine();
	if(temp2.equals("price"))
	{
		flag=0;
		break;
	}
	else if(temp2.equals("popularity"))
	{
		flag=1;
		break;
	}
	else
		System.out.println("wrong filtering input");
	}
	pro[i].sort(flag);
	System.out.println("\nFiltered-Results:\n");
	pro[i].prin();
	System.out.println("Do you want to buy a product?\n");
	temp2=sc3.nextLine();
	if(temp2.equals("yes"))
	{
		System.out.println("\nThen please login\n");
		while(true)
		{
			System.out.println("Username: ");
		temp=sc3.nextLine();
		System.out.println("\npassword: ");
		temp3=sc3.nextLine();
	for(k=0;k<m;k++)
	{
		z=u[k].login(temp, temp3);
		if(z==1)
			break;
	}
	if(z==1)
		{
	System.out.println("\nwhich product you want to buy(1 or 2 or ...)");
	j=sc3.nextInt();
	System.out.println("\nQuantity : ");
	while(true)
	{
	int v=sc3.nextInt();
	if(v==0)
		break;
	int d=pro[i].checkbudget(v,j,u,k);
	if(d==0)
	break;
	}
	break;
	}
	else 
	{
		if(count==2)
		{
			System.out.println("\nsorry,you have reached maximam login attempts");
			break;
		}
		else
		{
		System.out.println("\nWrong details entered");
		count++;
		}
		}
	}
	}
	if(temp2.equals("no"))
		break;
	System.out.println("Do you want shop futher ? 'yes' or 'no'");
	sc3.nextLine();
	temp3=sc3.nextLine();
	if(temp3.equals("no"))
		break;
}
sc.close();
sc2.close();
sc3.close();
}
}