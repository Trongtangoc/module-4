package com.codegym.productauction.repository;

import com.codegym.productauction.model.ProductType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.codegym.productauction.utils.JdbcUtils;

public class ProductTypeRepository implements IProductTypeRepository {
    @Override
    public List<ProductType> findAll() {
        List<ProductType> result = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT cid, name FROM product_type")) {
            while (rs.next()) {
                result.add(new ProductType(rs.getInt("cid"), rs.getString("name")));
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return result;
    }

    @Override
    public ProductType findById(Integer id) {
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT cid, name FROM product_type WHERE cid=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ProductType(rs.getInt("cid"), rs.getString("name"));
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return null;
    }
}
