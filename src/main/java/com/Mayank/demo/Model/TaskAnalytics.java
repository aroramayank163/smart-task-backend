package com.Mayank.demo.Model;

public class TaskAnalytics {
    private long numberOfTasks;
    private long countOfTaskCompleted;
    private long countOfHighPriorityTasks;

    public TaskAnalytics(long numberOfTasks, long countOfTaskCompleted, long countOfHighPriorityTasks) {
        this.numberOfTasks = numberOfTasks;
        this.countOfTaskCompleted = countOfTaskCompleted;
        this.countOfHighPriorityTasks = countOfHighPriorityTasks;
    }

    public long getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(long numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public long getCountOfTaskCompleted() {
        return countOfTaskCompleted;
    }

    public void setCountOfTaskCompleted(long countOfTaskCompleted) {
        this.countOfTaskCompleted = countOfTaskCompleted;
    }

    public long getCountOfHighPriorityTasks() {
        return countOfHighPriorityTasks;
    }

    public void setCountOfHighPriorityTasks(long countOfHighPriorityTasks) {
        this.countOfHighPriorityTasks = countOfHighPriorityTasks;
    }
}
