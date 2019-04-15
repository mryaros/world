package org.logic;

import io.swagger.jaxrs.config.BeanConfig;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kuznetcov-ia on 15.04.2019.
 */
@ApplicationPath("/api")
public class SampleApplication extends javax.ws.rs.core.Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }

    public SampleApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setBasePath("/world");
        beanConfig.setHost("localhost:8080/swagger-ui");
        beanConfig.setResourcePackage("org.hello");
        beanConfig.setScan(true);
    }

}