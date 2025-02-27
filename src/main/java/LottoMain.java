import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LottoMain {

    private static final Integer LOTTO_NUMBER_COUNT = 6; // 로또 장당 번호 6개
    private static final Integer MAX_NUMBER = 45; // 로또 번호 1~45
    private static Integer price = 0;
    private static Integer profit = 0;
    private static final List<Integer> lastNumberList = new ArrayList<>();
    private static final Map<Integer,Integer> result = new LinkedHashMap<>();

    private static void initResultMap() {
        result.put(5000,0); result.put(50000,0); result.put(1500000,0); result.put(2000000000,0);
    }

    private static void calculateStatistics(List<Integer> lottoNumbers) {
        int cnt = 0;
        for (Integer num : lastNumberList) {
            if (lottoNumbers.contains(num)) {
                cnt++;
            }
        }

        if(cnt == 3) {
            result.put(5000,result.get(5000)+1);
        }
        if(cnt == 4) {
            result.put(50000,result.get(50000)+1);
        }
        if(cnt == 5) {
            result.put(1500000,result.get(150000)+1);
        }
        if(cnt == 6) {
            result.put(2000000000,result.get(2000000000)+1);
        }
    }

    private static List<Integer> generateLottoNumbers() {
        // 1~45 수를 담은 리스트 생성
        List<Integer> numbers = new ArrayList<>();
        for(Integer i=1;i<=MAX_NUMBER;i++){
            numbers.add(i);
        }

        // shuffle 해주고
        Collections.shuffle(numbers);
        // 앞에 6개 숫자 고르기 + 오름차순
        List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(0,LOTTO_NUMBER_COUNT));
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    private static void printLottoNumbers(List<Integer> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String lottoNumbersString = String.join(", ",lottoNumbers.stream()
                .map(String::valueOf)
                .toArray(String[]::new));
        sb.append(lottoNumbersString);
        sb.append("]");

        System.out.println(sb);
    }

    private static void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("--------");
        Integer init = 3;
        for(Map.Entry<Integer,Integer> entry : result.entrySet()) {
            System.out.println(init+"개 일치 ("+ entry.getKey() +")- " + entry.getValue()+"개");
            profit = profit + (entry.getKey() * entry.getValue());
            init++;
        }
        System.out.println("총 수익률은 " + calculateProfitRatio() + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static Double calculateProfitRatio() {
        if(profit == 0) return 0.0;
        return (double) profit / price;
    }

    public static void main(String[] args) throws IOException {
        initResultMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("구입금액을 입력해 주세요.");
        price = Integer.parseInt(br.readLine());

        Integer number = price/1000; // 구매한 로또 장수
        System.out.println("\n"+ number+"개를 구매했습니다.");

        List<List<Integer>> myLottos = new ArrayList<>();

        while(number-- > 0) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            myLottos.add(lottoNumbers);
            printLottoNumbers(lottoNumbers);
        }

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String last = br.readLine();
        String[] numbers = last.split(",");

        for(String num : numbers) {
            lastNumberList.add(Integer.parseInt(num.trim()));
        }

        for(List<Integer> myLotto : myLottos) {
            calculateStatistics(myLotto);
        }
        printResult();
    }
}
