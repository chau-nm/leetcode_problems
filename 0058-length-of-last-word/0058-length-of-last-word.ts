function lengthOfLastWord(s: string): number {
    let count = 0;
    let sTrim = s.trim();
    for (let i = sTrim.length - 1; i >= 0; i--) {
        if (sTrim.charAt(i) !== ' ') count++;
        else break;
    }
    return count;
};