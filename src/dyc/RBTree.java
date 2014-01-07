package dyc;


public class RBTree<T extends Object > {
	RBNode<T> root;
	static RBNode<Object> NIL = new RBNode<Object>(0, null);
	@SuppressWarnings("unchecked")
	public RBTree() {
		root = (RBNode<T>) NIL;
	}
	
	public RBNode<T> find(int key) {
		return null;
	}
	
	public void insert(int key, T val) {
		if (root != null) {
			RBNode<T> newRoot = root.insert(key, val);
			if(newRoot != null) {
				root = newRoot;
			}
			root.color = RBColor.BLACK;
		} else {
			root = new RBNode<T>(key, val);
		}
	}
	
	public void delete(int key) {
		RBNode<T> newRoot = root.delete(key);
		if (newRoot == null) { return; }
		//if (newRoot.color == RBColor.DELETEBLACK || newRoot.color == RBColor.DELETERED) {
		//	root = (RBNode<T>) NIL;
		//} else {
			root = newRoot;
			root.color = RBColor.BLACK;
		//}
		
	}
	
	public void dumpgv() {
		System.out.println("digraph rbtree {");
		root.dumpgv();
		System.out.println("}");
	}
	
	public static void main(String args[]) {
		RBTree<Integer> rbtree = new RBTree<Integer>();
		rbtree.insert(10, 10);
		//rbtree.dumpgv();
		rbtree.insert(8, 8);
		
		rbtree.insert(15, 15);
		rbtree.insert(9, 9);
		rbtree.insert(6, 6);
		rbtree.insert(5, 5);
		rbtree.delete(15);
		rbtree.dumpgv();
	}
}



class RBNode<T extends Object> {
	RBColor color;
	int key;
	T val;
	RBNode<T> left, right;
	
	public RBNode() {}
	
	
	RBNode<T> fixSubTree(RBNode<T> singleBranchNode) {
		RBNode<T> deleted = null;
		                  
		boolean isLeftSon = true;
		if (this == singleBranchNode) {
			right.color = color == RBColor.RED? right.color : (right.color == RBColor.RED? RBColor.BLACK : RBColor.DOUBLEBLACK);
			return right;
		}
		if (singleBranchNode.key < key) {
			deleted = fixSubTree(left);
		} else {
			deleted = fixSubTree(right);
		}
		return processDeleted(deleted, isLeftSon);
	}
	public RBNode<T> delete(int key) {
		RBNode<T> deleted = null;
		boolean isLeftSon = true;
		if (this == RBTree.NIL) {
			return null;
		} else if (this.key == key) {
			if(left != RBTree.NIL) {
				isLeftSon = false;
				RBNode<T> node = right.findSmallest();
				if (node != RBTree.NIL) {
					key = node.key;
					val = node.val;
					//node.color = node.color == RBColor.RED? RBColor.DELETERED: RBColor.DELETEBLACK;
					deleted = right.fixSubTree(node);
				} else {
					left.color = color == RBColor.RED? left.color : (left.color == RBColor.RED? RBColor.BLACK : RBColor.DOUBLEBLACK);
					return left;
				}
				
			} else if (right != RBTree.NIL) {
				right.color = color == RBColor.RED? right.color : (right.color == RBColor.RED? RBColor.BLACK : RBColor.DOUBLEBLACK);
				return right;
			} else { //left and right are all NIL;
				//color = color == RBColor.RED ? RBColor.DELETERED : RBColor.DELETEBLACK;
				
					if(color != RBColor.RED) {
					
						left.color = RBColor.DOUBLEBLACK;
						
					}
				
				return left;
			}
			
		} else if (key < this.key) {
			deleted = left.delete(key);
		} else {
			deleted = right.delete(key);
			isLeftSon = false;
		} 
		if (deleted == null) {
			return null;
		}
		return processDeleted(deleted, isLeftSon);
	}
	
