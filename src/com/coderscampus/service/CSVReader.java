package com.coderscampus.service;

import com.coderscampus.domain.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;



public class CSVReader {
    private static CSVReader csvReader = null;

    private CSVReader() {

    }

    public static CSVReader getInstance() {
        if (csvReader == null) {
            csvReader = new CSVReader();
        }
        return csvReader;
    }

    public List readProductsFromFile(String filePath) {
        try {
            List<String> data = Files.readAllLines(Path.of(filePath));
            List<Product> products = new ArrayList<>();

            data.stream()
                    .skip(1)
                    .forEach((String lineOfData) -> {
                        Product product = new Product();
                        String[] productData = lineOfData.split(",");
                        product.setId(Integer.parseInt(productData[0])); // productId
                        product.setName(productData[1]); // productName
                        product.setQuantity(Integer.parseInt(productData[2])); // productQuantity
                        product.setPrice(Double.parseDouble(productData[3])); // productPrice
                        products.add(product);
                    });
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
