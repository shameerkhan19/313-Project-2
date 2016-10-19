
public class binaryTree {

	
private binaryTreeNode root;
	
	public binaryTree(){
		root=null;
	}
	
	public binaryTree(Object x){
		root=new binaryTreeNode(x);
	}
	
	public binaryTree (Object x, binaryTreeNode lt, binaryTreeNode rt){
		root= new binaryTreeNode(x,lt,rt);
	}
	
	public boolean isEmpty(){
		if(root==null)return true;
		return false;
	}
	
	public void makeEmpty(){
		root=null;
	}
	public int nodeCount(){
		return binaryTreeNode.nodeCount(root);
	}
	
	public int getHeight(){
		return binaryTreeNode.height(root);
	}

	public Object getRootObject()throws treeException{
		if(root==null)throw new treeException("Empty Tree!");
		else
		return root.element;
	}
	
	public binaryTreeNode getRoot(){
		return root;
	}
	
	public void setRoot(Object x)throws treeException{
		if(root==null)throw new treeException("Empty tree!");
		else
		root.element=x;
	}
	
	public binaryTree getLeft()throws treeException{
		if(root==null)throw new treeException("Empty tree!");
		else{
		binaryTree t= new binaryTree();
		t.root= root.left;
		return t;
		}
	}
	
	public void setLeft(binaryTree t)throws treeException{
		if(root==null)throw new treeException("Empty tree!");
		else
		root.left=t.root;
	}
	
	public binaryTree getRight()throws treeException{
		if(root==null)throw new treeException("Empty tree!");
		else{
		binaryTree t= new binaryTree();
		t.root=root.right;
		return t;
	}
}
	
	public void setRight(binaryTree t)throws treeException{
		if(root==null)throw new treeException("Empty tree!");
		root.right=t.root;
	}
	
	
	public static binaryTree insert(binaryTree t, Object x) throws treeException{
		if(t.isEmpty())
			return new binaryTree(x);
		else if(((Integer)t.getRootObject()).intValue()<((Integer)x).intValue()){
			t.setRight(insert(t.getRight(),x));
		}
		else
			t.setLeft(insert(t.getLeft(),x));
		return t;
		}
	/*for the right threading i just followed the algorithm and logic explained
	 * in class and the project2 hand out. So basically passing in the root and 
	 * null first. why Null? because previous of Root doesn't exist meaning there
	 * is no Node there.  Then we check if a left Node exist on root. if so then 
	 * call that recursively. Then my function will look like this (left Node, root).
	 * Follow this logic until we hit current.left=null; meaning no more left Node left.
	 * then we check right. If it exits our Function will look like this:
	 * (right node, but same previous as last recursive call). Finally if 
	 * rightPointer of the given Node is null then thread it to its previous.
	 * and set the flag value into true. That way we successfully Trace a threaded
	 * link when using non-recursive inroder traveling of the tree.Also keeping the 
	 * function void. Since I have access to root pointer in the function I have
	 * access to the entire tree. I am just checking it and creating threads by
	 * closing up the null right pointers. No need to return anything.
	 */
	
	public static void rightThread(binaryTreeNode N, binaryTreeNode P){
		if(N.left!=null)//checking if left pointer is empty or no.
		rightThread(N.left,N);//if not call recursively
		if(N.right!=null)//checking if right pointer is empty
			rightThread(N.right,P);//if not call recursively but keep previous pointer same as last call
		else{//if right pointer is empty we create the  thread here.
			N.right=P;//establishing the thread with previous Node.
			N.flag=true;//flagging the node now as a threaded node.
			if(N.right!=null)
				System.out.println(N.element+"-->"+P.element);
		}
	}
	public static void nonRecursiveInorder(binaryTree t){
		binaryTreeNode current=t.root;
		
		while(current.left!=null)//this brings me to the leftmost node of the tree
			current=current.left;
		while(current!=null){//now we check for threaded links
			System.out.print(current.element+" ");
			
		if(current.flag==true){//checking if my current Node right pointer is threaded;
			current=current.right;//ride the thread to go back to previous node;
		}
		
		else{//if current.flag is false. meaning it's not threaded. Right pointer points to a Node
			current=current.right;//get the right node;
			while(current.left!=null)//find the leftmost of the that right node.
				current=current.left;
			}
		}
		
		}
	public boolean compBT(binaryTreeNode n1, binaryTreeNode n2){
		if(n1==null  && n2==null) return true;
		else if((n1.left!=null && n2.left==null)|| (n1.left==null && n2.left!=null))return false;
		else if((n1.right!=null && n2.right==null)|| (n1.right==null && n2.right!=null))return false;
		else return compBT(n1.left,n2.left) && compBT(n1.right, n2.right);
	}
	
	public static boolean compBTT(binaryTree t1, binaryTree t2){
		if(t1.root==null  && t2.root==null) return true;
		else if((t1.root.left!=null && t2.root.left==null)|| (t1.root.left==null && t2.root.left!=null))return false;
		else if((t1.root.right!=null && t2.root.right==null)|| (t1.root.right==null && t2.root.right!=null))return false;
		else return compBTT(t1.getLeft(),t2.getLeft()) && compBTT(t1.getRight(), t2.getRight());
	}
	
}
