package com.coderscampus;

import com.coderscampus.domain.Product;
import com.coderscampus.service.CSVReader;
import com.coderscampus.service.ReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagementApp {
    public static void main(String[] args) {
        CSVReader csvReader = CSVReader.getInstance();
        List<Product> products = csvReader.readProductsFromFile("product-inventory.txt");

        ReportGenerator reportGenerator = ReportGenerator.getInstance();
        reportGenerator.generateLowInventoryReport(products);

    }
}
