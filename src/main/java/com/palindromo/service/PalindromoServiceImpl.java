package com.palindromo.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromoServiceImpl implements PalindromoService{
	
	public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int countSpecialCharacters(String s) {
    	// Filtrar solo los caracteres que no son letras ni dígitos, excluyendo los espacios
        return (int) s.chars()
                .filter(ch -> !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch))
                .count();
    }

    public String cleanString(String s) {
        return s.replaceAll("\\s+", "").toLowerCase();
    }
}
