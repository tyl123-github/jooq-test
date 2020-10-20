package com.test.controller;

import com.test.entity.tables.pojos.Member;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 类SQL方式 添加
     *
     * @return
     */
    @RequestMapping("insert")
    public Map<String, Object> insert() {
        HashMap<String, Object> map = new HashMap<>();
        Integer id = testService.insert();
        Integer id1 = testService.insertTest();
        Integer id2 = testService.insertApi();
        map.put("code", 200);
        map.put("date", id + " " + id1 + " " + id2);
        map.put("msg", "成功");
        return map;
    }

    @RequestMapping("query")
    public Map<String, Object> query() {
        HashMap<String, Object> map = new HashMap<>();
        List<Member> list = testService.query();
        map.put("code", 200);
        map.put("date", list);
        map.put("msg", "成功");
        return map;
    }

    @RequestMapping("queryById")
    public Map<String, Object> queryById() {
        HashMap<String, Object> map = new HashMap<>();
        Member member = testService.getById();
        map.put("code", 200);
        map.put("date", member);
        map.put("msg", "成功");
        return map;
    }
}
