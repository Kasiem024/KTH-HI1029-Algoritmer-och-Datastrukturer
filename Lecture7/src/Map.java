public class Map<K extends Comparable<K>,V> {
    private static class Node<K extends Comparable<K>,V>{
        private V value;
        private K key;
        private Node<K,V> left,right;
        private Node(K key,V value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString(){
            return key.toString()+"="+value.toString();
        }
    }

    private Node<K,V> root;
    private V deletedData;

    private void inOrder(Node<K,V> node, StringBuilder sb){
        if(node!=null){
            inOrder(node.left, sb);
            sb.append(" ").append(node);
            inOrder(node.right, sb);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }

    	private boolean put(Node<K,V> newNode,Node<K,V> node){
        int order = newNode.key.compareTo(node.key);
		if(order==0)
			return false;
		else if(order<0)
			if(node.left==null){
				node.left = newNode;
				return true;
			}else
				return put(newNode,node.left);
		else
			if(node.right==null){
				node.right = newNode;
				return true;
			}else
				return put(newNode,node.right);
	}
	public boolean put(K key, V value){
        Node<K,V> newNode = new Node<>(key,value);
		if(root==null){
			root = newNode;
			return true;
		}else{
			return put(newNode,root);
		}
	}

    public V get(K key){
        return get(key, root);
    }

    private V get(K key, Node<K,V> node){
        if( node==null)
            return null;
        if(key.compareTo(node.key)==0)
            return node.value;
        if(key.compareTo(node.key)<0)
            return get(key,node.left);
        return get(key,node.right);
    }

	public V remove(K key){
		root = remove(key,root);
		return deletedData;
	}
	private Node<K,V> remove(K key,Node<K,V> node){
		if(node==null){
			deletedData = null;
			return null;
		}else{
		    int order = key.compareTo(node.key);
			if(order<0){
				node.left=remove(key,node.left);
				return node;
			}else if(order>0){
				node.right=remove(key,node.right);
				return node;
			}else{
				deletedData = node.value;
				if(node.left==null)
					return node.right;
				else if(node.right==null)
					return node.left;
				else{
					Node<K,V> nodeToMove=node.right,parentNodeToMove=node;
					if(nodeToMove.left==null){
						nodeToMove.left=node.left;
						return nodeToMove;
					}
					while(nodeToMove.left!=null){
						parentNodeToMove=nodeToMove;
						nodeToMove=nodeToMove.left;
					}
					parentNodeToMove.left = nodeToMove.right;
					node.key = nodeToMove.key;
					node.value = nodeToMove.value;
					return node;
				}
			}
		}

	}
}
