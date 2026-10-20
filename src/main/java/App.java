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
        System.out.println("명언(기존) %s".formatted(wiseSayings[modifyId - 1].getContent()));
        System.out.print("명언 : ");
        wiseSayings[modifyId - 1].setContent(scanner.nextLine().trim());

        System.out.println("작가(기존) : %s".formatted(wiseSayings[modifyId - 1].getAuthor()));
        System.out.print("작가 : ");
        wiseSayings[modifyId - 1].setAuthor(scanner.nextLine().trim());
    }

    boolean isWiseSayingExistById(int deleteId) {
        boolean isWiseSayingExist = true;
        if(deleteId-1 >= wiseSayingLastIndex || wiseSayings[deleteId - 1].getId() == 0)
            isWiseSayingExist = false;

        return isWiseSayingExist;

    }

    void deleteWiseSayingById(int deleteId) {
        if(!isWiseSayingExistById(deleteId)){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(deleteId));
        }
        else{
            wiseSayings[deleteId - 1].setId(0);
            wiseSayings[deleteId - 1].setAuthor(null);
            wiseSayings[deleteId - 1].setContent(null);
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
        }
    }

    void showWiseSayingList(){
        WiseSaying[] sortedWiseSayings = getWiseSayingList();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for(int i=0; i < sortedWiseSayings.length; i++){
            if(sortedWiseSayings[i].getId() == 0)
                continue;
            System.out.println("%d / %s / %s".formatted(sortedWiseSayings[i].getId(), sortedWiseSayings[i].getAuthor(), sortedWiseSayings[i].getContent()));
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
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        int id = wiseSayingLastIndex + 1;

        wiseSayings[wiseSayingLastIndex] = new WiseSaying(id,content,author);

        wiseSayingLastIndex++;

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSayingLastIndex));
    }
}
