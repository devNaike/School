/*
*	@author Naike
*	@date 24 Sep 2016
*	@description Conversione di una stringa nella codifica Morse
*/
import java.io.*;

public class Morse {

	public static String Converti(String codice) {

		String[] alfabetoMorse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
			".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
			".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....",
			"--...","---..","----.","-----"," // "};
		char[] alfabeto = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
			'Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0',' '};
		
        int arrayPosition = 0;
		String result =" ";
		codice = codice.toUpperCase();
        
		for(int i = 0; i < codice.length(); i++){
			char lettera = codice.charAt(i);
			for(int j = 0; j < alfabeto.length; j++) {
				if(lettera == alfabeto[j]) {
					arrayPosition = j;
					break;
				}
			}

			if(i != codice.length()-1) {
				if(codice.charAt(i+1) == ' ') result += alfabetoMorse[arrayPosition];
				else if(codice.charAt(i) == ' ') result += alfabetoMorse[arrayPosition] + "\n" + " ";
				else result += alfabetoMorse[arrayPosition] + " / ";
			}else result += alfabetoMorse[arrayPosition] + " //";
		}
		return result;
	}
	public static void main(String[] args) {

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);

		try{
			System.out.print(" Inserisci la stringa da convertire in morse: ");
			String codice = tastiera.readLine();
			System.out.println("");
			System.out.println(Converti(codice));
			System.out.println("");
		}catch(IOException e) {
			System.out.println("Errore: " + e.getMessage());
		}
	}
}