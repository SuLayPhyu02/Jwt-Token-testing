//package com.nexcode.mm.taskmanager;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.nexcode.mm.taskmanager.entities.Task;
//import com.nexcode.mm.taskmanager.service.TaskService;
//
//@SpringBootTest
//class TaskManagerApplicationTests {
//	
//	@Autowired
//	private TaskService taskservice;
//
//	@Test
//	void test()
//	{
//		if(taskservice==null)
//		{
//			System.out.println("bean is null");
//			
//		}
//		else
//		{
//			System.out.println("bean is not null");
//			System.out.println(taskservice);
//		}
//		
//	}
//
//	@Test
//	void test_createTask()
//	{
//		//add value
//		Task task=taskservice.createTask("Download","Korean Movie");
//		//check size
//		assertEquals(1, taskservice.getAllTask().size());
//		assertEquals("Download",task.getTitle());
//		assertEquals("Korean Movie",task.getDescription());
//	}
//
//}
