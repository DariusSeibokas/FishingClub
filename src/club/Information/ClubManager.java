package club.Information;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import club.exeption.EmptyFieldException;
import club.exeption.ExistingIDException;
import club.exeption.InvalidPriceException;
import club.hire.Equipment;
import club.io.FileHandlerHire;
import club.io.FileHandlerMembers;

public class ClubManager 
{
	
	private static Icon myIcon = new ImageIcon("images\\fishing_club.jpg");
	private static Icon anIcon = new ImageIcon();
	private FileHandlerMembers fileHandler = new FileHandlerMembers();
	private FileHandlerHire fileHire = new FileHandlerHire();	
	
	private List<Members> membersList = new ArrayList <Members>();
		
	private List<Equipment> equipmentList = new ArrayList <Equipment>();
	
	public ClubManager()
	{
	
	fileHandler.setFile("members.dat");

	if(!fileHandler.isFileEmpty())
		membersList = (List<Members>) fileHandler.readFromFile();
		
		else
		{
			membersList = new ArrayList<Members>();
		
		}
	
	
	fileHire.setFile("equipment.dat");

	if(!fileHire.isFileEmpty())
		equipmentList = (List<Equipment>) fileHire.readFromFile();
		
		else
		{
			equipmentList = new ArrayList<Equipment>();
		
		}
	}
	private static ImageIcon getImageResource(String path)
	{
		
		URL url = ClubManager.class.getResource(path);
		return new ImageIcon(url);
	}
	public int menu()
	{
	
		int option = 0;

	
		   String addMember = new String("1. Add a Member ");
		   String searchMember = new String("2. Search a Member");
		   String modifyMember = new String("3. Modify a Member");
		   String removeMember = new String("4. Remove Member ");
		   String listMember = new String("5. List All Members ");
		   String hire = new String("6. Hire Equipment ");
		   String exit = new String("7. Exit ");
		   String msg = new String("Enter Option");
		   String members = new String("Number of Members in the system: " + membersList.size());
		   String equipment = new String("Numbers equipments on hire: " + equipmentList.size());
		   JTextField opt = new JTextField("");
		   		   
		   Object message[] = new Object[12];

		   message[0] = myIcon;
		   message[1] = addMember;
		   message[2] = searchMember;
		   message[3] = modifyMember;
		   message[4] = removeMember;
		   message[5] = listMember;
		   message[6] = hire;
		   message[7] = exit;
		   message[8] = msg;
		   message[9] = opt;
		   message[10] = members;
		   message[11] = equipment;
		  
		   int table = JOptionPane.showConfirmDialog(null,message,"Fishing Club Manager",JOptionPane.OK_CANCEL_OPTION,
			 JOptionPane.QUESTION_MESSAGE ,anIcon);
		   
		   if(table == JOptionPane.CANCEL_OPTION) ;
			   
		   else
		   	{
			   try {
				   option = Integer.parseInt( opt.getText());
			   	   }
			   catch (Exception e)
			   {
			   JOptionPane.showMessageDialog(null,"Data Input Error! " + "\nPlease Enter On Option [1-7]" + "\nPlease Try Again");
			   }
		   	}
		   return option;
	}

	public void menuAddMembers() 
	{
		   String msgID = new String("Member ID :");
		   String msgName = new String("Member Name :");
		   String msgPhone = new String("Phone Number :");
		   String msgAddress = new String("Address");
		   
		   
		   JTextField id = new JTextField("");
		   JTextField name = new JTextField("");
		   JTextField phone = new JTextField("");
		   JTextField address = new JTextField("");
		   
		   Object message[] = new Object[9];

		   message[0] = myIcon;
		   message[1] = msgID;
		   message[2] = id;
		   message[3] = msgName;
		   message[4] = name;
		   message[5] = msgPhone;
		   message[6] = phone;
		   message[7] = msgAddress;
		   message[8] = address;
		 
		   int table = JOptionPane.showConfirmDialog(null,message,"Fishing Club Manager",JOptionPane.OK_CANCEL_OPTION,
					 JOptionPane.QUESTION_MESSAGE ,anIcon);
				   
			 if(table == JOptionPane.CANCEL_OPTION);
					   
		 else
			{
			 try{

		   		Members members = new Members (Integer.parseInt(id.getText()), address.getText(),Integer.parseInt(phone.getText()),name.getText());
		   		
		   		for (int i = 0; i < membersList.size(); i++)
				{
					if (membersList.get(i).getId() == members.getId())
					{
						throw new ExistingIDException();
					}
				}
					 				    
					membersList.add(members);
					
					Collections.sort(membersList);
					
					fileHandler.writeToFile(membersList);
										    
					JOptionPane.showMessageDialog(null, "The Member Added Successfully ");
				 
				 }
			    catch (ExistingIDException ide)
				{
					JOptionPane.showMessageDialog(null, "The ID Exist On List " +  "\nPlease Try Again" );
				}
			    catch (Exception e)
			    {
				 JOptionPane.showMessageDialog(null, "Data Input Error!  " + "\nPlease Try Again" ); 
			    }
			 
			  }
	}

