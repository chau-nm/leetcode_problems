function isValid(s: string): boolean {
    const stack = [];
    const openChars = ["(", "{", "["];
    const closeChars = [")", "}", "]"];
    const matchingPairs = {
        ")": "(",
        "}": "{",
        "]": "[",
    };

    for (let i = 0; i < s.length; i++) {
        if (openChars.includes(s.charAt(i))) {
            stack.push(s.charAt(i));
        } else if (closeChars.includes(s.charAt(i))) {
            const expectedOpenChar = matchingPairs[s.charAt(i)];
            if (stack.pop() !== expectedOpenChar) {
                return false;
            }
        } else {
            return false;
        }
    }

    return stack.length === 0;
};