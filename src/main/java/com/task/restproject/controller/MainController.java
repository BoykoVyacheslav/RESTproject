package com.task.restproject.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.task.restproject.model.Data;
import com.task.restproject.model.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private DataRepo dataDAO;
    private Gson gson=new Gson();

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void saveData(@RequestBody String reqBody){
        JsonObject jsonObject=gson.fromJson(reqBody,JsonObject.class);       //creating JSON object from request body
        JsonArray jsonArray=jsonObject.getAsJsonArray("data"); //extracting an array of internal objects
        Data[] dataArray=gson.fromJson(jsonArray,Data[].class);                       //parsing JSON array to "Data" array
        for (Data d:dataArray) {                                                                              //saving each objects from array to database via JpaRepository
            dataDAO.save(d);
        }
    }
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET,produces = "application/text")
    public String getData(@PathVariable("id") Integer id){
        return dataDAO.findDataByIde(id).toString();
    }
}
