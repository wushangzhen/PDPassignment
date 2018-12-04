package edu.neu.ccs.cs5010.assignment2;

/**
 * An interface named StockItem to represents stock item's basic methods.
 */
public interface StockItem {

  Category getCategory();

  void setCategory(Category category);

  String getSkuNumber();

  void setSkuNumber(String skuNumber);

  Price getPrice();

  void setPrice(Price price);
}
