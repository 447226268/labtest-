package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.ThesisMapper;
import com.gooalgene.labtest.entity.Thesis_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ThesisServiceImpl implements com.gooalgene.labtest.service.ThesisService {
    @Autowired
    private ThesisMapper thesisMapper;

    @Override
    public List<Thesis_List> findThesis() {
        List<Thesis_List> list = thesisMapper.findThesis();
        List<Thesis_List> list1 = new ArrayList<>();
        for (Thesis_List n : list) {
            Date time = new Date(n.getTl_date().toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            n.setTl_realtime(sdf.format(time));
            list1.add(n);

        }
        return list1;
    }

    @Override
    public Thesis_List findById(Integer tl_id) {
        return thesisMapper.findById(tl_id);
    }

    @Override
    public void insertThesis(Thesis_List thesis_list) {

        System.out.print(thesis_list);
        thesisMapper.addThesis(thesis_list);
    }

    @Override
    public void deleteThesis(Integer tl_id) {
        thesisMapper.deleteThesis(tl_id);
    }

    @Override
    public void updateThesis(Thesis_List thesis_list) {

        thesisMapper.updateThesis(thesis_list);
    }


}
