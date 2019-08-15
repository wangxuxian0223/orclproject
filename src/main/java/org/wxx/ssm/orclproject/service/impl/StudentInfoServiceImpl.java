package org.wxx.ssm.orclproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wxx.ssm.orclproject.dao.StudentInfoMapper;
import org.wxx.ssm.orclproject.entity.StudentInfo;
import org.wxx.ssm.orclproject.service.StudentInfoService;
@Service
public class StudentInfoServiceImpl implements StudentInfoService {
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	
	@Override
	public List<StudentInfo> getAll() {
		return studentInfoMapper.selectByExampleWithClassInfo(null);
	}

	@Override
	public void importExcel(List<StudentInfo> studentInfoList) {
		for (StudentInfo studentInfo : studentInfoList) {
			studentInfoMapper.insertSelective(studentInfo);
		}
	}
}
