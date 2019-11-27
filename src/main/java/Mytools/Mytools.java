package Mytools;

public class Mytools {
  static int temp;

  public Mytools() {
  }

  public static void Swap(int var0, int var1) {
    temp = var0;
    var1 = temp;
  }

  public static void Swap(int[] var0, int var1, int var2) {
    temp = var0[var1];
    var0[var1] = var0[var2];
    var0[var2] = temp;
  }
}

