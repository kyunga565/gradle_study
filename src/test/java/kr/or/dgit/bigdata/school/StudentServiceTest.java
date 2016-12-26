package kr.or.dgit.bigdata.school;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.school.dto.Student;
import kr.or.dgit.bigdata.school.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentservice;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentservice = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentservice = null;
	}

	@Test
	public void testSelectbyAll() {
		List<Student> list = studentservice.findAllStudent();
		Assert.assertNotNull(list);
		for(Student s : list){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSelectByNo(){
		Student std = studentservice.selectByNo(3);
		Assert.assertNotNull(std);
	}
	
	/*	@Test
	public void testInsertItem(){
		Calendar cal = Calendar.getInstance();
		cal.set(2000, 01, 01);
		// 0 -> 1월  , 1 -> 2월
		Student insStd = new Student(5, "강보미3","kbm@test.com", cal.getTime());
		studentservice.insertItem(insStd);
		
		List<Student> list = studentservice.findAllStudent();
		
		Assert.assertEquals(5, list.size());
		//현재 공유 김사부=>2명인데 강보미넣어서 만약3이라면 입력된거
	}
*/	
/*	@Test
	public void testDeleteItem(){
		studentservice.deleteItem(2);
		
		Student std = studentservice.selectByNo(1);
		Assert.assertNull(std);
	}*/
	@Test
	public void testUpdateItem(){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2000, 00, 01);
		
		Student update = new Student(3,"이유진2","lyj@test.com",cal.getTime()); 
		
		studentservice.updateItem(update);
		
		Student selectItem = studentservice.selectByNo(3);
		Assert.assertEquals(selectItem, update);
	}
	
}
