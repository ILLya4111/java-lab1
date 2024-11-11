import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main class that demonstrates filtering, grouping, statistical analysis,
 * and price analysis of a list of clothes.
 */
public class Main {

  /**
   * Main entry point of the program.
   */
  public static void main(String[] args) {
    int N = 10;

    List<ClothingItem> clothingItems = ClothingGenerator.generateClothingItems()
        .gather(new ClothingGatherer(N, "Lviv"))
        .limit(500)
        .toList();
    for (ClothingItem clothingItem : clothingItems) {
      System.out.println(clothingItem);
    }

    Map<String, List<ClothingItem>> groupedClothingItems = clothingItems.stream()
        .filter(item -> item.manufacturingDate().isAfter(LocalDate.now().minusMonths(60)))
        .collect(Collectors.groupingBy(ClothingItem::fabricType));
    for (Map.Entry<String, List<ClothingItem>> entry : groupedClothingItems.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue().size());
    }

    ClothingStatistics statistics = clothingItems.stream()
        .collect(new ClothingStatisticsCollector());
    System.out.println(statistics);

    Map<String, Long> priceAnalysis = PriceAnalysis.analyzePrices(clothingItems);
    System.out.println(priceAnalysis);
  }
}
