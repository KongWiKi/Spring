package com.wkk;

/**
 * @Time: 20-2-6下午4:20
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
