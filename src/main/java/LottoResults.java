import java.util.ArrayList;
import java.util.List;

public class LottoResults {

    private List<LottoResult> results;
    private int totalProfit; // 수익금

    public void initLottoResults() {
        results = new ArrayList<>();
        results.add(new LottoResult(3, 5000, 0, false));
        results.add(new LottoResult(4, 50000, 0, false));
        results.add(new LottoResult(5, 1500000, 0, false));
        results.add(new LottoResult(5, 1500000, 0, true));
        results.add(new LottoResult(6, 2000000000, 0, false));
    }

    public List<LottoResult> getResults() {
        return results;
    }

    private Double calculateProfitRatio(int price) {
        if(totalProfit == 0) return 0.0;
        return (double) totalProfit / price;
    }

    public void printCalculateProfitRatio() {
        System.out.printf("총 수익률은 %.2f입니다.", calculateProfitRatio(totalProfit));
    }

    public void printLottoResults() {
        System.out.println("당첨 통계\n---------");

        for(LottoResult result : results) {
            System.out.println(result.toString());
        }
    }


}
