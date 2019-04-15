package org.hello;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.logic.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
@Api(value = "Hello", description = "Helloworld")
@Path("/world")
public class World {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "hello world")
    public String getMessage(){
        return "Hello world";
    }
}


