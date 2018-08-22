package ds.tree.common;

public class TreeUtil {
	
	/**
	 *  method  to calculate height of tree
	 * @param root -root of tree
	 * @return Height of Tree
	 */
	public static int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

}