	RBNode<T> processDeleted(RBNode<T> deleted, boolean isLeftSon) {
		/*
		  if (deleted.color == RBColor.DELETERED || deleted.color == RBColor.DELETEBLACK) {
		 
			if(isLeftSon) {
				left = deleted.left != RBTree.NIL ? deleted.left : deleted.right;
			} else {
				right = deleted.left != RBTree.NIL ? deleted.left : deleted.right;
			}
			if(deleted.color == RBColor.DELETEBLACK) {
				if(color == RBColor.RED) {
					color = RBColor.BLACK;
				} else {
					color = RBColor.DOUBLEBLACK;
				}
			}
			return this;
		}
		*/
		RBNode<T> otherSon;
		if(deleted.color == RBColor.DOUBLEBLACK) {
			deleted.color = RBColor.BLACK;
			if(isLeftSon) {
				otherSon = right;
			} else {
				otherSon = left;
			}
			if (otherSon.color == RBColor.RED) { //mycolor must be black if otherson is black
				if (isLeftSon) {
					left = deleted;
					right = otherSon.left;
					otherSon.left = this;
					right.color = RBColor.RED;
				} else {
					right = deleted;
					left = otherSon.right;
					otherSon.right = this;
					left.color = RBColor.RED;
				}
				deleted.color = RBColor.BLACK;
				//color = RBColor.RED;
				otherSon.color = RBColor.BLACK;
				
				return otherSon;
			} else {
				RBNode<T> sonOfSon = null;
				if (isLeftSon) {
					
 					if (otherSon.right.color == RBColor.BLACK && otherSon.left.color == RBColor.RED) {
						sonOfSon = otherSon.left;						
						otherSon.left = sonOfSon.right;
						sonOfSon.right = otherSon;
						right = sonOfSon;
						
						sonOfSon.color = RBColor.BLACK;
						otherSon.color = RBColor.RED;
						otherSon = sonOfSon;
					}
					if (otherSon.right.color == RBColor.RED) {
						right = otherSon.left;
						otherSon.left = this;
						
						otherSon.right.color = RBColor.BLACK;
						otherSon.color = color;
						color = RBColor.BLACK;
						return otherSon;
					} else {
						otherSon.color = RBColor.RED;
						if (color == RBColor.RED) {
							color = RBColor.BLACK;
						} else {
							color = RBColor.DOUBLEBLACK;
						}
						return this;
					}
				} else {
					if (otherSon.left.color == RBColor.BLACK && otherSon.right.color == RBColor.RED) {
						sonOfSon = otherSon.right;
						otherSon.right = sonOfSon.left;
						sonOfSon.left = otherSon;
						left = sonOfSon;
						
						sonOfSon.color = RBColor.BLACK;
						otherSon.color = RBColor.RED;
						otherSon = sonOfSon;
					}
					if (otherSon.left.color == RBColor.RED) {
						left = otherSon.right;
						otherSon.right = this;
						
						otherSon.left.color = RBColor.BLACK;
						otherSon.color = color;
						color = RBColor.BLACK;
						return otherSon;
						
					} else {
						otherSon.color = RBColor.RED;
						if (color == RBColor.RED) {
							color = RBColor.BLACK;
						} else {
							color = RBColor.DOUBLEBLACK;
						}
						return this;
					}
				}
				
			}
		}
		return null;

	}

	RBNode<T> findSmallest() {
		if(this == RBTree.NIL || left == RBTree.NIL) {
			return this;
		}
		return left.findSmallest();
	}
	@SuppressWarnings("unchecked")
	public RBNode(int k, T val) {
		this.key = k;
		this.val = val;
		this.color = RBColor.BLACK;
		left = right = (RBNode<T>) RBTree.NIL;
		
	}
	
	@SuppressWarnings("unchecked")
	public RBNode(int k, T val, RBColor c) {
		this.key = k;
		this.val = val;
		this.color = c;
		left = right = (RBNode<T>) RBTree.NIL;
	}
	