	public void menuSearchMembers() throws EmptyFieldException
	{
		try{ 
		
		String txtID = JOptionPane.showInputDialog("Please Enter Members ID  :");
	    int id = Integer.parseInt(txtID);
	   
	   
	if (membersList.isEmpty() == true)
	{
		JOptionPane.showMessageDialog(null, "The Members List Is Empty");
	}
	
	boolean found = false;
	for (int i = 0; i < membersList.size(); i++)
	{
		if(membersList.get(i).getId() == id)
		{
			
			JOptionPane.showMessageDialog(null, " ID : " + membersList.get(i).getId() + "\n"
					+ " Name : " + membersList.get(i).getName() + "\n"
							+ " Address : " + membersList.get(i).getAddress() + "\n"
									+ " Phone : " + membersList.get(i).getPhone());
			found = true;
			break;
		  }
	 }
	 if(!found) 
		 JOptionPane.showMessageDialog(null, "The Member does not exist");
		
		}
	 
	  catch( NumberFormatException nfm)
	    {
		 JOptionPane.showMessageDialog(null, "Please Enter ID!  " + "\nPlease Try Again" );	 
	    }
   }

	public void menuModifyMembers() throws EmptyFieldException
	{
		try{
			
		
		String txtID = JOptionPane.showInputDialog("Please Enter Members ID  :");
	    int id = Integer.parseInt(txtID);
		
		
	if (membersList.isEmpty() == true)
	{
		JOptionPane.showMessageDialog(null, "The Members List Is Empty");
	}
	
	boolean found = false;
	
	for (int i = 0; i < membersList.size(); i++)
	{
		if(membersList.get(i).getId() == id)
		{

			   String msgID = new String("Member ID: " +id);
			   String msgName = new String("Member Name: ");
			   String msgPhone = new String("Phone Number: ");
			   String msgAddress = new String("Address: ");
			   
			   JTextField name = new JTextField("");
			   JTextField phone = new JTextField("");
			   JTextField address = new JTextField("");
			   
			   Object message[] = new Object[8];

			   message[0] = myIcon;
			   message[1] = msgID;
			   message[2] = msgName;
			   message[3] = name;
			   message[4] = msgPhone;
			   message[5] = phone;
			   message[6] = msgAddress;
			   message[7] = address;
			   			   
			   int table = JOptionPane.showConfirmDialog(null,message,"Fishing Club Manager",JOptionPane.OK_CANCEL_OPTION,
						 JOptionPane.QUESTION_MESSAGE ,anIcon);
					   
				 if(table == JOptionPane.CANCEL_OPTION);
						   
					 else
					 {
						 try{

					membersList.get(i).setName(name.getText());
			   		membersList.get(i).setPhone(Integer.parseInt(phone.getText()));
			   		membersList.get(i).setAddress(address.getText());
			   		
					JOptionPane.showMessageDialog(null, "The Member Modified Successfully ");
					
					found = true;
					break;
					 }
						 catch (Exception e)
       					 {
       						 JOptionPane.showMessageDialog(null, "Data Input Error!  " + "\nPlease Try Again" ); 
       					 }
					 }
		         }
				 
		   		}
	if(!found)
		JOptionPane.showMessageDialog(null, "The Member is Not Exist");
		
		}
			
	catch( NumberFormatException nfm)
	 {
		 JOptionPane.showMessageDialog(null, "Please Enter Members ID!  " + "\nPlease Try Again" );	 
	 }
  }

