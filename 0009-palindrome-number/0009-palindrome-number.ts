function isPalindrome(x: number): boolean {
    return x === parseInt(String(x).split('').reverse().join(''));
};