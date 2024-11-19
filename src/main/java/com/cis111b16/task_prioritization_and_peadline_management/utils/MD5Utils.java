package com.cis111b16.task_prioritization_and_peadline_management.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /** add by ChatGpt :)
     * 对给定的字符串进行 MD5 加密
     *
     * @param input 要加密的字符串
     * @return 加密后的 32 位十六进制字符串
     */
    public static String encrypt(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        try {
            // 创建 MessageDigest 实例，指定使用 MD5 算法
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 执行加密
            byte[] digest = md.digest(input.getBytes());

            // 将加密后的字节数组转换为十六进制字符串
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

//    public static void main(String[] args) {
//        // 示例测试
//        String input = "HelloWorld";
//        String encrypted = MD5Utils.encrypt(input);
//        System.out.println("Original: " + input);
//        System.out.println("Encrypted: " + encrypted);
//    }
}
