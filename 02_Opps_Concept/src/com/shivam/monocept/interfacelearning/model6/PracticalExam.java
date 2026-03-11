package com.shivam.monocept.interfacelearning.model6;



public class PracticalExam implements ExamEvaluator {

    private int marks;
    private String result;

    public PracticalExam(int marks) {
        this.marks = marks;
    }

    @Override
    public void evaluateMarks() {
        System.out.println("Practical Exam Marks: " + marks);
    }

    @Override
    public void calculateGrade() {
    	 result = "Fail";
        if (marks >= 40 )
            result = "Distinction";
         if (marks >= 25  && marks<40)
            result = "Pass";
        
           

        System.out.println("Result: " + result);
    }
}