class Timer implements Runnable {
    int minutes;
    int sec;
  public void run() {
    int time = 0;
    while (true) {
      try {
        Thread.sleep(1000);
      } catch(InterruptedException exc) {
          System.out.println("Wątek zliczania czasu zoostał przerwany.");
          return;
      }
      time++;
      minutes = time/60;
      sec = time%60;

    }
  }
}
