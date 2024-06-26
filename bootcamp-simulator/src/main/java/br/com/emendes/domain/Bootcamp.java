package br.com.emendes.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.util.*;

/**
 * Classe que representa um bootcamp.
 */
public class Bootcamp {
  @Getter
  private final String name;
  @Getter
  private final String description;
  @Getter
  private final LocalDate startDate;
  @Getter
  private final LocalDate endDate;
  private final Set<Dev> subscribedDevs;
  private final Set<Content> contents;

  public Bootcamp(String name, String description, LocalDate startDate, LocalDate endDate) {
    this.name = name;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    subscribedDevs = new HashSet<>();
    contents = new LinkedHashSet<>();
  }

  public void subscribeDev(Dev dev) {
    subscribedDevs.add(dev);
  }

  public void addContent(Content content) {
    contents.add(content);
  }

  public Set<Dev> getSubscribedDevs() {
    return Collections.unmodifiableSet(subscribedDevs);
  }

  public Set<Content> getContents() {
    return Collections.unmodifiableSet(contents);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Bootcamp bootcamp = (Bootcamp) o;
    return Objects.equals(name, bootcamp.name) &&
           Objects.equals(description, bootcamp.description) &&
           Objects.equals(startDate, bootcamp.startDate) &&
           Objects.equals(endDate, bootcamp.endDate);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(name);
    result = 31 * result + Objects.hashCode(description);
    result = 31 * result + Objects.hashCode(startDate);
    result = 31 * result + Objects.hashCode(endDate);
    return result;
  }

  @Override
  public String toString() {
    return "Bootcamp{name='%s', description='%s', startDate='%s', endDate='%s', totalContent=%d, totalDevs=%d}"
        .formatted(this.name, this.description, this.startDate, this.endDate, this.contents.size(), this.subscribedDevs.size());
  }

}
