public class Round15_Ex05 {
	public static void main(String[] args) {
		int count = Thread.activeCount(); 
		System.out.println("count = " + count);
		Thread cur = Thread.currentThread();
		System.out.println("cur = " + cur);
		System.out.println("cur name = " + cur.getName());
		try{
			Thread.sleep(2000);
		}catch(InterruptedException ie) {
			System.err.println("이거 실행 되는 경우는 없슴.");
		}
		System.out.println("cur priority = " + cur.getPriority());
		System.out.println("cur alive = " + cur.isAlive());
		System.out.println("cur daemon = " 	+ cur.isDaemon());
	}
}
