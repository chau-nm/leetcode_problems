/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {
    visited := make(map[*Node]*Node)
    return copy(head, visited)
}

func copy(node *Node, visited map[*Node]*Node) *Node {
    if node == nil {
        return nil
    }

    if v, ok := visited[node]; ok {
        return v
    }

    newNode := &Node{Val: node.Val}
    visited[node] = newNode

    newNode.Next = copy(node.Next, visited)
    newNode.Random = copy(node.Random, visited)
    return newNode
}