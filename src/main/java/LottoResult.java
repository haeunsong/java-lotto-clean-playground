public class LottoResult {
    private int correct = 0; // 맞춘 장수
    private int reward = 0;
    private int quantity = 0;

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

    private boolean isBonus = false;

    public LottoResult(int quantity)
    public LottoResult(int correct, int reward, int quantity, boolean isBonus) {
        this.correct = correct;
        this.reward = reward;
        this.quantity = quantity;
        this.isBonus = isBonus;
    }

    public String toString() {
        if(isBonus) {
            return correct + "개 일치, 보너스 볼 일치("+ reward+"원)- " + quantity+"개";
        }
        return correct + "개 일치 ("+ reward+"원)- " + quantity+"개";
    }

}
