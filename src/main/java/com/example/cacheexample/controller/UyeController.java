package com.example.cacheexample.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController //@RestController annotasyonu ile çalışan sınıfın URL ile istenen request’lere ait dönüş biçimlerini belirler.
public class UyeController {
    @GetMapping("/getUye") //Sınıf üzerinde kullanıldığı zaman, o sınıfın belirtilen URL ile ilgili tüm işleri yapması sağlanır.
    @Cacheable(value="cacheGetUye") //Bu anotasyon ile sadece @Entity olarak işaretli sınıf önbellekte saklanır.
    public List<Customer> uyeBilgi() { // öğeleri eklemek, güncellemek, silmek ve aramak için dizin tabanlı yöntemler içerir.
        try {
            System.out.println("main thread will be slept for 5 seconds");
            Thread.sleep(5000);
            System.out.println("main thread resumed after sleeping");
        } catch (InterruptedException ex) {
            System.out.println("sleeping thread get interrupted");
        }
        List<Customer> uyeList = Arrays.asList(
                new Customer(1, "Ahmet", "Veli"),
                new Customer(1, "Mehmet", "Ali"));

        return uyeList;
    }
/*Controllerimizin içerisine verilerimiz bulunmakta uyeBilgi metodumuzdan çıkacak sonucun caching özelliği
verebilmek için caching @Cacheable anotasyonu ile işaretlemiş oluyoruz.*/
    }

