package packet;

import java.util.Comparator;

/**
 * This comparator compares two packets by their  SourceType.
 * @author www.codejava.net
 *
 */

public class PacketSourceTypeComparator implements Comparator<Packet> {
 
    @Override
    public int compare(Packet newPacket, Packet oldPacket) {
        return newPacket.getSourceType().compareTo(oldPacket.getSourceType());
    }
}
