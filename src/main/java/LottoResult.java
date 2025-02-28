public class LottoResult {
    private int correct = 0; // 맞춘 장수
    private int reward = 0;
    private int quantity = 0;
    private boolean isBonus;

    public int getCorrect() {
        return correct;
    }

    public int getReward() {
        return reward;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public LottoResult(int correct, int reward, boolean isBonus) {
        this.correct = correct;
        this.reward = reward;
        this.isBonus = isBonus;
        this.quantity = 0; // 초기 갯수 0
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public String toString() {
        if(isBonus) {
            return correct + "개 일치, 보너스 볼 일치("+ reward+"원)- " + quantity+"개";
        }
        return correct + "개 일치 ("+ reward+"원)- " + quantity+"개";
    }

}