	public void menuRemoveMembers()
	{
		try{
			
		String txtID = JOptionPane.showInputDialog("Please Enter Members ID  :");
	    int id = Integer.parseInt(txtID);
		
		
	if (membersList.isEmpty() == true)
	{
		JOptionPane.showMessageDialog(null, "The Members List Is Empty");
	}
	
	boolean found = false;
	
	for (int i = 0; i < membersList.size(); i++)
	{
		if(membersList.get(i).getId() == id)
		{
			membersList.remove(i);
			fileHandler.writeToFile(membersList);
		
			JOptionPane.showMessageDialog(null, "The Member Was Removed Successfully ");
			found = true;
			break;
		  }
		
		}
		if(!found)
			JOptionPane.showMessageDialog(null, "The Member is Not Exist");
		
	     }
		catch( NumberFormatException nfm)
		 {
			 JOptionPane.showMessageDialog(null, "Please Enter Members ID!  " + "\nPlease Try Again" );	 
		 }
	}
	
	public void menuListMembers()
	{
		if (membersList.isEmpty() == true)
		{
			JOptionPane.showMessageDialog(null, "The Members List Is Empty");
		}
		else
		{
		JOptionPane.showMessageDialog(null,membersList);
		}
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////Start of Hire Manager ////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

	public void menuHireEquipment() 
	{}
	
public int hire()
	{
	int option = 0;
	
	   String opt1 = new String("1. Hire Equipment ");
	   String opt2 = new String("2. Search Equipment");
	   String opt3 = new String("3. Modify Equipment");
	   String opt4 = new String("4. List Hired Equipment ");
	   String opt5 = new String("5. Return Equipment ");
	   String opt6 = new String("6. Back To Main Menu ");
	   String msg = new String("Enter Option");
	   String equipment = new String("Numbers equipments on hire: " + equipmentList.size());
	   JTextField opt = new JTextField("");
	   
	   Object message[] = new Object[10];

	   message[0] = myIcon;
	   message[1] = opt1;
	   message[2] = opt2;
	   message[3] = opt3;
	   message[4] = opt4;
	   message[5] = opt5;
	   message[6] = opt6;
	   message[7] = msg;
	   message[8] = opt;
	   message[9] = equipment ;

	   int table = JOptionPane.showConfirmDialog(null,message,"Equipment For Rent",JOptionPane.OK_CANCEL_OPTION,
		 JOptionPane.QUESTION_MESSAGE ,anIcon);
	   
	   if(table == JOptionPane.CANCEL_OPTION)
		   ;
	   else
	   	{
		   try {
			   option = Integer.parseInt( opt.getText());
			   
			 }
		   	   
		   catch (Exception e)
		   {
		   JOptionPane.showMessageDialog(null,"Data Input Error! " + "\nPlease Enter On Option [1-6]" + "\nPlease Try Again" );
		   }
	   	}
	return option;
	   
  }
  public void hireEquipment () throws EmptyFieldException
   {
	 String[] hireList = { "Please Select", "Boat", "Rod", "Tripod"};
	 String msgEquipment = new String("Equipment Menu for hire :");
	 
	 String msgName = new String(" Customer Name: ");
	 String msgNumber = new String(" Equipment number");
	 String msgTitle = new String(" Title: ");
	 String msgSize = new String(" Size: ");
	 String msgPrice = new String("Price :");
	 
	 
	 JTextField name = new JTextField("");					   
	 JTextField number = new JTextField("");
	 JTextField title = new JTextField("");
	 JTextField Size = new JTextField("");
	 JTextField price = new JTextField("");
	 
	 JComboBox equipment = new JComboBox(hireList);
	 
	 equipment.setSelectedIndex(0);
	
	 
	 Object message[] = new Object[13];
				   
	 message[0] = myIcon;
	 message[1] = msgEquipment;
	 message[2] = equipment;
	 message[3] = msgName;
	 message[4] = name;
	 message[5] = msgNumber;
	 message[6] = number;
	 message[7] = msgTitle;
	 message[8] = title;
	 message[9] = msgSize;
	 message[10] = Size;
	 message[11] = msgPrice;
	 message[12] = price;
	 					   
				   
	int table = JOptionPane.showConfirmDialog(null,message,"Equipment for Fishing",JOptionPane.OK_CANCEL_OPTION,
					 JOptionPane.QUESTION_MESSAGE ,anIcon);
				   
	 if(table == JOptionPane.CANCEL_OPTION);
	 	   	   
	  else
	  {
		try {
			if ( Double.parseDouble(price.getText()) <= 0)
			{
				throw new InvalidPriceException();
			}
			
			else
			 {
				if(equipment.getSelectedIndex() == 1)
				{
					    	
			 Boat boat = new Boat (name.getText(),Integer.parseInt(number.getText()),title.getText(), Double.parseDouble(Size.getText()), Double.parseDouble(price.getText()));
					    
			
			
			for (int i = 0; i < equipmentList.size(); i++)
			{
				if (equipmentList.get(i).getNumber() == boat.getNumber())
				{
					throw new ExistingIDException();
				}
			}
			equipmentList.add(boat);
			fileHire.writeToFile(equipmentList);
			 					    
			JOptionPane.showMessageDialog(null, "The Boat Added Successfully ");
				    
			  }
				if (equipment.getSelectedIndex() == 2)
				{
					Rod rod = new Rod (name.getText(),Integer.parseInt(number.getText()), title.getText(),Double.parseDouble(Size.getText()), Double.parseDouble(price.getText()));
					
					for (int i = 0; i < equipmentList.size(); i++)
					{
						if (equipmentList.get(i).getNumber() == rod.getNumber())
						{
							throw new ExistingIDException();
						}
					}
				    
				    equipmentList.add(rod);
				    fileHire.writeToFile(equipmentList);
				    
				    JOptionPane.showMessageDialog(null, "The Rod Added Successfully ");
				    
				     	}
				else if (equipment.getSelectedIndex() == 3)
				{
					 Tripod tripod = new Tripod (name.getText(),Integer.parseInt(number.getText()), title.getText(),Double.parseDouble(Size.getText()), Double.parseDouble(price.getText()));
					 
					 for (int i = 0; i < equipmentList.size(); i++)
						{
							if (equipmentList.get(i).getNumber() == tripod.getNumber())
							{
								throw new ExistingIDException();
							}
						}
					    
					 equipmentList.add(tripod);
					 
					 Collections.sort(equipmentList);
					 
					 fileHire.writeToFile(equipmentList);
							    
							    JOptionPane.showMessageDialog(null, "The Tripod Added Successfully ");
							    
							     	}	
				}
		}
		
		catch (InvalidPriceException ee)
		{
			JOptionPane.showMessageDialog(null, "The Price Is Invalid" + "\nPlease Try Again" );
		}
		catch (ExistingIDException eee)
		{
			JOptionPane.showMessageDialog(null, "The Equipment Number Exist On List " + "\nPlease Try Again" );
		}
		catch (Exception e)
		 {
			 JOptionPane.showMessageDialog(null, "Data Input Error!  " + "\nPlease Try Again" ); 
		 }
	 }
   }

       public void hireSearchEquipment()
        {
    	   
    	try{
    	   
        	 String txtNumber = JOptionPane.showInputDialog("Please Enter Equipment Number  :");
       	    int number = Integer.parseInt(txtNumber);
       		
       		
       	if (equipmentList.isEmpty() == true)
       	{
       		JOptionPane.showMessageDialog(null, "The Equipment List Is Empty");
       	}
       	
       	boolean found = false;
       	for (int i = 0; i < equipmentList.size(); i++)
       	{
       		if(equipmentList.get(i).getNumber() == number)
       		{
       			
       			JOptionPane.showMessageDialog(null," Customer Name : " + equipmentList.get(i).getName() + "\n"
       			+ " Equipment Number : " + equipmentList.get(i).getNumber() + "\n"
       					+ " Title : " + equipmentList.get(i).getTitle() + "\n"
       							+ " Price : " + equipmentList.get(i).getPrice() + "\n"
       									+ " Size : " + equipmentList.get(i).getSize());
       			found = true;
       			break;
       		}
       	}
       	
       	if(!found)
       	       	JOptionPane.showMessageDialog(null, "The Equipment is Not Exist");
       	 
    	}
       	catch( NumberFormatException nfm)
   	     {
   		 JOptionPane.showMessageDialog(null, "Please Enter Equipment Number!  " + "\nPlease Try Again" );	 
   	     }
    }

     public void hereModifyEquipment() throws EmptyFieldException
     {
      try{
    	 
          String txtNumber = JOptionPane.showInputDialog("Please Enter Equipment Number  :");
       	  int number = Integer.parseInt(txtNumber);
       		
       	  if (equipmentList.isEmpty() == true)
       	    {
       		JOptionPane.showMessageDialog(null, "The Equipment List Is Empty");
       	    }
       	
        	boolean found = false;
       	
       	  for (int i = 0; i < equipmentList.size(); i++)
       	  {
       		 if(equipmentList.get(i).getNumber() == number)
       		 {
       		 	
       		  String msgNumber = new String("Equipment Number: " +number);
       		  String msgName = new String("Customer Name: " ); 
       		  String msgTitle = new String("Title: ");
       		  String msgSize = new String("Size: ");
       		  String msgPrice = new String("Price: ");
       							   
       		  JTextField name = new JTextField("");
       		  JTextField title = new JTextField("");
       		  JTextField Size = new JTextField("");
       		  JTextField price = new JTextField("");
       					   
       		  Object message[] = new Object[10];
       					   
       		  message[0] = myIcon;
       		  message[1] = msgNumber;
       		  message[2] = msgName;
       		  message[3] = name;
       		  message[4] = msgTitle;
       		  message[5] = title;
       		  message[6] = msgSize;
       		  message[7] = Size;
       		  message[8] = msgPrice;
       		  message[9] = price;
       		
       			   
       			   int table = JOptionPane.showConfirmDialog(null,message,"Fishing Club Manager",JOptionPane.OK_CANCEL_OPTION,
       						 JOptionPane.QUESTION_MESSAGE ,anIcon);
       					   
       			   if(table == JOptionPane.CANCEL_OPTION);
       						   
       			    else
       				 {
       						 try{
	   
       			   		equipmentList.get(i).setTitle(title.getText());
       			   		equipmentList.get(i).setSize(Double.parseDouble(Size.getText()));
       			   		equipmentList.get(i).setPrice(Double.parseDouble(price.getText()));
       			   		
       					JOptionPane.showMessageDialog(null, "The Equipment Modified Successfully ");
       					
       					found = true;
       					break;
       					 }
       						catch (Exception e)
       					 {
       						 JOptionPane.showMessageDialog(null, "Data Input Error!  " + "\nPlease Try Again" ); 
       					 }
       				 }
       		     }
       	  }
       		
       		if(!found)
       		     JOptionPane.showMessageDialog(null, "The Equipment is Not Exist");
       	  
         	
    	 }
    	 catch( NumberFormatException nfm)
    	 {
    		 JOptionPane.showMessageDialog(null, "Please Enter Equipment Number!  " + "\nPlease Try Again" );	 
    	 }
       }   
      
        public void hireEquipmentList()
        {
        if (equipmentList.isEmpty() == true)
       	{
       		JOptionPane.showMessageDialog(null, "The Equipment List Is Empty");
       	}
       	
        else                
         {
			 JOptionPane.showMessageDialog(null,equipmentList);
		 }
       }
    
            public void hireReturnEquipment()
              {
            	try{
            	
                 String txtNumber = JOptionPane.showInputDialog("Please Enter Equipment Number  :");
               	 int number = Integer.parseInt(txtNumber);
               		
               		
               	if (equipmentList.isEmpty() == true)
               	{
               		JOptionPane.showMessageDialog(null, "The Equipment List Is Empty");
               	}
               	
               	boolean found = false;
               	
               	for (int i = 0; i < equipmentList.size(); i++)
               	{
               		if(equipmentList.get(i).getNumber() == number)
               		{
               			equipmentList.remove(i);
               			fileHire.writeToFile(equipmentList);
               		
               			JOptionPane.showMessageDialog(null, "The Equipment Was Returned Successfully ");
               			
               			found = true;
               			break;
               		   }
               		}
               		if(!found)
               		    JOptionPane.showMessageDialog(null, "The Equipment is Not Exist");
               	    
            	}
            	catch( NumberFormatException nfm)
           	    {
           		 JOptionPane.showMessageDialog(null, "Please Enter Equipment Number!  " + "\nPlease Try Again" );	 
           	    }
	
	}
}
            

