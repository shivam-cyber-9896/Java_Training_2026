package com.shivam.monocept.exceptionhandling.puc;

public class MultipleCatchblock {
    public static void main(String[] args) {

        try {
        	int a=10;
            a=a/10;
            int arr[] = new int[15];
            arr[10] = 100;
            
           
        } 
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Error"+e);
            
        }
        catch (Exception e) {
            System.out.println("Arithmetic Error"+e);
        } 
        finally {
            System.out.println(" error occured so finally block executed");
        }
    }
}