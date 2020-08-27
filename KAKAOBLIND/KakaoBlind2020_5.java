import java.util.*;
class KakaoBlind2020_5 {
    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<Frame> list = new ArrayList<>();

        for(int i=0;i<build_frame.length;i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if(b==0){ // 삭제
                list.remove(new Frame(x,y,a));
                if(!isDelete(list,x,y)){ // 삭제가 불가능 하다면
                    list.add(new Frame(x,y,a));
                }
            } else { // 생성
                if(a==0){ // 기둥 생성
                    if(isMakeColumn(list,x,y)){
                        list.add(new Frame(x,y,a));
                    }
                } else { // 보 생성
                    if(isMakeBeam(list,x,y)){
                        list.add(new Frame(x,y,a));
                    }
                }
            }
        }

        int[][] result = new int[list.size()][3];

        for(int i=0;i< result.length;i++){
            Frame frame = list.get(i);
            result[i][0] = frame.x;
            result[i][1] = frame.y;
            result[i][2] = frame.type;
        }

        Arrays.sort(result, (o1, o2) -> {
            if(o1[0]==o2[0]){
                if(o1[1]==o2[1]){
                    return o1[2]-o2[2];
                } else {
                    return o1[1]-o2[1];
                }
            } else {
                return o1[0]-o2[0];
            }
        });

        return result;
    }

    public boolean isMakeColumn(ArrayList<Frame> list, int x, int y){
        if(y==0 || list.contains(new Frame(x,y-1,0)) || list.contains(new Frame(x-1,y,1))
                || list.contains(new Frame(x,y,1))){
            return true;
        } else {
            return false;
        }
    }

    public boolean isMakeBeam(ArrayList<Frame> list, int x, int y){
        if(list.contains(new Frame(x,y-1,0)) || list.contains(new Frame(x+1,y-1,0))
                || (list.contains(new Frame(x-1,y,1)) && list.contains(new Frame(x+1,y,1)))){
            return true;
        } else {
            return false;
        }
    }

    public boolean isDelete(ArrayList<Frame> list, int x, int y){
        for(int i=0;i<list.size();i++){
            Frame frame = list.get(i);
            if(frame.type==0){ // 기둥이면
                if(!isMakeColumn(list, frame.x, frame.y)){  // 지금 자리에 기둥을 세울 수 있다면
                    return false; // 삭제 불가
                }
            } else { // 보이면
                if(!isMakeBeam(list, frame.x, frame.y)){
                    return false;
                }
            }
        }
        return true; // 이상없으면 삭제 가능
    }
}

class Frame{
    int x;
    int y;
    int type;

    Frame(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }
        Frame frame = (Frame)object;

        if(x==frame.x && y==frame.y && type==frame.type){
            return true;
        } else {
            return false;
        }
    }
}