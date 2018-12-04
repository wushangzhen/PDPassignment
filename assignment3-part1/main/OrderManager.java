package edu.neu.ccs.cs5010.assignment3.part1;

import edu.neu.ccs.cs5010.assignment2.BasicFactor;
import edu.neu.ccs.cs5010.assignment2.Category;
import edu.neu.ccs.cs5010.assignment2.Measurement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * A class of order manager.
 */
public class OrderManager {

  private List<String> currentOrderList;
  private StockService stockService;

  OrderManager(List<String> currentOrderList, StockService stockService) {
    this.currentOrderList = currentOrderList;
    this.stockService = stockService;
  }

  /**
   * Add the commodity to the order.
   * @param skuNumber A string represent commodity's SKUNUMBER
   * @return A boolean value represent whether it is worked
   */
  public boolean addToOrder(String skuNumber) {
    Map<String, BasicFactor> stockInfo = stockService.getStockItemMap();
    if (stockInfo.containsKey(skuNumber)) {
      this.currentOrderList.add(skuNumber);
      System.out.println("The commodity is moved to orderList");
      return true;
    } else {
      System.out.println("The hard ware you pick is out of stock");
      return false;
    }
  }

  /**
   * Remove Commodity.
   * @param skuNumber A string represent commodity's SKUNUMBER
   * @return A boolean value represent whether it is worked
   */
  public boolean removeOneFromOrder(String skuNumber) {
    boolean result = false;
    String string = "";
    for (String str : this.currentOrderList) {
      if (str.equals(skuNumber)) {
        string = str;
        System.out.println("The commodity has been removed successfully");
        result = true;
      }
    }
    if (result) {
      currentOrderList.remove(string);
      return result;
    }
    System.out.println("There is no such commodity in the current order");
    return false;
  }

  /**
   * Validate whether the measurement system are same.
   * @return A boolean value represents whether it is worked
   */
  public boolean validateMeasurementSystem() {
    Map<String, BasicFactor> stockInfo = stockService.getStockItemMap();
    Set<Measurement> set = new HashSet<>();
    boolean areSameMeasurement = true;
    for (String str : this.currentOrderList) {
      set.add(stockInfo.get(str).getMeasurement());
      if (set.size() > 1) {
        System.out.println("The order includes mixed measurement systems");
        System.out.println("The item's SKU number is " + str
            + " with " + stockInfo.get(str).getMeasurement());
        areSameMeasurement = false;
      }
    }
    return areSameMeasurement;
  }

  /**
   * Remove different commodity by measurement.
   * @param measurement A measurement class
   */
  public void filterByMeasurementSystem(Measurement measurement) {
    Map<String, BasicFactor> stockInfo = stockService.getStockItemMap();
    List<String> wrongMeasurement = new ArrayList<>();
    for (String str : this.currentOrderList) {
      if (!(stockInfo.get(str).getMeasurement().equals(measurement))) {
        System.out.println("The item is not conformed with measurement "
            + "with SKU number:" + str);
        wrongMeasurement.add(str);
      }
    }
    for (String s : wrongMeasurement) {
      this.currentOrderList.remove(s);
    }
  }

  /**
   * A method to print orderCategory.
   * @return A String represent order's category
   */
  public String orderCategory() {
    Map<String, BasicFactor> stockInfo = stockService.getStockItemMap();
    Set<Category> set = new HashSet<>();
    for (String str : this.currentOrderList) {
      set.add(stockInfo.get(str).getCategory());
    }
    if (set.size() == 1) {
      Iterator<Category> iterator = set.iterator();
      while (iterator.hasNext()) {
        Category category = iterator.next();
        return category.toString();
      }
    }
    return "Mixed";
  }

