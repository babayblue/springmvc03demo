package com.company.service.impl;

import com.company.dao.CollegeMapper;
import com.company.dao.MajorMapper;
import com.company.entity.*;
import com.company.service.MajorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;

    //查找所有
    public PageInfo<Major> findAllMajor(String page, QueryMajor queryMajor) {
        //给page初始值
        if (page == null || page.trim().length() == 0) {
            page = "1";
        }
        int pageNum = Integer.parseInt(page);
        //分页
        PageHelper.startPage(pageNum, 2);
        //条件查询
        MajorExample majorExample = new MajorExample();
        MajorExample.Criteria criteria = majorExample.createCriteria();
        //按专业名称模糊查询
        if (queryMajor.getmName() != null && queryMajor.getmName().trim().length() > 0) {
            criteria.andMNameLike("%" + queryMajor.getmName() + "%");
        }
        //按学院类型查
        if (queryMajor.getcId() != null && queryMajor.getcId() != -1) {
            criteria.andCIdEqualTo(queryMajor.getcId());
        }
        //按学分查
        if (queryMajor.getMaxCredit() != null && queryMajor.getMinCredit() != null) {
            if (queryMajor.getMinCredit() < queryMajor.getMaxCredit()) {
                criteria.andCReditBetween(queryMajor.getMinCredit(), queryMajor.getMaxCredit());
            } else {
                criteria.andCReditBetween(queryMajor.getMaxCredit(), queryMajor.getMinCredit());
            }
        }
        List<Major> majors = majorMapper.selectByExample(majorExample);
        PageInfo<Major> pageInfo = new PageInfo<Major>(majors);
        return pageInfo;
    }

    //查找专业所属学院
    public List<College> findAllCollege() {
        List<College> colleges = collegeMapper.selectByExample(new CollegeExample());
        return colleges;
    }

    public void addMajor(Major major) {
        majorMapper.insert(major);
    }

    public void deleteMajor(Integer id) {
        majorMapper.deleteByPrimaryKey(id);
    }

    public Major findUpdateMajor(Integer id) {
        Major major = majorMapper.selectByPrimaryKey(id);
        return major;
    }

    public void updateMajor(Major major) {
        majorMapper.updateByPrimaryKeySelective(major);
    }
}
