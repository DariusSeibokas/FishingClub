package club.hire;

import java.io.Serializable;

public abstract class Equipment implements Serializable, Comparable <Equipment>
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8043736856385741776L;
	protected String name;
	protected int number;
	protected String title;
	protected double size;
	protected double price;
	
	public Equipment()
	{
		
		this.number = 0;
		this.name = "";
		this.title = "";
		this.size = 0.0;
		this.price = 0.0;
	}
	
	public Equipment( String name, int number, String title, double size, double price) {
		
		this.number = number;
		this.name = name;
		this.title = title;
		this.size = size;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
	
	public abstract String toString();
}

	