class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                R.add(i);
            } else {
                D.add(i);
            }
        }

        while (!R.isEmpty() && !D.isEmpty()) {
            int idx1 = R.poll();
            int idx2 = D.poll();
            if (idx1 < idx2) {
                R.offer(idx1 + n);
            } else {
                D.offer(idx2 + n);
            }
        }
        return R.isEmpty() ? "Dire" : "Radiant";
    }
}