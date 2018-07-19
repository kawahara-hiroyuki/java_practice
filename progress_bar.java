class progressBar {
	public static void main(String args[]) {
		int parseTime = 5;

		progessBar(parseTime);
	}

	public static void progessBar(int parseTime) {
		int currentProgess = 0;
		int maxPercent = 100;

		int i = 0;
		for (i = 0; i < parseTime; i++) {
			currentProgess += maxPercent / parseTime;

			showProgessBar(currentProgess);

			sleepScript(1000);
		}
	}
		

	public static void sleepScript(int sleepTime) {
			try {
				Thread.sleep(sleepTime);
			}catch(InterruptedException e){}
	}

	public static void showProgessBar(int percent) {

		String progessBar = "";

		int i = 0;
		for (i = 0; i <= 100; i = i + 5) {
			if(i < percent) {
				progessBar =  progessBar + "=";
			} else {
				progessBar = progessBar + " ";
			}
		}

		System.out.print("\r進捗状況[" + progessBar + "] 現在" + percent + "％");

	}


}





/*
import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.*;

class JProgressBarTest10 extends JFrame implements ActionListener{

  Timer timer;
  JButton startButton;
  JButton stopButton;
  JProgressBar bar;
  JLabel label;
  int count;

  public static void main(String[] args){
    JProgressBarTest10 frame = new JProgressBarTest10();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  JProgressBarTest10(){
    count = 0;
    label = new JLabel("Not Start");

    JPanel labelPanel = new JPanel();
    labelPanel.add(label);

    startButton = new JButton("start");
    startButton.addActionListener(this);
    startButton.setActionCommand("start");

    stopButton = new JButton("stop");
    stopButton.addActionListener(this);
    stopButton.setActionCommand("stop");
    stopButton.setEnabled(false);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(startButton);
    buttonPanel.add(stopButton);

    bar = new JProgressBar(0, 50);
    bar.setPreferredSize(new Dimension(100, 40));
    bar.setStringPainted(true);
    bar.setValue(0);

    JPanel barPanel = new JPanel();
    barPanel.add(bar);

    timer = new Timer(100 , this);
    timer.setActionCommand("timer");

    getContentPane().add(labelPanel, BorderLayout.PAGE_START);
    getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
    getContentPane().add(barPanel, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();

    if (cmd.equals("start")){
      startButton.setEnabled(false);
      stopButton.setEnabled(true);

      timer.start();
    }else if (cmd.equals("stop")){
      startButton.setEnabled(true);
      stopButton.setEnabled(false);

      timer.stop();
    }else if (cmd.equals("timer")){
      label.setText(count + " count");

      if (count >= 50){
        startButton.setEnabled(true);
        stopButton.setEnabled(false);

        timer.stop();

        bar.setValue(count);

        count = 0;
      }else{
        count++;
        bar.setValue(count);
      }
    }
  }
}
*/
