package org.jakz.common.util;

import java.util.List;

public class StringUtil 
{
	public static String stringSeparateFixedSpacingLeft(String target, String separator, int spacing)
	{
		StringBuilder result = new StringBuilder();
		
		for(int is=0; is<target.length(); is+=spacing)
		{
			if(is!=0)
				result.append(separator);
			if(is+spacing<target.length())
				result.append(target.substring(is, is+spacing));
			else
				result.append(target.substring(is));
		}
		
		return result.toString();
	}
	
	public static String stringSeparateFixedSpacingRight(String target, String separator, int spacing)
	{
		StringBuilder result = new StringBuilder();
		
		for(int is=target.length(); is>0; is-=spacing)
		{
			if(is!=target.length())
				result.insert(0,separator);
			if(is-spacing>=0)
				result.insert(0,target.substring(is-spacing, is));
			else
				result.insert(0,target.substring(0, is));
		}
		
		return result.toString();
	}
	
	public static String appendAll(List<String> s, String separator)
	{
		StringBuilder toReturn = new StringBuilder();
		
		for(String spart : s)
		{
			if(toReturn.length()>0)
				toReturn.append(separator);
			
			toReturn.append(spart);
		}
		
		return toReturn.toString();
	}
}
