package internet_banking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class ServerDatabase{
	private static ArrayList<ArrayList<Conta>> contas;
	private static int N = 100;
	
	static{
		contas = new ArrayList<ArrayList<Conta>>();
		for(int i=0;i<N;i++){
			contas.add(new ArrayList<Conta>());
		}
	}
	
	public static void insereConta(Conta conta) {
		contas.get(hashCode(conta.get_md5())).add(conta);	
	}
	
	public static Conta getConta(String md5) {
		ArrayList<Conta> aux=contas.get(hashCode(md5));
		Iterator<Conta> it=aux.iterator();
		
		while(it.hasNext()) {
			Conta aux_conta=it.next();
			if(aux_conta.get_md5().equals(md5)) {return aux_conta;}
		}
		
		return null;
	}
	
	public static int hashCode(String md5){
		BigInteger bi = new BigInteger(md5, 16);
		BigInteger m = new BigInteger(Integer.toString(N), 10);
		int pos;
		pos = bi.mod(m).intValue();
		return pos;
	}
	
	public static void test3(){
		Conta c = new Conta("1234", "2222","1245");
		ServerDatabase.insereConta(c);
		String chave = SecurityProvider.md5ToServer(c);
		System.out.println(chave);
		Conta conta = ServerDatabase.getConta(chave);
		System.out.println(conta);
	}
	
	
	public static void main(String[] args) {
		test3();
	}
}
