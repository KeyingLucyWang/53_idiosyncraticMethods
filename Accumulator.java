/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.

  3.  Stmbling block 0
  Java protects a programmer against applying a method to
  elements in list when some elements of the list might
  omit support for a particular operation.

  This protection is implemented by the __Java compiler__. 
  The following code violates the restriction:

  Object ele = list.get(i);
  if (ele.startsWith(prefix))
  //the compiler checks the variable type of ele for the method
      result += ele + " ";

  [predicted error message]
  The startsWith method is not found in the Object class, of which ele is an instance of.

  [actual error message]
  error: cannot find symbol
  if (ele.startsWith(prefix))
	           ^
		   symbol:   method startsWith(String)
		   location: variable ele of type Object




  4.  Workaround 0
  A programmer should expect there to be a way to
  work around the stumbling block, because
  the ___JVM___ knows the type of an element.

  Java's _instanceof__ operator identifies the type 
  of an element to the _JVM_.



  5. Stumbling block 1
  However, use of the operator alone is insufficient,
  because the __Java compiler___
  objects to the following code that adds use of
  the operator to the code from Stumbling block 0:

    for (int i = 0; i < list.size(); i++){
	   Object ele = list.get(i);
        if (ele instanceof String)
            if (ele.startsWith(prefix))
                result += ele + " ";

[predicted error message] 
    startsWith() method is not found in Object class (ele's variable type)
[resulting error message]
    error: cannot find symbol
        if (ele.startsWith(prefix))
		       ^
		       symbol:   method startsWith(String)
		       location: variable ele of type Object


  6.  Workaround 1
  Programmers use Java's ___cast____ operator
  to tell the __compiler__
  that code uses a subclass's method on an object,
  even though the reference to the object is stored
  in a super-class variable.
 
[code that illustrates the use of the operator] 
    Object ele = list.get(i);
    if (((String)ele).startsWith(prefix))
	    result += ele + " ";

  7. Stumbling block 2
  But use of this operator alone is insufficient, 
  because the __JVM__ objects to the following code that adds use of
  the operator to the code from Stumbling block 0:

  Object ele = list.get(i);
    if (((String)ele).startsWith(prefix))
      result += ele + " ";

predicted error message: 
the cast from Double to String is not applicable

[resulting error message]
java.base/java.lang.Double cannot be cast to java.base/java.lang.String
	at Accumulator.catElementsStartingWith(Accumulator.java:85)
	at UserOfList.main(UserOfList.java:72)


A programmer can combine use of the operator and the facility to apply a method to exactly those elements in the list that support the method. 

[working code here, finally]
    Object ele = list.get(i);
	    if (ele instanceof String)
		    if (((String)ele).startsWith(prefix))
		      result += ele + " ";
	}
 */

public class Accumulator {

    /**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
     */
    public static String catElementsStartingWith(
        List_inArraySlots list
      , String prefix
      ) {
      String result = "";
      for (int i = 0; i < list.size(); i++){
        Object ele = list.get(i);
        if (ele instanceof String)
          if (((String)ele).startsWith(prefix))
            result += ele + " ";
        }
        return result; 
      }


    /**
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
    public static List_inArraySlots finites(
        List_inArraySlots list
      ) {
      List_inArraySlots newList = new List_inArraySlots();
      for (int i = 0; i < list.size(); i++){
        Object ele = list.get(i);
        if (ele instanceof Double)
          if (!(((Double)ele).isInfinite()))
            newList.add(ele);
        }
        return newList;
      }
    }
