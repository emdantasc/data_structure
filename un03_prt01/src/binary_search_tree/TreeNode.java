package binary_search_tree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author J-C. Filliatre and L. Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * An implementation of an ordered set based on binary search trees
 */
public class TreeNode<E extends Comparable<E>> {
	  final E value;
	  TreeNode<E> left, right;

	  public TreeNode(TreeNode<E> left, E value, TreeNode<E> right) {
		  this.value=value;
		  this.left=left;
		  this.right=right;
	  }

	  public TreeNode(E value) {
		  this.value=value;
		  this.left=null;
		  this.right=null;
	  }

	  public boolean contains(E x) {
		  if(this.value==x) {return true;}
		  else if(this.value.compareTo(x)<0 && this.right!=null) {return this.right.contains(x);}
		  else if(this.value.compareTo(x)>0 && this.left!=null) {return this.left.contains(x);}
		  else {return false;}
	  }

	  public TreeNode<E> add(E x) {
		 if(this.value.compareTo(x)==0) {return this;}
		 else if(this.value.compareTo(x)>0) {
			 if(this.left==null) {
				 this.left=new TreeNode<E>(x);
				 return this;
			 }
			 else {
				 this.left.add(x);
				 return this;
			 }
		 }
		 else {
			 if (this.right==null) {
				 this.right=new TreeNode<E>(x);
				 return this;
			 }
			 else {
				 this.right.add(x);
				 return this;
			 }
		 }
	  }

	  public E getMin() {
		if(this.left==null) {return this.value;}
		else {return this.left.getMin();}
	  }

	  static<E extends Comparable<E>> TreeNode<E> ofList(Queue<E> l, int n, int k) {
		throw new Error("A completer: exo 1");
	  }
	  
	  static<E extends Comparable<E>> TreeNode<E> ofList(Queue<E> l) {
	    int n = l.size();
	    return ofList(l, n, (int)(Math.log(n) / Math.log(2)));
	  }
	  
	   
	  /* subset */
	  static<E extends Comparable<E>> boolean subset(TreeNode<E> s1, TreeNode<E> s2) {
		throw new Error("A completer: exo 2");
	  }
	  
	  /* split(v,s) returns two trees, containing values
	   * from s smaller and greater than s
	   */
	  public Pair<TreeNode<E>> split(E x) {
		  TreeNode<E> A,B, it=this, prev=null;
		  
		 
	  }
		  
	  
	  /* union */
	  public TreeNode<E> union(TreeNode<E> s2) {
		
	  }

	  public String infixOrder() {
		  String result="";
		  if(this.left!=null) result=result+this.left.infixOrder();
	      result=result+" "+this.value;
	      if(this.right!=null) result=result+this.right.infixOrder();
	      return result;
	  }
	
		 /**
	   * Return the list of elements listed according to infix order
	   */
	  public LinkedList<E> toList() {
		  LinkedList<E> result=null;
		  if(this.left!=null) result=(this.left.toList());
		  if(result==null) result=new LinkedList<E>();
	      result.add(this.value);
	      if(this.right!=null) result.addAll(this.right.toList());
	      return result;
	  }

	  public String toString() {
		    return "(" + this.left + "+" + this.value + "+" + this.right + ")";
	  }

}
