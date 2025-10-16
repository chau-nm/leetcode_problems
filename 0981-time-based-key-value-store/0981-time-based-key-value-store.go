type TimeMap struct {
    store map[string][]entry
}

type entry struct {
    val string
    time int
}


func Constructor() TimeMap {
    return TimeMap{store: make(map[string][]entry)}
}


func (this *TimeMap) Set(key string, value string, timestamp int)  {
    this.store[key] = append(this.store[key], entry{val: value, time: timestamp})
}


func (this *TimeMap) Get(key string, timestamp int) string {
    entries, ok := this.store[key]
    if !ok || len(entries) == 0 {
        return ""
    }

    left, right := 0, len(entries) - 1
    ans := -1
    for left <= right {
        mid := (left + right) / 2

        if entries[mid].time <= timestamp {
            ans = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    if ans == -1 {
        return ""
    }

    return entries[ans].val
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Set(key,value,timestamp);
 * param_2 := obj.Get(key,timestamp);
 */