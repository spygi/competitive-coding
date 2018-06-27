package strings;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleExpressions {
    /*
    function:
        input: string of digits (eg. "123")
        outputs: all the expressions and their evaluation that you can generate by inserting + or - in the string

    ex:
    input: 123
    output:
        123 = 123
        12 + 3 = 15
        12 - 3 = 9
        1 + 23 = 24
        1 - 23 = -22
        1 + 2 + 3 = 6
        1 + 2 - 3 = 0
        1 - 2 + 3 = 2
        1 - 2 - 3 = -4
*/

    public static void problem(String num) {
        // generate seq
        List<String> sequences = new ArrayList<>();

        for (int j = 0; j < num.length(); j++) {
            if (sequences.isEmpty()) {
                sequences.add(num.charAt(j) + "");
            } else {
                List<String> next = new ArrayList<>();
                for (String seq : sequences) {
                    next.add(seq + num.charAt(j));
                    next.add(seq + "+" + num.charAt(j));
                    next.add(seq + "-" + num.charAt(j));
                }
                sequences = next;
            }
        }

        // and evaluate
        /*
        split(\d[+-]?) -> [123, +, 456, -, 78]
        if index%2==0 Integer.parseInt
        index - 1
        */
    }

    public static void main(String[] args) {

    }
}
