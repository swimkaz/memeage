
public class  LinkedNode<T>{
  //create c first, even though it reads last
  //need c reference to create other objects(linked node)
  
  //do not lost track of necessary/needed nodes
  //understand which nodes and their arrows should change first
  //look for special cases in methods of changing, removing
  
    private T data;
    private LinkedNode<T> next;
    public LinkedNode(T data, LinkedNode<T> next) {
      this.data = data;
      this.next = next;
    }
    public static void main(String[] args) {
      LinkedNode<String> list = new LinkedNode<>(
          "A", new LinkedNode<>(
          "B", new.//...));
      
    }
  }

}
