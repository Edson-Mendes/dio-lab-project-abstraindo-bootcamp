package br.com.emendes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Classe que representa um curso.
 */
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Course extends Content {

  private int workload;

  @Override
  public double calcXp() {
    return DEFAULT_XP * workload;
  }

  @Override
  public String toString() {
    return "Course{title='%s', description='%s', workload=%d}".formatted(getTitle(), getDescription(), this.workload);
  }

}
