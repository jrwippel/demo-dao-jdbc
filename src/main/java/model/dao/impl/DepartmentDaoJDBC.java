package model.dao.impl;

import db.DB;
import db.DbException;
import model.entities.Department;
import model.entities.DepartmentDao;
import model.entities.Seller;
import model.entities.SellerDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection connection;

    public DepartmentDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO department (Name) Values (?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, obj.getName());

            int rowsaffected = preparedStatement.executeUpdate();
            if (rowsaffected > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()){
                    int id = resultSet.getInt(1);
                    obj.setId(id);
                }
            }
            else{
                throw new DbException("Unexpected Error:No Rows affectd!");
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
        }

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM department WHERE Id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                Department dep = InstanciateDepartment(resultSet);
                return dep;
            }

            return null;
        }

        catch ( SQLException e){
            throw new  DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(preparedStatement);
        }

    }

    @Override
    public List<Department> findAll() {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM department ORDER BY Name");
            resultSet = preparedStatement.executeQuery();
            List <Department> departmentList = new ArrayList<>();

            while (resultSet.next()){

                Department department = InstanciateDepartment(resultSet);
                departmentList.add(department);
            }
            return departmentList;
        }
        catch ( SQLException e){
            throw new  DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(preparedStatement);
        }
    }

    private Department InstanciateDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt("Id"));
        department.setName(resultSet.getString("Name"));
        return department;
    }
}