	public RBNode<T> insert(int key, T val) {
		RBNode<T> son = null;
		RBNode<T> otherSon = null;
		boolean isLeftSon = true;
		if (this == RBTree.NIL) {
			return new RBNode<T>(key, val, RBColor.RED);
		} else {
			if (this.key > key) {
				son = left.insert(key, val);
			} else { 
				son = right.insert(key, val);
				isLeftSon = false;
			}
		}
		// son == null means success
		if (son == null) {
			return null;
		}
		if (isLeftSon) {
			left = son;
		} else {
			right = son;
		}
		// if is BLACK, the upper need not change, but we may update current son reference to this.
		if (son.color == RBColor.BLACK) {
			if (son == (isLeftSon? left : right)) {
				return null;
			} else {
				if (isLeftSon) {
					left = son;
				} else {
					right = son;
				}
			}
			return null;	
		}
		
		if (son.color == RBColor.RED) {
			if (color == RBColor.BLACK) {
				return null;
			} else {
				/*
				 * son might be no longer the original one, so we must re-judge whether it is left or right
				 * Or we can record it when using left.insert or right.insert
				 */
				if (isLeftSon) { //son.key < key) {
					this.color = RBColor.RL;
				} else { // the semetric
					this.color = RBColor.RR;
				}
				return this;
			}
		} 
		otherSon = isLeftSon ? right : left;
		if (otherSon.color == RBColor.RED) {
			son.color = RBColor.BLACK;
			otherSon.color = RBColor.BLACK;
			if(isLeftSon) {
				left = son;
				right = otherSon;
			} else {
				left = otherSon;
				right = son;				
			}
			this.color = RBColor.RED;
			return this;
		}
		
		if (son.color == RBColor.RL) {
			if(isLeftSon) {
				left = son.right;
				son.right = this;
				
			} else {
				RBNode<T> leftOfSon = son.left;
				son.left = leftOfSon.right;
				leftOfSon.right = son;
				son = leftOfSon;				
				right = son.left;
				son.left = this;
			}
			
			
		} else { // son.color == RBColor.RR;
			if(isLeftSon) {
				RBNode<T> rightOfSon = son.right;
				son.right = rightOfSon.left;
				rightOfSon.left = son;
				son = rightOfSon;				
				left = son.right;
				son.right = this;
			} else {
				right = son.left;
				son.left = this;
			}
		}
		color = RBColor.RED;
		son.color = RBColor.BLACK;
		return son;
	}
	
	public RBNode<T> find(int key) {
		if(this == RBTree.NIL || this.key == key) {
			return this;
		} else {
			if(this.key > key) {
				return left.find(key);
			} else {
				return right.find(key);
			}
		}
	}
	
	public void dumpgv() {
		System.out.println(String.format("%s [color = %s, shape = circle, height = \"0.5\", width = \"0.5\"]", getName(), getColor()));
		if (this != RBTree.NIL) {
			System.out.println(String.format("%s -> %s [label = left]", getName(), left.getName()));
			System.out.println(String.format("%s -> %s [label = right]", getName(), right.getName()));
			left.dumpgv();
			right.dumpgv();
		} 
	}
	
	String getName() {
		if(this == RBTree.NIL) {
			return "NIL";
		}
		return String.valueOf(key);
	}
	
	String getColor() {
		if(color == RBColor.BLACK) {
			return "black";
		} else {
			return "red";
		} 
	}
}

//static RBNode<Object> RBNIL;// = new RBNode<Object>(); 

enum RBColor {
	BLACK,
	RED,
	/*
	 * Temporary State
	 * Need parent to fix it.
	 */
	// my color is red and my left son is also red
	RL,
	// my color is red and my right son is also red
	RR,
	//DELETERED,
	//DELETEBLACK,
	//There is no temporary case that my color and both my sons are red 
	DOUBLEBLACK
}