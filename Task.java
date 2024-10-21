public class Task {
    private String taskName;
    private String date;
    private String timeSlot;
    private boolean isCompleted;

    public Task(String taskName, String date, String timeSlot) {
        this.taskName = taskName;
        this.date = date;
        this.timeSlot = timeSlot;
        this.isCompleted = false;
    }

    // Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
