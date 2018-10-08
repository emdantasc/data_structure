package internet_banking;

class Conta {
	private String nomeCliente;
	private String saldo;
	private String agencia;
	private String numero;
	private String senha;
	private String md5;
	
	public Conta(String _agencia, String _numero, String _senha) {
		this.agencia=_agencia;
		this.numero=_numero;
		this.senha=_senha;
		this.md5=SecurityProvider.md5ToServer(this);
	}
	
	public Conta(String _agencia, String _numero, String _senha, String _saldo, String _nomeCliente) {
		this.agencia=_agencia;
		this.numero=_numero;
		this.senha=_senha;
		this.saldo=_saldo;
		this.nomeCliente=_nomeCliente;
		this.md5=SecurityProvider.md5ToServer(this);
	}
	
	public Conta(String _nomeCliente, String _saldo) {
		this.nomeCliente=_nomeCliente;
		this.saldo=_saldo;
		this.md5=SecurityProvider.md5ToServer(this);
	}
	
	String get_nomeCliente() {
		if(this.nomeCliente!=null) {return this.nomeCliente;}
		else {return null;}
	}
	String get_saldo() {
		if(this.saldo!=null) {return this.saldo;}
		else {return null;}
	}
	String get_agencia() {
		if(this.agencia!=null) {return this.agencia;}
		else {return null;}
	}
	String get_numero() {
		if(this.numero!=null) {return this.numero;}
		else {return null;}
	}
	String get_senha() {
		if(this.senha!=null) {return this.senha;}
		else {return null;}
	}
	String get_md5() {return this.md5;}
	
	void set_nomeCliente(String _nomeCliente) {this.nomeCliente=_nomeCliente;}
	void set_saldo(String _saldo) {this.saldo=_saldo;}
	void set_agencia(String _agencia) {this.agencia=_agencia;}
	void set_numero(String _numero) {this.numero=_numero;}
	void set_senha(String _senha) {this.senha=_senha;}
	
	@Override
	public String toString() {
		String output="Agencia: "+this.agencia+"\nConta: "+this.numero+"\nSenha: "+this.senha+"\nNome do Cliente: "+this.nomeCliente+"\nSaldo: "+this.saldo+"\nMD5: "+this.md5+"\n";
		return output;
	}
	
	public static void test() {
		Conta c1 = new Conta("124", "333", "1234", "10", "john doe");
		System.out.println(c1);
		Conta c2 = new Conta("John Doe", "10");
		System.out.println(c2);
		Conta c3 = new Conta("123", "321", "666");
		System.out.println(c3);
	}
	
	public static void main(String[] args) {test();}
}
