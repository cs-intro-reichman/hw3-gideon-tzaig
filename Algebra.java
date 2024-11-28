// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// taking variables and defining 'i'
		int baseParam = x1;
		int addedParam = x2;
		int i = 0;

		// handle a possitive integers
		if (addedParam > 0) {
			while (i < addedParam) {
				baseParam ++;
				i ++;
			}
		}

		// handle a negative integers
		if (addedParam < 0) {
			while (addedParam < i) {
				baseParam --;
				i --;
			}
		}

		// to handle the neutral integer '0' , just return the first value

		return baseParam;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// taking variables and defining 'i'
		int baseParam = x1;
		int reducedParam = x2;
		int i = 0;

		// handle a possitive integers
		if (reducedParam > 0) {
			while (i < reducedParam) {
				baseParam --;
				i ++;
			}
		}

		// handle a negative integers
		if (reducedParam < 0) {
			while (reducedParam < i) {
				baseParam ++;
				i --;
			}
		}

		// to handle the neutral integer '0' , just return the first value

		return baseParam;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// taking variables and defining 'i'
		int baseParam = x1;
		int multiplyParam = x2;
		int result = 0;
		int i = 0;

		// handle a two positive integers
		if (0 < baseParam && 0 < multiplyParam) {
			while (i < multiplyParam) {
				result = plus(result, baseParam);
				i ++;
			}
		}

		// handle a two negative integers
		else if (0 > baseParam && 0 > multiplyParam) {
			while (i > multiplyParam) {
				result = minus(result, baseParam);
				i --;
			}
		}

		// handle a first negative integer and a second possitive integer
		else if (0 > baseParam && 0 < multiplyParam) {
			while (i < multiplyParam) {
				result = plus(result, baseParam);
				i ++;
			}
		}

		// handle a first possitive integer and a second negative integer
		else if (0 < baseParam && 0 > multiplyParam) {
			while (i > multiplyParam) {
				result = minus(result, baseParam);
				i --;
			}
		}

		// handle the neutral integer '0' - just return result (=0)

		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// set variables
		int baseParam = x;
		int powerParam = n;
		int result = x;
		int i = 1;

		// handle a power larger then 1 
		if (1 < powerParam) {
			while (i < powerParam) {
				result = times(result, baseParam);
				i ++;
			}
		}

		// handle a zero power
		else if (powerParam == 0) {
			if (0 == baseParam) {
				result = 0;
			}
			else {
				result = 1;
			}
		}	

		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// taking variables and defining 'i'
		int baseParam = x1;
		int devideParam = x2;
		int result = 0;
		int i = 1;

		// handle a two positive integers
		if (0 < baseParam && 0 < devideParam) {
			while (times(devideParam, i) < baseParam) {
				i ++;
			}

			if (times(devideParam, i) == baseParam) {
				result = i;
			}

			if (times(devideParam, i) > baseParam) {
				i --;
				result = i; 
			}
		}

		// handle a two negative integers
		else if (0 > baseParam && 0 > devideParam) {
			while (times(devideParam, i) > baseParam) {
				i ++;
			}

			if (times(devideParam, i) == baseParam) {
				result = i;
			}

			if (times(devideParam, i) < baseParam) {
				return 0; 
			}
		}

		// handle a first negative integer and a second possitive integer
		else if (0 > baseParam && 0 < devideParam) {
			while (times(devideParam, i) > baseParam) {
				i --;
			}

			if (times(devideParam, i) == baseParam) {
				result = i;
			}

			if (times(devideParam, i) < baseParam) {
				return 0; 
			}
		}

		// handle a first possitive integer and a second negative integer
		else if (0 < baseParam && 0 > devideParam) {
			while (times(devideParam, i) < baseParam) {
				i --;
			}

			if (times(devideParam, i) == baseParam) {
				result = i;
			}

			if (times(devideParam, i) > baseParam) {
				return 0; 
			}
		}

		// handle the neutral integer '0' - just return result (=0)

		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// deducing modParam until >= 0
		int baseParam = x1;
		int modParam = x2;
		int result = 0;

		// handle a two positive integers
		if (0 < baseParam && 0 < modParam) {
			while (baseParam >= modParam) {
				baseParam = minus(baseParam, modParam); 
			}

			if (baseParam < modParam) {
				result = baseParam;
			}
		}

		// handle the neutral integer '0' - just return result (=0)

		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// set variables
		int i = 0;
		int result = 0;

		// check if every number square equals x
		while (pow(i, 2) < x) {
			i ++;
			result = i;
		}

		// handle error of larger number
		if (pow(i, 2) > x) {
			i --;
			result = i;	
		}

		// return desired number
		return result;
	}	  	  
}