import java.util.ArrayList;
import java.util.List;

public class LottoResults {

    private List<LottoResult> results;
    private int totalProfit = 0; // 수익금

    public LottoResults() {
        initLottoResults();
    }

    private void initLottoResults() {
        results = new ArrayList<>();
        results.add(new LottoResult(3, 5000, false));
        results.add(new LottoResult(4, 50000, false));
        results.add(new LottoResult(5, 1500000,false));
        results.add(new LottoResult(5, 30000000,  true)); // 보너스 볼 일치
        results.add(new LottoResult(6, 2000000000, false));
    }

    public List<LottoResult> getResults() {
        return results;
    }

    // 당첨 개수 업데이트
    public void addResult(int correct, boolean bonus) {
        for (LottoResult result : results) {
            if (result.getCorrect() == correct && result.isBonus() == bonus) {
                result.increaseQuantity();
                return;
            }
        }
    }

    // 총 수익 계산
    public void updateTotalProfit() {
        totalProfit = 0;
        for (LottoResult result : results) {
            totalProfit += result.getReward() * result.getQuantity();
        }
    }

    private Double calculateProfitRatio(int price) {
        if(totalProfit == 0) return 0.0;
        return (double) totalProfit / price;
    }

    public void printCalculateProfitRatio(int price) {
        updateTotalProfit(); // 수익 업데이트
        System.out.printf("총 수익률은 %.2f입니다.", calculateProfitRatio(price));
    }

    public void printLottoResults() {
        System.out.println("당첨 통계\n---------");
        for(LottoResult result : results) {
            System.out.println(result.toString());
        }
    }
}
