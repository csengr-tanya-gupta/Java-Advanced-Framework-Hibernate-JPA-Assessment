package com.capgemini.product_inventory_management.Task2.main;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;

import com.capgemini.product_inventory_management.Task2.entity.*;

public class JavaApp {

    public static void execution(){

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("product-unit");
        EntityManager em=emf.createEntityManager();

        ProductDAO dao=new ProductDAO(em);

        Scanner sc=new Scanner(System.in);

        System.out.println("Add Product Name:");
        String name=sc.nextLine();

        System.out.println("Category:");
        String category=sc.nextLine();

        System.out.println("Price:");
        double price=sc.nextDouble();

        System.out.println("Quantity:");
        int quantity=sc.nextInt();

        Product p=new Product(name,category,price,quantity);

        dao.addProduct(p);

        sc.nextLine();

        System.out.println("Search Product");
        System.out.println("Category:");
        String cat=sc.nextLine();

        List<Product> list=dao.getProductsByCategory(cat);

        if(list.isEmpty()){
            System.out.println("No product found.");
        }else{
            for(Product pr:list){
                System.out.println();
                dao.displayProduct(pr);
            }
        }

        System.out.println();
        System.out.println("Update Product");
        System.out.println("ID:");
        int id=sc.nextInt();

        System.out.println("New Price:");
        double newPrice=sc.nextDouble();

        dao.updateProductPrice(id,newPrice);

        System.out.println();
        System.out.println("Delete Product");
        System.out.println("ID:");
        int deleteId=sc.nextInt();

        dao.deleteProduct(deleteId);
    }
}