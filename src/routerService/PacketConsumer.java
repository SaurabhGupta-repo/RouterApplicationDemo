package routerService;

import java.util.concurrent.BlockingQueue;

import packet.Packet;

/**
 * @author Saurabh Gupta
 */

public class PacketConsumer implements Runnable{
	
	private int threadNo;
	private final BlockingQueue<Packet> sharedQueue;
	

	public PacketConsumer (BlockingQueue<Packet> sharedQueue, int threadNo){
		 this.threadNo=threadNo;
		 this.sharedQueue=sharedQueue;
		 
	}
	
	@Override
	public void run() {
		
	while (true) //!sharedQueue.isEmpty()
			try{
				synchronized (this) {
					
					Packet packet=sharedQueue.take();
					// Thread.sleep(10);
					System.out.println("Consumed: "+packet.toString() + ": by thread: "+Thread.currentThread().getName());

				}
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in PacketConsumer --> run() :"+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
}

