package br.com.emendes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * Classe que representa uma mentoria.
 */
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Mentoring extends Content {

  private LocalDate date;

  @Override
  public double calcXp() {
    return DEFAULT_XP * 20d;
  }

  @Override
  public String toString() {
    return "Course{title='%s', description='%s', date='%s'}".formatted(getTitle(), getDescription(), this.date);
  }

}
