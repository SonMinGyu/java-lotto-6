package lotto;

import java.util.List;

public class Lotto {
    private static final int BONUS_USE_NUMBER = 5;
    private static final int BONUS_COUNT = 10;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int compareWithUserNumbers(final List<Integer> userNumbers, final int bonusNumber) {
        int matchCount = compareLottoWithUserNumbers(userNumbers);

        if (matchCount == BONUS_USE_NUMBER) {
            if (compareLottoWithBonusNumber(bonusNumber)) {
                matchCount += BONUS_COUNT;
            }
        }

        return matchCount;
    }

    private int compareLottoWithUserNumbers(final List<Integer> userNumbers) {
        int count = 0;
        for (Integer lotto : this.numbers) {
            if (isSameNumber(lotto, userNumbers)) {
                count++;
            }
        }

        return count;
    }

    private boolean isSameNumber(final int lotto, final List<Integer> userNumbers) {
        for (Integer userNumber : userNumbers) {
            if (lotto == userNumber) {
                return true;
            }
        }

        return false;
    }

    private boolean compareLottoWithBonusNumber(final int bonusNumber) {
        for (Integer lotto : this.numbers) {
            if (lotto == bonusNumber) {
                return true;
            }
        }

        return false;
    }

    public void printLottoNumbers() {
        for (Integer number : this.numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
