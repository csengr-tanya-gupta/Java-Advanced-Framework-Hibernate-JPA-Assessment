package com.capgemini.product_inventory_management.Task1.entity;

import jakarta.persistence.*;
import java.util.List;

public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public void addProduct(Product p) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(p);

        et.commit();

        System.out.println("Product added successfully.");
        displayProduct(p);
    }

    public List<Product> getProductsByCategory(String category) {

        Query q = em.createQuery("SELECT p FROM Product p WHERE p.category = :category");
        q.setParameter("category", category);

        return q.getResultList();
    }

    public void updateProductPrice(int id, double newPrice) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Product p = em.find(Product.class, id);

        if(p != null) {
            p.setPrice(newPrice);
            em.merge(p);

            System.out.println("Product price updated successfully.");
            displayProduct(p);
        }

        et.commit();
    }

    public void deleteProduct(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Product p = em.find(Product.class, id);

        if(p != null) {
            em.remove(p);
            System.out.println("Product deleted successfully.");
        }

        et.commit();
    }

    public void displayProduct(Product p) {

        System.out.println("ID: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Category: " + p.getCategory());
        System.out.println("Price: " + p.getPrice());
        System.out.println("Quantity: " + p.getQuantity());
    }
}