
public class MaximumXORofTwoNumbersinanArray {

    private class TrieNode {

        private TrieNode[] nodes;

        private TrieNode() {
            this.nodes = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        TrieNode curr;

        for (int i = 0; i < nums.length; i++) {
            curr = root;
            for (int j = 30; j >= 0; j--) {
                int bit = getIthBit(nums[i], j);
                if (curr.nodes[bit ^ 1] == null) {
                    curr.nodes[bit ^ 1] = new TrieNode();
                }
                curr = curr.nodes[bit ^ 1];
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = root;
            int local = 0;
            for (int j = 30; j >= 0; j--) {
                int bit = getIthBit(nums[i], j);
                if (curr.nodes[bit] != null) {
                    curr = curr.nodes[bit];
                    local += (1 << j);
                } else {
                    curr = curr.nodes[bit ^ 1];
                }
            }
            max = Math.max(max, local);
        }
        return max;
    }

    private int getIthBit(int num, int i) {
        return ((num & (1 << i)) == 0) ? 0 : 1;
    }

    public static void main(String args[]) {
        MaximumXORofTwoNumbersinanArray mxtna = new MaximumXORofTwoNumbersinanArray();
        int[] nums = new int[]{3, 10, 5, 25, 2, 8};
        System.out.println(mxtna.findMaximumXOR(nums));
    }
}
