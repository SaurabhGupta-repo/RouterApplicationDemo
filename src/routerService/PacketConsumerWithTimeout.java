package routerService;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import packet.Packet;

public class PacketConsumerWithTimeout implements Runnable{
	
	private int threadNo;
	private final BlockingQueue<Packet> sharedQueue;
	

	public PacketConsumerWithTimeout (BlockingQueue<Packet> sharedQueue, int threadNo){
		 this.threadNo=threadNo;
		 this.sharedQueue=sharedQueue;
		 
	}
	
	@Override
	public void run() {
		
		int USER_INPUT_TIME= 5;  // configurable. It can be adjusted and read dynamically from property file.
		
	
			try{
				
				while (true) //!sharedQueue.isEmpty()
				{
					synchronized (this) {
						
					
					Packet packet=sharedQueue.poll( USER_INPUT_TIME, TimeUnit.SECONDS);
					// Thread.sleep(10);
					if (packet== null){
						System.out.println("No Packet. Times out."+ " Thread: "+Thread.currentThread().getName());
					break;
					}
					
					System.out.println("Consumed: "+packet.toString() + ": by thread: "+Thread.currentThread().getName());

				}		}
				
			} catch (InterruptedException ie) {
				System.out.println("InterruptedException in PacketConsumer --> run() :"+ie.getLocalizedMessage());
	            ie.printStackTrace();
	        }catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in PacketConsumer --> run() :"+e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
}

