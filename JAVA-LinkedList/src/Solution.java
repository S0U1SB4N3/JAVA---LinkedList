import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int groupCount = 0;
        System.out.println("Enter 3 Collections of course codes: one collection per line:"+
                "\nExample Course Codes: IT345 IT236 IT678 IT123");
        System.out.println("");

        Scanner scan = new Scanner(System.in);

        scan.useLocale(Locale.US);
        while (groupCount < 3) {
            String[] collectCourses = scan.nextLine().split("\\s+");
            LinkedList<String> courses = new LinkedList<String>();
            for (int i = 0; i < collectCourses.length; i++) {
                addInOrder(courses, collectCourses[i]);
            }

            groupCount++;
            // System.out.println("Gc: " + groupCount); // for debugging only
            printList(courses);
        }
        scan.close();
        //  System.out.println("Program Ended"); // for debugging only

    }

    public static void printList(LinkedList<String> coursesList){
        Iterator<String> i = coursesList.iterator();
        int count = 0;
        String str = "";
        while (i.hasNext()){
            str += i.next() + " ";
            count++;
        }
        System.out.println("Size: " + count + " Sorted: " + str.trim());
        System.out.println("");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCourse) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCourse);

            if (comparison == 0) {
                //is equal do not add to list
                System.out.println(newCourse + " is already in the list.");
                return false;

            } else if (comparison > 0) {
                // it needs to be inserted before this result in the list
                stringListIterator.previous(); // to go back one
                stringListIterator.add(newCourse); // now add item to list
                return true;

            } else if (comparison < 0) {
                /* move to next item in list and check again.
                So we do nothing here */
            }

        }

        stringListIterator.add(newCourse);
        return true;
    }

}

