package game;
import java.util.Scanner;
public class GamePlay {

    /***
     * タイピングゲーム開始処理
     * 配列の単語一覧からランダムで１０問出題する
     * 正解につき１０点の加算を行い、結果を戻り値に設定する
     *
     * @return タイピングゲームの得点
     */
    public int start(){
        //キーボード入力を受付けるスキャナークラスを宣言する
        Scanner in = new Scanner(System.in);
        //ランダム変数の宣言
        int r = 0;

        //得点を管理する変数
        int score = 0;
        //問題数を管理する変数
        int question = 10;

        //タイピングゲームで使用する単語一覧
        String [] word = {"春","夏","秋","冬","今日","昨日","明日","変数","火曜日","日曜日"};
        //タイピングゲームで使用する単語の答え
        String [][] answer = {
                {"haru"},
                {"natsu","natu"},
                {"aki"},
                {"fuyu","huyu"},
                {"kyou"},
                {"kinou"},
                {"asita","ashita"},
                {"hensuu","hennsuu"},
                {"kayoubi"},
                {"nichiyoubi","nitiyoubi"},
        };



        //設定した問題数を満たすまで繰り返す
        for (int i = 0; i < question; i++) {

            //（ワードリストの添え字を超えない範囲で）ランダム変数から値を取得する
            r = (int) (Math.random() * word.length);
            //ランダム変数に紐づく問題を表示する
            System.out.print(i + 1 + "問目:");
            System.out.println(word[r]);
            //画面から入力された文字列を変数に格納する
            String num = in.next();
            boolean bo = false;
            //入力された文字列とスペルが同じなら１０点加算する
            for (int g = 0; g < answer[r].length; g++){
                if (answer[r][g].equals(num)){
                    score += 10;
                    bo = true;
                    break;
                }
            }
            if (bo == true){
                System.out.println("正解");
            }else {
                System.out.println("不正解");
            }
        }

        //戻り値に得点をセットする
        return score;
    }
}
