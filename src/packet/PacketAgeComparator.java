package packet;

import java.util.Comparator;

public class PacketAgeComparator implements Comparator<Packet> {
	 
	  @Override
	    public int compare(Packet newPacket, Packet oldPacket) {
	        
	       
				return (int) (newPacket.getReceiviingTime()-oldPacket.getReceiviingTime());
	        
	    }

}
