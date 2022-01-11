package application;

import com.sun.source.tree.NewArrayTree;
import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.entities.SellerDao;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main (String[] args){
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Scanner sc = new Scanner(System.in);


        System.out.println("=== Test 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== Test 2: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);
        for (Seller obj : sellerList){
            System.out.println(obj);
        }

        System.out.println("=== Test 3: Seller findAll ===");
        sellerList = sellerDao.findAll();
        for (Seller obj : sellerList){
            System.out.println(obj);
        }

        System.out.println("=== Test 4: Seller insert ===");
        Seller newseller = new Seller(null, "Jackson R Wippel", "jrwippel@hotmail.com", new Date(), 5000.00, department);
        sellerDao.insert(newseller);
        System.out.println("Inserted! New Id = "+newseller.getId());

        System.out.println("=== Test 5: Seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("James Bond");
        sellerDao.update(seller);
        System.out.println("Update Completed!");

        System.out.println("=== Test 6: Seller delete ===");

        System.out.print("Enter with ID for delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

    }
}
