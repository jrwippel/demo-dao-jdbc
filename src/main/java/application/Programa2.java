package application;

import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.DepartmentDao;

public class Programa2 {

    public static void main(String[]args){



        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: Department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);


    }
}
