# Microservicio: Verificador de Palíndromos
Descripción

Este microservicio recibe un JSON de entrada con una cadena de texto y devuelve un JSON de salida con los siguientes parámetros:

- lengthCadena: La longitud total de la cadena ingresada.

- isPalindromo: Indica si la cadena ingresada es un palíndromo (1 para verdadero, 0 para falso).

- lengthCaracteresEspeciales: La cantidad de caracteres especiales presentes en la cadena (aquellos que no son letras ni números).

## Ejemplo de Entrada

{


  "palindromo": "anita lava la tina"

}

## Ejemplo de Salida
{

  "lengthCadena": 18,

  "isPalindromo": 1,
  
  "lengthCaracteresEspeciales": 0

}

## Tecnologías Utilizadas
Java 21

Spring Boot

Maven

