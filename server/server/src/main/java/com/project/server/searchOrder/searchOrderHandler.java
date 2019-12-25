package com.project.server.searchOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.server.JDBC.SearchOrder;
import com.project.server.JDBC.SearchRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
@RestController
public class searchOrderHandler {

    @CrossOrigin
    @RequestMapping(value="/searchOrder")
    public List<orderListEntity> searchorder(@RequestBody searchRequest request) throws Exception{
    	return SearchOrder.Get(request);
    }
}
