package faffimg;

public class JSONItem implements Comparable<JSONItem>{
	private int[] img;
	private int x_start;
	private int y_start;
	private int x_dim;
	private int y_dim;
	
	public int getX_start() {
		return x_start;
	}

	public void setX_start(int x_start) {
		this.x_start = x_start;
	}

	public int getY_start() {
		return y_start;
	}

	public void setY_start(int y_start) {
		this.y_start = y_start;
	}

	public int getX_dim() {
		return x_dim;
	}

	public void setX_dim(int x_dim) {
		this.x_dim = x_dim;
	}

	public int getY_dim() {
		return y_dim;
	}

	public void setY_dim(int y_dim) {
		this.y_dim = y_dim;
	}
	
	public void setImg(int[] newImg){
		this.img = newImg;
	}
	
	public int[] getImg(){
		return this.img;

	}
	
	public int compareTo(JSONItem item) {
		int compareQuanitity = ((JSONItem) item).getX_dim();
		
		return compareQuanitity - this.getX_dim();
	}	
}
