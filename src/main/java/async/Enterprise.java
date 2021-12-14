package async;

import io.vavr.control.Option;

class Enterprise implements Option<Enterprise> {
  String id;
  String name;
  String ceo_id;

  public Enterprise(String id, String name, String ceo_id) {
    this.id = id;
    this.name = name;
    this.ceo_id = ceo_id;
  }

  public Enterprise() {
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
  public Enterprise get() {
    return null;
  }

  public String toString() {return "Enterprise_" + name;}

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

  public String getCeo_id() {
    return ceo_id;
  }

  public void setCeo_id(String ceo_id) {
    this.ceo_id = ceo_id;
  }
}
