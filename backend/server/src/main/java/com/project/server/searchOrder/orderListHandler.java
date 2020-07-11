package com.project.server.searchOrder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.server.JDBC.OrderListJDBC;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
@RestController
public class orderListHandler {
    @CrossOrigin
    @RequestMapping("/orderlist")
    public List<orderListEntity> orderlist()throws ClassNotFoundException, SQLException {
        List<orderListEntity> datalist=OrderListJDBC.Get("001");
        return datalist;
    }

}

