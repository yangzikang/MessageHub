package com.ea.messagelibrary.messageDistribute;
public class SCControlThread implements Runnable{
    public Thread t;
    boolean suspended=false;
    
    public SCControlThread(){

    }

    public void run() {
      while(true){
        try {
            Thread.sleep(100);
            synchronized(this) {
                if(suspended) {
                   wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

      }
    }
    
    /**
     * 开始
     */
    public void start(){
        if(t==null){
            t=new Thread(this);
            t.start();
        }
    }
    
    /**
     * 暂停
     */
     void suspend(){
        suspended = true;
    }
     
     /**
      * 继续
      */
     synchronized void resume(){
         suspended = false;
         notify();
     }
}