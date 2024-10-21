import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class Main extends Application {

    ScheduleManager scheduleManager = new ScheduleManager();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Daily Planner");

        VBox vbox = new VBox();
        DatePicker datePicker = new DatePicker();
        ListView<String> taskListView = new ListView<>();
        Button addButton = new Button("Add Task");

        addButton.setOnAction(event -> {
            // Add Task Dialog
            Task newTask = new Task("Sample Task", LocalDate.now().toString(), "09:00-10:00");
            scheduleManager.addTask(newTask);
            updateTaskList(taskListView, LocalDate.now().toString());
        });

        datePicker.setOnAction(event -> {
            String selectedDate = datePicker.getValue().toString();
            updateTaskList(taskListView, selectedDate);
        });

        vbox.getChildren().addAll(datePicker, taskListView, addButton);
        primaryStage.setScene(new Scene(vbox, 300, 200));
        primaryStage.show();
    }

    private void updateTaskList(ListView<String> taskListView, String date) {
        taskListView.getItems().clear();
        List<Task> tasks = scheduleManager.getTasksForDate(date);
        for (Task task : tasks) {
            String taskDisplay = task.getTaskName() + " - " + task.getTimeSlot() +
                                 (task.isCompleted() ? " (Completed)" : " (Not Completed)");
            taskListView.getItems().add(taskDisplay);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
