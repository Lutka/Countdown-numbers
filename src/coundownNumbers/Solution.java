package coundownNumbers;

public class Solution
{
	private String text = "";
	private int num = 0;
	
	public Solution(int num)
	{
		this.num = num;
		text= ""+num;
	}
	public String getText()
	{
		return text;
	}
	public int getNum()
	{
		return num;
	}
	public void setText(String text)
	{
		this.text=text;
	}
}

