package com.coderscampus.service;

import com.coderscampus.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private static ReportGenerator reportGenerator = null;

    public static ReportGenerator getInstance() {
        if (reportGenerator == null) {
            reportGenerator = new ReportGenerator();
        }
        return reportGenerator;
    }

    public void generateReport(List<Product> products) {
        for (Product product : products) {
            System.out.println("ID: " + product.getId() +
                    ", Name: " + product.getName() +
                    ", Quantity: " + product.getQuantity() +
                    ", Price: S" + product.getPrice());
        }
    }

    public void generateLowInventoryReport(List<Product> products) {
        boolean lowOnInventory = false;

        for (Product product : products) {
            if (product.getPrice() > 0.99 && product.getPrice() < 100.00) {
                if (product.getQuantity() <= 20) {
                    lowOnInventory = true;
                    System.out.println("ID: " + product.getId() +
                            ", Name: " + product.getName() +
                            ", Quantity: " + product.getQuantity() +
                            ", Price: S" + product.getPrice() +
                            " Needs to be reordered.");
                }
            } else if (product.getPrice() > 100.00) {
                if (product.getQuantity() <= 10) {
                    lowOnInventory = true;
                }
            } else {
                lowOnInventory = false;
            }
        }

    }
}
