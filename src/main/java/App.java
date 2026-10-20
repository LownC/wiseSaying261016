import java.util.Arrays;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    WiseSaying[] wiseSayings = new WiseSaying[100];
    private int wiseSayingLastIndex = 0;

    void run(){
        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if(cmd.equals("종료")){
                break;
            }

            else if(cmd.equals("등록")){
                addWiseSaying();
            }

            else if(cmd.equals("목록")){
                showWiseSayingList();
            }

            else if(cmd.startsWith("삭제?id=")){
                int deleteId = Integer.parseInt(cmd.split("=")[1]);
                deleteWiseSayingById(deleteId);
            }

            else if(cmd.startsWith("수정?id=")){
                int modifyId = Integer.parseInt(cmd.split("=")[1]);
                modifyWiseSayingById(modifyId);
            }
        }
        scanner.close();
    }

    void modifyWiseSayingById(int modifyId) {
        if(!isWiseSayingExistById(modifyId)){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(modifyId));
        }

        else{
            modifyContentAndAuthor(modifyId);
        }
    }

    void modifyContentAndAuthor(int modifyId) {
        System.out.println("명언(기존) %s".formatted(wiseSayings[modifyId-1].content));
        System.out.print("명언 : ");
        wiseSayings[modifyId-1].content = scanner.nextLine().trim();

        System.out.println("작가(기존) : %s".formatted(wiseSayings[modifyId-1].author));
        System.out.print("작가 : ");
        wiseSayings[modifyId-1].author = scanner.nextLine().trim();
    }

    boolean isWiseSayingExistById(int deleteId) {
        boolean isWiseSayingExist = true;
        if(deleteId-1 >= wiseSayingLastIndex || wiseSayings[deleteId-1].id == 0)
            isWiseSayingExist = false;

        return isWiseSayingExist;

    }

    void deleteWiseSayingById(int deleteId) {
        if(!isWiseSayingExistById(deleteId)){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteId));
        }
        else{
            wiseSayings[deleteId-1].id=0;
            wiseSayings[deleteId-1].author = null;
            wiseSayings[deleteId-1].content = null;
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
        }
    }

    void showWiseSayingList(){
        WiseSaying[] sortedWiseSayings = getWiseSayingList();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for(int i=0; i < sortedWiseSayings.length; i++){
            if(sortedWiseSayings[i].id == 0)
                continue;
            System.out.println("%d / %s / %s".formatted(sortedWiseSayings[i].id, sortedWiseSayings[i].author, sortedWiseSayings[i].content));
        }
    }

    WiseSaying[] getWiseSayingList(){

        WiseSaying[] sortedWiseSayings = new WiseSaying[wiseSayingLastIndex];
        int index = 0;
        for(int i = wiseSayingLastIndex-1 ; i >= 0; i--){
            sortedWiseSayings[index++] = wiseSayings[i];
        }

        return sortedWiseSayings;
    }

    void addWiseSaying(){
        wiseSayings[wiseSayingLastIndex] = new WiseSaying();
        System.out.print("명언 : ");
        wiseSayings[wiseSayingLastIndex].content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        wiseSayings[wiseSayingLastIndex].author = scanner.nextLine().trim();
        wiseSayings[wiseSayingLastIndex].id = wiseSayingLastIndex+1;
        wiseSayingLastIndex++;
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSayingLastIndex));
    }
}
