package org.example.resource;

import com.google.gson.Gson;
import org.example.model.TaskManager;
import org.example.operations.TaskManagerOperations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("task")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskManagerResource {

    TaskManagerOperations taskManagerOperations=new TaskManagerOperations();

    //Get all tasks
    @GET
    @Path("/all")
    public Response getAllTask(){
        Gson gson=new Gson();
        String entity= gson.toJson(taskManagerOperations.getAllTasks());
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    //Get task by id
    @Path("/{taskId}")
    @GET
    public Response getTask(@PathParam("taskId") int id){
        Gson gson=new Gson();
        String entity=gson.toJson(taskManagerOperations.getTask(id));
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    //addTask
    @POST
    public Response addTask(TaskManager task){
        Gson gson=new Gson();
        String entity=gson.toJson(taskManagerOperations.addTask(task));
        return Response.status(Response.Status.ACCEPTED).entity(entity).build();
    }

    //UpdateTask
    @Path("/{taskId}")
    @PUT
    public Response updateTask(TaskManager task,@PathParam("taskId") int taskId) {
        Gson gson = new Gson();
        String entity = gson.toJson(taskManagerOperations.updateTask(task, taskId));
        return Response.status(Response.Status.ACCEPTED).entity(entity).build();
    }

    //Delete task
    @Path("/{taskId}")
    @DELETE
    public void deleteTask(@PathParam("taskId") int taskId){
        taskManagerOperations.deleteTask(taskId);
    }

}
