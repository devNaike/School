/*
 * @author Naike Romeo
 * @date 29 Ago 2016
 * @descriprion Concatena due parole.
 */

import java.io.*;

public class PrimoEsercizio{
	public static void main(String[] args){

		InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        
        try{

        	System.out.print("Inserisci il tuo nome: ");
        	String nome = tastiera.readLine();

        	System.out.print("Insersci la seconda parola: ");
        	String cognome = tastiera.readLine();

        	System.out.print("Insersci la tua età: ");
        	String eta = tastiera.readLine();

        	System.out.println(nome + " " + cognome + ", " + eta);

        }catch(IOException e){
        	System.out.println("Errore!");
        }

	}
}