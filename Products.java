package project1;

import java.util.ArrayList;

public class Products {
	static ArrayList<Products> arr = new ArrayList<Products>(5);
	String name;
	int price;
	String category;
	int popularity;
	int quantity;
	int c=0;
	public Products(String name,int price,String category,int timessearched,int q)
	{
		this.name=name;
		this.price=price;
		this.category=category;
		this.popularity=timessearched;
		this.quantity=q;
	}
	public void search(String temp)
	{
			if((temp.equalsIgnoreCase(this.name))||(temp.equalsIgnoreCase(this.category)))
			{
		        arr.add(this);
		        System.out.println(arr.size()+"." +this.name+" -->  $"+this.price);

			}
		
	}
	public int suggested(String temp)
	{
		if((temp.charAt(0)==(this.name.charAt(0)))&&(temp.charAt(temp.length()-1)==this.name.charAt(this.name.length()-1)))
		{
			System.out.println("Suggested search: "+this.name+"\n");
			return 1;
		}
		else if(temp.charAt(0)==(this.name.charAt(0)))
		{
			System.out.println("Suggested search: "+this.name+"\n");
	        return 0;
		}
		return 0;
	}
	public void sort(int z)
	{
			for(int i=0;i<arr.size();i++)
			{
				for(int j=0;j<arr.size()-1;j++)
				{
					if(z==0)
					{
						if(arr.get(j).price>arr.get(j+1).price)
						{
							Products k=arr.get(j);
							arr.set(j, arr.get(j+1));
							arr.set(j+1, k);
						}
					}
					else if(z==1)
					{
						if(arr.get(j).popularity<arr.get(j+1).popularity)
						{
							Products k=arr.get(j);
							arr.set(j, arr.get(j+1));
							arr.set(j+1, k);
						}
					}
				}
			}
	}
	public void prin()
	{
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(i+1+". "+arr.get(i).name+" -->   $ "+arr.get(i).price+"\n");
	   }
	}
	public int checkbudget(int v,int j,User u[],int k) {
		for(int i=0;i<arr.size();i++)
		{
		if((j-1)==i)
		{
			if(((arr.get(i).price*v)<=u[k].budget)&&(v<=arr.get(i).quantity))
			{
				u[k].budget=u[k].budget-(arr.get(i).price*v);
				arr.get(i).quantity=arr.get(i).quantity-v;
				System.out.println("-------------------------------------------------------------------------------------------------------------------");
				System.out.println("|##################################################  SHIPPING BILL  ###############################################");
				System.out.println(" Name: "+u[k].uname);
				System.out.println(" Address: "+u[k].address);
				System.out.println(" Your Product is "+arr.get(i).name+" x "+v);
				System.out.println(" Amount paid: "+(arr.get(i).price*v));
				System.out.println("\nYour product is successfully shipped and would be delivered to you by estimated 26th of april 2016");
		        System.out.println("\n\t\t\t\t\t\tThank You!For shopping with Flipazon.");
				System.out.println("-------------------------------------------------------------------------------------------------------------------");
				arr.remove(i);
				c=0;
			}
			else if(v>arr.get(i).quantity)
			{
				System.out.println("\nSorry, we don't have enough quantity of "+arr.get(i).name);
				System.out.println("\nPlease Enter appropriate quantity");
				c=1;
			}
			else
			{
				System.out.println("\nSorry,You dont have enough balance");
				c=0;
				arr.remove(i);
			}
		}

		}
		if(c==0)
		return 0;
		else
		return 1;	
	}
	public int checknull()
	{
		if(arr.size()==0)
		{
			System.out.println("Sorry! Results did not match your search.\n");
			return 1;
		}
		else
		{
			return 2;
		}
	}
}
