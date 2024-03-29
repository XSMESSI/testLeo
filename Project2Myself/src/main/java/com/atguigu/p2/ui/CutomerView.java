package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

/**
 * @Author: Leo messi
 * @Date: 2022/03/20/14:37
 * @Description: CustomerView为主模块，负责菜单的显示和处理用户操作
 */
public class CutomerView {
    private CustomerList customerList = new CustomerList(10);

//    CustomerList customerList = new CustomerList(10);

    public CutomerView(){
        Customer cust = new Customer("张三", '男', 30, "010-56253825",
                "abc@email.com");
        customerList.addCustomer(cust);
    }

    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();

            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出（Y/N）");
                    char isExit  = CMUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        isFlag = false;
                    }
            }
            System.out.println();
        }
    }


    /**
     * 添加客户的操作
     */
    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.println("姓名");
        String name = CMUtility.readString(10);
        System.out.println("性别");
        char gender = CMUtility.readChar();
        System.out.println("年龄");
        int age = CMUtility.readInt();
        System.out.println("电话");
        String phone = CMUtility.readString(13);
        System.out.println("邮箱");
        String email = CMUtility.readString(30);

        //将上述数据封装到对象中
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess){
            System.out.println("添加完成");
        }else{
            System.out.println("客户目录添加失败");
        }
    }

    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        int num = 0;
        Customer cust = null;
        for (;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            num = CMUtility.readInt();
            if (num == -1) {
                return;
            }

            cust = customerList.getCustomer(num - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else //找到相应编号的客户
            {
                break;//结束循环
            }
        }

        //修改客户信息
        System.out.println("姓名（"+cust.getName()+"):");
        String name = CMUtility.readString(10,cust.getName());
        System.out.print("性别(" + cust.getGender() + ")：");
        char gender = CMUtility.readChar(cust.getGender());

        System.out.print("年龄(" + cust.getAge() + ")：");
        int age = CMUtility.readInt(cust.getAge());

        System.out.print("电话(" + cust.getPhone() + ")：");
        String phone = CMUtility.readString(13, cust.getPhone());

        System.out.print("邮箱(" + cust.getEmail() + ")：");
        String email = CMUtility.readString(30, cust.getEmail());

        cust = new Customer(name, gender, age, phone, email);

        boolean flag = customerList.replaceCustomer(num - 1, cust);
        if (flag) {
            System.out.println("---------------------修改完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }
    }

    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        int number = 0;
        for (;;){
            System.out.print("请选择待删除客户编号(-1退出)：");
            number = CMUtility.readInt();

            if (number == -1){
                return;
            }

            Customer customer = customerList.getCustomer(number - 1);

            if (customer ==null){
                System.out.println("无法找到指定客户");
            }else{
                break;
            }
        }

        //找到了指定客户
        System.out.println("确认是否删除（Y/N）");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y'){
            boolean deleteSuccess = customerList.deleteCustomer(number - 1);
            if (deleteSuccess){
                System.out.println("---------------删除成功-----------------");
            }else {
                System.out.println("-------------删除失败-----------");
            }
        }else {
            return;
        }
    }

    /**
     * 客户列表展示
     */
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        int total = customerList.getTotal();
        if (total == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < total; i++) {
            System.out.println(i + 1 + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t\t" + custs[i].getEmail());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }

    public static void main(String[] args){
        CutomerView cView = new CutomerView();
        cView.enterMainMenu();
    }
}
