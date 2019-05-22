package com.spring.aopfight;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public String delete() {
        System.out.println("删除");
        return "ok";
    }

    @Override
    public void search() {
        System.out.println("查询");
    }

    @Override
    public void update() {
        System.out.println("修改");
        int i=1/0;
    }
}
