package com.shivam.monocept.interfacelearning.model6;


public class OnlineQuiz implements ExamEvaluator {

    private int correctAnswers;
    private int totalMarks;
    private String grade;

    public OnlineQuiz(int correctAnswers) {
        this.correctAnswers = correctAnswers;
        this.totalMarks = correctAnswers * 10;
    }

    @Override
    public void evaluateMarks() {
        System.out.println("Online Quiz Marks: " + totalMarks);
    }

    @Override
    public void calculateGrade() {
    	 grade = "Needs Improvement";
        if (totalMarks >= 80)
            grade = "Excellent";
         if (totalMarks >= 50 && totalMarks<80)
            grade = "Good";
        
           

        System.out.println("Grade: " + grade);
    }
}