public class SearchTree implements NodeList{

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            // the tree was empty so our item becomes the head of the tree
            this.root = newItem;
            return true;
        }
        // otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while(currentItem != null){

            int comparison = currentItem.compareTo(newItem);
            if(comparison < 0){
                //newItem is greater, move right if possible
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }
                else{
                    currentItem.setNext(newItem);
                    return true;
                }
            }
            else if(comparison > 0){
                //newItem is less, move left if possible
                if(currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }
                else{
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }
            else{
                //equal, so don't add
                System.out.println(newItem.getValue() + "is already present, not added");
                return false;
            }
        }return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
       // return false;                               // add remove item method
        if(item != null){
            System.out.println("Deleting Item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            }
            else if(comparison > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
            else{
                performRemoval(currentItem, parentItem);
                return true;
            }
        } return false;
    }


    public void performRemoval(ListItem item, ListItem parent){
        //remove item from the tree
        if(item.next() == null){
            //no right tree, so make parent point to left tree(which may be null)
            if(parent.next() == item){
                //item is right child of its parent
                parent.setNext(item.previous());
            }
            else if(parent.previous() == item){
                //item is left child of its parent
                parent.setPrevious(item.previous());
            }
            else{
                //parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        }
        else if(item.previous() == null){
            //no left tree, so make parent point to right tree(which may be null)
            if(parent.next() == item){
                //item is right child of its parent
                parent.setNext(item.next());
            }
            else if(parent.previous() == item){
                //item is left child of its parent
                parent.setPrevious(item.next());
            }
            else{
                //we are deleting the root
                this.root = item.next();
            }
        }
        else{
            //neither left nor right are null, deletion is now a lot trickier.
            //From the right sub-tree, fins the smallest value(the leftmost)
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while(current.previous() != null){
                leftMostParent = current;
                current = current.previous();
            }
            //Now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            //and delete the smallest
            if(leftMostParent == item){
                //there as no leftmost node, so 'current' points to the smallest
                item.setNext(current.next());
            }
            else{
                //set the smallest node's parent to point to the smallest node's right child(which may be null)
                leftMostParent.setPrevious(current.next());
            }
        }
    }


    @Override
    public void traverse(ListItem root) {
        //recursive method
        if(root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
