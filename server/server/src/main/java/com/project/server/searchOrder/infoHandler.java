package com.project.server.searchOrder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.server.JDBC.DetailByOrderJDBC;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class infoHandler {
    @CrossOrigin
    @RequestMapping("/info")
    public List<infoEntity> info(@RequestBody infoRequest request) throws SQLException, ClassNotFoundException{
    	return 	DetailByOrderJDBC.Get(request);
    }
}
