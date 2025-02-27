import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> myLottos;

    public LottoTickets(List<LottoTicket> myLottos) {
        this.myLottos = myLottos;
    }

    public void printAllMyLottos() {
        for (LottoTicket lottoTicket : myLottos) {
            List<Integer> numbers = lottoTicket.getLotto();
            String result = "[" + String.join(", ", numbers.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new)) + "]";
            System.out.println(result);
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return myLottos;
    }
}
