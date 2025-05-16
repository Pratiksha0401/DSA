package org.example.patterns;

public class StartPatterns {

    public static void main(String[] args) {

        /*
        *
        *
        *
        *
        * pattern1---------------
        # # # # #
        # # # # #
        # # # # #
        # # # # #
        # # # # #
        pattern2---------------
        #
        # #
        # # #
        # # # #
        # # # # #
        pattern3---------------
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
        --------pattern4-------
        1
        2 2
        3 3 3
        4 4 4 4
        5 5 5 5 5
        -------pattern5--------
        # # # # #
        # # # #
        # # #
        # #
        #
        -------pattern6--------
        1 2 3 4 5
        1 2 3 4
        1 2 3
        1 2
        1
        ---------pattern7------
                *
              * * *
            * * * * *
          * * * * * * *
        * * * * * * * * *
        -------pattern8--------
        * * * * * * * * *
          * * * * * * *
            * * * * *
              * * *
                *
        -------pattern9--------
                *
              * * *
            * * * * *
          * * * * * * *
        * * * * * * * * *
        * * * * * * * * *
          * * * * * * *
            * * * * *
              * * *
                *
        --------pattern10-------
        *
        **
        ***
        ****
        *****
        ****
        ***
        **
        *
        -------pattern1--------
        1
        1 0
        1 0 1
        1 0 1 0
        1 0 1 0 1
        -------pattern12--------
        1________1
        12______21
        123____321
        1234__4321
        1234554321
        --------pattern13-------
        1
        2 3
        4 5 6
        7 8 9 10
        11 12 13 14 15
        --------pattern14-------
        A
        A B
        A B C
        A B C D
        A B C D E
        --------pattern15-------
        A B C D E
        A B C D
        A B C
        A B
        A
        --------pattern16-------
        A
        B B
        C C C
        D D D D
        E E E E E
        --------pattern17-------
        1
        2 2
        3 3 3
        4 4 4 4
        5 5 5 5 5
        --------pattern18-------
        A
        B B
        C C C
        D D D D
        E E E E E
        --------pattern19-------
        _____A
        ____ABA
        ___ABCBA
        __ABCDCBA
        _ABCDEDCBA
        -------pattern20--------
        E
        DE
        CDE
        BCDE
        ABCDE
        ---------pattern21------
        ##########
        ####__####
        ###____###
        ##______##
        #________#
        #________#
        ##______##
        ###____###
        ####__####
        ##########
        --------pattern22-------
        _____#_
        ____#_#_
        ___#_#_#_
        __#_#_#_#_
        _#_#_#_#_#_
        --------pattern23-------
        #______#####
        ##_____####
        ###____###
        ####___##
        #####__#
        ######_
        #######
        ########
        #########
        #####________#
        ####______##
        ###____###
        ##__####
        ######
        *
        * */
        System.out.println("pattern1---------------");
        pattern1(5);
        System.out.println("pattern2---------------");
        pattern2(5);
        System.out.println("pattern3---------------");
        pattern3(5);
        System.out.println("--------pattern4-------");
        pattern4(5);
        System.out.println("-------pattern5--------");
        pattern5(5);
        System.out.println("-------pattern6--------");
        pattern6(5);
        System.out.println("---------pattern7------");
        pattern7(5);
        System.out.println("-------pattern8--------");
        pattern8(5);
        System.out.println("-------pattern9--------");
        pattern9(5);
        System.out.println("--------pattern10-------");
        pattern10(5);
        System.out.println("-------pattern1--------");
        pattern11(5);
        System.out.println("-------pattern12--------");
        pattern12(5);
        System.out.println("--------pattern13-------");
        pattern13(5);
        System.out.println("--------pattern14-------");
        pattern14(5);
        System.out.println("--------pattern15-------");
        pattern15(5);
        System.out.println("--------pattern16-------");
        pattern16(5);
        System.out.println("--------pattern17-------");
        pattern17(5);
        System.out.println("--------pattern18-------");
        pattern18(5);
        System.out.println("--------pattern19-------");
        pattern19(5);
        System.out.println("-------pattern20--------");
        pattern20(5);
        System.out.println("---------pattern21------");
        pattern21(5);
        System.out.println("--------pattern22-------");
        pattern22(5);
        System.out.println("--------pattern23-------");
        pattern23(5);
    }

