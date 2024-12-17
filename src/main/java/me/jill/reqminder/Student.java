package me.jill.reqminder;

import java.util.ArrayList;


public class Student {
    private String name;
    private int gradeLevel;
    private ArrayList<Task> taskList;
    private double gwa;

    public Student(String name, int gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Task " + task.getName() + " added successfully!");
    }

    public void editTask(int index, Task updatedTask) {
        if (index >= 0 && index < taskList.size()) {
            taskList.set(index, updatedTask);
            System.out.println("Task updated successfully");
        } else {
            // IndexOutOfBoundsException
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("Task deleted successfully");
        } else {
            // IndexOutOfBoundsException
        }
    }

    public void viewTaskSummary() {
        System.out.println("Task List:");
        for (Task task : taskList) {
            System.out.println(task.getName());
        }
    }

    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).setStatus(true);
            System.out.println("Task marked as completed");
        } else {
            //IndexOutOfBoundsException
        }
    }

    public void addGrade(Subject subject, String requirementName, double score, double maxScore) {
        for (String requirementType : subject.getCategorizedRequirements().keySet()) {
            for (Requirement req : subject.getCategorizedRequirements().get(requirementType)) {
                if (req.getName().equals(requirementName)) {
                    req.setGrade(score, maxScore);
                    return;
                }
            }
        }
        // RequirementNotFoundException
        System.out.println("Requirement not found");
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

}
