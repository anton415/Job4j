package ru.aserdyuchenko.convertListToMap;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com   +7 (916) 154-92-00)
 */
import java.util.*;

class UserConvert {
  /**
   * Метод конвертирует List в Map.
   */
  public HashMap<Integer, User> process(List<User> list) {
    HashMap<Integer, User> map = new HashMap<Integer, User>();
    int i = 0;
    for (User user: list) {
      map.put(i, user);
      i++;
    }
    return map;
  }
}
