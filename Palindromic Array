An array is called palindromic if it remains the same after reversing the order of its elements.

You have an array of strings arr. For each i, arr[i] consists of at least two characters. For each pair of consecutive elements arr[i] and arr[i + 1], you can:

Move the rightmost character of arr[i] to the leftmost position in arr[i + 1]. For instance, "abc" and "def" will become "ab" and "cdef". This operation can be applied only once to any pair of consecutive elements.
Move the leftmost character of arr[i + 1] to the rightmost position in arr[i]. For instance, "abc" and "def" will become "abcd" and "ef". Again, this operation can be applied only once to any pair of consecutive elements.
Do nothing to the pair of consecutive elements.
Is it possible to obtain a palindromic array from arr by performing these operations?

Example

For arr = ["aa", "bab", "cde", "aba", "ab"], the output should be
solution(arr) = true.

Apply the second operation to "aa" and "bab".
Apply the first operation to "aba" and "ab".
This gives us the following array: ["aab", "ab", "cde", "ab", "aab"], which is palindromic.
For arr = ["palindrome"], the output should be
solution(arr) = true.

The given array is already palindromic, so no operations are needed.

For arr = ["aaaaaa", "aa"], the output should be
solution(arr) = false.

If moving two characters between two consecutive array elements was allowed, the array could have been made palindromic, but this is impossible given the actual rules.

Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.string arr

An array of strings.

Guaranteed constraints:
1 ≤ arr.length ≤ 105,
2 ≤ arr[i].length ≤ 10.

[output] boolean

Return true if the given array can be turned into a palindromic array, otherwise return false.

```
boolean solution(String[] arr) {
        return makePalindrome(Arrays.asList(arr),new HashMap<>());
    }

    public static boolean makePalindrome(List<String> words, Map<List<String>, Boolean> memo) {
        if (words.size() == 0 || words.size() == 1) {
            return true;
        }
        if (memo.containsKey(words)) {
            return memo.get(words);
        }
        if(words.size()==2){
            return words.get(0).equals(words.get(1)) ||
                    words.get(0).substring(0,words.get(0).length()-1).equals(words.get(0).substring(words.get(0).length()-1)+words.get(1)) ||
                    (words.get(0)+words.get(1).substring(0,1)).equals(words.get(1).substring(1));

        }
        boolean result = false;
        String first = words.get(0);
        String last = words.get(words.size()-1);
        String second = words.get(1);
        String secondLast = words.get(words.size()-2);
        int wSize = words.size();

        if(first.equals(last)){
            List<String> filtered =copy(words, 1, wSize-1);
            result = result||makePalindrome(filtered,memo);
        }

        String firstShort = first.substring(0,first.length()-1);
        String secondLong = first.charAt(first.length()-1) + second;
        String firstLong = first + second.charAt(second.length()-1);
        String secondShort = second.substring(1);
        String lastShort = last.substring(1);
        String secondLastLong = secondLast + last.charAt(0);
        String lastLong = secondLast.substring(secondLast.length()-1) + last;
        String secondLastShort = secondLast.substring(0,secondLast.length()-1);

        if(firstShort.equals(last)){
            List<String>filtered = copy(words, 1,wSize-1);
            filtered.add(0,secondLong);
            result = result||makePalindrome(filtered,memo);
        }

        if(firstShort.equals(lastShort)){
            List<String>filtered = copy(words, 2,wSize-2);
            filtered.add(0,secondLong);
            filtered.add(secondLastLong);
            result = result||makePalindrome(filtered,memo);
        }

        if(firstShort.equals(lastLong)){
            List<String>filtered = copy(words, 2,wSize-2);
            filtered.add(0,secondLong);
            filtered.add(secondLastShort);
            result = result||makePalindrome(filtered,memo);
        }

        if(first.equals(lastShort)){
            List<String>filtered = copy(words, 1,wSize-2);
            filtered.add(secondLastLong);
            result = result||makePalindrome(filtered,memo);
        }

        if(first.equals(lastLong)){
            List<String>filtered = copy(words, 1,wSize-2);
            filtered.add(secondLastShort);
            result = result||makePalindrome(filtered,memo);
        }

        if(firstLong.equals(last)){
            List<String>filtered = copy(words, 2,wSize-1);
            filtered.add(0,secondShort);
            result = result||makePalindrome(filtered,memo);
        }

        if(firstLong.equals(lastShort)){
            List<String>filtered = copy(words, 2,wSize-2);
            filtered.add(0,secondShort);
            filtered.add(secondLastLong);
            result = result||makePalindrome(filtered,memo);
        }

        if(firstLong.equals(lastLong)){
            List<String>filtered = copy(words, 2,wSize-2);
            filtered.add(0,secondShort);
            filtered.add(secondLastShort);
            result = result||makePalindrome(filtered,memo);
        }
                memo.put(words, result); // Store the result in the memoization map
        return result;

    }

    public static List<String> copy(List<String> elements, int start, int end){
        List<String> result = new ArrayList<String>();
        for(int i=start;i<end;i++ ){
            result.add(elements.get(i));
        }
        return result;
    }
```
