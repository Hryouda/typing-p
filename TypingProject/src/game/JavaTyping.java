package game;
import java.io.*;
import java.util.Scanner;
public class JavaTyping {

    public static void main(String[] args) {

        //ゲーム処理とハイスコア表示用クラスを宣言する
        GamePlay gamePlay = new GamePlay();
        HighScore highScore = new HighScore();
        //キーボード入力を受付けるスキャナークラスを宣言する
        Scanner in = new Scanner(System.in);
        boolean b = highScore.filecrs();
        if (b == true){
            highScore.write();
        }else {
            highScore.load();
        }

        //ループ変数がtrueの間、ゲームを繰り返す
        boolean judge = true;
        while(judge){
            //メニューメッセージ表示
            System.out.print("1:ゲームスタート 2:ハイスコア 3:ゲーム終了 4:ハイスコア初期化->");
            //画面から入力された文字列を変数に格納する
            try {
                int num = Integer.parseInt(in.next());
                //switchによる条件分岐を行う
                switch (num) {
                    case 1:
                        System.out.println("タイピングソフトを開始します");
                        //１が入力された場合は、タイピングゲームを開始する
                        //タイピングゲーム開始処理を呼び出す
                        int score = gamePlay.start();
                        //今回の得点を表示する
                        System.out.println("あなたのスコアは" + score + "点です");
                        //ハイスコア更新処理を呼び出す
                        highScore.change(score);
                        highScore.write();
                        break;
                    case 2:
                        System.out.println("ハイスコアを表示します");
                        //２が入力された場合は、ハイスコアの表示を行う
                        //ハイスコア表示処理を呼び出す
                        highScore.display();
                        break;
                    case 3:
                        //３が入力された場合は、ゲームを終了させる
                        //ループ変数をfalseにしてゲーム終了
                        System.out.println("タイピングソフトを終了します");
                        judge = false;
                        break;
                    case 4:
                        highScore.reset();
                        System.out.println("ハイスコアを初期化しました");
                        highScore.write();
                        break;
                    //１から4以外の値が入力された場合は、不正メッセージを表示する
                    default:
                        System.out.println("1~4の数字を入力してください");
                }
            }catch (NumberFormatException e){
                System.out.println("1~4の数字を入力してください");
            }
        }
    }
}
