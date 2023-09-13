package org.WordMasterProject;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    static ArrayList<Word> list;
    Scanner s;
    static final String filename = "Dictionary.txt";
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }
    public void addItem() {
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다 !!! ");
    }
    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String tmp = s.next();
        ArrayList<Integer> dlist = this.listAll(tmp);

        System.out.print("=> 삭제할 번호 선택 : ");
        int dn = s.nextInt();

        System.out.print("정말로 삭제하실래요?(Y/n) ");
        String yn = s.next();

        if(yn.equalsIgnoreCase("y")){
            list.remove((int)dlist.get(dn-1));
            System.out.println("단어가 삭제되었습니다. ");
        }else if(yn.equalsIgnoreCase("n")){
            System.out.println("취소되었습니다. ");
        }else{
            System.out.println("유효하지 않은 입력입니다. 메인 메뉴로 돌아갑니다.");
        }

    }
    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String tmp = s.next();
        ArrayList<Integer> uplist = this.listAll(tmp);

        System.out.print("=> 수정할 번호 선택 : ");
        int un = s.nextInt();
        s.nextLine(); //안하면 뜻 입력 에서 바로 넘어감.

        System.out.print("=> 뜻 입력: ");
        tmp = s.nextLine();

        Word word = list.get(uplist.get(un-1));
        word.setMeaning(tmp);
        System.out.println("단어가 수정되었습니다.");
    }
    public void searchItem() {
        System.out.print("=> 검색할 단어 입력 : ");
        String tmp = s.next();
        ArrayList<Integer> list = this.listAll(tmp);
    }
    public static void loadFile() throws IOException {
        BufferedReader bfrd = new BufferedReader(new FileReader(filename));
        int n=0;
        String words;

        while(true){
            words = bfrd.readLine();

            if(words==null){
                break;
            }

            String data[] = words.split("\\|");
            int level = Integer.parseInt(data[0]);
            String word = data[1];
            String meaning = data[2];
            list.add(new Word(0, level, word, meaning));
            n++;
        }

        bfrd.close();
        System.out.println("==> "+n+"개 로딩 완료.");
    }
    public void saveFile() throws IOException {
        BufferedWriter bfwt = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter pw = new PrintWriter((new FileWriter("test.txt")));
        String s;

        pw.close();
    }
    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
    public void listAll(){
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
    }
    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j=0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("--------------------------------");
        return idlist;
    }


}
