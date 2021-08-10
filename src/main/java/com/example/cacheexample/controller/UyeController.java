package com.example.cacheexample.controller;

import com.example.cacheexample.model.Customer;
import com.example.cacheexample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
//@RestController annotasyonu ile çalışan sınıfın URL ile istenen request’lere ait dönüş biçimlerini belirler.

@RequiredArgsConstructor
public class UyeController {


    final CustomerRepository customerRepository;

    @Cacheable(value = "Customer")
    @GetMapping("/customer/{id}")
    //Sınıf üzerinde kullanıldığı zaman, o sınıfın belirtilen URL ile ilgili tüm işleri yapması sağlanır.
    public Customer getCustomer(@PathVariable Integer id) {
        try {
            System.out.println("main thread will be slept for 5 seconds");
            Thread.sleep(5000);
            System.out.println("main thread resumed after sleeping");
        } catch (InterruptedException ex) {
            System.out.println("sleeping thread get interrupted");
        }
        return customerRepository.findById(id).get();
    }

    @Cacheable(value = "Customer") //Bu anotasyon ile sadece @Entity olarak işaretli sınıf önbellekte saklanır.
    @PostMapping("/customer") //create ettiğimiz için post kullandık.
    public Customer creatCustomer(@RequestBody Customer customer) {//method oluşturma
        try {
            System.out.println("main thread will be slept for 5 seconds");
            Thread.sleep(5000);
            System.out.println("main thread resumed after sleeping");
        } catch (InterruptedException ex) {
            System.out.println("sleeping thread get interrupted");
        }
        return customerRepository.save(customer);
    }

    @CachePut(cacheNames = "Customer", key = "'Customer#'+ #id")
    //Cacheable anotasyonunda olduğu gibi netot sonucunu cache'e kaydeder.fakat
    //sonraki metot çağırımlarında yine metot çalışır. ( güncelleme )
    @PutMapping("Customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        try {
            System.out.println("main thread will be slept for 5 seconds");
            Thread.sleep(5000);
            System.out.println("main thread resumed after sleeping");
        } catch (InterruptedException ex) {
            System.out.println("sleeping thread get interrupted");
        }
        customer.setId(id);
        return customerRepository.save(customer);
    }



    @CacheEvict(cacheNames = "Customer", allEntries = true)
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        try {
            System.out.println("main thread will be slept for 5 seconds");
            Thread.sleep(5000);
            System.out.println("main thread resumed after sleeping");
        } catch (InterruptedException ex) {
            System.out.println("sleeping thread get interrupted");
        }
        customerRepository.deleteById(id);
    }
/*Controllerimizin içerisine verilerimiz bulunmakta uyeBilgi metodumuzdan çıkacak sonucun caching özelliği
verebilmek için caching @Cacheable anotasyonu ile işaretlemiş oluyoruz.*/
}

