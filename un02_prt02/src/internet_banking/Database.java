package internet_banking;

import java.util.ArrayList;
import java.util.Iterator;

class Database {
	public static final ArrayList<Letra> caracteres;
	static {
		caracteres=new ArrayList<Letra>();
		for(char i=48; i<=57; i++) {
			caracteres.add(new Letra(String.valueOf(i)));
		}
		for(char i=65; i<=90; i++) {
			caracteres.add(new Letra(String.valueOf(i)));
		}
		for(char i=97; i<=122; i++) {
			caracteres.add(new Letra(String.valueOf(i)));
		}
		caracteres.add(new Letra(String.valueOf((char)32)));
		caracteres.add(new Letra(String.valueOf((char)44)));
		caracteres.add(new Letra(String.valueOf((char)46)));
	}
	
	public static Letra getLetra(String md5) {
		Iterator<Letra> it=caracteres.iterator();
		Letra aux;
		while(it.hasNext()) {
			aux=it.next();
			if(aux.getMd5Code().equals(md5)) {
				return aux;
			}
		}
		return null;
	}
	
	public static Conta getConta(String[] message) {
		String decode="", Nome="", Saldo="";
		String[] words;
		
		for(int i=0; i<message.length; i++) {
			decode+=Database.getLetra(message[i]).getCaractere();
		}
		
		words=decode.split(" ");
		
		for(int i=0; i<words.length-1; i++) {Nome=Nome+words[i]+" ";}
		Saldo=words[words.length-1];
		
		return new Conta(Nome, Saldo);
	}
	
	public static void test6(){
		Letra l = new Letra("a");
		String md5 = l.getMd5Code();
		System.out.println(md5);
		Letra ll = Database.getLetra(md5);
		System.out.println(ll.getCaractere());
	}
	
	public static void test5(){
		Conta c = new Conta("124", "333", "1234","10,50", "john doe da silva");
		ServerDatabase.insereConta(c);
		String chave = SecurityProvider.md5ToServer(c);
		Conta conta = ServerDatabase.getConta(chave);
		String chars[];
		chars = SecurityProvider.md5ToClient(conta);
		System.out.println(Database.getConta(chars));
	}
	
	public static void main(String[] args) {test5();}
}
