// point1 -> point2 -> point3 -> point4 -> point1 구조로 이루어진 히트박스 체크
public class HitBoxCheck {
	private double point1X;
	private double point1Y;
	
	private double point2X;
	private double point2Y;
	
	private double point3X;
	private double point3Y;
	
	private double point4X;
	private double point4Y;
	
	public double getPoint1X() {
		return point1X;
	}

	public void setPoint1X(double point1x) {
		point1X = point1x;
	}

	public double getPoint1Y() {
		return point1Y;
	}

	public void setPoint1Y(double point1y) {
		point1Y = point1y;
	}

	public double getPoint2X() {
		return point2X;
	}

	public void setPoint2X(double point2x) {
		point2X = point2x;
	}

	public double getPoint2Y() {
		return point2Y;
	}

	public void setPoint2Y(double point2y) {
		point2Y = point2y;
	}

	public double getPoint3X() {
		return point3X;
	}

	public void setPoint3X(double point3x) {
		point3X = point3x;
	}

	public double getPoint3Y() {
		return point3Y;
	}

	public void setPoint3Y(double point3y) {
		point3Y = point3y;
	}

	public double getPoint4X() {
		return point4X;
	}

	public void setPoint4X(double point4x) {
		point4X = point4x;
	}

	public double getPoint4Y() {
		return point4Y;
	}

	public void setPoint4Y(double point4y) {
		point4Y = point4y;
	}

	public HitBoxCheck(double point1x, double point1y, double width, double height) {
		super();
		point1X = point1x;
		point1Y = point1y;
		point2X = point1x + width;
		point2Y = point1y;
		point3X = point1x + width;
		point3Y = point1y + height;
		point4X = point1x;
		point4Y = point1y + height;
	}
	

	public void HitBoxReset(double point1x, double point1y, double width, double height) {
		point1X = point1x;
		point1Y = point1y;
		point2X = point1x + width;
		point2Y = point1y;
		point3X = point1x + width;
		point3Y = point1y + height;
		point4X = point1x;
		point4Y = point1y + height;
	}
	

	public HitBoxCheck(double point1x, double point1y, double point2x, double point2y, double point3x, double point3y,
			double point4x, double point4y) {
		super();
		point1X = point1x;
		point1Y = point1y;
		point2X = point2x;
		point2Y = point2y;
		point3X = point3x;
		point3Y = point3y;
		point4X = point4x;
		point4Y = point4y;
	}
	public void HitBoxReset(double point1x, double point1y, double point2x, double point2y, double point3x, double point3y,
			double point4x, double point4y) {
		point1X = point1x;
		point1Y = point1y;
		point2X = point2x;
		point2Y = point2y;
		point3X = point3x;
		point3Y = point3y;
		point4X = point4x;
		point4Y = point4y;
	}
	public boolean hithithithit(HitBoxCheck r) {
		if((point1X >= r.point1X && point1X <= r.point3X)&&(point1Y >= r.point1Y && point1Y <= r.point3Y)) {
			return true;
		}
		if((point2X <= r.point2X && point2X >= r.point4X)&&(point2Y >= r.point2Y && point2Y <= r.point4Y)) {
			return true;
		}
		if((point3X <= r.point3X && point3X >= r.point1X)&&(point3Y <= r.point3Y && point3Y >= r.point1Y)) {
			return true;
		}
		if((point4X >= r.point4X && point4X <= r.point2X)&&(point4Y <= r.point4Y && point4Y >= r.point2Y)) {
			return true;
		}
		return false;
	}
	boolean hit(HitBoxCheck r) {
		if(hithithithit(r)||r.hithithithit(this)) {
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		
	}
}
