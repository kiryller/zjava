package zjava.datastructure;

import java.util.List;

/**
 * <tt>Node</tt> interface represents a single node in a tree or tree-like data structure.<br>
 * 
 * @param <T> - actual node type
 * 
 * @since Zjava 1.0
 * 
 * @author Ivan Zaitsau
 */
public interface Node<T extends Node<? super T>> {
	
	/**
	 * Returns list of node child-nodes<br>
	 * 
	 * @return list of node children
	 */
	List<T> getChildren();
}
