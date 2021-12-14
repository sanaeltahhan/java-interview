package async;

import io.vavr.control.Option;

class Ceo implements Option<Ceo> {
  String id;
  String name;


  public Ceo(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Ceo() {
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public String stringPrefix() {
    return null;
  }

  @Override
  public Ceo get() {
    return null;
  }

  public String toString() {return "Ceo_" + name;}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
