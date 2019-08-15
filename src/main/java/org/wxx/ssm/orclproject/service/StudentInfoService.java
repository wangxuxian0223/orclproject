package org.wxx.ssm.orclproject.service;

import java.util.List;

import org.wxx.ssm.orclproject.entity.StudentInfo;

public interface StudentInfoService {

	List<StudentInfo> getAll();

	void importExcel(List<StudentInfo> studentInfoList);

}
