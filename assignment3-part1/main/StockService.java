package edu.neu.ccs.cs5010.assignment3.part1;

import edu.neu.ccs.cs5010.assignment2.BasicFactor;
import java.util.Map;

/**
 * A class represent stock service.
 */
public class StockService {

  private Map<String, BasicFactor> stockItemMap;

  StockService(Map<String, BasicFactor> stockItemMap) {
    this.stockItemMap = stockItemMap;
  }

  /**
   * stock item getter.
   * @return Map represents stock item
   */
  public Map<String, BasicFactor> getStockItemMap() {
    return stockItemMap;
  }

  public void setStockItemMap(Map<String, BasicFactor> stockItemMap) {
    this.stockItemMap = stockItemMap;
  }
}
