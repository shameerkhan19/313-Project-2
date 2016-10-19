
public class binaryTreeNode {

	Object element;
	binaryTreeNode left, right;
	boolean flag;

	public binaryTreeNode(){
		element=null;
		left=null;
		right=null;
		flag=false;
	}
	
	public binaryTreeNode(Object e){
		element=e;
		left=null;
		right=null;
		flag=false;
	}
	
	public binaryTreeNode(Object e, binaryTreeNode ln, binaryTreeNode rn){
		element=e;
		left=ln;
		right=rn;
		flag=false;
	}
	
	public static int nodeCount(binaryTreeNode n){
		if(n==null)return 0;
		else return 1+nodeCount( n.left)+nodeCount( n.right);
	}
	
	public static int height(binaryTreeNode n){
		if(n==null)return -1;
		else return Math.max(height(n.left), height(n.right));
	}

}
