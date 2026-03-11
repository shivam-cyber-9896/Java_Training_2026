package com.shivam.monocept.string.model1;

public class FileNameVaildater {
	String FileName;
	
	public FileNameVaildater(String FileName){
		this.FileName=FileName;
	}
	public void vaildate() {
		boolean isPdf = FileName.endsWith(".pdf");

        int lastDot = FileName.lastIndexOf('.');

        String nameWithoutExtension = FileName.substring(0, lastDot);

 
        String extension = FileName.substring(lastDot + 1);

        String modifiedName = nameWithoutExtension.replace("_", " ");

        String upperCaseName = modifiedName.toUpperCase();

        boolean containsFinal = FileName.contains("final");

     
        System.out.println("Is PDF file: " +isPdf);
        System.out.println("File Name without extension: " + nameWithoutExtension);
        System.out.println("Extension: " + extension);
        System.out.println("Modified Name: " + modifiedName);
        System.out.println("Uppercase Name: " + upperCaseName);
        System.out.println("Contains 'final': " +containsFinal);
	}
}
