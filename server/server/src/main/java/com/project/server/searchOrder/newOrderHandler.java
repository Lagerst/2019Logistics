package com.project.server.searchOrder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.server.JDBC.NewOrderJDBC;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
    @RestController
    public class newOrderHandler {
        @CrossOrigin
        @RequestMapping("/newOrder")
        public String neworder(@RequestBody Neworder neworder) throws Exception{
            return (NewOrderJDBC.Get(neworder)==true)?"true":"false";
    }
}