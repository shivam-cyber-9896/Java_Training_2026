package com.shivam.monocept.interfacelearning.model6;


public class TheoryExam implements ExamEvaluator {

    private int marks;
    private String grade;

    public TheoryExam(int marks) {
        this.marks = marks;
    }

    @Override
    public void evaluateMarks() {
        System.out.println("Theory Exam Marks: " + marks);
    }

    @Override
    public void calculateGrade() {
        grade = "Fail";

        if (marks >= 90)
            grade = "A+";
         if (marks >= 75 && marks<90)
            grade = "A";
         if (marks >= 60 && marks<75)
            grade = "B";
         if (marks >= 50 && marks<60)
            grade = "C";
       
       
        System.out.println("Grade: " + grade);
    }
}
