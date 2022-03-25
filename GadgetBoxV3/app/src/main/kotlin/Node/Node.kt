package Node

/**Using T: Any to set an upper bound for the parameter type which ensures T will
always be a non-nullable type**/
data class Node<T>(var value : T, var next: Node<T>? = null)
{
    override fun toString(): String
    {
        //If there are still nodes in the list
        return if (next != null)
        {
            //Print the value of the node and print the toString of the next node
            "$value -> ${next.toString()}"
        }
        //Otherwise just print the value
        else
        {
            "$value"
        }
    }
    /**fun printInReverse()
    {
    next ?.printInReverse()
    if(next!=null)
    {
    print(" -> ")
    }
    print(value.toString())
    }**/
}