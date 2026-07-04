class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch != ']') {
                stack.push(ch);
            } else {

                // Get the encoded string
                StringBuilder str = new StringBuilder();
                while (stack.peek() != '[') {
                    str.append(stack.pop());
                }
                str.reverse();

                // Remove '['
                stack.pop();

                // Get the number
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.append(stack.pop());
                }
                num.reverse();
                int k = Integer.parseInt(num.toString());

                // Repeat the string
                String temp = str.toString();
                StringBuilder repeated = new StringBuilder();

                for (int i = 0; i < k; i++) {
                    repeated.append(temp);
                }

                // Push back onto stack
                for (char c : repeated.toString().toCharArray()) {
                    stack.push(c);
                }
            }
        }

        // Build the final answer
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}