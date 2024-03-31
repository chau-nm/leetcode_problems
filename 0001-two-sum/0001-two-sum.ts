function twoSum(nums: number[], target: number): number[] {
    const map = {};
    for (let i = 0; i < nums.length; i++) {
        const otherNum = target - nums[i];
        const otherNumIndex = map[otherNum]
        if (otherNumIndex !== undefined) {
            return [otherNumIndex, i];
        } else {
            map[nums[i]] = i;
        }
    };
    return [];
};