package edu.itpu.comparator;

import de.vandermeer.asciitable.AsciiTable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class NPC {
  private String name;
  private String lastName;
  private String race;
  private String region;
  private String city;

  //region Tech Stuff
  private static final AtomicInteger idSeq = new AtomicInteger(1);

  private final int id = idSeq.getAndIncrement();
  
  private static final List<String> fields = List.of("id", "name", "lastName", "race", "region", "city");

  public static void addHeader(AsciiTable table) {
    Objects.requireNonNull(table);
    table.addRow(fields);
    table.addRule();
    table.addRule();
  }

  private void addToTable(AsciiTable table) {
    Objects.requireNonNull(table);
    table.addRow(
        Objects.toString(id),
        Objects.toString(name),
        Objects.toString(lastName),
        Objects.toString(race),
        Objects.toString(region),
        Objects.toString(city)
    );
  }
  
  public static void addToTable(AsciiTable table, NPC npc) {
    Objects.requireNonNull(table);
    Optional.ofNullable(npc)
        .ifPresentOrElse(
            n -> n.addToTable(table),
            () -> table.addRow(Collections.nCopies(fields.size(), "null"))
        );
  }
  //endregion
  
  //region Generated Stuff
  public NPC() {
  }

  public String getName() {
    return this.name;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getRace() {
    return this.race;
  }

  public String getRegion() {
    return this.region;
  }

  public String getCity() {
    return this.city;
  }

  public int getId() {
    return this.id;
  }

  public NPC setName(String name) {
    this.name = name;
    return this;
  }

  public NPC setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public NPC setRace(String race) {
    this.race = race;
    return this;
  }

  public NPC setRegion(String region) {
    this.region = region;
    return this;
  }

  public NPC setCity(String city) {
    this.city = city;
    return this;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof final NPC other)) {
      return false;
    }
    if (!other.canEqual(this)) {
      return false;
    }
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (!Objects.equals(this$name, other$name)) {
      return false;
    }
    final Object this$lastName = this.getLastName();
    final Object other$lastName = other.getLastName();
    if (!Objects.equals(this$lastName, other$lastName)) {
      return false;
    }
    final Object this$race = this.getRace();
    final Object other$race = other.getRace();
    if (!Objects.equals(this$race, other$race)) {
      return false;
    }
    final Object this$region = this.getRegion();
    final Object other$region = other.getRegion();
    if (!Objects.equals(this$region, other$region)) {
      return false;
    }
    final Object this$city = this.getCity();
    final Object other$city = other.getCity();
    return Objects.equals(this$city, other$city);
  }

  protected boolean canEqual(final Object other) {
    return other instanceof NPC;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    final Object $lastName = this.getLastName();
    result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
    final Object $race = this.getRace();
    result = result * PRIME + ($race == null ? 43 : $race.hashCode());
    final Object $region = this.getRegion();
    result = result * PRIME + ($region == null ? 43 : $region.hashCode());
    final Object $city = this.getCity();
    result = result * PRIME + ($city == null ? 43 : $city.hashCode());
    result = result * PRIME + this.getId();
    return result;
  }

  public String toString() {
    return "NPC(name=" + this.getName() + ", lastName=" + this.getLastName() + ", race=" + this.getRace() + ", region="
        + this.getRegion() + ", city=" + this.getCity() + ", id=" + this.getId() + ")";
  }
  //endregion
}
