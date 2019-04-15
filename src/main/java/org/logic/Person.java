package org.logic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kuznetcov-ia on 12.04.2019.
 */
@ApiModel("Person bean")
public class Person {
    private String name;
    private String surname;

    public Person(){}
    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    @ApiModelProperty(value = "Name of person", example = "Ivan")
    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name = name;
    }
    @ApiModelProperty(value = "Surname of person", example = "Ivanov")
    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String toString(){
        return "name: " + name +
                " surname: " + surname;
    }

}
