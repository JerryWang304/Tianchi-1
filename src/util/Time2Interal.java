package util;

public class Time2Interal {
	public static int getInteral(String time)
	{
		//System.out.println(time);
		int result=0;
		int mouth=Integer.parseInt(time.substring(6, 7));
		int day=Integer.parseInt(time.substring(8,10));
		int hour=Integer.parseInt(time.substring(11,13));
		//System.out.println(day+":"+mouth+""+hour);
		if(mouth==1)
		{
			result+=24*(18+31-mouth);
		}
		result+=(18-day)*24+24-hour;
		
		
		
		return result;
		
	}
	public static void main(String args[])
	{
		String result="2014-11-18 23";
		
		
		
		System.out.println( getInteral(result));
	}

}
