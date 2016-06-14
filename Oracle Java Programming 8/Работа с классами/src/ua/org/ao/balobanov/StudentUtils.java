package ua.org.ao.balobanov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class StudentUtils
{
	public static Map<String, Student> createMapFromList(List<Student> list)
	{
		Map<String, Student> map = new HashMap<>();
		for (Student student : list) {
			map.put(student.getfName() + " " + student.getsName(), student);
		}
		return map;
	}
	
	public static void printStudents(List<Student> list, int course)
	{
		Iterator<Student> it = list.iterator();
		Student s;
		
		while(it.hasNext())
		{
			s = it.next();
			if(s.getCourse() == course)
				System.out.println(s.getfName() + " " + s.getsName());
		}
	}
	
	public static List<Student> sortStudent(List<Student> list)
	{
		List<Student> l = new ArrayList<>(list);
		
		Collections.sort(l, new Comparator<Student>()
		{
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getfName().compareTo(o2.getfName());
			}
			
		});
		return l;
	}
}