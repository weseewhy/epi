/*
MULTIPLY TWO ARBITRARY-PRECISION INTEGERS

Write a program that takes two arrays representing integers, and re¬ turns an integer representing their product.

For example, since 193707721 X -761838257287 = -147573952589676412927, if the inputs are
(1,9,3,7,0,7,7,2,1} and (-7,6,1,8,3,8,2,5,7,2,8,7), return (-1,4,7,5,7,3,9,5,2,5,8,9,6,7,6,4,1,2,9,2,7).
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> multiply(List<Integer> n1, List<Integer> n2) {
        boolean isNegative = false;
        if (n1.get(0) < 0) {
            isNegative = true;
            n1.set(0, Math.abs(n1.get(0)));
        }

        if (n2.get(0) < 0) {
            isNegative = !isNegative;
            n2.set(0, Math.abs(n2.get(0)));
        }

        List<Integer> big = n1.size() >= n2.size() ? n1 : n2;
        List<Integer> small = n1.size() < n2.size() ? n1 : n2;

        List<Integer> out = new ArrayList<>();
        List<Integer> row;
        for (int i = small.size() - 1; i >= 0; i--) {
            row = mulAndGetRow(big, small, i);
            accumulateSum(out, row);
        }

        if (isNegative) {
            out.set(0, out.get(0) * -1);
        }

        return out;
    }

    private List<Integer> mulAndGetRow(List<Integer> big, List<Integer> small, int indexFromSmall) {
        int num = small.get(indexFromSmall);
        if (num == 0) {
            return Collections.emptyList();
        }

        List<Integer> row = new ArrayList<>();
        int mul;
        int carry = 0;
        for (int i = big.size() - 1; i >= 0; i--) {
            mul = num * big.get(i) + carry;
            row.add(mul % 10);
            carry = mul / 10;
        }

        if (carry > 0) {
            row.add(carry);
        }

        Collections.reverse(row);

        int numOfZeroes = small.size() - 1 - indexFromSmall;
        while (numOfZeroes-- > 0) {
            row.add(0);
        }

        return row;
    }

    private void accumulateSum(List<Integer> rowSum, List<Integer> row) {
        int sum;
        int carry = 0;

        int i = rowSum.size() - 1;
        int j = row.size() - 1;

        while (i >= 0 || j >= 0) {
            sum = (i >= 0 ? rowSum.get(i) : 0)
                    + (j >= 0 ? row.get(j) : 0)
                    + carry;

            if (i >= 0) {
                rowSum.set(i, sum % 10);
            } else {
                rowSum.add(0, sum % 10);
            }
            carry = sum / 10;
            i--;
            j--;
        }

        if (carry > 0) {
            rowSum.add(0, carry);
        }
    }

    /****************************************************/
    /****************** NO EXTRA SPACE ******************/
    /****************************************************/
    public List<Integer> multiply_Optimized(List<Integer> n1, List<Integer> n2) {
        boolean isNegative = false;
        if (n1.get(0) < 0) {
            isNegative = true;
            n1.set(0, Math.abs(n1.get(0)));
        }

        if (n2.get(0) < 0) {
            isNegative = !isNegative;
            n2.set(0, Math.abs(n2.get(0)));
        }

        List<Integer> out = new ArrayList<>(n1.size() + n2.size());
        for (int i = 0; i < n1.size() + n2.size(); i++) {
            out.add(0);
        }

        for (int i = n1.size() - 1; i >= 0; i--) {
            for (int j = n2.size() - 1; j >= 0; j--) {
                out.set(i + j + 1, out.get(i + j + 1) + n1.get(i) * n2.get(j));
                out.set(i + j, out.get(i + j) + out.get(i + j + 1) / 10);           // carry
                out.set(i + j + 1, out.get(i + j + 1) % 10);
            }
        }

        int firstNonZero = 0;
        while (firstNonZero < out.size() && out.get(firstNonZero) == 0) {
            firstNonZero++;
        }

        if (firstNonZero >= out.size()) {
            return Collections.singletonList(0);
        }

        out = out.subList(firstNonZero, out.size());
        if (isNegative) {
            out.set(0, out.get(0) * -1);
        }

        return out;
    }
}
