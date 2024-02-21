import java.util.Random;

/*
Дан двумерный массив из двух строк и двадцати двух столбцов.
В его первой строке записано количество мячей, забитых футбольной командой в той
или иной игре, во второй — количество пропущенных мячей в этой же игре.
а) Для каждой проведенной игры напечатать словесный результат: "выигрыш", "ничья" или "проигрыш".
б) Определить количество выигрышей данной команды.
в) Определить количество выигрышей и количество проигрышей данной
команды.
г) Определить количество выигрышей, количество ничьих и количество проигрышей данной команды.
д) Определить, в скольких играх разность забитых и пропущенных мячей
была большей или равной трем.
е) Определить общее число очков, набранных командой (за выигрыш даются
3 очка, за ничью — 1, за проигрыш — 0).
 */
public class Task12_70 {
    static int[][] games = new int[2][22];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < games[0].length; i++) {
            games[0][i] = random.nextInt(6);
        }
        for (int i = 0; i < games[1].length; i++) {
            games[1][i] = random.nextInt(6);
        }
        for (int[] row: games){
            for (int num: row){
                System.out.print(num+" ");
            }
            System.out.println();
        }

        //a
        for (int i = 0; i < games[0].length; i++) {
            if (games[0][i]-games[1][i]!=0){
                System.out.print(games[0][i]>games[1][i]? "W ":"L ");
            } else {
                System.out.print("D ");
            }

        }

        //б,в,г
        int winCount = 0, lossCount = 0, drawCount = 0;
        for (int i = 0; i < games[0].length; i++) {
            if (games[0][i]-games[1][i]!=0){
                if (games[0][i]-games[1][i]>0){
                    winCount++;
                } else {
                    lossCount++;
                }
            } else {
                drawCount++;
            }
        }
        System.out.printf("%nWINS: %d LOSSES: %d DRAWS: %d",winCount,lossCount,drawCount);

        //д
        int count = 0;
        for (int i = 0; i < games[0].length; i++) {
            if (games[0][i]-games[1][i]!=0){
                if (Math.abs(games[0][i]-games[1][i])>=3){
                    count++;
                }
            }
        }
        System.out.println("\nSCORE DIFFERENCE OF 3 OR HIGHER HAS HAPPENED "+count+" TIMES");

        //е
        count = 0;
        for (int i = 0; i < games[0].length; i++) {
            if (games[0][i]-games[1][i]!=0){
                count += games[0][i]-games[1][i]>0? 3: 0;
            } else {
                count++;
            }

        }
        System.out.println("TOTAL SCORE: "+count);

    }
}
