package me.jill.reqminder;
import java.time.LocalDate;
import java.time.Duration;


public class Task {
    protected boolean status;
    protected String name;
    protected Subject subject;
    protected LocalDate deadline;
    protected int priority;
    protected Duration duration;

    public Task(String name, Subject subject, LocalDate deadline, int priority, Duration duration) {
        this.name = name;
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.duration = duration;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean getStatus() {
        return status;
    }
}
