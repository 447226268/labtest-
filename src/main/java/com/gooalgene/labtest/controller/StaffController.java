package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.Staff_list;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffServiceImpl staffServiceImpl;

    @GetMapping("/getAllStaff")
    public BaseResponse<List<Staff_list>> GetAll() {
        List<Staff_list> list = staffServiceImpl.findAll();
        return new BaseResponse<>(list);
    }

    @GetMapping("/getStaff/{sl_id}")
    public BaseResponse<Staff_list> GetStaff(@PathVariable int sl_id) {
        Staff_list ret = staffServiceImpl.Sel(sl_id);
        return new BaseResponse<>(ret);
    }

    @PostMapping("/insertStaff")
    public String Insert(@RequestBody Staff_list staff) {
        String ret = staffServiceImpl.Insert(staff);
        return ret;
    }

    @DeleteMapping("/del/{sl_id}")
    public String Del(@PathVariable int sl_id) {
        String ret = staffServiceImpl.Del(sl_id);
        return ret;
    }

    @PostMapping("/update")
    public void Update(@RequestBody Staff_list staff) {
        staffServiceImpl.Update(staff);
        return;
    }
}
