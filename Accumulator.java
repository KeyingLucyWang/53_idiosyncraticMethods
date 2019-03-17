/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
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
	/* 3.  Stumbling block 0
	    Java protects a programmer against applying a method to elements in list when some elements of the list might omit support for a particular operation.

	    if (ele instanceof String)
		if (((String)ele).startsWith(prefix))
		    result += ele + " ";
	}
	    This protection is implemented by the __Java compiler__. The following attempt to violate the restriction is expected to result in the error _method not found in the given type___.

	    The following code violates the restriction:
              */
            // [code that violates the restriction]
	// if (ele.startsWith(prefix))
	//     //the compiler checks the variable type of ele for the method
	//     result += ele + " ";
	/*
             predicted error message:
	     method startsWith() is not found in Object class
             actual error message:
	     error: cannot find symbol
	     if (ele.startsWith(prefix))
	           ^
		   symbol:   method startsWith(String)
		   location: variable ele of type Object

             */
	 

            /* 4.  Workaround 0
               A programmer should expect to be able to work around the stumbling block because the _JVM_ knows the type of an element.

  Java's _instanceof__ operator identifies the type of an element to the _Java compiler_ 
             */


            /* 5.  Stumbling block 1
	       However, use of the operator alone is insufficient,
               because the _compiler_ (compiler? JVM?)
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:
             */

            // [code that illustrates the use of the operator]
        // if (ele instanceof String)
        //     if (ele.startsWith(prefix))
        //         result += ele + " ";
            /*
             predicted error message:
startsWith() method is not found in Object class (ele's variable type)
             actual error message:
	     error: cannot find symbol
	     if (ele.startsWith(prefix))
		       ^
		       symbol:   method startsWith(String)
		       location: variable ele of type Object
             */


            /* 6. Workaround 1
	    Programmers use Java's _cast__ operator
               to tell the __compiler__ (compiler? JVM?)
               that code uses a subclass's method on an object,
               even though the reference to the object is stored
               in a super-class variable.
             */


            /* 7. Stumbling block 2
               However, use of this operator alone is insufficient,
               because the _JVM_ (compiler? JVM?)
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:
             */

            // [code that illustrates the use of the operator]
	    // if (((String)ele).startsWith(prefix))
	    // 	result += ele + " ";
            /*
             predicted error message:
	     the cast from Double to String is not applicable

	     actual error message:
	     java.base/java.lang.Double cannot be cast to java.base/java.lang.String
	at Accumulator.catElementsStartingWith(Accumulator.java:85)
	at UserOfList.main(UserOfList.java:72)
             
             */


            /* 8. Workaround 2
               A programmer can combine use of both operators
               to apply a method to exactly those
               elements in the list that support the method.
             */

            // [working code here, finally]
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
