import com.zy.spring.jdbc.dao.EmployeeDao;
import com.zy.spring.jdbc.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JdbcTemplateTestor {
    @Resource
    private EmployeeDao employeeDao;


    @Test
    public void testFindById() {
        Employee employee = employeeDao.findById(3308);
        System.out.println(employee);
    }

    @Test
    public  void testFindByDname() {
        System.out.println(employeeDao.findByDname("市场部"));
    }

    @Test
    public void testFindMapByDname(){
        System.out.println(employeeDao.findMapByDname("研发部"));
    }
    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setEno(9998);
        employee.setEname("乔峰");
        employee.setSalary(66666f);
        employee.setDname("研发部");
        employee.setHiredate(new Date());
        employeeDao.insert(employee);
    }
    @Test
    public void testUpdate() {
        Employee employee = employeeDao.findById(9998);
        employee.setSalary(employee.getSalary()+1000);
        int count = employeeDao.update(employee);
        System.out.println("本次更新："+count+"条数据");

    }

    @Test
    public void testDelete() {
        int count = employeeDao.delete(9998);
        System.out.println("本次删除："+count+"条数据");

    }
}
