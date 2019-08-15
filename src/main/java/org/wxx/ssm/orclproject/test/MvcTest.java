package org.wxx.ssm.orclproject.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.wxx.ssm.orclproject.entity.StudentInfo;

import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class MvcTest {
	@Autowired
	WebApplicationContext context;

	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void pageTest() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/studentInfo/getAll").param("pageNo", "1")).andReturn();

		MockHttpServletRequest request = result.getRequest();
		PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页号：" + pageInfo.getPageNum());
		System.out.println("总页数：" + pageInfo.getPages());
		System.out.println("总记录数：" + pageInfo.getTotal());
		System.out.println("导航页码：");
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i : nums) {
			System.out.print(i + ",");
		}
		
		//导航页码
		List<StudentInfo> list = pageInfo.getList();
		for (StudentInfo studentInfo : list) {
			System.out.println(studentInfo.getStudentname() + "," + studentInfo.getClassInfo().getClassname());
		}
	}
}
