package src;

import java.util.Objects;

public class User {

    private String gameId;   //게임 아이디
    private String userName; //사람 이름
    private String passWord; //비밀번호
    private int score;       //점수
    private int gameLife; //게임 목숨
    private int hint;     //힌트 갯수
    //생성자
    public User(String gameId, String userName, String passWord, int score, int gameLife, int hint) {
        this.gameId = gameId;
        this.userName = userName;
        this.passWord = passWord;
        this.score = score;
        this.gameLife = gameLife;
        this.hint = hint;
    }



    public String getGameId() {
        return gameId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getScore() {
        return score;
    }

    public int getGameLife() {
        return gameLife;
    }

    public int getHint() {
        return hint;
    }

    @Override
    public String toString() {
        return "User{" +
                "gameId='" + gameId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", score=" + score +
                ", gameLife='" + gameLife + '\'' +
                ", hint='" + hint + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return score == that.score && Objects.equals(gameId, that.gameId) && Objects.equals(userName, that.userName) && Objects.equals(passWord, that.passWord) && Objects.equals(gameLife, that.gameLife) && Objects.equals(hint, that.hint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, userName, passWord, score, gameLife, hint);
    }
}
