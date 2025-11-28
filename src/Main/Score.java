package Main;

public class Score {

	GameManager gm;
	public Score(GameManager gm) {this.gm = gm;}
	
	private int[] list_itemA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] list_itemB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int orderA=0, orderB=0, score=0, s;
	private int indexM;
	static int[][] recipe = 
	{{1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
	{1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
	{1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
	{1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
	{1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
	{1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
	{1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
	{1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
	{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
	{1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
	{1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
	{1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
	{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
	{1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0},
	{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0},
	{1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
	{1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
	{1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
	{1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
	{1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
	{1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
	{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
	{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
	{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
	{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},};


	
	public void setListItemA(int item) {

		list_itemA[orderA] = item;
		orderA++;
		
		if(orderA == list_itemA.length) {
			
			orderA = 0;
		}
	}
	
	public void resetListItemA() {

		for(int i=0;i<list_itemA.length;i++) {
			
			list_itemA[i] = 0;
		}
	}
	
	public void setListItemB(int item) {

		list_itemB[orderB] = item;
		orderB++;
		
		if(orderB == list_itemB.length) {
			
			orderB = 0;
		}
	}
	
	public void resetListItemB() {

		for(int i=0;i<list_itemB.length;i++) {
			
			list_itemB[i] = 0;
		}
	}
	
	//public void setRecipe(String[] recipe) { this.recipe = recipe;}
	
	public int getScore() {
		
		System.out.println("SCORE" + ": "+ score);
		return score;
	}
	public void setItemlist(int[] list_itemA, int[] list_itemB) {
		this.list_itemA = list_itemA;
		this.list_itemB = list_itemB;
	}
	
	public void resetScore() {
		
		score = 0;
	}
	
	public void calScoreA() { 
		
		for (int i = 0; i < list_itemA.length; i++) {
            int s = Math.abs(list_itemA[i] - recipe[indexM][i]); // หาแตกต่างของวัตถุดิบ
            System.out.println(list_itemA[i] + " | " + recipe[indexM][i] + " = " + s);

            if (s == 0 && recipe[indexM][i] != 0) {
                switch (i) {
                    case 0: score += (list_itemA[i] * 20); break;
                    case 1: score += (list_itemA[i] * 20); break;
                    case 2: score += (list_itemA[i] * 90); break;
					case 3: score += (list_itemA[i] * 60); break;
					case 4: score += (list_itemA[i] * 90); break;
					case 5: score += (list_itemA[i] * 90); break;
					case 6: score += (list_itemA[i] * 60); break;
					case 7: score += (list_itemA[i] * 90); break;
					case 8: score += (list_itemA[i] * 90); break;
					case 9: score += (list_itemA[i] * 100); break;
					case 10: score += (list_itemA[i] * 110); break;
					case 11: score += (list_itemA[i] * 120); break;
					case 12: score += (list_itemA[i] * 130); break;
					case 13: score += (list_itemA[i] * 140); break;
					case 14: score += (list_itemA[i] * 150); break;
					case 15: score += (list_itemA[i] * 160); break;
					case 16: score += (list_itemA[i] * 170); break;
					case 17: score += (list_itemA[i] * 180); break;
					case 18: score += (list_itemA[i] * 190); break;
					case 19: score += (list_itemA[i] * 200); break;
					case 20: score += (list_itemA[i] * 210); break;
					case 21: score += (list_itemA[i] * 220); break;
                }
            } else {
                switch (i) {
                    case 0: score -= (s * 10); break;
                    case 1: score -= (s * 20); break;
                    case 2: score -= (s * 20); break;
					case 3: score -= (s * 20); break;
					case 4: score -= (s * 20); break;
					case 5: score -= (s * 20); break;
					case 6: score -= (s * 20); break;
					case 7: score -= (s * 20); break;
					case 8: score -= (s * 20); break;
					case 9: score -= (s * 20); break;
					case 10: score -= (s * 20); break;
					case 11: score -= (s * 20); break;
					case 12: score -= (s * 20); break;
					case 13: score -= (s * 20); break;
					case 14: score -= (s * 20); break;
					case 15: score -= (s * 20); break;
					case 16: score -= (s * 20); break;
					case 17: score -= (s * 20); break;
					case 18: score -= (s * 20); break;
					case 19: score -= (s * 20); break;
					case 20: score -= (s * 20); break;
					case 21: score -= (s * 20); break;
                }
            }
            System.out.println("คะแนนปัจจุบัน: " + score);
        }

       // resetListItemA(); // รีเซ็ต list_itemA
	}
	
	public void calScoreB() {
		
		for (int i = 0; i < list_itemB.length; i++) {
            int s = Math.abs(list_itemB[i] - recipe[indexM][i]); // หาแตกต่างของวัตถุดิบ
            System.out.println(list_itemB[i] + " | " + recipe[indexM][i] + " = " + s);

            if (s == 0 && recipe[indexM][i] != 0) {
                switch (i) {
                    case 0: score += (list_itemB[i] * 10); break;
                    case 1: score += (list_itemB[i] * 20); break;
                    case 2: score += (list_itemB[i] * 30); break;
					case 3: score += (list_itemB[i] * 40); break;
					case 4: score += (list_itemB[i] * 50); break;
					case 5: score += (list_itemB[i] * 60); break;
					case 6: score += (list_itemB[i] * 70); break;
					case 7: score += (list_itemB[i] * 80); break;
					case 8: score += (list_itemB[i] * 90); break;
					case 9: score += (list_itemB[i] * 100); break;
					case 10: score += (list_itemB[i] * 110); break;
					case 11: score += (list_itemB[i] * 120); break;
					case 12: score += (list_itemB[i] * 130); break;
					case 13: score += (list_itemB[i] * 140); break;
					case 14: score += (list_itemB[i] * 150); break;
					case 15: score += (list_itemB[i] * 160); break;
					case 16: score += (list_itemB[i] * 170); break;
					case 17: score += (list_itemB[i] * 180); break;
					case 18: score += (list_itemB[i] * 190); break;
					case 19: score += (list_itemB[i] * 200); break;
					case 20: score += (list_itemB[i] * 210); break;
					case 21: score += (list_itemB[i] * 220); break;
                }
            } else {
                switch (i) {
                    case 0: score -= (s * 10); break;
                    case 1: score -= (s * 20); break;
                    case 2: score -= (s * 20); break;
					case 3: score -= (s * 20); break;
					case 4: score -= (s * 20); break;
					case 5: score -= (s * 20); break;
					case 6: score -= (s * 20); break;
					case 7: score -= (s * 20); break;
					case 8: score -= (s * 20); break;
					case 9: score -= (s * 20); break;
					case 10: score -= (s * 20); break;
					case 11: score -= (s * 20); break;
					case 12: score -= (s * 20); break;
					case 13: score -= (s * 20); break;
					case 14: score -= (s * 20); break;
					case 15: score -= (s * 20); break;
					case 16: score -= (s * 20); break;
					case 17: score -= (s * 20); break;
					case 18: score -= (s * 20); break;
					case 19: score -= (s * 20); break;
					case 20: score -= (s * 20); break;
					case 21: score -= (s * 20); break;
                }
            }
            System.out.println("คะแนนปัจจุบัน: " + score);
        }

       // resetListItemB(); // รีเซ็ต list_itemA
	}
	
	public void setIndexM(int index) {
        this.indexM = index;
    }
    // Add this method to get the index
    public int getIndexM() {
        return indexM;
    }
}