package com.application.TicketingApp.sample;

public class SampleApp {

	public int divide(int a, int b)
	{
		return a/b;
	}

	public String ReverseString(String str)
	{
		char[] charArr = str.toCharArray();
		
		int left = 0;
		int right = charArr.length -1;
		
		while(left<right)
		{
		   char temp = charArr[left];
		   charArr[left] = charArr[right];
		   charArr[right] = temp;		 
		   left++;
		   right--;
		}
		return new String(charArr);
	}
}
