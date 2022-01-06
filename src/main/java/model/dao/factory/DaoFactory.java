package model.dao.factory;

import model.dao.impl.SellerDaoJDBC;
import model.entities.Seller;
import model.entities.SellerDao;

import java.util.List;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC();
    }
}
