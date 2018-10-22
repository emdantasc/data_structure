package internet_banking;

import java.math.BigInteger;
import java.util.ArrayList;

public class ServerDatabase{
	private static ArrayList<ArrayList<Conta>> contas;
	private static int N = 100;
	
	static{
		contas = new ArrayList<ArrayList<Conta>>();
		for(int i=0;i<N;i++){
			contas.add(new ArrayList<Conta>());
		}
	}
	
	public static void add()
	
	public static int hashCode(String md5){
		BigInteger bi = new BigInteger(md5, 16);
		BigInteger m = new BigInteger(Integer.toString(N), 10);
		int pos;
		pos = bi.mod(m).intValue();
		return pos;
	}
	
	
}
