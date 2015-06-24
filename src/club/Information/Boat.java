package club.Information;

import club.hire.Equipment;


public  class Boat extends Equipment 
{
/**
	 * 
	 */
	private static final long serialVersionUID = 7249794803417981765L;
protected double size;
protected int number;
protected String name;

public Boat()
{
super();
this.size = 0.0;
this.number = 0;
this.name = "";
}

public Boat(String name,int number, String title, double price, double size)
{
    super( name, number, title, size, price);
    this.name = name;
    this.number = number;
    this.size = size;
	
	
}

public double getSize() {
	return size;
}

public void setSize(double size) {
	this.size = size;
}		
public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


	@Override
	public String toString() {
		return "\nBOAT INFO - Customer Name :  " + name + " ;  Number :  " + number + " ; Size :  " + size + " ; Price :  " + price ;
	}

	@Override
	public int compareTo(Equipment arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

	
