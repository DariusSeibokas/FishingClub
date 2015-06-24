package club.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import club.hire.Equipment;

public class FileHandlerHire
{
	private FileOutputStream outByteStream;
	private ObjectOutputStream OOStream;
	private FileInputStream inByteStream;
	private ObjectInputStream OIStream;
	private File aFile;
	
	public void setFile(String string)
	{
		aFile = new File(string);
		
	}
	
	
	public boolean isFileEmpty()
	{
		return (aFile.length() <= 0);
	}
	
	public void writeToFile(List <Equipment> equipmentList)	
	{
	 try
	 {
	  outByteStream = new FileOutputStream(aFile);
	  OOStream = new ObjectOutputStream(outByteStream);
	 
	  OOStream.writeObject(equipmentList);
	  
	  outByteStream.close();
	  OOStream.close();
	 }
	 catch(IOException e)
	 {
		 JOptionPane.showMessageDialog(null,"I/O Error: " + e);
	 }
	}
	
	@SuppressWarnings("unchecked")
	public List <Equipment> readFromFile()
	{
	List <Equipment> temp = null;
	
	try
	 {
	  inByteStream = new FileInputStream(aFile);
	  OIStream = new ObjectInputStream(inByteStream);
	 
	  if(!this.isFileEmpty())
		  temp = (List<Equipment>)OIStream.readObject();
	  
	  inByteStream.close();
	  OIStream.close();
	 }
	 catch(IOException e)
	 {
		 JOptionPane.showMessageDialog(null,"I/O Error" + e);
	 }
	 
	 catch(Exception e)
	 {
		 JOptionPane.showMessageDialog(null,"General Error" + e);
	 }

	return temp;
	}

}

