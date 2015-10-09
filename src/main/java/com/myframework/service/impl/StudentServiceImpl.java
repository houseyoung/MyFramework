package com.myframework.service.impl;

import com.myframework.dto.StudentDto;
import com.myframework.entity.Student;
import com.myframework.mapper.StudentMapper;
import com.myframework.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:43.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDto> listStudent(@Param("keywords") String keywords){
        return studentMapper.listStudent(keywords);
    }

    @Override
    public void insert(@Param("studentDto") StudentDto studentDto){
        studentMapper.insert(studentDto);
    }

    @Override
    public void delete(@Param("id") int id)  {
        studentMapper.delete(id);
    }

    @Override
    public StudentDto queryById(@Param("id") int id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void update(@Param("studentDto") StudentDto studentDto){
        studentMapper.update(studentDto);
    }
}
