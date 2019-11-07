package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.dto.BaseRequest;
import com.gooalgene.labtest.dto.Staff;
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
    public BaseResponse<List<Staff>> GetAll() {
        List<Staff> list = staffServiceImpl.findAll();
        return new BaseResponse<>(list);
    }

    @GetMapping("/getStaff/{sl_id}")
    public BaseResponse<Staff> GetStaff(@PathVariable int sl_id) {
        Staff ret = staffServiceImpl.Sel(sl_id);
        return new BaseResponse<>(ret);
    }

    @PostMapping("/insertStaff")
    public BaseResponse<String> Insert(@RequestBody Staff staff) {
        String ret = staffServiceImpl.Insert(staff);
        return new BaseResponse<>(ret);
    }

    @DeleteMapping("/del/{sl_id}")
    public BaseResponse<String> Del(@PathVariable int sl_id) {
        String ret = staffServiceImpl.Del(sl_id);
        return new BaseResponse<>(ret);
    }

    @PostMapping("/update")
    public BaseResponse<String> Update(@RequestBody Staff staff) {
        String ret = staffServiceImpl.Update(staff);
        return new BaseResponse<>(ret);
    }

    @GetMapping("/getAllType")
    public BaseResponse<List<String>> GetAllType() {
        List<String> list = staffServiceImpl.getAllType();
        return new BaseResponse<>(list);
    }

    @DeleteMapping("/deleteType")
    public BaseResponse<String> DeleteType(@RequestBody BaseRequest<String> res) {
        String name = res.getRequestment();
        String ret = staffServiceImpl.deleteType(name);
        return new BaseResponse<>(ret);
    }

    @PostMapping("/addType")
    public BaseResponse<String> AddType(@RequestBody BaseRequest<String> res) {
        String name = res.getRequestment();
        String ret = staffServiceImpl.addType(name);
        return new BaseResponse<>(ret);
    }

    @PostMapping("/updateType")
    public BaseResponse<String> UpdateType(@RequestBody BaseRequest<List<String>> res) {
        String ret = staffServiceImpl.updateType(res.getRequestment());
        return new BaseResponse<>(ret);
    }

    @GetMapping("/getStaffInfo/{sl_id}")
    public BaseResponse<Staff> GetStaffInfo(@PathVariable int sl_id) {
        Staff ret = staffServiceImpl.getStaffInfo(sl_id);
        return new BaseResponse<>(ret);
    }

    @PostMapping("/updateStaffInfo")
    public BaseResponse<String> InsertStaffInfo(@RequestBody Staff staff) {
        String ret = staffServiceImpl.updateStaffInfo(staff);
        return new BaseResponse<>(ret);
    }
}
