package com.company.service;

import com.company.entity.College;
import com.company.entity.Major;
import com.company.entity.QueryMajor;
import com.github.pagehelper.PageInfo;

import javax.management.Query;
import java.util.List;

public interface MajorService {
    PageInfo<Major> findAllMajor(String page, QueryMajor queryMajor);

    List<College> findAllCollege();

    void addMajor(Major major);

    void deleteMajor(Integer id);

    Major findUpdateMajor(Integer id);

    void updateMajor(Major major);
}
