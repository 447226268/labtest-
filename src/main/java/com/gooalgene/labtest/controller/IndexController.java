package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.Staff_list;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/10/9 15:24
 *
 * @author XL
 * @version 1.0
 */
@RestController
@RequestMapping("/test")
public class IndexController {

    @Autowired
    private StaffServiceImpl staffServiceImpl;

    @GetMapping("/hello")
    public BaseResponse<List<String>> hello(){
        BaseResponse<List<String>> response = new BaseResponse<>();
        List<String> list = new ArrayList<>();
        list.add("company : gooalgene");
        list.add("name: gooalgene");
        response.setResult(list);
        return response;
    }

    @GetMapping("/getStaff/{sl_id}")
    public BaseResponse<Staff_list> GetStaff(@PathVariable int sl_id) {
        Staff_list ret = new Staff_list();
        ret = staffServiceImpl.Sel(sl_id);
        return new BaseResponse<>(ret);
    }

    @GetMapping("/getAllStaff")
    public BaseResponse<List<Staff_list>> GetAll() {
        List<Staff_list> list = staffServiceImpl.findAll();

        return new BaseResponse<>(list);
    }
}
