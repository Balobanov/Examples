package ua.org.ao.balobanov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

class StringUtil
{
	public enum SORTTYPE
	{
		NAME_AZ, NAME_ZA, VALUE_TO_BIGGEST, VALUE_TO_LOWER;
	}
	
	public static void metod(String text)
	{
		Map<String, Integer> map = new HashMap<>();
		Integer count = 0;
		
		Scanner scan = new Scanner(text).useDelimiter(" ");
		String key;
		
		while(scan.hasNext())
		{
			key = scan.next();
			count = map.get(key);
			if(count == null)
			{
				map.put(key, 0);
			}
			else
			{
				map.put(key, ++count);
			}
		}
		
		
		Set<Map.Entry<String, Integer>> s = map.entrySet();
		
		for (Entry<String, Integer> entry : s) {
			System.out.println(entry.getKey()+ " раз(а): " + entry.getValue());
			System.out.println();
		}
	}

	public static Map<String, Integer> metod(String text, SORTTYPE sort)
	{
		Map<String, Integer> map = new LinkedHashMap<>();
		Integer count = 0;
		
		Scanner scan = new Scanner(text).useDelimiter(" ");
		String key;
		
		while(scan.hasNext())
		{
			key = scan.next();
			count = map.get(key);
			if(count == null)
			{
				map.put(key, 0);
			}
			else
			{
				map.put(key, ++count);
			}
		}
		
		Set<Map.Entry<String, Integer>> s = map.entrySet();
		List<Entry<String, Integer>> w = new ArrayList<>(s);
		
		switch (sort) {
		case NAME_AZ:
			Collections.sort(w, new Comparator<Entry<String, Integer>>()
					{
						@Override
						public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
							return o1.getKey().compareTo(o2.getKey());
						}
						
					});
			break;
			
		case NAME_ZA:
			Collections.sort(w, new Comparator<Entry<String, Integer>>()
					{
						@Override
						public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
							return o2.getKey().compareTo(o1.getKey());
						}
						
					});
			break;
			
		case VALUE_TO_BIGGEST:
			Collections.sort(w, new Comparator<Entry<String, Integer>>()
					{
						@Override
						public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
							return o1.getValue() - o2.getValue();
						}
						
					});
			break;
			
		case VALUE_TO_LOWER:
			Collections.sort(w, new Comparator<Entry<String, Integer>>()
					{
						@Override
						public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
							return o2.getValue() - o1.getValue();
						}
						
					});
			break;

		default:
			break;
		}
		
		Map<String, Integer> map2 = new LinkedHashMap<>();
		Iterator<Entry<String, Integer>> it = w.iterator();
		Entry<String, Integer> e;
		
		while(it.hasNext())
		{
			e = it.next();
			map2.put(e.getKey(), e.getValue());
		}
		
		return map2;
	}
}