package com.nagy.resources;

import com.nagy.entity.Todo;
import com.nagy.service.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.Response.Status.*;

@Path("/todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    TodoService todoService;

    @Path("new")
    @POST
    public Response createTodo(Todo todo) {
        try {
            var persistTodo = todoService.createTodo(todo);
            return Response.ok(persistTodo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(SERVICE_UNAVAILABLE).build();
        }
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {
        try {
            var persistTodo = todoService.updateTodo(todo);
            return Response.ok(persistTodo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(NOT_MODIFIED).build();
        }
    }

    @Path("{id}")
    @GET
    public Response updateTodo(@PathParam("id") Long id) {
        try {
            var todo = todoService.findTODoById(id);
            return Response.ok(todo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @Path("list")
    @GET
    public Response getTodos() {
        try {
            var todos = todoService.getTodos();
            return Response.ok(todos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(NO_CONTENT).build();
        }
    }

    @Path("status")
    @POST
    public Response makeTaskCompleted(@QueryParam("id") Long id) {
        try {
            var todo = todoService.findTODoById(id);
            todo.setCompleted(true);
            var persistTodo = todoService.updateTodo(todo);
            return Response.ok(persistTodo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(NOT_MODIFIED).build();
        }
    }

}
