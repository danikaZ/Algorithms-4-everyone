/* Author:DanikaZ
Dynamic Programming Java implementation of Fibonacci  */

/*Description: The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……
In mathematical terms, the sequence Fn of Fibonacci numbers is 
defined by the recurrence relation
    Fn = Fn-1 + Fn-2
with seed values
   F0 = 0 and F1 = 1
From http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
Give a number N, find the fibonacci value of Fn
Example:
N = 0 then F0 = 0, N = 1 then F1 = 1; N = 5 then F9 = 34
The key point is, with a given N to calculate Fn, instead of calculating Fn-1 and Fn-2 from scratch,
we would save Fn-1 and Fn-2 from previous calcution to save the effort.
*/

public class Fibonacci {
	public static void main(String args[]) {
		int n = 9;
		System.out.println(fib_dp(n));
		System.out.println(fib_dp_optimized(n));
	}

	/*
	 * We save all the values of Fn into the array fn Therefore, with a given N,
	 * Fn would be the value of fn[N]
	 */
	public static int fib_dp(int n) {
		if(n <= 1 ) return n;
		
		int[] fn = new int[n + 1];
		fn[0] = 0;
		fn[1] = 1;

		for (int i = 2; i <= n; i++) {
			fn[i] = fn[i - 1] + fn[i - 2];
		}
		return fn[n];
	}
	
	/*
	 * Instead of saving all the values of Fn into the array fn, we save 
	 * Fn-1, Fn-2 into two parameters a, b to keep the algorithm going
	 * Fn would be the value of b
	 */
	public static int fib_dp_optimized(int n) {
		if(n <= 1 ) return n;
		
		int a = 0;
		int b = 1;
		int c;
		
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}