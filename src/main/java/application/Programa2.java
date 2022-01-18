package application;

import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.DepartmentDao;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Programa2 {

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);



        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: Department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("=== Test 2: Department findAll ===");
        List<Department> departmentList = departmentDao.findAll();
        departmentList = departmentDao.findAll();
        for (Department obj : departmentList){
            System.out.println(obj);
        }

        System.out.println("=== Test 3: Department insert ===");
        Department newdepartment = new Department(5, "Tecnology");
        departmentDao.insert(newdepartment);
        System.out.println("Inserted new ID:"+ newdepartment.getId());

        System.out.println("=== Test 4: Department update ===");
        department = departmentDao.findById(3);
        department.setName("Engenary");
        departmentDao.update(department);
        System.out.println("Update Completed!");

        System.out.println("=== Test 5: Department delete ===");
        System.out.println("Enter ID for delete:");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Completed");

    }
}
