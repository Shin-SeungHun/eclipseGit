package thread;

public class ServerData {

	// 디비 회원정보를 저장할 변수
	public static String id;
	public static String pw;
	public static String name;
	public static String grade;

	// 디비 담당 기계정보 저장할 변수
	public static String productName[];
	public static int productCnt[];
	public static int productSecond[];
	public static String productMemberName[];
	public static String productMemberId[];

	public ServerData() {

	}

	public ServerData(String id, String pw, String name, String grade) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.grade = grade;
	}

	public ServerData(String[] productName, int[] productCnt, int[] productSeocnd, String[] productMemberName,
			String[] productMemberId) {
		this.productName = productName;
		this.productCnt = productCnt;
		this.productSecond = productSecond;
		this.productMemberName = productMemberName;
		this.productMemberId = productMemberId;

	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		ServerData.id = id;
	}

	public static String getPw() {
		return pw;
	}

	public static void setPw(String pw) {
		ServerData.pw = pw;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ServerData.name = name;
	}

	public static String getGrade() {
		return grade;
	}

	public static void setGrade(String grade) {
		ServerData.grade = grade;
	}

	public static String getPart() {
		return part;
	}

	public static void setPart(String part) {
		ServerData.part = part;
	}

	public static String[] getProductName() {
		return productName;
	}

	public static void setProductName(String[] productName) {
		ServerData.productName = productName;
	}

	public static int[] getProductCnt() {
		return productCnt;
	}

	public static void setProductCnt(int[] productCnt) {
		ServerData.productCnt = productCnt;
	}

	public static int[] getProductSecond() {
		return productSecond;
	}

	public static void setProductSecond(int[] productSecond) {
		ServerData.productSecond = productSecond;
	}

	public static String[] getProductMemberName() {
		return productMemberName;
	}

	public static void setProductMemberName(String[] productMemberName) {
		ServerData.productMemberName = productMemberName;
	}

	public static String[] getProductMemberId() {
		return productMemberId;
	}

	public static void setProductMemberId(String[] productMemberId) {
		ServerData.productMemberId = productMemberId;
	}

	public static String part;

	@Override
	public String toString() {
		return "Server_data [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
