package com.andres.curso.springboot.id.factura.springboot_di_factura.models;

public class Item {
    private Product product;
    private Integer quantity;
    
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Item() {
    }

    public int getImporte(){
        return quantity * product.getPrice();
    }

}
