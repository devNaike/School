/*
* @author: Naike
* @date: 03 Oct 2016
*/

import java.io.*;

public class Fraction{

	private int numerator;      //attributo
	private int denominator;    //attributo

	//metodo costruttore
	public Fraction(int numerator, int denominator){
		setNumerator(numerator);
		setDenominator(denominator);
	}

	//ottengo il numeratore
	public int getNumerator(){
		return this.numerator;
	}

	//assegno il numeratore
	public void setNumerator(int numerator){
		this.numerator = numerator;
	}

	//ottengo il denominatore
	public int getDenominator(){
		return this.denominator;
	}

	//controlla che il denominatore sia diverso da 0, in caso contrario diventa 1
	public void setDenominator(int denominator){
		if(denominator != 0){
			this.denominator = denominator;
		}else{ 
			this.denominator = 1;
		}
	} 

	//minimo comune multiplo
	private int mcm(int a, int b){
		while(a != b){ 
            if(a > b){a = a - b;}
            else{b = b - a;}
        }
        return a;
    }

    //esegue la frazione
	public double getValue(){
		double valore = (double)this.numerator / (double)this.denominator;
		return valore;
	}

    //massimo comun divisore
    private int mcd(int a, int b){
        int mcd=(a*b)/mcm(a,b);
         return mcd;
	}

	//somma due frazioni
	public Fraction sum(Fraction b){
		 int sDenominator = mcd(this.denominator, b.denominator);
		 int sNumerator = this.numerator * (sDenominator / this.denominator) + b.numerator * (sDenominator / b.denominator);
		 Fraction result = new Fraction(sNumerator, sDenominator);
		 return result;
	}

	//ritorna true se le due frazioni hanno lo stesso risultato
	public boolean equals(Fraction b){
		double val1 = this.getValue();
		double val2 = b.getValue();
		if(val1 == val2) return true;
		else return false;
	}

	//ritorna true se la frazione Ã¨ propria
	public boolean isProper(){
		if(this.numerator < this.denominator){
			return true;
		}else return false;
	}

	//ritorna true se la frazione a Ã¨ piÃ¹ grande
	public boolean isGreaterThan(Fraction b){
		if(this.getValue() > b.getValue()){
			return true;
		}
		return false;
	}

	//riduce la frazione
	public Fraction reduce(){
		double rNumerator = this.numerator / mcm(this.numerator, this.denominator);
		double rDenominator = this.denominator / mcm(this.numerator, this.denominator);	
		Fraction result = new Fraction((int)rNumerator, (int)rDenominator);	
		return result;
	}

	//converte la frazione in stringa
	public String toString(){
		String l = Integer.toString(this.numerator);
		String m = Integer.toString(this.denominator);
		String f = l + "/"  + m;
		return f;
	}

	public static void main(String[] args){

				Fraction b = new Fraction(10, 5);
				Fraction a = new Fraction(10, 0);
				System.out.println("");
				System.out.println("ATTENZIONE: Se è presente uno 0 al denominatore, diventera' direttamente un 1!");
				System.out.println("");
				System.out.println("Risultato: " + a.getValue());
				System.out.println("Sono uguali? "+ a.equals(b));
				System.out.println("È propria: "+ a.isProper());
				System.out.println("Frazione: "+ a.toString());
				System.out.println("La frazione a é piu grande della b: "+ a.isGreaterThan(b));
				System.out.println("Somma frazioni: "+ a.sum(b));
				System.out.println("Frazione A ridotta: "+ a.reduce());

	}

}