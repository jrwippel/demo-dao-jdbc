package application;

import com.sun.source.tree.NewArrayTree;
import model.dao.factory.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import model.entities.SellerDao;

import java.util.Date;

public class Program {

    public static void main (String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);


        System.out.println(seller);
    }
}
