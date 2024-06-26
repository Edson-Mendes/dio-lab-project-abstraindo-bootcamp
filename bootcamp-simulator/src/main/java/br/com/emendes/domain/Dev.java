package br.com.emendes.domain;

import lombok.Getter;

import java.util.*;

/**
 * Classe para representar um aluno developer.
 */
public class Dev {

  private static int idSequence = 100;

  @Getter
  private final int id;
  @Getter
  private final String name;
  private final Set<Content> subscribedContent;
  private final Set<Content> concludedContent;

  public Dev(String name) {
    this.name = name;
    this.id = idSequence++;
    subscribedContent = new LinkedHashSet<>();
    concludedContent = new LinkedHashSet<>();
  }

  public void toProgress() {
    Optional<Content> contentOptional = subscribedContent.stream().findFirst();

    contentOptional.ifPresentOrElse(
        content -> {
          subscribedContent.remove(content);
          concludedContent.add(content);
        },
        () -> System.err.println("your are not subscribed at none content"));
  }

  public void addContent(Content content) {
    subscribedContent.add(content);
  }

  public Set<Content> getSubscribedContent() {
    return Collections.unmodifiableSet(subscribedContent);
  }

  public Set<Content> getConcludedContent() {
    return Collections.unmodifiableSet(concludedContent);
  }

  @Override
  public String toString() {
    return "Dev{" +
           "name='" + name + '\'' +
           ", subscribedContent=" + subscribedContent +
           ", concludedContent=" + concludedContent +
           '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Dev dev = (Dev) o;
    return id == dev.id && Objects.equals(name, dev.name);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + Objects.hashCode(name);
    return result;
  }
}
