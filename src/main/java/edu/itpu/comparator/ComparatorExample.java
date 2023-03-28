package edu.itpu.comparator;

import com.github.javafaker.ElderScrolls;
import com.github.javafaker.Faker;
import de.vandermeer.asciitable.AsciiTable;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class ComparatorExample {
  
  public static void main(String[] args) {
    var npcs = generateNPCs(5);
    printAsTable(npcs);
  }
  
  //region Tech Stuff
  private static final Random rnd = new Random(42L);
  private static final ElderScrolls gen = Faker.instance(rnd).elderScrolls();
  
  private static void printAsTable(Collection<NPC> npcs) {
    var table = new AsciiTable();
    table.addRule();
    NPC.addHeader(table);
    npcs.forEach(npc -> {
      NPC.addToTable(table, npc);
      table.addRule();
    });
    System.out.println(table.render());
  }
  
  private enum NullifyingMode {
    WHOLE,
    RACE,
    REGION
  }
  
  private static List<NPC> randomNullify(List<NPC> npcs, Set<NullifyingMode> modes) {
    return npcs.stream()
        .map(npc -> switch (rnd.nextInt(5)) {
          case 0 -> modes.contains(NullifyingMode.WHOLE) ? null : npc;
          case 1 -> modes.contains(NullifyingMode.RACE) ? npc.setRace(null) : npc;
          case 2 -> modes.contains(NullifyingMode.REGION) ? npc.setRegion(null) : npc;
          default -> npc;
        })
        .toList();
  }
  
  @SuppressWarnings("all")
  private static List<NPC> generateNPCs(int size) {
    return Stream.generate(ComparatorExample::generateNPC)
        .limit(size)
        .toList();
  }
  
  private static NPC generateNPC() {
    return new NPC()
        .setName(gen.firstName())
        .setLastName(gen.lastName())
        .setRace(gen.race())
        .setRegion(gen.region())
        .setCity(gen.city());
  }
  //endregion
}
