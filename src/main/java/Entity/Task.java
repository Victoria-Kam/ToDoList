package Entity;

import java.util.Objects;

public class Task {

    private int idTask;
    private int idTaskType;
    private String title;
    private String content;
    private int idTaskStatus;

    public Task(int idTask, int idTaskStyle, String title, String content, int idTaskStatus) {
        this.idTask = idTask;
        this.idTaskType = idTaskStyle;
        this.title = title;
        this.content = content;
        this.idTaskStatus = idTaskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idTask == task.idTask && idTaskType == task.idTaskType && idTaskStatus == task.idTaskStatus && Objects.equals(title, task.title) && Objects.equals(content, task.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTask, idTaskType, title, content, idTaskStatus);
    }

    public int getIdTask() {
        return idTask;
    }

    public int getIdTaskStyle() {
        return idTaskType;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getIdTaskStatus() {
        return idTaskStatus;
    }

    @Override
    public String toString() {
        return  "ID задания: " + idTask +
                "\nID типа задания: " + idTaskType +
                "\nЗаголовок: " + title +
                "\nЗадание: " + content +
                "\nID статус задания: " + idTaskStatus + "\n";
    }
}
