package br.com.emendes.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Classe que representa um conteúdo
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
public abstract class Content {

  protected static final double DEFAULT_XP = 10d;

  private String title;
  private String description;

  /**
   * Calcula o xp ganho ao concluir este conteúdo.
   *
   * @return xp ganho ao concluir este conteúdo.
   */
  public abstract double calcXp();

}
