package application;

import com.sun.source.tree.NewArrayTree;
import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.entities.SellerDao;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main (String[] args){
        SellerDao sellerDao = DaoFactory.createSellerDao();

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
    }
}
