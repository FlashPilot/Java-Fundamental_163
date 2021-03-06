import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	public static void perfectNumber(int input)
	{
		
		int originalInput = input;
		int j = 0;
		int sum = 1;
		int[] primes = new int[100000];
		int[] primeFactor = new int[input];
		boolean[] isPrime = new boolean[primes.length];
		
//		set each cell of array isPrime to true
		for(int i=0; i<isPrime.length; i++)
		{
			isPrime[i] = true;
		}
		
//		construct primes table
		for(int i=2; i<isPrime.length; i++)
		{
			if(isPrime[i])
			{
				for(int k=2; i*k<isPrime.length; k++)
				{
					isPrime[i*k] = false;
				}
			}
		}
		
//		find out prime factors of arbitrary integer
		for(int i=2; i<=input; i++)
		{
			if(isPrime[i])
			{
				if(input == i)
				{
					primeFactor[j] = i;
					break;
				}
				if(input%i == 0)
				{
					primeFactor[j] = i;
					input /= i;
					j++;
					i = 1;
				}
			}
		}

		for(int i=0; i<primeFactor.length; i++)
		{
			if(primeFactor[i]!=0)
			{
				sum = sum + primeFactor[i];
			}
		}
		
		
		if(originalInput == sum)
		{
//			perfectNumber[i] = a;
			System.out.println(originalInput + " is a perfect number.");
		}
		else
		{
			System.out.println(originalInput + " is not a perfect number.");
		}
//		System.out.println(Arrays.toString(primeFactor));
//		System.out.println(sum);
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int integer = in.nextInt();
		perfectNumber(integer);
		
	}

}