    /**
     *     # # #
     *     # # #
     *     # # #
     * */
    public static void pattern1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    /**
     *
     * #
     * # #
     * # # #
     * # # # #
     * # # # # #
     *
    * */
    public static void pattern2(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int tmp = j+1;
                System.out.print(tmp +" ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int tmp = i+1;
                System.out.print(tmp +" ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n){
        for(int i=n;i>0;i--){
            for(int j=i;j>0;j--){
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n){
        for(int i=n;i>0;i--){
            for(int j=0;j<i;j++){
                int tmp = j+1;
                System.out.print(tmp+" ");
            }
            System.out.println();
        }
    }

    public static void pattern7(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print("  ");
            }
            for(int k=0;k<2*i+1;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print("  ");
            }
            for(int k=0;k< 2*n - (2*i+1);k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n){
        for(int i=0;i<n;i++) {
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print("  ");
            }
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print("  ");
            }
            for(int k=0;k< 2*n - (2*i+1);k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern10(int n){
        for(int i=0;i<n;i++){
            for(int k=0;k<i+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n-1;i>0;i--){
            for(int k=i;k>0;k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern11(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int tmp = (j+1)%2;
                System.out.print(tmp+" ");
            }
            System.out.println();
        }
    }

    public static void pattern12(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int tmp = j+1;
                System.out.print(tmp+"");
            }

            for(int j=2*n-(2*i+2);j>0;j--){
                System.out.print("_");
            }

            for(int j=i;j>=0;j--){
                int tmp = (j+1);
                System.out.print(tmp+"");
            }
            System.out.println();
        }
    }

    public static void pattern13(int n){
        int num =1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num+" ");
                num = num+1;
            }
            System.out.println();
        }
    }

    public static void pattern14(int n){
        for(int i=1;i<=n;i++){
            for(int j=65;j<65+i;j++){
                System.out.print((char)j+" ");
            }
            System.out.println();
        }
    }

    public static void pattern15(int n){
        for(int i=n;i>0;i--){
            for(int j=65;j<65+i;j++){
                System.out.print((char)j+" ");
            }
            System.out.println();
        }
    }

    public static void pattern16(int n){
        char ch='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
            }
            ch = (char) (ch+1);
            System.out.println();
        }
    }

    public static void pattern17(int n){
        int num =1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num+" ");
            }
            num = num+1;
            System.out.println();
        }
    }

    public static void pattern18(int n){
        char ch='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
            }
            ch = (char) (ch+1);
            System.out.println();
        }
    }

    public static void pattern19(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=n-i-1;j++){
                System.out.print("_");
            }
            int breakpoint=(2*i+1)/2;
            char ch='A';
            for(int j=0;j<2*i+1;j++){
                System.out.print((char)(ch)+"");
                if(j<breakpoint)
                    ch++;
                else
                    ch--;
            }

            System.out.println();
        }
    }

    public static void pattern20(int n){
        for(int i=0;i<n;i++){
            for(char j = (char) ('E'-i); j<='E'; j++){
                System.out.print((char)j+"");
            }

            System.out.println();
        }
    }

    public static void pattern21(int n){
        for(int i=0;i<n;i++){
            for(int j = i;j<n;j++){
                System.out.print("#");
            }
            for(int j = 0;j<(2*i);j++){
                System.out.print("_");
            }
            for(int j =i;j<n;j++){
                System.out.print("#");
            }

            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j = 0;j<=i;j++){
                System.out.print("#");
            }
            for(int j =0;j<2 * (n - i - 1);j++){
                System.out.print("_");
            }
            for(int j =0;j<=i;j++){
                System.out.print("#");
            }

            System.out.println();
        }
    }

    public static void pattern22(int n){
        for(int i=0;i<n;i++){
            for(char j =0; j<=n-i-1; j++){
                System.out.print("_");
            }

            for(char j =0; j<=i; j++){
                System.out.print("#_");
            }

            System.out.println();
        }
    }


    public static void pattern23(int n){
        for(int i=0;i<2*n-1;i++){
            for(int j = 0;j<=i;j++){
                System.out.print("#");
            }
            for(int j = (n-(i));j>=0;j--){
                System.out.print("_");
            }
            for(int j =i;j<n;j++){
                System.out.print("#");
            }

            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j = n;j>i;j--){
                System.out.print("#");
            }
            for(int j =0;j<2 * (n - i - 1);j++){
                System.out.print("_");
            }
            for(int j =0;j<=i;j++){
                System.out.print("#");
            }

            System.out.println();
        }
    }


}

