package dyc;


public class RBTree<T extends Object> {
	static RBNode<Object> RBNIL = new RBNode<Object>();
	RBNode<T> root;
	public RBTree() {
		root = (RBNode<T>) RBNIL;
	}
	
	public RBNode<T> find(int key) {
		return null;
	}
	
	public void insert(int key, T val) {
		if (root != RBNIL) {
			
		} else {
			root = new RBNode<T>(key, val);
		}
	}
	
	public void delete(int key) {
		
	}
}



class RBNode<T extends Object> {
	RBColor color;
	int key;
	T val;
	RBNode<T> left, right;
	
	public RBNode() {}
	
	public RBNode(int k, T val) {
		this.key = k;
		this.val = val;
		this.color = RBColor.BLACK;
	}
	
	public RBNode<T> find(int key) {
		if(this == RBTree.RBNIL || this.key == key) {
			return this;
		} else {
			if(this.key > key) {
				return left.find(key);
			} else {
				return right.find(key);
			}
		}
	}
}

//static RBNode<Object> RBNIL;// = new RBNode<Object>(); 

enum RBColor {
	BLACK,
	RED
}