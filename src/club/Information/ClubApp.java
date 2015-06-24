
package club.Information;

import club.exeption.InvalidPriceException;
import club.exeption.ExistingIDException;
import club.exeption.EmptyFieldException;

public class ClubApp
{

public static void main( String args[] ) throws InvalidPriceException,ExistingIDException, EmptyFieldException
 
{
	   int option;
	   
	   ClubManager manager = new ClubManager();
	   
	   do {
		   
	   option = manager.menu();
	   
	   	switch(option)
	   		{
	   	case 1: manager.menuAddMembers();
	   			  break;
	   			  
	   	case 2: manager.menuSearchMembers();
	   	         break;
	   	         
	   	case 3: manager.menuModifyMembers();
	   			 break;
	   			  
	   	case 4:	manager.menuRemoveMembers();
	   			  break;
	   	
	   	case 5: manager.menuListMembers();
	   		      break;
	   	
	   	case 6: manager.menuHireEquipment();
	   	
	   	int hireOption;

		   do {
			   
		   hireOption = manager.hire();
		   
	   		   	    	   switch(hireOption)
	   	                      {
	   	    	   
   								case 1: manager.hireEquipment();
   								break;
   			     								   								
   								case 2: manager.hireSearchEquipment();
   								break;
   								
   								case 3: manager.hereModifyEquipment();
   								break;
   	
   								case 4: manager.hireEquipmentList();
   								break;
   			  
   								case 5: manager.hireReturnEquipment();
   								break;
   		   		   	 			  
   								case 6: break;      
   								default : break;
	   	                         }
	   		   		   	 			  
	   	
	                      } while(hireOption != 6);
		   
		   break;
		   
	   	case 7: break;      
		default : break;
            }


  } while(option != 7);
} 
}

	   	
