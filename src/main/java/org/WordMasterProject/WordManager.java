package org.WordMasterProject;

import java.io.IOException;
import java.util.Scanner;

public class WordManager {
    Scanner s  = new Scanner(System.in);
    WordCRUD wordCRUD;
    WordManager(){
        wordCRUD = new WordCRUD(s);
    }
    public void start() throws IOException {
        WordCRUD.loadFile();
        while (true) {
            int menu = selectMenu();

            if(menu == 0){
                System.out.println("Exit the Program.\n" +
                        "See you again :)");
                break; //나가기
            }
            else if(menu == 1) { //모든 단어 보기
                wordCRUD.listAll();
            }
            else if(menu == 2) { //수준별 단어 보기
                ment();
            }
            else if(menu == 3) { //단어 검색
                wordCRUD.searchItem();
            }
            else if(menu == 4) { //단어 추가
                wordCRUD.addItem();
            }
            else if(menu == 5) { //단어 수정
                wordCRUD.updateItem();
            }
            else if(menu == 6) { //단어 삭제
                wordCRUD.deleteItem();
            }
            else if(menu == 7) { //파일 저장
                wordCRUD.saveFile();
            }
        }
    }
    public int selectMenu() {
        System.out.print("*** 영단어 마스터 ***\n" +
                "********************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "********************\n" +
                "=> 원하는 메뉴는? ");
        return  s.nextInt();
    }
    public void ment(){
        System.out.println("Not implemented yet.");
    }

}
