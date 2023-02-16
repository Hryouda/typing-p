package game;
import java.io.*;


public class HighScore {

    //ハイスコアを管理する配列（高得点の降順で管理する）
    int [] high = {70,50,30,20,10};
    /***
     * ハイスコア表示処理
     * ハイスコアリストの内容を画面に表示させる
     */
    public void display(){
        //ランキングを管理する変数
        int ranking = 1;
        //ハイスコアリストが存在する間、繰り返す
        for (int i = 0; i < high.length; i++){
            System.out.println(ranking + "位:" + high[i]);
            //ハイスコアの情報を出力する
            ranking++;
            //ランキングをインクリメントする
        }
    }
    public void reset(){
        high = new int[]{70, 50, 30, 20, 10};
    }


    /***
     * ハイスコア更新処理
     * 引数で受け取った得点とハイスコアリストの見比べを行い
     * ハイスコアが更新されていればリストの更新を行う
     *
     * @param newScore 新しい得点
     * @return
     */
    public void change(int newScore){
        //ハイスコア更新（バブルソート）
    for (int i = 0; i < high.length; i++)
        if (high[i] < newScore){
            int tmp = high[i];
            high[i] = newScore;
            newScore = tmp;
        }
    }
    public void write(){
        File file = new File("data.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            ;
            fw = new FileWriter(file); //書き込むファイル指定。ファイルが既にあるなら、そのファイルの末尾に書き込む
            bw = new BufferedWriter(fw); //バッファクラスでfwを包んであげる
            pw = new PrintWriter(bw); //さらに、PrintWriterで包む
            for (int i = 0; i < high.length; i++) {
                pw.write(high[i] + "\n"); //　行単位でデータ出力
            }
            pw.close(); //ファイル閉じる
        } catch (IOException e) {
            System.out.println("エラー：" + e);
            if (pw != null) pw.close(); //エラーが起きた場合でも閉じるようにする（Java7では不要）
        }
    }
    public void load(){
        File file = new File("data.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file); //書き込むファイル指定。ファイルが既にあるなら、そのファイルの末尾に書き込む
            br = new BufferedReader(fr); //バッファクラスでfwを包んであげる
            String s;
            int e = 0;
            while((s=br.readLine()) != null){ //readLine()で１行ずつ読み込んでいく
//              System.out.println(s);
                high[e] = Integer.parseInt(s);
                e++;
            }
            br.close(); //ファイル閉じる
        } catch (FileNotFoundException | NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean filecrs() {
        boolean bo = true;
        //ファイル宣言
        File file = new File("data.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("data.txtを作りました");
                bo = true;
            } else {
                System.out.println("data.txtは既に存在しています");
                bo = false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bo;
    }
}

