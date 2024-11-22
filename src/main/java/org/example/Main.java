package org.example;

import org.example.Class.QrCode;

public class Main {
    public static void main(String[] args){
        try{
            QrCode qrCode = new QrCode("https://www.tiktok.com/@mentesprogramadoras",300,300);
            qrCode.generate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}