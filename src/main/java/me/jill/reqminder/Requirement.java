package me.jill.reqminder;
import java.util.*;
import java.time.Duration;
import java.time.LocalDate;

public class Requirement extends Task {
    private String requirementType;
    private double score;
    private double maxScore;

    public Requirement(String name, Subject subject, LocalDate deadline, int priority, Duration duration, String requirementType, double score, double maxScore) {
        super(name, subject, deadline, priority, duration);
        this.requirementType = requirementType;
        this.score = score;
        this.maxScore = maxScore;
    }

    public void setGrade(double score, double maxScore) {
        if (score <= maxScore && score >= 0) {
            this.score = score;
            this.maxScore = maxScore;
            System.out.println("Grade is set.");
        } else {
            // InvalidScoreException
        }
    }

    public String getRequirementType() {
        return requirementType;
    }


    public double getScore() {
        return score;
    }

    public double getMaxScore() {
        return maxScore;
    }

}
