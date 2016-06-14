package ua.org.oa.balobanov_d;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable{
	private List<Student> students;

	public Group(List<Student> students) {
		this.students = students;
	}

	/*public void saveToFile(String file)
	{
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream ous = new ObjectOutputStream(fos))
		{
			ous.writeObject(students);
			ous.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> readFromFile(String file)
	{
		List<Student> students = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis))
		{
			students = (List<Student>) ois.readObject();	
		}
		catch(IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return students;
	}*/
	
	@Override
	public String toString() {
		return "Group [students=" + students + "]";
	}
	
}
