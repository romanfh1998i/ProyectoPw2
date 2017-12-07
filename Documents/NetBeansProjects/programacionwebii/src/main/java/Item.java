/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author roman
 */
public class Item {
 private String image = "";
 private Long id;
    private String name;
    private int cant;
    private double price;

    public Item() {
    }
 
  public Item(Long id,String image, String name, int cant, double price) {
        this.id = id;
        this.name = name;
        this.image=image;
        this.cant = cant;
        this.price = price;
    }

    public Item(String name, int cant, double price) {
        
        this.name = name;
        this.cant = cant;
        this.price = price;
    }
 public String getImage() {
        return image;
    }
public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}