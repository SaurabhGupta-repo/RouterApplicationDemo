package routerService;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import packet.Packet;

public class PacketProducer implements Runnable {

	private int threadNo;
	private final BlockingQueue<Packet> sharedQueue;

	ConcurrentHashMap<Integer, Packet> packetMap;

	public PacketProducer(BlockingQueue<Packet> sharedQueue, int threadNo) {
		this.threadNo = threadNo;
		this.sharedQueue = sharedQueue;
		populatePacketMap();
		// this.sharedQueue= new PriorityBlockingQueue<>(sharedQueue);

	}

	@Override
	public void run() {

		for (int i = 1; i <= 20; i++) {
			try {
				System.out.println("Produced: " + packetMap.get(i).toString() + ": by thread: " + threadNo);
				sharedQueue.put(packetMap.get(i));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	public void populatePacketMap() {
		Packet p1 = new Packet("Management", "False", "1. Management --> False");
		Packet p2 = new Packet("Management", "True", "2. Management --> True");
		Packet p3 = new Packet("User", "True", "3. User --> True");
		Packet p4 = new Packet("User", "False", "4. User --> False");
		Packet p5 = new Packet("Management", "True", "5. Management --> True");
		Packet p6 = new Packet("Management", "True", "6. Management --> True");
		Packet p7 = new Packet("Management", "True", "7. Management --> True");
		Packet p8 = new Packet("Management", "True", "8. Management --> True");
		Packet p9 = new Packet("Management", "True", "9. Management --> True");
		Packet p10 = new Packet("Management", "True", "10. Management --> True");
		Packet p11 = new Packet("Management", "False", "11. Management --> False");

		Packet p12 = new Packet("Management", "False", "12. Management --> False");
		Packet p13 = new Packet("User", "False", "13. User --> False");
		Packet p14 = new Packet("User", "False", "14. User --> False");
		Packet p15 = new Packet("User", "True", "15. User --> True");
		Packet p16 = new Packet("User", "True", "16. User --> True");
		Packet p17 = new Packet("User", "True", "17. User --> True");
		Packet p18 = new Packet("Management", "True", "18. Management --> True");
		Packet p19 = new Packet("Management", "False", "19. Management --> False");
		Packet p20 = new Packet("Management", "True", "20. Management --> True");

		packetMap = new ConcurrentHashMap<>();

		packetMap.put(1, p1);
		packetMap.put(2, p2);
		packetMap.put(3, p3);
		packetMap.put(4, p4);
		packetMap.put(5, p5);
		packetMap.put(6, p6);
		packetMap.put(7, p7);
		packetMap.put(8, p8);
		packetMap.put(9, p9);
		packetMap.put(10, p10);
		packetMap.put(11, p11);
		packetMap.put(12, p12);
		packetMap.put(13, p13);
		packetMap.put(14, p14);
		packetMap.put(15, p15);
		packetMap.put(16, p16);
		packetMap.put(17, p17);
		packetMap.put(18, p18);
		packetMap.put(19, p19);
		packetMap.put(20, p20);
	}
}
