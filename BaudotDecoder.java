/***                                                                                        
 *                                                                                          
 *    NNNNNNNN        NNNNNNNN                    iiii  kkkkkkkk                            
 *    N:::::::N       N::::::N                   i::::i k::::::k                            
 *    N::::::::N      N::::::N                    iiii  k::::::k                            
 *    N:::::::::N     N::::::N                          k::::::k                            
 *    N::::::::::N    N::::::N  aaaaaaaaaaaaa   iiiiiii  k:::::k    kkkkkkk eeeeeeeeeeee    
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

public class BaudotDecoder{
	
	//Attributi
	public boolean shift;
	public int indiceArray = 0;
	public byte nBaudot = 0;

	/**
	 * BaudotDecoder Costructor 
	 * @description Metodo costruttore
	 * @since 1.0
	 *
	 * @param  boolean shift
	 * @param  byte nBaudot
	 * 
	 * @return 
	 */
	private BaudotDecoder(boolean shift, byte nBaudot){
		this.shift = shift;
		this.nBaudot = nBaudot;
	}
	 /*
	public boolean setShift(boolean shift){
		this.shift = shift;
	}
	*/
	public boolean isShift(){
		if(shift == true){return true;}
		else return false;
	}

	/**
	 * Converti: char
	 * @description Converte il codeci baudot in codice Ascii
	 * @since 1.01
	 *
	 * @param
	 * @return return
	 *			ascii[indiceArray].charAt(0);
	 *			asciiShift[indiceArray].charAt(0)
	 */

	public char convert(){
		//Array in codice Baudot, Ascii e AsciiShift -- int[] baudot = {Ob00011};
		byte[] baudot = {(byte)00011, (byte)11001, (byte)01110, (byte)01001, (byte)00001, (byte)01101, (byte)11010, (byte)10100, (byte)00110, (byte)01011, (byte)01111, (byte)10010, (byte)11100, (byte)01100, (byte)11000, (byte)10110, (byte)10111, (byte)01010, (byte)00101, (byte)10000, (byte)00111, (byte)11110, (byte)10011, (byte)11101, (byte)10101, (byte)10001};
		String[] ascii = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		String[] asciiShift = {"-","?",":","","3","!","&","£","8","","(",")",".",",","9","0","1","4","'","5","7",";","2","/","6","+"};
		
		//Guardo se c'é un elemento uguale a quello inserito dall'utente in codice baudot
		for(int i = 0; i < baudot.length; i++){
			if(baudot[i] == (int)nBaudot){indiceArray = i;}
		}

		//Decido se convertirlo in codice Ascii oppure AsciiShift
		if(shift == false){
			return ascii[indiceArray].charAt(0);
		}else return asciiShift[indiceArray].charAt(0);
	}

	public static void main(String[] args){
		
		BaudotDecoder a = new BaudotDecoder(false, (byte)00011);
		System.out.println(a.convert());
		BaudotDecoder b = new BaudotDecoder(true, (byte)11001);
		System.out.println(b.convert());

		//String[] ascii = {"0", "E", "\n", "A", " ", "S", "I", "U", " ", "D", "R", "J", "N", "F", "C", "K", "T", "Z", "L", "W", "H", "Y", "P", "Q", "O", "B", " ", "M", "X", "V", " "};
		//String[] asciiShift = {"0","3"," ","-"," ","\u0027","8","7"," "," ","4","\\a",",","!",":","(","5","+",")","2","£","6","0","1","9","?","&"," ",".","/",";"," "};
		//byte[] baudot = {(byte)00000, (byte)00001, (byte)00010, (byte)00011, (byte)00100, (byte)00101, (byte)00111, (byte)01000, (byte)01001, (byte)01010, (byte)01011, (byte)01100, (byte)01101, (byte)01110, (byte)01111, (byte)10000, (byte)10001, (byte)10010, (byte)10011, (byte)10100, (byte)10101, (byte)10110, (byte)10111, (byte)11000, (byte)11001, (byte)11010, (byte)11011, (byte)11100, (byte)11101, (byte)11110, (byte)11111};

	}
}