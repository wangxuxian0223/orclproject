package org.wxx.ssm.orclproject.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wxx.ssm.orclproject.entity.StudentInfo;
import org.wxx.ssm.orclproject.entity.StudentInfoExample;

public interface StudentInfoMapper {
    long countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    int deleteByPrimaryKey(Integer studentid);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    StudentInfo selectByPrimaryKey(Integer studentid);
    
    List<StudentInfo> selectByExampleWithClassInfo(StudentInfoExample example);

    StudentInfo selectByPrimaryKeyWithClassInfo(Integer studentid);

    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}