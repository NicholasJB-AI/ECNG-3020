package Node

//Class for creating and managing multiple nodes in a list. Also a collection to alter contained items
class LinkedList<T> : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T>
{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean
    {
        return size == 0
    }

    override fun toString(): String
    {
        if(isEmpty())
        {
            return "Empty List"
        }
        else
        {
            return head.toString()
        }
    }

    override fun iterator(): MutableIterator<T>
    {
        return LinkedListIterator(this)
    }

    //Adds a value to the front of the list
    fun push(value: T): LinkedList<T>
    {
        //Creates a new node which holds the new value. Points to the node that was previously the head
        head = Node(value = value, next = head)
        if(tail == null)
        {
            tail = head
        }
        //Increments the size of the list
        size++
        return this
    }

    //Iterates through all elements of the list
    override fun contains(element: T): Boolean
    {
        for (item in this)
        {
            if(item == element)
            {
                return true
            }
        }
        return false
    }

    //Iterates through a collection of elements in the list
    override fun containsAll(elements: Collection<T>): Boolean
    {
        for(searched in elements)
        {
            if(!contains(searched))
            {
                return false
            }
        }
        return true
    }

    override fun add(element: T): Boolean
    {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean
    {
        for(element in elements)
        {
            append(element)
        }
        return true
    }

    override fun clear()
    {
        head = null
        tail = null
        size = 0
    }

    //Removing elements using an iterative approach
    override fun remove(element: T): Boolean
    {
        //Create an iterator to iterate through the collection
        val iterator = iterator()
        //Keeps checking that there are elements and gets the next
        while(iterator.hasNext())
        {
            val item = iterator.next()
            //Check if item is the element being searched for
            if(item == element)
            {
                //Return boolean if element was removed
                iterator.remove()
                return true
            }
        }
        //Return boolean if element was not removed
        return false
    }

    //Removes all elements in the list
    override fun removeAll(elements: Collection<T>): Boolean
    {
        var result = false
        for(item in elements)
        {
            result = remove(item) || result
        }
        return result
    }


    //Removes all elements from the list except that which was specified
    override fun retainAll(elements: Collection<T>): Boolean
    {
        var result = false
        var iterator = this.iterator()
        //Keeps checking that there are elements and gets the next
        while(iterator.hasNext())
        {
            val item = iterator.next()
            if(!elements.contains(item))
            {
                //Return boolean if element was removed
                iterator.remove()
                result = true
            }
        }
        //Returns boolean if element was not removed
        return result
    }

    //Adds a value to the end of the list
    fun append(value: T): LinkedList<T>
    {
        //If empty, update the list to the new node
        if(isEmpty())
        {
            push(value)
            return this
        }
        //Create new node at the tail of the list
        tail?.next = Node(value = value)

        tail = tail?.next
        //Increment the size of the list
        size++
        return this
    }

    //Inserts a node at a specified point in the list
    fun nodeAt(index: Int): Node<T>?
    {
        //Create new reference to head //Keep track of the number of increments
        var currentNode = head
        var currentIndex = 0

        //Moving reference through list until desired index
        while (currentNode != null && currentIndex < index)
        {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    //Updates tail by appending value if called with a tail node
    fun insert(value: T, afterNode: Node<T>): Node<T>
    {
        //Updates tail by appending value if called with a tail node
        if(tail == afterNode)
        {
            append(value)
            return tail!!
        }

        //Create new node and point to the next node in list
        val newNode = Node(value = value, next = afterNode.next)

        //Reassign the next value to the new node
        afterNode.next = newNode
        size++
        return newNode
    }

    //Remove node from the front of the list and returns the value that was removed
    fun pop(): T?
    {
        if(!isEmpty())
        {
            size--
        }
        //Moving the head to the next node
        val result = head?.value
        head = head?.next
        //If list is empty the tail is set to null
        if(isEmpty())
        {
            tail = null
        }
        return result
    }

    //Traverse the list to find the node before the last
    fun removeLast(): T?
    {
        //If head is null, return null
        val head = head ?: return null
        //If list is empty return pop()
        if(head.next == null)
        {
            return pop()
        }
        //Update size of list
        size--

        //Continue searching for the next node until current.next is null
        var prev = head
        var current = head

        var next = current.next
        while(next!=null)
        {
            prev = current
            current = next
            next = current.next
        }
        //Current is last node and must be disconnected
        prev.next = null
        tail = prev
        return current.value
    }

    //Removes a node at a specified location
    fun removeAfter(node: Node<T>): T?
    {
        val result = node.next?.value

        if(node.next == tail)
        {
            tail = node
        }
        if(node.next != null)
        {
            size--
        }
        node.next = node.next?.next
        return result
    }
}