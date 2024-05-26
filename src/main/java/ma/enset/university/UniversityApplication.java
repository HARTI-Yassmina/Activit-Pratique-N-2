package ma.enset.university;

import ma.enset.university.entities.Product;
import ma.enset.university.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository ;
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null , "Computer" , 35000 ,3 ));
        productRepository.save(new Product(null , "Printer " , 1500 ,5 ));
        productRepository.save(new Product(null , "Scanner " , 4000 ,2 ));
        productRepository.save(new Product(null , "test " , 4000 ,2 ));
        productRepository.save(new Product(null , "test0.2 " , 4000 ,2 ));
        List<Product> products  = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());

        });
        System.out.println("****************************");
        Product produit = productRepository.findById(Long.valueOf(1)).get();
        System.out.println(produit );
        System.out.println("****************************");



    }
}
