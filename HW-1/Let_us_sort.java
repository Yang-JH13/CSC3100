import java.util.*;

class coordinate{
    private int x;
    private int y;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public coordinate(){
    }
}

public class Let_us_sort {

    public static void main(String[] args) {
        int T,n,id,k,A;

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        for (int i =0;i<T;i++){

            n = scanner.nextInt();
            k = scanner.nextInt();
            id = scanner.nextInt();
            List<coordinate> points = new ArrayList<coordinate>();

            if(n==1){
                A = scanner.nextInt();
                int op1 = A/k;
                int op2 = A%k;
                System.out.println(op1 + " " + op2);
                System.out.println();
            }
            else{
                for (int j = 0; j < n; j++) {
                    A = scanner.nextInt();
                    coordinate point = new coordinate(A/k,A%k);
                    points.add(point);
                }

                if(id==1){
                    Collections.sort(points, new Comparator<coordinate>() {
                        @Override
                        public int compare(coordinate o1, coordinate o2) {
                            if(o1.getX()-o2.getX()==0)
                                return o1.getY()-o2.getY();
                            else return o1.getX()-o2.getX();
                        }
                    });
                }
                else if(id==2){
                    Collections.sort(points, new Comparator<coordinate>() {
                        @Override
                        public int compare(coordinate o1, coordinate o2) {
                            if(o1.getX()-o2.getX()==0)
                                return o1.getY()-o2.getY();
                            else return o2.getX()-o1.getX();
                        }
                    });
                }
                else if(id==3){
                    Collections.sort(points, new Comparator<coordinate>() {
                        @Override
                        public int compare(coordinate o1, coordinate o2) {
                            if(o1.getX()-o2.getX()==0)
                                return o2.getY()-o1.getY();
                            else return o1.getX()-o2.getX();
                        }
                    });
                }
                else if(id==4){
                    Collections.sort(points, new Comparator<coordinate>() {
                        @Override
                        public int compare(coordinate o1, coordinate o2) {
                            if(o1.getX()-o2.getX()==0)
                                return o2.getY()-o1.getY();
                            else return o2.getX()-o1.getX();
                        }
                    });
                }


                for(int p=0;p<n;p++){
                    int otp1 = points.get(p).getX();
                    int otp2 = points.get(p).getY();
                    System.out.println(otp1 + " " + otp2);
                }
                System.out.println();
            }

        }
    }
}