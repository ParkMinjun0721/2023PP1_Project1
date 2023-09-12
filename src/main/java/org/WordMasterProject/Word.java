package org.WordMasterProject;

public class Word {
    private int id;
    private int level;
    private String word;
    private String meaning;

    Word(){}
    Word(int id, int level, String word, String meaning){
        this.id = id;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    public String toString(){
        String slevel = "";
        if(level>3) level = 3; //레벨이 3을 넘으면 그냥 3으로 설정.

        for(int i = 0; i<level ; i++) slevel += "*";
        String str = String.format("%-3s", slevel) +
                String.format("%15s", word) + "  " + meaning;
        return str;
    }
}
