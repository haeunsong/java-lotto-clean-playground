import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final Integer LOTTO_NUMBER_COUNT = 6; // 로또 장당 번호 6개
    private static final Integer MAX_NUMBER = 45; // 로또 번호 1~45
    private final List<Integer> myLotto;

    public LottoTicket(List<Integer> myLotto) {
        this.myLotto = myLotto;
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(myLotto);
    }

    public static LottoTicket generate(){
        // 1~45 수를 담은 리스트 생성
        List<Integer> numbers = new ArrayList<>();
        for(Integer i=1;i<=MAX_NUMBER;i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(0,LOTTO_NUMBER_COUNT));
        Collections.sort(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    // 지난주 번호와 몇 개가 일치하는지 확인
    public int countMatchingNumbers(List<Integer> lastNumbers){
        int cnt = 0;
        for(Integer num : lastNumbers){
            if(myLotto.contains(num)) cnt++;
        }
        return cnt;
    }
}
