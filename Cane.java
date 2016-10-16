/***                                                                                        
 *                                                                                          
 *    NNNNNNNN        NNNNNNNN                    iiii  kkkkkkkk                            
 *    N:::::::N       N::::::N                   i::::i k::::::k                            
 *    N::::::::N      N::::::N                    iiii  k::::::k                            
 *    N:::::::::N     N::::::N                          k::::::k                            
 *    N::::::::::N    N::::::N  aaaaaaaaaaaaa   iiiiiii  k:::::k   kkkkkkk eeeeeeeeeeeeee   
 *    N:::::::N::::N  N::::::N  aaaaaaaaa:::::a  i::::i  k:::::k  k:::::ke::::::eeeee:::::ee
 *    N::::::N N::::N N::::::N           a::::a  i::::i  k:::::k k:::::ke::::::e     e:::::e
 *    N::::::N  N::::N:::::::N   aaaaaaaa:::::a  i::::i  k::::::k:::::k e:::::::eeeee::::::e
 *    N::::::N    N::::::::::N a::::aaaa::::::a  i::::i  k:::::::::::k  e::::::eeeeeeeeeee  
 *    N::::::N     N:::::::::Na::::a    a:::::a  i::::i  k::::::k:::::k e:::::::e           
 *    N::::::N      N::::::::Na::::a    a:::::a i::::::ik::::::k k:::::ke::::::::e          
 *    N::::::N       N:::::::Na:::::aaaa::::::a i::::::ik::::::k  k:::::ke::::::::eeeeeeee  
 *    NNNNNNNN         NNNNNNN  aaaaaaaaaa  aaaaiiiiiiiikkkkkkkk    kkkkkkk eeeeeeeeeeeeee  
 *                                                                                          
 *	  © Romeo Naike 2016 - 2019 (10/09/2016) | Version 1.03c
 *	  
 *    This work is distributed under Creative Commons License Attribution - International Trade 4.0.  
 *    For more infomation visit: http://creativecommons.org/licenses/by-nc/4.0/                                                                                   
 */

import java.awt.Color;

public class Cane{

	private String razza = "Bastardino";
	private int peso = 1;
	private Color colorePelo = Color.WHITE;
	private int peli = 1000;

	//Set e Get Razza
	public void setRazza(String razza){
		this.razza = razza;
	}
	public String getRazza(){
		return razza;
	}

	//Set e Get Peso
	public void setPeso(int peso){
		this.peso = peso;
	}
	public int getPeso(){
		return peso;
	}

	//Set e Get Colore pelo
	public void setColorePelo(Color colorePelo){
		this.colorePelo = colorePelo;
	}
	public Color getColorePelo(){
		return colorePelo;
	}

	//Set e Get Peli
	public void setPeli(int peli){
		this.peli = peli;
	}
	public int getPeli(){
		return peli;
	}

	//metodo costruttore
	public Cane(String razza, int peso, Color colorePelo){
		this.razza = razza;
		this.peso = peso;
		this.colorePelo = colorePelo;
		this.peli = peli;
	}

	//metodo costruttore
	public Cane(String razza, Color colorePelo){
		this.razza = razza;
		this.colorePelo = colorePelo;
	}

	//metodo costruttore
	public Cane(String razza, int peso){
		this.razza = razza;
		this.peso = peso;
	}

	//metodo costruttore
	public Cane(int peso, Color colorePelo){
		this.peso = peso;
		this.colorePelo = colorePelo;
	}
	
	//metodo
	public void abbaia(){
		System.out.println("BAU!!");
	}

	//metodo modificatore, quando viene invocato
	//modifica lo stato (peso) dell'oggetto
	public void mangia(int numeroOssa){
		for(int i = 0; i < numeroOssa; i++){
			System.out.println("SLURP");
			this.peso++;
		}
	}

	//metodo modificatore, quando viene invocato
	//modifica lo stato (peli) dell'oggetto
	public void peliTotali(int peso){
		this.peli += this.peso*500;
		System.out.println("Peli totali: " + peli);
	}
  
  //metodo clone
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args){
		//istanza fido
		Cane fido = new Cane("Barboncino", 4, Color.BLACK);
		//istanza lessie
		Cane lessie = new Cane("Maltese", 3, Color.WHITE);
		Cane mina = new Cane("Bassotto", Color.RED);
		Cane luna = new Cane("Barboncino", 7);
		Cane spike = new Cane(4, Color.GREEN);
		Cane nema = (Cane)spike.clone();
		fido.abbaia();
		fido.mangia(2);
		fido.peliTotali(4);
		lessie.peliTotali(3);
		nema.peliTotali(2);
		nema.mangia(3);
		nema.abbaia();

	}
}

Errori quando si esegue il codice:

macx9-1:desktop naike$ java Cane
java.lang.CloneNotSupportedException: Cane
	at java.lang.Object.clone(Native Method)
	at Cane.clone(Cane.java:113)
	at Cane.main(Cane.java:128)
BAU!!
SLURP
SLURP
Peli totali: 4000
Peli totali: 2500
Exception in thread "main" java.lang.NullPointerException
	at Cane.main(Cane.java:133)
