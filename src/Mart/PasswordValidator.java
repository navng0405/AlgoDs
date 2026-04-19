package Mart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Password ValidationEasy
 * Skills:
 * Problem Solving (Basic)
 * Tags:
 * Strings, Brute Force, Real-World, Interviewer Guidelines
 * There are n passwords in the form of a string array of passwords[n]. There is also a dictionary dict_words[m] that contains m weak passwords.
 *
 *
 *
 * Classify each of the n passwords as "weak" or "strong".
 *
 *
 *
 * A password is "weak" if any of these conditions are met.
 *
 * The password is in the dictionary.
 *
 * A substring of the password is a word in the dictionary.
 *
 * The password is all numerical, i.e., consisting of characters from ('0' to '9').
 *
 * All characters are uppercase('A' to 'Z') or all of them are lowercase('a' to 'z').
 *
 * The password is shorter than 6 characters.
 *
 *
 *
 * Implement a prototype password validation service.
 *
 *
 *
 * Given a list of n strings, passwords, and m strings, common_words, for each of the passwords, report "strong" or "weak" based on the conditions.
 *
 *
 *
 * Example
 *
 * Suppose n = 5, m = 3, passwords = [“iliketoCoDe”, “teaMAKEsmehappy”, “abracaDabra”, “pasSword”, “blackcoffeeISthebest”], common_words = [“coffee”, “coding”, “happy”]
 *
 *
 *
 * password	strong/weak	Remarks
 * iliketoCoDe	strong
 * teaMAKEsmehappy	weak	Contains "happy"
 * abracaDabra	strong
 * pasSword	strong
 * blackcoffeeISthebest	weak	Contains "coffee"
 *
 *
 * Function Description
 *
 * Complete the function getPasswordStrength.
 *
 *
 *
 * getPasswordStrength has the following parameters:
 *
 *         string passwords[n]: the list of passwords to check
 *
 *         string common_words[m]: the list of dictionary words
 *
 *
 *
 * Returns:
 *
 *     string[n]: the strengths of the passwords
 *
 *
 *
 * Constraints
 *
 * 1 ≤ n ≤ 103
 *
 * 1 ≤ m ≤ 105
 *
 * 1 ≤ common_words[i] ≤ 20
 *
 * 1 ≤ passwords[i] ≤ 20
 *
 * The passwords consist of lowercase, uppercase, and numeric characters only.
 */
public class PasswordValidator {
    public static void main(String[] args) {
        String[] passwords = {"iliketoCoDe", "teaMAKEsmehappy", "abracaDabra", "pasSword", "blackcoffeeISthebest"};
        String[] common_words = {"coffee", "coding", "happy"};
        System.out.println(Arrays.toString(getPasswordStrength(passwords, common_words)));
    }

    private static String[] getPasswordStrength(String[] passwords, String[] commonWords) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(commonWords));
        String[] strength = new String[passwords.length];
        for(int i=0;i<passwords.length;i++){
            if(isWeek(passwords[i],dictionary)){
                strength[i] = "week";
            }else{
                strength[i] = "strong";
            }
        }

        return strength;
    }

    private static boolean isWeek(String password, Set<String> dictionary) {
        if(password.length()<6 || dictionary.contains(password) || isAllNumeric(password) || isUniformCase(password)){
            return true;
        }
        for(int i=0;i<password.length();i++){
            for(int j=i+1;j<=password.length();j++){
                if(dictionary.contains(password.substring(i,j))){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isUniformCase(String password) {
        return password.equals(password.toLowerCase()) || password.equals(password.toUpperCase());
    }

    private static boolean isAllNumeric(String password) {
        return password.matches("[0-9]+");
    }
}
