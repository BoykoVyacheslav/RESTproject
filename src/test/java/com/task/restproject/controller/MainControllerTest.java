package com.task.restproject.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.task.restproject.model.Data;
import com.task.restproject.model.DataRepo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MainControllerTest {
    @Autowired
    private DataRepo dataRepo;
    private Gson gson=new Gson();
    private String jsonData = "{\"data\": [{\"hash\": \"md5:70d30a1c3a7c291e8f96bf34708863a8\", \"format\": \"application/vnd.openxmlformats-officedocument.wordprocessingml.document\", \"url\": \"https://public.docs-sandbox.openprocurement.org/get/a90c899ad7c5456294a619763161eb5b?KeyID=1331dc52&Signature=YTNKJhBhilMY3OjlOl5dJbkcvz8zVUnlq2%2Fk0lt63D8pBL5FzXseMgj6S2EavEXiFQ9VURfa7i4xJaQktqOxCg%253D%253D\", \"title\": \"\\u0414\\u043e\\u043a\\u0443\\u043c\\u0435\\u043d\\u0442\\u0430\\u0446\\u0438\\u044f \\u043f\\u043e \\u043b\\u043e\\u0442\\u0443 4.docx\", \"documentOf\": \"tender\", \"datePublished\": \"2017-09-19T10:13:09.785229+03:00\", \"dateModified\": \"2017-09-19T10:13:09.785249+03:00\", \"id\": \"abecf7b014574c869a9eef0e9fe0163d\"}, {\"hash\": \"md5:ea939fcea77ce340ea35807f97daeb84\", \"format\": \"application/pkcs7-signature\", \"url\": \"https://public.docs-sandbox.openprocurement.org/get/5bdaa83e5472412ba23a35028e274ae8?KeyID=1331dc52&Signature=oO6MAN9xf4zBhebBxEOUbkBb71EU0tOkemRVJ9uIQ8rx3965J%252BsJiS%252B8AFr9l20aLpuj4xjH8c%252BT0r9yP5fBAw%253D%253D\", \"title\": \"sign.p7s\", \"documentOf\": \"tender\", \"datePublished\": \"2017-09-19T10:13:31.794670+03:00\", \"dateModified\": \"2017-09-19T10:13:31.794690+03:00\", \"id\": \"f35467d6693a4b369bff4302ea17f512\"}]}";
    @Test
    public void saveData() throws Exception {
        JsonObject jsonObject=gson.fromJson(jsonData,JsonObject.class);
        JsonArray jsonArray=jsonObject.getAsJsonArray("data");
        Data[] dataArray=gson.fromJson(jsonArray,Data[].class);
        assertNotNull(dataArray[0]);
    }
    @Test
    public void getData(){
        MainController mc=new MainController();
        assertNotNull(mc.getData(13));
    }

}