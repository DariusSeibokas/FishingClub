package club.Information;

import club.hire.Equipment;

public  class Tripod extends Equipment
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2349008252115416382L;
	protected String name;
	protected int number;
	protected double size;
	
	public Tripod()
	{
	super();
	this.size = 0.0;
	this.number = 0;
	this.name = "";
	}

	public Tripod(String name,int number, String title, double size, double price)
	{
	    super(name,number,title, size, price);
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
			return "\nTRIPOD INFO - Customer Name :  " + name + " ;  Number :  " + number + " ; Size :  " + size + " ; Price :  " + price ;
		}

		@Override
		public int compareTo(Equipment o) {
			// TODO Auto-generated method stub
			return 0;
		}

		
}

