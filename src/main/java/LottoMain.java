import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LottoMain {

    private static Integer price = 0;
    private static Integer bonusNumber = 0;
    private static final List<Integer> lastNumberList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("구입금액을 입력해 주세요.");
        price = Integer.parseInt(br.readLine());

        int number = price/1000; // 구매한 로또 장수
        System.out.println("\n"+ number+"개를 구매했습니다.");

        LottoTickets lottoTickets =  LottoTicket.buyLottoTickets(number);
        lottoTickets.printAllMyLottos();

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String last = br.readLine();
        String[] numbers = last.split(",");
        for(String num : numbers) {
            lastNumberList.add(Integer.parseInt(num.trim()));
        }

        // 보너스 볼 입력
        System.out.println("보너스 볼을 입력해주세요.");
        bonusNumber = Integer.parseInt(br.readLine());

        // 통계내기
        // LottoTickets 에 담긴 얘들을 통계내서 LottoResult 에 담아야한다.


        for(LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            int cnt = lottoTicket.countMatchingNumbers(lastNumberList);
            // LottoResult 에 담기
            if (lottoTicket.isBonusCorrect(bonusNumber)) {

            }
            LottoResult lottoResult = new LottoResult()

        }


        results.initLottoResults();
        results.printLottoResults();

        printResult(lottoTickets);
    }
}
