package packet;

import java.util.Comparator;

public class Packet {
	
	static int counter=0;
	
	private String sourceType;
	private String isLarge;
	private String content;
	private long receiviingTime;
	
	
	
	
	@Override
	public String toString() {
		return "Packet [sourceType=" + sourceType + ", isLarge=" + isLarge + ", content=" + content
				+ ", receiviingTime=" + receiviingTime + "]";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSourceType() {
		return sourceType;
	}
	
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getIsLarge() {
		return isLarge;
	}
	public void setIsLarge(String isLarge) {
		this.isLarge = isLarge;
	}
	public long getReceiviingTime() {
		return receiviingTime;
	}
	public void setReceiviingTime(long receiviingTime) {
		this.receiviingTime = receiviingTime;
	}

	public Packet(String sourceType, String isLarge, String content) {
		super();
		this.sourceType = sourceType;
		this.isLarge = isLarge;
		this.content = content;
		this.receiviingTime=++counter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((isLarge == null) ? 0 : isLarge.hashCode());
		result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Packet other = (Packet) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (isLarge == null) {
			if (other.isLarge != null)
				return false;
		} else if (!isLarge.equals(other.isLarge))
			return false;
		if (receiviingTime != other.receiviingTime)
			return false;
		if (sourceType == null) {
			if (other.sourceType != null)
				return false;
		} else if (!sourceType.equals(other.sourceType))
			return false;
		return true;
	}
	
}

class PacketComparator1 implements Comparator<Packet>{

	
	@Override
	public int compare(Packet o1, Packet o2) {
		// TODO Auto-generated method stub
		
		int compareStatus=0;
	System.out.println("in comparator");
	
	//// Management Type
	if ( (o1 instanceof Packet && o1.getSourceType().equalsIgnoreCase("Management"))
			&& (o2 instanceof Packet && o2.getSourceType().equalsIgnoreCase("Management")))
	{
		
		if (o1.getIsLarge().equalsIgnoreCase("true") && o1.getIsLarge().equalsIgnoreCase("true") ){
			compareStatus= (int) (o2.getReceiviingTime()-o1.getReceiviingTime());
		}
		else if (o1.getIsLarge().equalsIgnoreCase("true") )		
			compareStatus=-1;
		else if (o2.getIsLarge().equalsIgnoreCase("true") )		
			compareStatus=1;
		else 
			compareStatus=(int) (o2.getReceiviingTime()-o1.getReceiviingTime());
		
	}
	//// User Type
	else if ( (o1 instanceof Packet && o1.getSourceType().equalsIgnoreCase("User"))
			&& (o2 instanceof Packet && o2.getSourceType().equalsIgnoreCase("User")))
	{
		
		if (o1.getIsLarge().equalsIgnoreCase("true") && o1.getIsLarge().equalsIgnoreCase("true") ){
			compareStatus= (int) (o2.getReceiviingTime()-o1.getReceiviingTime());
		}
		else if (o1.getIsLarge().equalsIgnoreCase("true") )		
			compareStatus=-1;
		else if (o2.getIsLarge().equalsIgnoreCase("true") )		
			compareStatus=1;
		else 
			compareStatus=(int) (o2.getReceiviingTime()-o1.getReceiviingTime());
		
	}
	else {
		compareStatus=(int) (o2.getReceiviingTime()-o1.getReceiviingTime());
		
	}

	return compareStatus;
}
}


