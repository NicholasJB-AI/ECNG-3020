package Node

//Class is iterable and allows access to items in the list with permission to remove them
class LinkedListIterator<T>(private val list: LinkedList<T>) : Iterator<T>, MutableIterator<T>
{
    private var index = 0
    private var lastNode: Node<T>? = null

    //Reads the values of the nodes in the list in order
    override fun next(): T
    {
        //Check that there are elements to return
        if(index >= list.size) throw IndexOutOfBoundsException()

        //On first iteration, if there is no lastNode set, get the first node
        lastNode = if(index == 0)
        {
            list.nodeAt(0)
        }
        else
        {
            lastNode?.next
        }
        //Update list once lastNode was updated
        index++
        return lastNode!!.value
    }

    override fun hasNext(): Boolean
    {
        return index <list.size
    }

    //Function to comply with new interface added
    override fun remove()
    {
        //At the beginning of the list calls pop()
        if(index == 1)
        {
            list.pop()
        }
        else
        {
            //Find previous node
            val prevNode = list.nodeAt(index - 2) ?: return
            //Reassigning the lastNode
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        //Decreasing index
        index--
    }
}