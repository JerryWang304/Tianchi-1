package feature.profile.impl;
public class Category//对于每一个种类有这些东西
	{
		
		public int count[];
		public Category()
		{
			count=new int[4];
			for(int i=0;i<4;i++)
				count[i]=0;
		}
	}