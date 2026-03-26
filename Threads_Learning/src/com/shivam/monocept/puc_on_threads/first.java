package com.shivam.monocept.puc_on_threads;

public class first extends Thread {
	public void run() {
		for(int i=0;i<=38;i++)
			{System.out.println(""+i);}
	}
public static void main(String[] argus)
{ first t1 = new first(); 
first t2 = new first();
t2.start(); 
 t1.start();}
}
