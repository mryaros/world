package org.hello;


import com.sun.jersey.spi.dispatch.RequestDispatcher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.logic.Person;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by kuznetcov-ia on 12.04.2019.
 */
@Api(value = "persons", description = "Operation with personList")
@Path("/persons")
public class Persons {
    static ArrayList<Person> persons = new ArrayList<Person>();

    public int findPerson(Person person,  ArrayList<Person> per){
        for (int i = 0; i<per.size(); i++){
            if ((per.get(i).getName().equals(person.getName())) && (per.get(i).getSurname().equals(person.getSurname()))){
                return i;
            }
        }
        return per.size();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get all persons")
    public ArrayList<Person> getPerson() {
        return persons;
    }

    @GET @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get one person")
    public Person getPersonById(@PathParam("id") int id){
        if (persons.size() == 0)
            return new Person("Error:", "persons is empty");
        return persons.get(id);
    }

    @POST @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Post person with id=1")
    public Person postPerson(Person person, @PathParam("id") int id){

        persons.get(id).setName(person.getName());
        persons.get(id).setSurname(person.getSurname());

        return persons.get(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Put person")
    public ArrayList<Person> putPerson(Person person){
        persons.add(person);
        return persons;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete person")
    public ArrayList<Person> deletePerson (Person person){
        int id = findPerson(person, persons);
        if (id ==  persons.size())
            return persons;

        persons.remove(id);

        return persons;
    }
}
