/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// setting variables
		String firstAng = preProcess(str1);
		String secondAng = preProcess(str2);
		String finalList = "";
		int i = 0;
		
		// compare any char between the two strings 
		while (i < firstAng.length()) {
			for (int j = 0; j < secondAng.length();	j ++) {
				if (firstAng.charAt(i) == secondAng.charAt(j)) {
					finalList = finalList + firstAng.charAt(i);
					secondAng = secondAng.substring(0, j) + secondAng.substring(j + 1);
				}
			}
			i ++;
		}
		
		// compare final lists
		if (finalList.length() == firstAng.length()) return true;
			
		
		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// setting variables
		String preValue = str;
		String newValue = "";
		int i = 0;

		// check every letter and trasfer to lower case
		while (i < preValue.length()) {
			char charValue = str.charAt(i);
			if (Character.isLetter(charValue)) {
				newValue = newValue + Character.toLowerCase(charValue);
			} 
			i ++; 
		}

		return newValue;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// setting variablest
		String originalAng = preProcess(str);
		String untouchedAng = preProcess(str);
		String newAng = "";
		int i = 0;

		// create new anagram randomly
		while (i < originalAng.length()) {
			int indexToRemove = (int) Math.round(Math.random() * originalAng.length());
			if (indexToRemove >= originalAng.length()) {
				newAng = newAng + originalAng.charAt(indexToRemove - 1);
				originalAng = originalAng.substring(0, indexToRemove); // indexToRemove;
			}
			else {
				newAng = newAng + originalAng.charAt(indexToRemove);
				originalAng = originalAng.substring(0, indexToRemove) + originalAng.substring(indexToRemove + 1); // indexToRemove;
			}
			continue;
		}

		// verify new anagram
		if (newAng.length() == untouchedAng.length()) return newAng;
		
		else return "";
	}
}