  /**
   * A method to print order commodity.
   */
  public void printDocket() {
    Map<String, BasicFactor> stockInfo = stockService.getStockItemMap();
    int dollarsSum = 0;
    int centsSum = 0;
    for (String str : this.currentOrderList) {
      System.out.println("Category: " + stockInfo.get(str).getCategory().toString()
          + " SKU Number: " + str + " Price: " + stockInfo.get(str).getPrice().getAmount());
      dollarsSum += stockInfo.get(str).getPrice().getDollars();
      centsSum += stockInfo.get(str).getPrice().getCents();
    }
    int count = centsSum / 100;
    dollarsSum += count;
    centsSum %= 100;
    String cent = "";
    if (centsSum < 10) {
      cent += "0";
      cent += String.valueOf(centsSum);
    }
    System.out.println("The total cost is $ " + String.valueOf(dollarsSum)
        + "." + cent);
  }

  /**
   * check whether two commodity are fitted.
   * @param firstSkuNum A string represent first commodity
   * @param secondSkuNum A string represent second commodity
   * @return A boolean value to represent whether if they are fit
   */
  public boolean checkFit(String firstSkuNum, String secondSkuNum) {
    Map<String, BasicFactor> stockInfo = stockService.getStockItemMap();
    String shaftStr = checkIfIsPair(firstSkuNum, secondSkuNum);
    if (shaftStr == null) {
      System.out.println("Not a shaft/shaft-mounted pair");
      return false;
    }
    String shaftMountedStr = shaftStr.equals(firstSkuNum) ? secondSkuNum :
        firstSkuNum;
    if (stockInfo.get(shaftMountedStr).getCategory().equals
        (Category.BALL_BEARING)) {
      if (stockInfo.get(shaftStr).getShaftDiameter().equals
          (stockInfo.get(shaftMountedStr).getShaftDiameter())) {
        System.out.println("Precision Ball Bearings SKU# "
            + shaftMountedStr + "for "
            + stockInfo.get(shaftMountedStr).getShaftDiameter() +
            " shaft fits on Rotary Shafts SKU# " + shaftStr);
        return true;
      } else {
        System.out.println("Precision Ball Bearings SKU# "
            + shaftMountedStr + "for "
            + stockInfo.get(shaftMountedStr).getShaftDiameter() +
            " shaft does not fit on Rotary Shafts SKU# " + shaftStr);
      }
    }
    if (stockInfo.get(shaftMountedStr).getCategory().equals
        (Category.SPROCKET)) {
      if (stockInfo.get(shaftStr).getShaftDiameter().equals
          (stockInfo.get(shaftMountedStr).getShaftDiameter())) {
        System.out.println("Sprocket SKU# "
            + shaftMountedStr + "for "
            + stockInfo.get(shaftMountedStr).getShaftDiameter() +
            "shaft fits on Rotary Shafts SKU# " + shaftStr);
        return true;
      } else {
        System.out.println("Sprocket SKU# "
            + shaftMountedStr + "for "
            + stockInfo.get(shaftMountedStr).getShaftDiameter() +
            "shaft does not fit on Rotary Shafts SKU# " + shaftStr);
      }
    }
    return false;
  }

  /**
   * Check if they are paired
   * @param firstSkuNum first commodity
   * @param SecondSkuNum second commodity
   * @return A string of Rotary Shaft
   */
  public String checkIfIsPair(String firstSkuNum, String SecondSkuNum) {
    Map<String, BasicFactor> stockInfo = stockService.getStockItemMap();
    if (stockInfo.get(firstSkuNum).getCategory().equals(Category.ROTARY_SHAFTS)) {
      if (stockInfo.get(SecondSkuNum).getCategory().equals(Category.ROTARY_SHAFTS)) {
        return null;
      }
    }
    if (stockInfo.get(firstSkuNum).getCategory().equals(Category.ROTARY_SHAFTS)) {
      return firstSkuNum;
    }
    if (stockInfo.get(SecondSkuNum).getCategory().equals(Category.ROTARY_SHAFTS)) {
      return SecondSkuNum;
    }
    return null;
  }
}
