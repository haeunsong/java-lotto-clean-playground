import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LottoMain {

    private static Integer price = 0;
    private static Integer profit = 0;
    private static final List<Integer> lastNumberList = new ArrayList<>();
    private static final Map<Integer,Integer> result = new LinkedHashMap<>();

    private static void initResultMap() {
        result.put(5000,0); result.put(50000,0); result.put(1500000,0); result.put(2000000000,0);
    }

    private static void printResult(LottoTickets lottoTickets) {
        System.out.println("\n당첨 통계");
        System.out.println("--------");

        for(LottoTicket ticket : lottoTickets.getLottoTickets()) {
            int matchCount = ticket.countMatchingNumbers(lastNumberList);
            if (matchCount == 3) {
                result.put(5000, result.getOrDefault(5000, 0) + 1);
            } else if (matchCount == 4) {
                result.put(50000, result.getOrDefault(50000, 0) + 1);
            } else if (matchCount == 5) {
                result.put(1500000, result.getOrDefault(1500000, 0) + 1);
            } else if (matchCount == 6) {
                result.put(2000000000, result.getOrDefault(2000000000, 0) + 1);
            }
        }
        Integer init = 3;
        for(Map.Entry<Integer,Integer> entry : result.entrySet()) {
            System.out.println(init+"개 일치 ("+ entry.getKey() +")- " + entry.getValue()+"개");
            profit = profit + (entry.getKey() * entry.getValue());
            init++;
        }
        System.out.printf("총 수익률은 %.2f입니다.", calculateProfitRatio());
    }

    private static Double calculateProfitRatio() {
        if(profit == 0) return 0.0;
        return (double) profit / price;
    }

    private static LottoTickets buyLottoTickets(int number) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i=0;i<number;i++){
            lottoTickets.add(LottoTicket.generate());
        }
        return new LottoTickets(lottoTickets);
    }

    public static void main(String[] args) throws IOException {
        initResultMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("구입금액을 입력해 주세요.");
        price = Integer.parseInt(br.readLine());

        int number = price/1000; // 구매한 로또 장수
        System.out.println("\n"+ number+"개를 구매했습니다.");

        LottoTickets lottoTickets = buyLottoTickets(number);
        lottoTickets.printAllMyLottos();

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String last = br.readLine();
        String[] numbers = last.split(",");

        for(String num : numbers) {
            lastNumberList.add(Integer.parseInt(num.trim()));
        }

        printResult(lottoTickets);
    }
}
