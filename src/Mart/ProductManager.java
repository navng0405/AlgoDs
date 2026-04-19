package Mart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductManager {

    static class Product{
        String name;
        int price;
        int year;
        Product(String name,int price,int year){
            this.name = name;
            this.price = price;
            this.year = year;
        }
    }

    List<Product> allProducts;
    Map<Integer,List<Product>> yearMap;

    ProductManager(String[][] productsData){
        allProducts = new ArrayList<>();
        yearMap = new HashMap<>();
        for(String[] product : productsData){
            Product product1 = new Product(product[0],Integer.parseInt(product[1]),Integer.parseInt(product[2]));
            allProducts.add(product1);
            yearMap.putIfAbsent(Integer.parseInt(product[2]),new ArrayList<>());
            yearMap.get(Integer.parseInt(product[2])).add(product1);
        }
    }

    public List<String> executeQuery(int type,String param){
        List<String> result = new ArrayList<>();
        switch(type){
            case 1:
                int year = Integer.parseInt(param);
                if(yearMap.containsKey(year)){
                    for(Product product : yearMap.get(year)){
                        result.add(product.name);
                    }
                }
                break;
            case 2:
            case 3:
                for(Product product : allProducts){
                    if((type == 2 && product.price<Integer.parseInt(param)) || (type == 3 && product.price>Integer.parseInt(param))){
                        result.add(product.name);
                    }
                }
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] products = {
                {"Laptop", "800", "2021"},
                {"Smartphone", "500", "2020"},
                {"Tablet", "300", "2022"},
                {"Headphones", "150", "2021"},
                {"Smartwatch", "250", "2022"}
        };

        int[][] queries = {
                {1, 2021}, // Type1: Products from 2021
                {2, 300},  // Type2: Products below price 300
                {3, 500}   // Type3: Products above price 500
        };



        // Creating an instance of ProductManager with the sample data
        ProductManager manager = new ProductManager(products);
        for (int[] query : queries) {
            System.out.println("Query Result: " + manager.executeQuery(query[0], String.valueOf(query[1])));
        }
    }
}
