package org.jakz.common.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public static String matchAndCatch(String input, String regex)
	{
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(input);
		
		if(m.find())
		{
			return m.group();
		}
		
		return null;
	}
	
	public static String substringInc(String input,String beginStrIndexOf,String endStrIndexOf)
	{
		if(endStrIndexOf!=null)
			return input.substring(input.indexOf(beginStrIndexOf),input.indexOf(endStrIndexOf));
		else
			return input.substring(input.indexOf(beginStrIndexOf));
	}
	
	public static String substringInc(String input, String beginStrIndexOf)
	{
		return substringInc(input,beginStrIndexOf,null);
	}
	
	public static String lastSubstringInc(String input,String beginStrIndexOf,String endStrIndexOf)
	{
		if(endStrIndexOf!=null)
			return input.substring(input.lastIndexOf(beginStrIndexOf),input.lastIndexOf(endStrIndexOf));
		else
			return input.substring(input.lastIndexOf(beginStrIndexOf));
	}
	
	public static String lastSubstringInc(String input, String beginStrIndexOf)
	{
		return lastSubstringInc(input,beginStrIndexOf,null);
	}
	
	public static String substringMax(String input, int beginIndex,int maxEndIndex)
	{
		int endIndex = NumUtil.numMinInteger(maxEndIndex, input.length());
		return input.substring(beginIndex, endIndex);
	}
	
	public static String substringMax(String input, int maxEndIndex)
	{
		return substringMax(input,0,maxEndIndex);
	}
	
	public static String optToString(Object toStringObject)
	{
		if(toStringObject==null)
			return "";
		else
			return toStringObject.toString();
	}
	
	public static String iterableToSeparatedString(Object[] toIterate, String separator)
	{
		if(separator==null)
			separator=",";
		StringBuilder result = new StringBuilder();
		
		for(Object c : toIterate)
		{
			if(result.length()>0)
				result.append(separator);
			result.append(""+c);
		}
		
		return result.toString();
		
	}
	
	public static String padLeftToLength(String source, String padding, int targetLength)
	{
		StringBuilder product = new StringBuilder("");
		while(product.length()+source.length()<targetLength)
		{
			product.append(padding);
		}
		return product.toString()+source;
	}
	
	public static String padRightToLength(String source, String padding, int targetLength)
	{
		StringBuilder product = new StringBuilder("");
		while(product.length()+source.length()<targetLength)
		{
			product.append(padding);
		}
		return source+product.toString();
	}
	
}
