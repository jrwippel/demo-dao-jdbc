package application;

import com.sun.source.tree.NewArrayTree;
import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.entities.SellerDao;

import javax.sound.midi.Soundbank;
import java.util.Date;

public class Program {

    public static void main (String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: Seller findById ===");

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
