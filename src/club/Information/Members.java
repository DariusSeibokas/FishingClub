package club.Information;

import java.io.Serializable;



public class Members implements Serializable ,Comparable <Members>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 746243665444122192L;
	private int id;
	private String name;
	private int phone;
	private String address;
	
	public Members(int id, String name, int phone, String address)
	{
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
		
	public String getAddress() {
		return address;
	}
	public void setAddress(String address)	{
		this.address = address;
	}

	@Override
	public String toString() {
		return "\n Members ID =  " + id + ", Name = " + name + ", Phone = " + phone
				+ ", Address = " + address;
	}
	
	public int compareTo(Members arg0) {
		if (this.getId() > arg0.getId())
		{
			return 1;
		}
		if (this.getId() < arg0.getId())
		{
			return -1;
		}
		return 0;
	}
}