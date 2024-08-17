package com.palindromo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palindromo.dto.PalindromoRequest;
import com.palindromo.dto.PalindromoResponse;
import com.palindromo.service.PalindromoService;

@RestController
@RequestMapping("/api")
public class PalindromoController {

	@Autowired
	private PalindromoService palindromoService;
	
	@PostMapping("/palindromo")
    public PalindromoResponse checkPalindromo(@RequestBody PalindromoRequest request) {
        String palindromo = request.getPalindromo();
        String cleanedString = palindromoService.cleanString(palindromo);
        boolean isPalindromo = palindromoService.isPalindrome(cleanedString);
        int lengthCadena = cleanedString.length();
        int lengthCaracteresEspeciales = palindromoService.countSpecialCharacters(palindromo);

        return new PalindromoResponse(lengthCadena, isPalindromo ? 1 : 0, lengthCaracteresEspeciales);
    }
	
	
}
