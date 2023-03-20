package org.example.operations;
import org.example.model.TaskManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerOperationsTest {


    @Test
    void addTask() {
        TaskManager addTask=new TaskManager(10,"Nanthakumar","Java Junit testcase1",null);
        TaskManagerOperations.addTask(addTask);
        assertTrue(TaskManagerOperations.containsTask(addTask.getId()));
    }

    @Test
    void updateTask() {
        TaskManager updateTask=new TaskManager(1,"Nanthakumar","Java Junit testcase2",null);
        TaskManagerOperations.updateTask(updateTask, updateTask.getId());
        assertEquals("Java Junit testcase2",updateTask.getDescription());
    }

    @Test
    void deleteTask() {
        int taskId=1;
        TaskManagerOperations.deleteTask(taskId);
        assertFalse(TaskManagerOperations.containsTask(taskId));
    }

    @Test
    void getAllTasks() {
        TaskManager getTask1=new TaskManager(1,"Nanthakumar","Java Junit testcase1",null);
        TaskManager getTask2=new TaskManager(2,"Nanthakumar","Java Junit testcase2",null);
        TaskManager getTask3=new TaskManager(3,"Nanthakumar","Java Junit testcase3",null);
        TaskManager getTask4=new TaskManager(4,"Nanthakumar","Java Junit testcase4",null);
        TaskManagerOperations.addTask(getTask1);
        TaskManagerOperations.addTask(getTask2);
        TaskManagerOperations.addTask(getTask3);
        TaskManagerOperations.addTask(getTask4);
        List<TaskManager> tasks=new ArrayList<>();
        tasks.add(getTask1);
        tasks.add(getTask2);
        tasks.add(getTask3);
        tasks.add(getTask4);

        List<TaskManager> actualTasks=TaskManagerOperations.getAllTasks();
        assertEquals(tasks.size(),actualTasks.size());
        assertEquals(tasks.get(0).getId(),actualTasks.get(0).getId());
        assertEquals(tasks.get(1).getId(),actualTasks.get(1).getId());
        assertEquals(tasks.get(2).getId(),actualTasks.get(2).getId());
        assertEquals(tasks.get(3).getId(),actualTasks.get(3).getId());
        }

    @Test
    void getTask() {
        TaskManager getTask=new TaskManager(1,"Nanthakumar","Java Junit testcase2",null);
        TaskManagerOperations.addTask(getTask);
        assertEquals(getTask.getId(),TaskManagerOperations.getTask(1).getId());
    }
}