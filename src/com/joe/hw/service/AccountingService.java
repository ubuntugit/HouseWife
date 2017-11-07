package com.joe.hw.service;

import com.joe.hw.dao.AccountingDao;
import com.joe.hw.domain.Accounting;

import java.util.List;

/**
 * 账户业务层
 */
public class AccountingService {
    //    依赖AccountingDao
    private AccountingDao accountingDao = new AccountingDao();
    /**
     * 删除账务
     */
    public int delete(int accountid) {
        return accountingDao.delete(accountid);
    }

    /**
     * 编辑账务
     */
    public int edit(Accounting ac){
        return accountingDao.edit(ac);
    }

    public int insert(Accounting ac) {
        return accountingDao.insert(ac);
    }

    /**
     * 有条件查询
     *
     * @param start
     * @param end
     * @return
     */
    public List<Accounting> query(String start, String end) {
        return accountingDao.query(start, end);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<Accounting> queryAll() {
        return accountingDao.queryAll();
    }

}
