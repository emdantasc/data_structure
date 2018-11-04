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
		int l_size=0, r_size=0;
		
		if(this.left==null && this.right==null) {return 1;}
		else {
			l_size=this.left.size();
			r_size=this.right.size();
			return l_size+r_size;
		}
	}
		
	public void increment(int i, int delta) {
		if( this.left == null )
			this.value+=delta;
		else if ( this.leftSize >i ){
			this.value+=delta;
			this.left.increment(i,delta);
		}
		else{
			this.value+=delta;
			this.right.increment(i - this.leftSize,delta);
		}
	}
	
	public int prefixSum(int upto){
		if (left == null) {
			if(upto!=0){
				return this.value;
			}
			else {
				return 0;
			}
		}
		else if(this.leftSize<=upto){
				return this.left.value + this.right.prefixSum(upto-this.leftSize);
		}
		else{
				return this.left.prefixSum(upto);
		}
	}
	
	public int between(int lo, int hi){
			return this.prefixSum(hi)-this.prefixSum(lo);

	}
	
	public static void main(String[] args){
		FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
				new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
				new FenwickTree(1, new FenwickTree(3),
				new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
				System.out.println("Arvore this : " + T);
				System.out.println("Soma das folhas entre lo e hi : ");
				System.out.print(" ");
				for(int lo = 0; lo <= 6; lo++)
				System.out.print("lo = " + lo + " ");
				System.out.println();
				for(int hi = 0; hi <= 6; hi++){
				System.out.print("hi = " + hi + " ");
				for(int lo = 0; lo <= hi; lo++){
				System.out.print(T.between(lo, hi) + " ");
				if(T.between(lo, hi) < 10) System.out.print(" ");
				}
				System.out.println();
				}
	}
}
