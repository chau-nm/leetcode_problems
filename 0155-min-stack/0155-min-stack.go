import (
	"slices"
)

type MinStack struct {
    elms []int
}

func Constructor() MinStack {
    return MinStack{
        elms: []int{},
    }
}


func (this *MinStack) Push(val int) {
    this.elms = append(this.elms, val)
}


func (this *MinStack) Pop() {
    this.elms = this.elms[:len(this.elms) - 1]
}


func (this *MinStack) Top() int {
    return this.elms[len(this.elms) - 1]
}


func (this *MinStack) GetMin() int {
    return slices.Min(this.elms)
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */