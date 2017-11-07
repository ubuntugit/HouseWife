package com.joe.hw.dao;

import com.joe.hw.domain.Accounting;
import com.joe.hw.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountingDao {
    /**
     * 操作数据库
     */
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 删除账务
     */
    public int delete(int accountid) {
        String sql = "DELETE FROM housewife_accounting WHERE accountid = ?";
        Object[] params = {accountid};
        try {
            return qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败，请重试！");
        }
    }

    /**
     * 编辑账务
     */
    public int edit(Accounting ac) {
        String sql = "UPDATE  housewife_accounting SET classifi = ?,money =?,account =?,createtime= ? ,description = ? WHERE accountid = ?";
        Object[] params = {ac.getClassifi(), ac.getMoney(), ac.getAccount(), ac.getCreatetime(), ac.getDescription(), ac.getAccountid()};
        try {

            return qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据编辑失败，重试");
        }
    }

    /**
     * 插入数据
     */
    public int insert(Accounting ac) {
        String sql = "INSERT INTO housewife_accounting(classifi,money,account,createtime,description) VALUES(?,?,?,?,?)";
        Object[] params = {ac.getClassifi(), ac.getMoney(), ac.getAccount(), ac.getCreatetime(), ac.getDescription()};
        try {
            return qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("插入失败");
        }
    }

    /**
     * 按照条件查询
     */
    public List<Accounting> query(String start, String end) {
        String sql = "SELECT * FROM housewife_accounting WHERE createtime BETWEEN ? AND ?";
        Object[] params = {start, end};
        try {
            return qr.query(sql, new BeanListHandler<Accounting>(Accounting.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败");
        }
    }

    /**
     * 查询所有账务
     */
    public List<Accounting> queryAll() {
        String sql = "SELECT * FROM housewife_accounting";
        try {
            return qr.query(sql, new BeanListHandler<Accounting>(Accounting.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错");
        }
    }
}
