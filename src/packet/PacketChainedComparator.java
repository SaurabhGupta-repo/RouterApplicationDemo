package packet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PacketChainedComparator implements Comparator<Packet> {
 
    private List<Comparator<Packet>> listComparators;
 
    @SafeVarargs
    public PacketChainedComparator(Comparator<Packet>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Packet newPacket, Packet oldPacket) {
        for (Comparator<Packet> comparator : listComparators) {
            int result = comparator.compare(newPacket, oldPacket);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
