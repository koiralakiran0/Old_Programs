package de.vogella.algorithms.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
  public static List<Long> primeFactors(long number) {
    int n = number;
    List<Long> factors = new ArrayList<Long>();
    for (int i = 2; i <= n; i++) {
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }
    return factors;
  }

  public static void main(String[] args) {
    System.out.println("Primefactors of 44");
    for (Integer integer : primeFactors(44)) {
      System.out.println(integer);
    }
    System.out.println("Primefactors of 3");
    for (Integer integer : primeFactors(3)) {
      System.out.println(integer);
    }
    System.out.println("Primefactors of 32");
    for (Integer integer : primeFactors(32)) {
      System.out.println(integer);
    }
  }
} 