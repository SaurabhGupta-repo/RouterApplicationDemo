package packet;

import java.util.Comparator;

/**
 * This comparator compares two packets by their 'IsLarge' flag.
 * @author www.codejava.net
 *
 */
public class PacketIsLargeComparator implements Comparator<Packet> {
 
	  @Override
	    public int compare(Packet newPacket, Packet oldPacket) {
	        
	        if (newPacket.getIsLarge().equalsIgnoreCase("true") && oldPacket.getIsLarge().equalsIgnoreCase("true") ){
				return 0;
			}
			else if (newPacket.getIsLarge().equalsIgnoreCase("true") )		
				return -1;
			else if (oldPacket.getIsLarge().equalsIgnoreCase("true") )		
				return 1;
			else
				return 0;
	        
	    }

}