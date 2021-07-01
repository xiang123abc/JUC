package com.mashibing.juc.c_020;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class T09_TestPhaser2_my {
    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();


    static void milliSleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        phaser.bulkRegister(7);

        for(int i=0; i<5; i++) {

            new Thread(new Person("p" + i)).start();
        }

        new Thread(new Person("����")).start();
        new Thread(new Person("����")).start();

    }



    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println("�����˵����ˣ�" + registeredParties);
                    System.out.println();
                    return false;//
                case 1:
                    System.out.println("�����˳����ˣ�" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("�������뿪�ˣ�" + registeredParties);
                    System.out.println();
                    return false;
                case 4:
                    System.out.println("����������������ﱧ����" + registeredParties);
                    System.out.println();
                    return false;
                default:
                    return false;
            }
//            return false;
        }
    }


    static class Person implements Runnable {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {

            milliSleep(r.nextInt(1000));
            System.out.printf("%s �����ֳ���\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void eat() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s ����!\n", name);
            phaser.arriveAndAwaitAdvance();
        }

        public void leave() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s �뿪��\n", name);


            phaser.arriveAndAwaitAdvance();
        }

        private void hug() {
            if(name.equals("����") || name.equals("����")) {
                milliSleep(r.nextInt(1000));
                System.out.printf("%s ������\n", name);
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();//-----------------------------
                //phaser.register()
            }
        }

        @Override
        public void run() {
            arrive();//  ��Ӧ  phase 0


            eat();//  ��Ӧ  phase 1


            leave();


            hug();

        }
    }
}


