package org.example;

import java.util.Scanner;

public class Main {
    public static final double VAT = 0.08;
    public static final double bac1 = 1.806;
    public static final double bac2 = 1.866;
    public static final double bac3 = 2.167;
    public static final double bac4 = 2.729;
    public static final double bac5 = 3.050;
    public static final double bac6 = 3.151;

    public static double calculateBill(int electricityUsage) throws IllegalArgumentException {
        if (electricityUsage <= 0) {
            throw new IllegalArgumentException("Số điện không hợp lệ");
        }

        // Mảng lưu trữ các ngưỡng sử dụng điện
        int[] thresholds = {0, 50, 100, 200, 300, 400, Integer.MAX_VALUE};
        // Mảng lưu trữ các giá tiền tương ứng
        double[] levels = {0, bac1, bac2, bac3, bac4, bac5, bac6};

        double total = 0;
        int usageRemaining = electricityUsage;

        for (int i = 0; i < thresholds.length; i++) {
            // Tính số lượng điện sử dụng trong mỗi mức giá
            int usageInLevel = Math.min(usageRemaining, thresholds[i + 1] - thresholds[i]);
            
            // Tính tổng giá tiền cho mỗi mức giá
            total += usageInLevel * levels[i+1];

            // Cập nhật số lượng điện còn lại
            usageRemaining -= usageInLevel;

            // Nếu số lượng điện còn lại <= 0, dừng vòng lặp
            if (usageRemaining <= 0) {
                break;
            }
        }

        // Tính giá tiền sau thuế
        total *= 1.08;
        return Math.round(total * 1000.0) / 1000.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện: ");
        int number = scanner.nextInt();
        System.out.println("Tiền điện phải thanh toán: " + calculateBill(number));
    }
}