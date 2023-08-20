Consider a rectangular h × w board with all cells initially white. You are to process several queries of the following types:

"x a b" - color the white cell (a, b) (0-based coordinates, the first one is a row index, and the second one is a column index) black;
"> a b" - find the leftmost white cell to the right of the white cell (a, b);
"< a b" - find the rightmost white cell to the left of the white cell (a, b);
"v a b" - the same, but the search should be done downwards;
"^ a b" - the same, but the search should be done upwards;
For each query, except the ones of the first type, find the answer.

Example

For h = 3, w = 5, and
queries = ["v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"],
the output should be
solution(h, w, queries) = [[2, 2], [-1, -1], [2, 3], [2, 4], [-1, -1]].

Check out the image above to see the state of the board after each query of the first type:


Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] integer h

A positive integer.

Guaranteed constraints:
1 ≤ h ≤ 500.

[input] integer w

A positive integer.

Guaranteed constraints:
1 ≤ w ≤ 500.

[input] array.string queries

Queries in the above-described format.

Guaranteed constraints:
5 ≤ queries.length ≤ 104.

[output] array.array.integer
For each query except the ones of the first type, store the answer's coordinates in the array. If the desired cell doesn't exist, store [-1, -1] instead. The answers should be stored in the same order as the queries

```
int[][] solution(int h, int w, String[] queries) {
        char[][] board = new char[h][w];
        List<int[]> answers = new ArrayList<>();

        // Initialize the board with all white cells
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = 'W';
            }
        }

        for (String query : queries) {
            String[] parts = query.split(" ");
            char type = parts[0].charAt(0);
            int row = Integer.parseInt(parts[1]);
            int col = Integer.parseInt(parts[2]);

            if (type == 'x') {
                board[row][col] = 'B';
            } else {
                int[] answer = findAnswer(board, type, row, col);
                answers.add(answer);
            }
        }

        int[][] result = new int[answers.size()][2];
        for (int i = 0; i < answers.size(); i++) {
            result[i] = answers.get(i);
        }

        return result;
    }

    private static int[] findAnswer(char[][] board, char type, int row, int col) {
        int[] answer = new int[2];
        answer[0] = -1;
        answer[1] = -1;

        if (type == '>') {
            for (int j = col + 1; j < board[row].length; j++) {
                if (board[row][j] == 'W') {
                    answer[0] = row;
                    answer[1] = j;
                    break;
                }
            }
        } else if (type == '<') {
            for (int j = col - 1; j >= 0; j--) {
                if (board[row][j] == 'W') {
                    answer[0] = row;
                    answer[1] = j;
                    break;
                }
            }
        } else if (type == 'v') {
            for (int i = row + 1; i < board.length; i++) {
                if (board[i][col] == 'W') {
                    answer[0] = i;
                    answer[1] = col;
                    break;
                }
            }
        } else if (type == '^') {
            for (int i = row - 1; i >= 0; i--) {
                if (board[i][col] == 'W') {
                    answer[0] = i;
                    answer[1] = col;
                    break;
                }
            }
        }

        return answer;
    }
```


