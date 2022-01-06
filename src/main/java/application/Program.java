package application;

import com.sun.source.tree.NewArrayTree;
import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.entities.SellerDao;

import java.util.Date;

public class Program {

    public static void main (String[] args){

        Department department = new Department(1, "Books");

        Seller seller = new Seller(7, "Jackson Wippel", "jrwippel@hotmail.com", new Date(),1000.00, department);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println(seller);
    }
}
