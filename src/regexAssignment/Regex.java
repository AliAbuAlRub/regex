package regexAssignment;

public class Regex {

	private String interfacee;
	private String macAddress;
	private String Description;
	private String ipAddress;
	private String mtu;
	private String operationStatus;
	private String adminStatus;
	private String duplexMode;
	private String ifSpeed;

	
	//getters and setters
	public String getInterfacee() {
		return interfacee;
	}

	public void setInterfacee(String interfacee) {
		this.interfacee = "interface name: " + interfacee;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = "mac address: " + macAddress;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = "interface description: " + description;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = "ip address: " + ipAddress;
	}

	public String getMtu() {
		return mtu;
	}

	public void setMtu(String mtu) {
		this.mtu = "mtu: " + mtu;
	}

	public String getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = "operation status: " + operationStatus;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = "admin status: " + adminStatus;
	}

	public String getDuplexMode() {
		return duplexMode;
	}

	public void setDuplexMode(String duplexMode) {
		this.duplexMode = "duplex mode: " + duplexMode;
	}

	public String getIfSpeed() {
		return ifSpeed;
	}

	public void setIfSpeed(String ifSpeed) {
		this.ifSpeed = "ifSpeed: " + ifSpeed;
	}

	@Override
	public String toString() {
		return this.interfacee + "\n" + this.macAddress + "\n" + this.Description + "\n" + this.ipAddress + "\n"
				+ this.mtu + "\n" + this.operationStatus + "\n" + this.adminStatus + "\n" + this.duplexMode + "\n"
				+ this.ifSpeed;
	}

}
