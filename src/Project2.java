//Name: Shameer Khan
//CS-313
//Project 2.

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binaryTree t2= new binaryTree();
		binaryTree t3 = new binaryTree(50);
		Random rand= new Random();
		int generator;
		for(int i=0;i<5;i++){
			generator=rand.nextInt(10)+1;
			t2=binaryTree.insert(t2, new Integer(generator));
			t3=binaryTree.insert(t3, new Integer(generator));
		}
		if(t2.compBT(t2.getRoot(),t3.getRoot())==true){
			System.out.println("Identical!");
		}
		else
			System.out.println("Not identical!");
		binaryTree t= new binaryTree();
		
		if(binaryTree.compBTT(t2, t3)==true){
			System.out.println("Identical!");
		}
		else
			System.out.println("Not identical!");
		try{
			BufferedReader br= new BufferedReader(new FileReader (args[0]));
			String line=br.readLine();//reading line
			while(line!=null){//as long as we  don't hit null pointer on file
				if(!line.isEmpty()){
					String[] reference= line.split(" ");
					for (String ele:reference)
					t=binaryTree.insert(t, new Integer(ele));//creating search tree
					System.out.println("Given sequence is: "+ line);
					System.out.println("Threads in the given sequence: ");
					binaryTree.rightThread(t.getRoot(),null);//creating threads
					System.out.println("Nonrecursive Inorder prinout of the sequence: ");
					binaryTree.nonRecursiveInorder(t);//printing out threaded tree nonrecursive inorder
					System.out.println();
					t.makeEmpty();//clearing out the current tree to make room for the next one
				}
				System.out.println();
				line=br.readLine();//get nextline
			}
			br.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

	}


