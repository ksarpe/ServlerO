package database;

import java.util.HashMap;

public class User {
  private String username;
  private String password; // W praktyce hasła powinny być haszowane
  private HashMap<String, Boolean> products = new HashMap<>();
  // Gettery i settery
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public HashMap<String, Boolean> getProducts() {
    return products;
  }
  public void setProducts(HashMap<String, Boolean> products) {
    this.products = products;
  }
}
