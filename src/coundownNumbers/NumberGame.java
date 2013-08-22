package coundownNumbers;

import java.util.ArrayList;
import java.util.*;

public class NumberGame
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		//System.out.println("Enter the six numbers:");
		String input = "100 50 75 25 3 6";//myScanner.nextLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		while(st.hasMoreTokens())
		{
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		
		//System.out.println("Enter the target number: ");
		int target = 972;//myScanner.nextInt();
		int closest = 0;
		String solution = "";
		Solution currentSolution;
		
		ArrayList<Solution> myList = new ArrayList<>(); 
		
		int x;
		int result;		
		Solution first , second;
		
		for(int i = 0; i < 1000000; i++)
		{	
			//populate initial solution array
			for(int j = 0; j < numbers.size(); j++)
			{
				Solution entry = new Solution(numbers.get(j));
				myList.add(entry);
			}
			
			result = 0;
			while (myList.size() > 1) // while there are at least two solutions on the list
			{
				first = myList.remove((int)(Math.random()*myList.size()));			
				second = myList.remove((int)(Math.random()*myList.size()));
				
				//System.out.print(" first: "+first+" second: "+second);
				
				//switch varible
				x = (int) (Math.random()*4);	
				//System.out.print(" operation "+x);
				
				//switch cases for operators
				switch(x)
				{
					//add
					case 0: result = first.getNum() + second.getNum();					
							Solution entry = new Solution(result);
							entry.setText("( "+ first.getText()+" + "+ second.getText()+" )" );	
							myList.add(entry);
						break;
					//subtract	
					case 1:	result = first.getNum() - second.getNum();
							Solution entry1 = new Solution(result);
							entry1.setText("( "+ first.getText()+" - "+ second.getText()+" )" );	
							myList.add(entry1);
						break;
					//multiply	
					case 2:	result = first.getNum() * second.getNum();
							Solution entry2 = new Solution(result);
							entry2.setText("( "+ first.getText()+" * "+ second.getText()+" )" );	
							myList.add(entry2);
						break;
					//divide	
					case 3:	if(second.getNum() != 0 && (first.getNum() % second.getNum()) == 0) //can't divide by zero and can't divide
																								//if the result will be a fraction
							{
								result = (int)(first.getNum() / second.getNum());
								Solution entry3 = new Solution(result);
								entry3.setText("( "+ first.getText()+" / "+ second.getText()+" )" );	
								myList.add(entry3);
							}
						else // add back on the list those two numbers if one can't be divided by the other
						{
							myList.add(first);
							myList.add(second);
						}
						break;		
				}				
			}
			
			//remove the result from the list to start with an empty list again
			currentSolution = myList.remove(0);
			if( Math.abs(currentSolution.getNum()- target) < Math.abs(target - closest)) //check if the value is loser
			{
				closest = currentSolution.getNum(); //update the values for the closest
				solution = currentSolution.getText();
			}					
		}
		
		System.out.println("The closest found was "+closest);
		System.out.println("The solution is "+solution);
	}
}
		