package br.rcbop;
public class Tree {

	private int data;
	private Tree L;
	private Tree R;

	public Tree(int i) {
		data = i;
	}

	public void Insert(int i) {
		Tree No = new Tree(i);

		if (i < data) {
			if (L == null) {
				L = No;
			} else {
				L.Insert(i);
			}
		} else {
			if (i > data) {
				if (R == null) {
					R = No;
				} else {
					R.Insert(i);
				}
			}
		}

	}

	public int get() {
		return data;
	}

	public Tree getL() {
		return L;
	}

	public Tree getR() {
		return R;
	}

}
