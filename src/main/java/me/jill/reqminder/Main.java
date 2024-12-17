package me.jill.reqminder;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Subject math = new Subject("Math", 40.0, 1);
        Student jill = new Student("Jill", 10);

        Requirement exam1 = new Requirement("Exam 1", math, LocalDate.of(2024, 10, 17), 1, Duration.ofHours(1), "Periodical", 99, 100);
        Requirement newDeadlineExam1 = new Requirement("Exam 1", math, LocalDate.of(2024, 12, 17), 1, Duration.ofHours(1), "Periodical", 99, 100);
        Requirement quiz1 = new Requirement("Quiz 1", math, LocalDate.now(), 3, Duration.ofMinutes(40), "Quiz", 4, 10);

        Requirement hw1 = new Requirement("Homework 1", math, LocalDate.now(), 3, Duration.ofMinutes(40), "Homework", 10, 10);
        
        // Scenario 1
        jill.addTask(exam1);

        // Scenario 2
        System.out.println("Deadline before editing: " + jill.getTaskList().get(0).getDeadline().toString());
        jill.editTask(0, newDeadlineExam1);
        System.out.println("Deadline after editing: " +jill.getTaskList().get(0).getDeadline().toString());

        // Scenario 3
        System.out.println("Status before being marked as complete: " + jill.getTaskList().get(0).getStatus());
        jill.markTaskAsComplete(0);
        System.out.println("Status after being marked as complete: " + jill.getTaskList().get(0).getStatus());

    }
}
