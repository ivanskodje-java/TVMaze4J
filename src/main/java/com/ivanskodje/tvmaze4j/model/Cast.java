package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Cast {
  private Person actor;
  private Person character;

  @Override
  public String toString() {
    return "'" + actor.getName() + "' portraying the role as '" + character.getName() + "'";
  }
}
