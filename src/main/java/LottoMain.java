import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoMain {

    private static final int LOTTO_NUMBER_COUNT = 6; // 로또 장당 번호 6개
    private static final int MAX_NUMBER = 45; // 로또 번호 1~45

    private static List<Integer> generateLottoNumbers() {
        Random random = new Random();
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBER_COUNT);
        for(int i=0;i<LOTTO_NUMBER_COUNT;i++){
            int number = random.nextInt(MAX_NUMBER)+1;
            if(!lottoNumbers.contains(number)){
                lottoNumbers.add(number);
            }
        }

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

        System.out.println(number+"개를 구매했습니다.");

        while(number-- > 0) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            printLottoNumbers(lottoNumbers);
        }
    }

}
