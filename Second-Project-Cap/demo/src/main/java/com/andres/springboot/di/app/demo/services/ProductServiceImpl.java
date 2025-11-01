package com.andres.springboot.di.app.demo.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.demo.models.Product;
import com.andres.springboot.di.app.demo.repositories.ProductRepository;
import com.andres.springboot.di.app.demo.repositories.ProductRepositoryImpl;


/* El producto service con el repositroy es una implementacion de una Interface que permite garantizar
 como un contrato de que lo va tener algo ?....
  */

/* La parte de Autwires de la parte de repositroy */



@Service
public class ProductServiceImpl  implements ProductService{
    
    /* En la p[arte de l service se hace el cambio o la obtencion de los datos pero tu lo tienes
     * que mover o editar , en el repository ss lo qeu se obtiene de la base de datos 
    ] */


    /* Esto desde que se define la parte de Autowired en la parte de cada clase...
     * se lleva a cabo ello y se jala por cada clase sin necesidad de hacer el ProductSerrviceImple()...
     */

    private ProductRepository repository;


    /* En esta parte de  */
   /*  @Autowired
    @Qualifier("productFoo")  //Esto trae la parte del llamado al que swe le hice
    public void setRepository(ProductoRepository repository) {
        this.repository = repository;
    } */

    /* En este caso iniciar la parte de product... por parte de Qualifier */
    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        
        return repository.findAll().stream().map(p->{
            Double priceTax=p.getPrice() *1.25d;
            /* Product product=new Product(p.getId(),p.getName(),priceImp.longValue()); */
            /* p.setPrice(priceImp.longValue()); */
            Product newProd=(Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());

    }


    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

    



}
