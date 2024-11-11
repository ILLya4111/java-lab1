import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Generates random ClothingItem objects using Stream API.
 */
public class ClothingGenerator {

  private static final String[] NAMES = {"Shirt", "Pants", "Jacket", "Dress", "Sweater"};
  private static final String[] FABRIC = {"Cotton", "Wool", "Silk", "Polyester", "Linen"};
  private static final String[] CITIES = {"Kyiv", "Lviv", "Odesa", "Kharkiv", "Dnipro"};

  /**
   * Generates a stream of random clothes.
   *
   * @return A stream of clothes.
   */
  public static Stream<ClothingItem> generateClothingItems() {

    Random random = new Random();
    return Stream.generate(() -> new ClothingItem(
        NAMES[random.nextInt(NAMES.length)],
        FABRIC[random.nextInt(FABRIC.length)],
        CITIES[random.nextInt(CITIES.length)],
        LocalDate.now().minusMonths(random.nextInt(240)),
        100 + random.nextInt(1000)
    ));
  }
}
