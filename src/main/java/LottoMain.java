import java.util.*;

public class LottoMain {

    private static final int LOTTO_NUMBER_COUNT = 6; // 로또 장당 번호 6개
    private static final int MAX_NUMBER = 45; // 로또 번호 1~45

    private static List<Integer> generateLottoNumbers() {
        // 1~45 수를 담은 리스트 생성
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<MAX_NUMBER;i++){
            numbers.add(i);
        }

        // shuffle 해주고
        Collections.shuffle(numbers);

        // 앞에 6개 숫자 고르기 + 오름차순
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i=0;i<LOTTO_NUMBER_COUNT;i++){
            lottoNumbers.add(numbers.get(i));
        }
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

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();

        int number = price/1000; // 로또 장수

        System.out.println("\n"+ number+"개를 구매했습니다.");

        while(number-- > 0) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            printLottoNumbers(lottoNumbers);
        }
    }
}
