<<<<<<< HEAD:src/main/java/com/TheRPGAdventurer/ROTD/entity/helper/util/Pair.java
package com.TheRPGAdventurer.ROTD.entity.helper.util;
=======
package com.TheRPGAdventurer.ROTD.entity.entitytameabledragon.helper.util;
>>>>>>> 487f066b... changes:src/main/java/com/TheRPGAdventurer/ROTD/entity/entitytameabledragon/helper/util/Pair.java

/**
 * User: The Grey Ghost
 * Date: 12/07/2014
 * very simple class to group two objects into a pair
 */
public final class Pair<A, B>
{
  public Pair(A i_first, B i_second) {
    first = i_first;
    second = i_second;
  }

  public A getFirst() {
    return first;
  }

  public B getSecond() {
    return second;
  }

  public void setFirst(A first) {
    this.first = first;
  }

  public void setSecond(B second) {
    this.second = second;
  }

  private A first;
  private B second;

  @Override
  public String toString() {
    return "(" + first + "," + second + ")";
  }

}