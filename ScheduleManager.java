import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasksForDate(String date) {
        return tasks.stream()
                .filter(task -> task.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public void markTaskAsCompleted(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                task.setCompleted(true);
            }
        }
    }
}
