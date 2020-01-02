package io.simpolor.quiz.doit.chapter11;

enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;
}

/*
final class Season extends Enum<Season> {
  public static final Season[] values() {
    return (Season[])$VALUES.clone();
  }

  public static Season valueOf(String s){
    return (Season)Enum.valueOf(Season, s)
  }

  private Season(String s, int i){
    super(s, i);
  }

  public static final Season SPRING;
  public static final Season SUMMER;
  public static final Season AUTUMN;
  public static final Season WINTER;
  private static final Season $VALUES[];

  static {
    SPRING = new Season("SPRING", 0);
    SUMMER = new Season("SUMMER", 1);
    AUTUMN = new Season("AUTUMN", 2);
    WINTER = new Season("WINTER", 3);
    $VALUES = ( new Season[] {
        SPRING, SUMMER, AUTUMN, WINTER
    })
  }
}
*/
