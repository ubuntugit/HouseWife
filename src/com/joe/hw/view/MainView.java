package com.joe.hw.view;

import com.joe.hw.domain.Accounting;
import com.joe.hw.service.AccountingService;

import java.util.List;
import java.util.Scanner;

/**
 * 写完一个方法就向后推
 */
public class MainView {

    /**
     * 依赖Accountingservice
     */
    private static AccountingService accountingService = new AccountingService();

    /**
     * 运行方法
     * 1.1	完成功能界面菜单显示
     * 1.2	接收键盘输入的功能选项
     * 1.3	根据选项值，调用对应的功能方法
     */
    public void run() {
        boolean flag = true;
        while (flag) {
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            int in = new Scanner(System.in).nextInt();
            switch (in) {
                case 1:
                    addAccounting();
                    break;
                case 2:
                    editAccounting();
                    break;
                case 3:
                    deleteAccounting();
                    break;
                case 4:
                    queryAccounting();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");

            }
        }
    }

    /**
     * 实现删除功能
     */
    public static void deleteAccounting() {
        queryAll();
        System.out.println("请输入要删除账务的ID：");
        int accountid = new Scanner(System.in).nextInt();
        System.out.println("您真的要删除这条信息吗？确认删除输入'是',退出输入任意键");
        String confirmInfo = new Scanner(System.in).next();
        if (confirmInfo.equals("是")) {
            int row = accountingService.delete(accountid);
            if (row > 0) {
                System.out.println("恭喜您，删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else {
            return;
        }

    }

    /**
     * 实现删除编辑功能
     */
    public static void editAccounting() {
        queryAll();
        System.out.println("请输入要编辑账务的ID：");
        int accountid = new Scanner(System.in).nextInt();
        System.out.println("请输入新类别：");
        String classifi = new Scanner(System.in).next();
        System.out.println("请输入新账务信息：");
        String account = new Scanner(System.in).next();
        System.out.println("请输入新金额：");
        Double money = new Scanner(System.in).nextDouble();
        System.out.println("请输入新时间：");
        String createtime = new Scanner(System.in).next();
        System.out.println("请输入新描述：");
        String description = new Scanner(System.in).next();
        Accounting ac = new Accounting(accountid, classifi, money, account, createtime, description);
        int row = accountingService.edit(ac);
        if (row > 0) {
            System.out.println(row);
        } else {
            System.out.println("编辑失败");
        }
        queryAll();
    }

    /**
     * 实现功能
     * 1，添加账务
     */
    public static void addAccounting() {
        System.out.println("请输入类别：");
        String classifi = new Scanner(System.in).next();
        System.out.println("请输入账务：");
        String account = new Scanner(System.in).next();
        System.out.println("请输入金额：");
        Double money = new Scanner(System.in).nextDouble();
        System.out.println("请输入使用时间：");
        String createtime = new Scanner(System.in).next();
        System.out.println("请输入详细描述：");
        String description = new Scanner(System.in).next();
        // 调用service方法
        Accounting ac = new Accounting(0, classifi, money, account, createtime, description);
        int row = accountingService.insert(ac);
        if (row > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    /**
     * 按照条件查询账务，时间
     */
    public static void query() {
        System.out.println("请输入格式为XXXX-XX-XX格式的日期");
        System.out.print("请输入起始时间:");
        String start = new Scanner(System.in).next();
        System.out.print("请输入结束时间:");
        String end = new Scanner(System.in).next();
        List<Accounting> accountings = accountingService.query(start, end);
        print(accountings);
    }

    /**
     * 打印方法
     */
    public static void print(List<Accounting> accountings) {
        System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
        for (Accounting a : accountings
                ) {
            System.out.println(a.getAccountid() + "\t" + a.getClassifi() + "\t" +
                    a.getAccount() + "\t" + a.getMoney() + "\t" + a.getCreatetime() + "\t" + a.getDescription());

        }

    }

    /**
     * 查询所有账务
     */
    public static void queryAll() {
        List<Accounting> accountings = accountingService.queryAll();
        print(accountings);
    }

    /**
     * 查询功能
     */
    public static void queryAccounting() {
        System.out.println("1.查询所有 2.按条件查询");
        int i = new Scanner(System.in).nextInt();
        switch (i) {
            case 1:
                queryAll();
                break;
            case 2:
                query();
                break;
            default:
                System.out.println("输入错误");
        }
    }

}
