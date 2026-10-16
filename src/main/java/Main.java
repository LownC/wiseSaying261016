import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int[] ids = new int[100];
        String[] wiseSayings = new String[100];
        String[] authors = new String[100];

        while(true){
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();
            if(cmd.equals("종료")){
                break;
            }
            else if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String wiseSaying = scanner.nextLine().trim();
                System.out.print("작가 : ");
                String author = scanner.nextLine().trim();
                ids[n] = n+1;
                wiseSayings[n] = wiseSaying;
                authors[n] = author;
                n++;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(n));
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");

                for(int i = n-1; i>=0; i--){
                    System.out.println("%d / %s / %s".formatted(ids[i], authors[i], wiseSayings[i]));
                }
            }
        }
        scanner.close();
    }
}
