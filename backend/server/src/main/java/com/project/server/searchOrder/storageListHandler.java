package com.project.server.searchOrder;
import org.springframework.web.bind.annotation.RestController;

import com.project.server.JDBC.SearchRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;

@RestController
public class storageListHandler {

    @CrossOrigin
    @RequestMapping("/storagelist")
    public List<storageListEntity> storagelist(@RequestBody storageRequest storagenum) throws Exception{
        System.out.println(storagenum.getNum());
        return SearchRequest.Get(storagenum,"001");
    }
}
