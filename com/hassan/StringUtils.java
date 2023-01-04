package com.hassan;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    public static int CountVowels(String str)
    {
        if(str==null)
            return 0;
        int count=0;
        String vowels = "aeiou";
        for (var ch: str.toLowerCase().toCharArray())
        {
            if(vowels.contains(Character.toString(ch)))
                count++;
        }
        return count;
    }

    public static String reverseString(String str)
    {
        if (str==null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length()-1; i >=0 ; i--)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }
    public static String reverseWords(String sentence)
    {
        if (sentence==null)
            return "";
        var words = sentence.trim().split(" ");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length-1; i >=0 ; i--)
            reversed.append(words[i]+" ");
        return reversed.toString().trim();
    }
    public static boolean areRotations(String str1, String str2)
    {
        if (str1==null||str2==null)
            return false;
        return (str1.length()==str2.length() &&
                (str1 + str1).contains(str2));
    }
    public static String removeDuplicates(String str)
    {
        if (str==null)
            return "";
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (var ch: str.trim().toCharArray()) {
            if (!seen.contains(ch))
            {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static char getMaxOccuringChar(String str)
    {
        if(str == null|| str=="")
            throw new IllegalArgumentException();
        final int ASCII_SIZE = 256;
        int frequencies[] = new int[ASCII_SIZE];
        for (var ch:str.trim().toCharArray())
            frequencies[ch]++;

        int max=0;
        char result=' ';
        for (var i = 0; i < frequencies.length; i++) {
            if (frequencies[i]>max)
            {
                max = frequencies[i];
                result = (char) i;
            }
        }
        return result;
    }

    public static String capitalize(String sentence)
    {
        if (sentence==null||sentence.trim().isEmpty())
            return "";
        var words = sentence.trim().replaceAll(" +"," ").split(" ");
        var output = "";
        for (int i = 0; i < words.length; i++) {
            var firstLetter = words[i].substring(0,1);
            var remaining = words[i].substring(1);
            output += firstLetter.toUpperCase()+remaining+" ";
        }
        return output.trim();
    }

    public static boolean areAnagrams(String str1, String str2)
    {
        if (str1==null||str2==null)
            return false;
        var array1 = str1.toCharArray();
        Arrays.sort(array1);
        var array2 = str2.toCharArray();
        Arrays.sort(array2);
        return Arrays.equals(array1,array2);
    }
    public static boolean areAnagrams2(String str1, String str2)
    {
        if (str1==null||str2==null)
            return false;
        final int ALPHABET_SIZE = 26;
        int[] frequencies = new int[ALPHABET_SIZE];

        for (var ch: str1.toLowerCase().toCharArray()) {
            frequencies[ch-'a']++;
        }
        for (var ch: str2.toLowerCase().toCharArray()) {
            if (frequencies[ch-'a']==0)
                return false;
            frequencies[ch-'a']--;
        }
        return true;
    }

    public static boolean isPalindrome(String word)
    {
        if (word==null)
            return false;
        int left = 0;
        int right = word.length()-1;
        while (left<right)
        {
            if(word.charAt(left++)!= word.charAt(right--))
                return false;
        }
        return true;
    }
}
