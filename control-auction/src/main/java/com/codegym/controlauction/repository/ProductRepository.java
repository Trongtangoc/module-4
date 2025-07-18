package com.codegym.controlauction.repository;

import com.codegym.controlauction.model.Product;
import com.codegym.controlauction.model.ProductType;
import com.codegym.controlauction.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private ProductTypeRepository typeRepo = new ProductTypeRepository();

    private String buildWhere(String name, Long price, Integer typeId, List<Object> params) {
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        if (name != null && !name.trim().isEmpty()) {
            where.append(" AND LOWER(name) LIKE ? ");
            params.add("%" + name.trim().toLowerCase() + "%");
        }
        if (price != null) {
            where.append(" AND price = ? ");
            params.add(price);
        }
        if (typeId != null) {
            where.append(" AND product_type_id = ? ");
            params.add(typeId);
        }
        return where.toString();
    }

    @Override
    public List<Product> findAll(String name, Long price, Integer typeId, int offset, int limit) {
        List<Product> list = new ArrayList<>();
        List<Object> params = new ArrayList<>();
        String sql = "SELECT id, name, price, status, product_type_id FROM product" +
                buildWhere(name, price, typeId, params) +
                " ORDER BY id DESC LIMIT ? OFFSET ?";
        params.add(limit);
        params.add(offset);

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductType type = typeRepo.findById(rs.getInt("product_type_id"));
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getLong("price"),
                        rs.getString("status"),
                        type
                );
                list.add(p);
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return list;
    }

    @Override
    public int countAll(String name, Long price, Integer typeId) {
        List<Object> params = new ArrayList<>();
        String sql = "SELECT COUNT(*) FROM product" + buildWhere(name, price, typeId, params);
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception ex) { ex.printStackTrace(); }
        return 0;
    }

    @Override
    public void save(Product product) {
        try (Connection conn = JdbcUtils.getConnection()) {
            if (product.getId() == null) { // add mới
                String sql = "INSERT INTO product (name, price, status, product_type_id) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, product.getName());
                    ps.setLong(2, product.getPrice());
                    ps.setString(3, product.getStatus());
                    ps.setInt(4, product.getProductType().getCid());
                    ps.executeUpdate();
                }
            } else { // cập nhật
                String sql = "UPDATE product SET name=?, price=?, status=?, product_type_id=? WHERE id=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, product.getName());
                    ps.setLong(2, product.getPrice());
                    ps.setString(3, product.getStatus());
                    ps.setInt(4, product.getProductType().getCid());
                    ps.setInt(5, product.getId());
                    ps.executeUpdate();
                }
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) return;
        StringBuilder sql = new StringBuilder("DELETE FROM product WHERE id IN (");
        for (int i = 0; i < ids.size(); i++) {
            sql.append("?");
            if (i < ids.size() - 1) sql.append(",");
        }
        sql.append(")");
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < ids.size(); i++) ps.setInt(i + 1, ids.get(i));
            ps.executeUpdate();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    @Override
    public Product findById(Integer id) {
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, name, price, status, product_type_id FROM product WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ProductType type = typeRepo.findById(rs.getInt("product_type_id"));
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getLong("price"),
                        rs.getString("status"),
                        type
                );
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return null;
    }
}
