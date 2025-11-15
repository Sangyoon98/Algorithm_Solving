class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int maxCount = 0;
        int minCount = 0;
        
        for (int i : lottos) {
            for (int j : win_nums) {
                if (i == j) {
                    maxCount++;
                    minCount++;
                }
            }
            if (i == 0) maxCount++;
        }
        return new int[] { convertRank(maxCount), convertRank(minCount) };
    }
    
    public int convertRank(int i) {
        switch (i) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            case 1: return 6;
            case 0: return 6;
        }
        return 0;
    }
}