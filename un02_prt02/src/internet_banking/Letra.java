package internet_banking;

class Letra {
	String caractere;
	String md5Code;
	
	public Letra(String _caractere){
		this.caractere=_caractere;
		this.md5Code=SecurityProvider.md5(_caractere);
	}
	
	public void setCaractere(String _caractere) {
		this.caractere=_caractere;
		this.md5Code=SecurityProvider.md5(_caractere);
	}
	
	public String getCaractere() {return this.caractere;}
	public String getMd5Code() {return this.md5Code;}
}

