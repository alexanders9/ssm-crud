package com.jds.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jds.crud.bean.Employee;
import com.jds.crud.dao.DepartmentMapper;
import com.jds.crud.dao.EmployeeMapper;

/**
 * dao工作测试
 * 推荐spring项目使用Spring单元测试，可以自动注入我们需要的组件
 * @author 全栈攻城狮
 *
 *1.导入SpringTest模块
 *2.指定spring配置文件的位置
 *3.autiwired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DepartmentMapper bean = ctx.getBean(DepartmentMapper.class);
		
//		Department department1 = new Department(null,"开发部");
//		Department department2 = new Department(null,"测试部");
//		
//		departmentMapper.insertSelective(department1);
//		departmentMapper.insertSelective(department2);
		
		employeeMapper.insertSelective(new Employee(null,"jdsjds","M","jdsjds@qq.com",1));
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@qq.com",1));
		}
		
	}
	
	@Test
	public void testCRUD2() {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DepartmentMapper bean = ctx.getBean(DepartmentMapper.class);
		
		employeeMapper.insertSelective(new Employee(null,"jdsjds","M","jdsjds@qq.com",1));
	
		
	}
}
