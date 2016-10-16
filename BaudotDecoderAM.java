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

public class BaudotDecoderAM{
	
	public boolean shift;          //attributo
	public char FGRS = 0x1B;       //attributo
	public char LTRS = 0x1f;	   //attributo

	//metodo costruttore
	private BaudotDecoderAM(boolean shift){this.shift = shift;}

	//ritorno il valore di shift
	public boolean isShift(){return this.shift;}

	//metodo per modificare il valore di shift
	public void setShift(boolean shiftSet){shift = shiftSet;}

	//metodo per decodificare il valore inserito dall'utente a dipendenza dello shift
	public char convert(byte code){
		if(code == FGRS) setShift(true);
		else if(code == LTRS) setShift(false);
		final char[][] TABLE = {
		{'\u0000', '\u0000'},
		{'E', '3'},
		{'\n', '\n'},
		{'A', '-'},
		{' ', ' '},
		{'S', '\''},
		{'I', '8'},
		{'U', '7'},
		{'\r', '\r'},
		{'D'},
		{'R', '4'},
		{'J'},
		{'N', ','},
		{'F', '!'},
		{'C', ':'},
		{'K', '('},
		{'T', '5'},
		{'Z', '+'},
		{'L', ')'},
		{'W', '2'},
		{'H', '\u0003'},
		{'Y', '6'},
		{'P', '0'},
		{'Q', '1'},
		{'O', '9'},
		{'B', '?'},
		{'G', '&'},
		{},
		{'M', '.'},
		{'X', '/'},
		{'V', ';'},	
		};
		return TABLE[code][shift?1:0];
	}

	public static void main(String[] args){
		//decido se lo shift è attivo o no
		BaudotDecoderAM a = new BaudotDecoderAM(true);

		//stampo il risultato passandogli un valore in baudot
		System.out.println("Il risultato é: " + a.convert((byte)0b00001));
	}

}