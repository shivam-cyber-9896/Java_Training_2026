package com.shivam.monocept.isp.model1;

public class TeacherService implements ExamGrader, QuestionBankManager {

    public void gradeExam() {
        System.out.println("Teacher grading exam");
    }

    public void createQuestionBank() {
        System.out.println("Teacher creating question bank");
    }
}
