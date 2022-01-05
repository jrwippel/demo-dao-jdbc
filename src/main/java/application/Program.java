package application;

import com.sun.source.tree.NewArrayTree;
import model.entities.Department;

public class Program {

    public static void main (String[] args){

        Department department = new Department(1, "Books");
        System.out.println(department);
    }
}
