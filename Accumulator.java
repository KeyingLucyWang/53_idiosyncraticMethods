/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.

- Java protects a programmer against applying a method to elements in list when some elements of the list might omit support for a particular operation.

  This protection is implemented by the __Java compiler__. The following attempt to violate the restriction is expected to result in the error _method not found in the given type___.

  [your code]
  Object ele = list.get(i);
  if (ele.startsWith(prefix))
  //the compiler checks the variable type of ele for the method
      result += ele + " ";

  [resulting error message]
  error: cannot find symbol
  if (ele.startsWith(prefix))
	           ^
		   symbol:   method startsWith(String)
		   location: variable ele of type Object




- A programmer should expect to be able to work around the stumbling block because the _JVM_ knows the type of an element.

  Java's _instanceof__ operator identifies the type of an element to the _Java compiler_ 



- Use of the operator alone is insufficient because the __Java compiler___ (Java compiler? JVM?) continues to stumble over the previous stumbling block of protection against mis-applying a method. 

[code that illustrates the use of the operator] 
    for (int i = 0; i < list.size(); i++){
	Object ele = list.get(i);
        if (ele instanceof String)
            if (ele.startsWith(prefix))
                result += ele + " ";
predicted error message: 
    startsWith() method is not found in Object class (ele's variable type)
[resulting error message]
    error: cannot find symbol
        if (ele.startsWith(prefix))
		       ^
		       symbol:   method startsWith(String)
		       location: variable ele of type Object


Java provides a _casting_ facility that a programmer uses to tell the _Java compiler_ that they are using a subclass's method on an object for which a reference is stored in a super-type variable. 

[code that illustrates the use of the operator] 
    Object ele = list.get(i);
    if (((String)ele).startsWith(prefix))
	    result += ele + " ";

But use of that facility alone is insufficient because the _JVM_ stumbles over _some specific types of the Object in list cannot be casted to String_ (20–40 words). 

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
    // public static List_inArraySlots finites(
        // List_inArraySlots list
      // ) {
    // }
}
