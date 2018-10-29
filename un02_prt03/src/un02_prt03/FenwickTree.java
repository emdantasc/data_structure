package un02_prt03;

class FenwickTree {
	int value, leftSize;
	FenwickTree  left, right;

	
	public FenwickTree(int _value){
		this.value=_value;
		this.left=null;
		this.right=null;
	}
	
	public FenwickTree(int _leftSize, FenwickTree _left, FenwickTree _right){
		this.leftSize=_leftSize;
		this.left=_left;
		this.right=_right;
		this.value+=_left.value+_right.value;
	}
	
	public String toString() {
		String buffer="";
		
		buffer+="["+String.valueOf(this.value)+", "+String.valueOf(this.leftSize);
		
		if(this.left!=null) {
			buffer+=", "+this.left.toString();
		}
		
		if(this.right!=null) {
			buffer+=", "+this.right.toString();
		}
		
		buffer+="]";
		
		return buffer;
	}
	
	public static FenwickTree allZeros(int n){
		if (n==0) { return null;}
		if (n==1) {return new FenwickTree(0);}
		int m = n/2;
		return new FenwickTree(n-m, allZeros(n-m), allZeros(m));
	}
	
	public int size() {
		
	}
	
	public static void main(String[] args){
		System.out.println("Construcao de allZeros(3) : " + FenwickTree.allZeros(3));
		System.out.println("Construcao de allZeros(4) : " + FenwickTree.allZeros(4));
		System.out.println("Construcao de allZeros(5) : " + FenwickTree.allZeros(5));
		System.out.println("Construcao de allZeros(6) : " + FenwickTree.allZeros(6));
	}
}
