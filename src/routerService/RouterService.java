package routerService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import packet.*;

public class RouterService {

	private static ExecutorService producerService= null;
	private static ExecutorService routerService= null;
    private static BlockingQueue<Packet> priorityBQ;
		
		
	public static void main(String[] args) {
		
		priorityBQ= new PriorityBlockingQueue<Packet>(20 , new PacketChainedComparator(
				new PacketSourceTypeComparator(),
                new PacketIsLargeComparator(),
                new PacketAgeComparator()));
		
        /*executing producer service*/
		producerService=  Executors.newFixedThreadPool(1);
	    producerService.execute(new PacketProducer(priorityBQ, 1));
				 
	    /*executing router service*/
	    
	   /* with Timeout  - Executor Service based implementation*/
	  
	   /* PacketConsumerWithTimeout packetConsumerWithTimeout1 = new PacketConsumerWithTimeout(priorityBQ, 1);
	    PacketConsumerWithTimeout packetConsumerWithTimeout2 = new PacketConsumerWithTimeout(priorityBQ, 2);
	    
		 routerService=  Executors.newFixedThreadPool(5);
		 routerService.execute(new Thread (packetConsumerWithTimeout1));
		 routerService.execute(new Thread (packetConsumerWithTimeout2));*/
		 
		 
	    /* without Timeout  - Thread based implementation*/
	    PacketConsumer packetConsumer1 = new PacketConsumer(priorityBQ, 1);
	    PacketConsumer packetConsumer2 = new PacketConsumer(priorityBQ, 2);
	  
	    
		 					 
		Thread consThread1= new Thread (packetConsumer1);
		Thread consThread2= new Thread (packetConsumer1);
		Thread consThread3= new Thread (packetConsumer1);
		Thread consThread4= new Thread (packetConsumer2);
		Thread consThread5= new Thread (packetConsumer2);
		
		consThread1.setName("packetConsumer1  --> Thread 1");
		consThread2.setName("packetConsumer1  --> Thread 2");
		consThread3.setName("packetConsumer1  --> Thread 3");
		consThread4.setName("packetConsumer2  --> Thread 1");
		consThread5.setName("packetConsumer2  --> Thread 2");
		
		consThread1.start();
		consThread2.start();
		consThread3.start();
		consThread4.start();
		consThread5.start();
	}
}
	
