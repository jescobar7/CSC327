// 2004 ACM Mid-Central Regional Programming Contest
// Problem B: Triangle Cuts
// by Andy Harrington, Loyola University Chicago
/*
triangle.java

Problem: Imagine making straight cuts all the way across pieces of paper.
 Given the vertex angles of a triangle, determine if you can start with
 the triangle, and make three such cuts, and end up with exactly 4 pieces
 of paper, all triangles, whose angles are as specified.  Assume that no piece
 of paper is flipped over, and all angles are specified in clockwise order.

Algorithm:
 The basic approach is to combine triangles into new triangles, and
 maintain lists of the possible triangles created.
 There are four main cases based on the outermost split into subtriangles:
   (1+1) + (1+1)
   1 + (1 + (1+1))
   4 triangles in one : two patterns shown in the problem
                 (outline of justification in notes.html)

 The program must also make sure that all rotations of any triangle are
 checked as are all permutations of parameter lists of triangles.
 The base triangles and the combined triangles are managed differently in
 the reguard:  all permutations and rotations of the 4 base triangles are
 generated in outer loops, hence avoiding the need for them to be rotated and
 permuted in methods that combine them.  Rotations of combinations of all four
 triangles are avoided by finally rotating the triangle they fit in (bigT).

 As larger triangles are built up, a consistent assumption maintained is that
 the parameter triangles appear in multiple calls covering all vertex rotations.
 This is already arranged for if the triangles are base triangles. Combinations
 of 2 triangles are always explicitly rotated all three ways when they are
 produced.  When two triangles are put together, both permutations of the
 parameters are explicitily considered in one call.  When four triangles are put
 together at once, all permutations of the parameters are considered between
 multiple calls that rearrange the base triangles every possible way.

 See the accompanying notes.html to display geometries.gif, which shows the
 index scheme used for the tests, referenced in comments by 'pic n', n = 1 to 4.
 */

import java.io.*;
import java.util.*;

public class triangle {

  static int[] bigT; //outer triangle angles in array of three ints

  public static void main(String[] arg) {
    String FILE = "triangle";
    ACMIO in = new ACMIO(FILE + ".in");
    PrintWriter out = null;
    try {
      out = new PrintWriter(
              new BufferedWriter(
                new FileWriter(FILE + ".out")));
    } catch(Exception e) {
        System.out.println("can't open output");
    }
    bigT = newTri(in);
    while(bigT[0] != 0) {
      int[] a = newTri(in), b = newTri(in), c = newTri(in), d = newTri(in);
      // since there are exactly 4 triangles, all permutations can be easily
      //   written down:
      if (fits(a,b,c,d) || fits(b,a,c,d) || fits(c,a,b,d) || fits(d,a,b,c) ||
          fits(a,b,d,c) || fits(b,a,d,c) || fits(c,a,d,b) || fits(d,a,c,b) ||
          fits(a,c,b,d) || fits(b,c,a,d) || fits(c,b,a,d) || fits(d,b,a,c) ||
          fits(a,c,d,b) || fits(b,c,d,a) || fits(c,b,d,a) || fits(d,b,c,a) ||
          fits(a,d,b,c) || fits(b,d,a,c) || fits(c,d,a,b) || fits(d,c,a,b) ||
          fits(a,d,c,b) || fits(b,d,c,a) || fits(c,d,b,a) || fits(d,c,b,a) )
        out.println("yes");
      else
        out.println("no");
      bigT = newTri(in);
    } // end of dataset
    out.close();
  }

  static int[] newTri(ACMIO in) { // make a new triangle from input
    int[] v = new int[] {in.intRead(), in.intRead(), in.intRead()};
    if (v[0] + v[1] + v[2] != 180) System.out.println("Bad sum");
    return v;
  }

  static boolean fits(int[] a, int[] b, int[] c, int[] d) { //true if solved
    for (int ia = 0; ia < 3; ia++) { // consider all rotations of all triangles
      a = rot(a);
      for (int ib = 0; ib < 3; ib++) {
        b = rot(b);
        for (int ic = 0; ic < 3; ic++) {
          c = rot(c);
          for (int id = 0; id < 3; id++) {
            d = rot(d);

            // names indicate which triangles are joined into one larger one
            ArrayList jABCD = new ArrayList(), jABC = new ArrayList(),
                jAB = new ArrayList(), jCD = new ArrayList();

            join2(jAB, a, b);  // list used several times

            // 1. split in two parts, each with two triangles
            join2(jCD, c, d);
            join2(jABCD, jAB, jCD);

            // 2. split in two parts, 1 with 1 triangle (d), one with three(abc)
            join2(jABC, jAB, c);  //  2 tri + 1
            join2(jABCD, jABC, d);

            // Four together, not first cut into 2 triangles, as in examples
            // 3.  judge's notes pic 3:  no cuts through an original vertex
            if ( 180 == a[1]+b[2]+d[1] && 180 == b[1]+c[2]+d[2] &&
                 180 == c[1]+a[2]+d[0] )
              jABCD.add(new int[] {a[0], b[0], c[0]});

            // 4.  judge's notes pic 4:  cuts part way from original vertices
            if (180 == b[1]+d[1] && 180 == c[2]+d[2] && 180 == a[0]+b[0]+c[0])
              jABCD.add(new int[] {d[0], a[1]+b[2], a[2]+c[1]});

            for (int nRot = 0; nRot < 3; nRot++) { // check against outer tri
              bigT = rot(bigT);                           //  all rotations
              for (int i = jABCD.size() - 1; i >= 0; i--) {
                int[] v = (int[])jABCD.get(i);
                if (v[0] == bigT[0] && v[1] == bigT[1] && v[2] == bigT[2])
                  return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  static int[] rot(int[] v) { // return a new vector, rotating indices one place
    return new int[] {v[1], v[2], v[0]};
  }

  static void addRot(List join, int[] v) { // add all rotations of v to the list
    for (int i = 0; i < 3; i++) {
      join.add(v);
      v = rot(v);
    }
  }

  // Create a list of all rotations of triangles that can be formed from a and b
  //   in either order.
  // Assume all rotations of vertices of a, b are supplied in separate calls.
  static void join2(List joins, int[] a, int[] b) {
    if (a[2] + b[0] == 180) {
        addRot(joins, new int[] {a[0], a[1] + b[1], b[2]}); // judge notes pic 1
        addRot(joins, new int[] {a[1], b[1], a[0] + b[2]}); // judge notes pic 2
    }
  }

  // repeatedly add joined triangles to the list
  static void join2(List joins, List aList, int[] b) {
    for (int i = aList.size() - 1; i >= 0; i--)
      join2(joins, (int[])aList.get(i), b);
  }

  // double loop to join triangles and add to the list
  static void join2(List joins, List aList, List bList) {
    for (int i = bList.size() - 1; i >= 0; i--)
      join2(joins, aList, (int[])bList.get(i));
  }
} // end of class triangle
