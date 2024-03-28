package database;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String username;
  private String password; // W praktyce hasła powinny być haszowane
  private List<Product> shoppingList = new ArrayList<>();
  
  public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.shoppingList = new ArrayList<>(); //
    }

  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }

  public List<Product> getShoppingList() {
        return shoppingList;
    }

    // Add a method to add a product to the list
    public void addProduct(Product product) {
        this.shoppingList.add(product);
        System.out.println("Product added to the list");
        for (Product p : shoppingList) {
            System.out.print(p.getName());
        }
    }
}
