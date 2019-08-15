package org.wxx.ssm.orclproject.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wxx.ssm.orclproject.dao.ClassInfoMapper;
import org.wxx.ssm.orclproject.dao.StudentInfoMapper;
import org.wxx.ssm.orclproject.entity.ClassInfo;
import org.wxx.ssm.orclproject.entity.StudentInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	private ClassInfoMapper classInfoMapper;
	@Autowired
	private StudentInfoMapper studentInfoMapper;
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void insertClassInfoTest() {
		classInfoMapper.insertSelective(new ClassInfo(null, "大一"));
		classInfoMapper.insertSelective(new ClassInfo(null, "大二"));
		classInfoMapper.insertSelective(new ClassInfo(null, "大三"));
		classInfoMapper.insertSelective(new ClassInfo(null, "大四"));
	}
	
	@Test
	public void insertStudentInfoTest() {
		studentInfoMapper.insertSelective(new StudentInfo(1001, "rtght", "男", 20, 12597l, "武汉", 1));
	}
	
	@Test
	public void batchInsertTest() {
		StudentInfoMapper StudentInfoMapper = sqlSession.getMapper(StudentInfoMapper.class);
		for (int i = 1; i <= 1000; i++) {
			String name = UUID.randomUUID().toString().substring(0, 5);
			String[] sexes = {"男", "女"};
			String sex = sexes[Math.random() > 0.5 ? 1 : 0];
			int[] ages = {18, 19, 20, 21, 22, 23, 24};
			int age = ages[(int) (Math.random() * 7)];
			Long tel = 14562l + i;
			String[] addresses = {"武汉", "北京", "上海", "广州", "深圳", "杭州"};
			String address = addresses[(int) (Math.random() * 6)];
			int cid = (int) (Math.random() * 4 + 1);
			StudentInfoMapper.insertSelective(new StudentInfo(null, name, sex, age, tel, address, cid));
		}
	}
}
