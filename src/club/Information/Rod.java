package club.Information;


import club.hire.Equipment;

public  class Rod extends Equipment
{

/**
	 * 
	 */
	private static final long serialVersionUID = -7450023375098182406L;
protected String name;
protected int number;
protected double size;

public Rod()
{
super();
this.size = 0.0;
this.number = 0;
this.name = "";
}

public Rod(String name, int number, String title,  double size, double price)
{
	super(name,number,title, size,price);
	this.size = size;
	this.number = number;
	this.name = name;
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
	return "\nROD INFO - Customer Name :  " + name + " ;  Number :  " + number + " ; Size :  " + size + " ; Price :  " + price ;
}

@Override
public int compareTo(Equipment o) {
	// TODO Auto-generated method stub
	return 0;
}


}
