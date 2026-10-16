import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        int wiseSayingLastIndex = 0;

        WiseSaying[] wiseSayings = new WiseSaying[100];

        while(true){
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if(cmd.equals("종료")){
                break;
            }

            else if(cmd.equals("등록")){
                wiseSayings[wiseSayingLastIndex] = new WiseSaying();
                System.out.print("명언 : ");
                wiseSayings[wiseSayingLastIndex].content = scanner.nextLine().trim();
                System.out.print("작가 : ");
                wiseSayings[wiseSayingLastIndex].author = scanner.nextLine().trim();
                wiseSayings[wiseSayingLastIndex].id = wiseSayingLastIndex+1;
                wiseSayingLastIndex++;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSayingLastIndex));
            }

            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");

                for(int i = wiseSayingLastIndex-1 ; i >= 0; i--){
                    System.out.println("%d / %s / %s".formatted(wiseSayings[i].id, wiseSayings[i].author, wiseSayings[i].content));
                }
            }
        }

        scanner.close();
    }
}
